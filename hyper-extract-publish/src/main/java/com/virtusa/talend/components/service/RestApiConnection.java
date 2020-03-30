package com.virtusa.talend.components.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.core.UriBuilder;

import com.virtusa.talend.components.binding.*;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.AttachmentBuilder;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.apache.cxf.transport.http.HTTPConduit;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;


public final class RestApiConnection {

    /**
     * 30 seconds
     */
    private static final long DEFAULT_CONNECTION_TIMEOUT = 30000;

    /**
     * 60 seconds
     */
    private static final long DEFAULT_RECEIVE_TIMEOUT = 60000;

    /**
     * Default page size for query datasources
     */
    private static final long DATASOURCES_PAGE_SIZE = 200;

    /**
     * Default page size for query projects
     */
    private static final long PROJECTS_PAGE_SIZE = 200;

    /**
     * 100KB per chunk (as in the example)
     */
    private static final int UPLOAD_CHUNK_SIZE = 100000;

    private static final String API_VERSION = "2.8";

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    private static final String SIGN_IN = "auth/signin";

    private static final String TABLEAU_AUTH_HEADER = "X-Tableau-Auth";

    private static final String QUERY_PROJECTS = "sites/{siteId}/projects";

    private static final String QUERY_DATA_SOURCES = "sites/{siteId}/datasources";

    private static final String PUBLISH_DATASOURCE = "sites/{siteId}/datasources";

    private static final String INITIATE_FILE_UPLOAD = "sites/{siteId}/fileUploads";

    private static final String APPEND_FILE_UPLOAD = "sites/{siteId}/fileUploads/{uploadSessionId}";

    private final String m_url;

    private final long m_connectionTimeout;

    private final long m_receiveTimeout;

    private boolean m_signedIn = false;

    private String m_token;

    private String m_siteId;

    /**
     * Creates a new connection to the tableau server with the given url.
     *
     * @param url the url to the server
     */
    public RestApiConnection(final String url) {
        m_url = url;
        m_connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
        m_receiveTimeout = DEFAULT_RECEIVE_TIMEOUT;
    }

    /**
     * Creates a new connection to the tableau server with the given url.
     *
     * @param url               the url to the server
     * @param connectionTimeout timeout for establishing the connection in milliseconds
     * @param receiveTimeout    timeout for receiving responses in milliseconds
     */
    public RestApiConnection(final String url, final long connectionTimeout, final long receiveTimeout) {
        m_url = url;
        m_connectionTimeout = connectionTimeout;
        m_receiveTimeout = receiveTimeout;
    }

    /**
     * Requests a sign in with the given username and password.
     *
     * @param username   the tableau server username
     * @param password   the tableau server password
     * @param contentUrl url of the site to sign in
     * @throws TsResponseException if the server responds with an non successful response code
     */
    public synchronized void invokeSignIn(final String username, final String password, final String contentUrl)
            throws TsResponseException {
        final String url = getUriBuilder().path(SIGN_IN).build().toString();

        // Create the sign in credentials payload
        final TableauCredentialsType credentialsSignIn = OBJECT_FACTORY.createTableauCredentialsType();
        credentialsSignIn.setName(username);
        credentialsSignIn.setPassword(password);
        final SiteType site = OBJECT_FACTORY.createSiteType();
        site.setContentUrl(contentUrl);
        credentialsSignIn.setSite(site);

        // Create a ts request
        final TsRequest payload = OBJECT_FACTORY.createTsRequest();
        payload.setCredentials(credentialsSignIn);

        // Execute the post
        final TsResponse response = post(url, payload);
        final TableauCredentialsType credentials = response.getCredentials();
        m_token = credentials.getToken();
        m_siteId = credentials.getSite().getId();
        m_signedIn = true;
    }

    /**
     * Manually set the REST API authentication token.
     *
     * @param token  the authentication token
     * @param siteId the site id of the connected site
     */
    public synchronized void setAuthToken(final String token, final String siteId) {
        m_token = token;
        m_siteId = siteId;
        m_signedIn = true;
    }

    /**
     * Queries the project of the connected tableau site.
     *
     * @return the list of projects
     * @throws TsResponseException if the server responds with an non successful response code
     */
    public List<ProjectType> invokeQueryProjects() throws TsResponseException {
        checkSignedIn();

        final List<ProjectType> projects = new ArrayList<>();

        int currentPage = 1; // Tableau starts counting at 1
        BigInteger totalReturned = BigInteger.ZERO;
        BigInteger totalAvailable;

        // Loop over pages
        do {
            // Query the projects page
            final String url = getUriBuilder().path(QUERY_PROJECTS) //
                    .queryParam("pageNumber", currentPage) //
                    .queryParam("pageSize", PROJECTS_PAGE_SIZE) //
                    .build(m_siteId).toString();
            final TsResponse response = get(url);

            // Get the projects from the response
            projects.addAll(response.getProjects().getProject());

            // Next page
            currentPage++;
            // NOTE: total available is the number of datasources available
            totalAvailable = response.getPagination().getTotalAvailable();
            totalReturned = totalReturned.add(response.getPagination().getPageSize());
        } while (totalReturned.compareTo(totalAvailable) < 0);

        return projects;
    }

    /**
     * Queries the datasources of the connected tableau site.
     *
     * @return the list of datasources
     * @throws TsResponseException if the server responds with an non successful response code
     */
    public DataSourceListType invokeQueryDatasources() throws TsResponseException {
        checkSignedIn();
        final String url = getUriBuilder().path(QUERY_DATA_SOURCES).build(m_siteId).toString();
        final TsResponse response = get(url);
        return response.getDatasources();
    }

    /**
     * Checks if the datasource with the given name exists in the given project.
     *
     * @param name      the name of the datasource
     * @param projectId the identifier of the project
     * @return true if the datasource exists
     * @throws TsResponseException if the server responds with an non successful response code
     */
    public boolean existsDatasource(final String name, final String projectId) throws TsResponseException {
        checkSignedIn();
        int currentPage = 1; // Tableau starts counting at 1
        BigInteger totalReturned = BigInteger.ZERO;
        BigInteger totalAvailable;
        do {
            // Query the datasources page
            final String url = getUriBuilder().path(QUERY_DATA_SOURCES) //
                    .queryParam("pageNumber", currentPage) //
                    .queryParam("pageSize", DATASOURCES_PAGE_SIZE) //
                    .queryParam("fields", "name,project.id") // Ask only for the relevant fields: Smaller response
                    .build(m_siteId).toString();
            final TsResponse response = get(url);

            // Check if the response contains a datasource with the name and project
            final List<DataSourceType> datasources = response.getDatasources().getDatasource();
            if (datasources.stream() //
                    .filter(d -> d.getName().equals(name)) //
                    .anyMatch(d -> d.getProject().getId().equals(projectId))) {
                return true;
            }

            // Next page
            currentPage++;
            // NOTE: total available is the number of datasources available
            totalAvailable = response.getPagination().getTotalAvailable();
            totalReturned = totalReturned.add(response.getPagination().getPageSize());
        } while (totalReturned.compareTo(totalAvailable) < 0);
        return false;
    }

    /**
     * Sends a datasource to the connected tableau site.
     *
     * @param projectId      the id of the project to which the datasource should be added
     * @param datasourceName the name of the data source
     * @param datasourceType the type of the data source (e.g. "hyper")
     * @param dataSource     the datasource file
     * @param overwrite      if the datasource should be overwritten if it exists
     * @param append         if the data should be appended to an existing datasource
     * @return the datasource response from the server
     * @throws IOException         something goes wrong while reading the file
     * @throws TsResponseException if the server responds with an non successful response code
     */
    public DataSourceType invokePublishDataSourceChunked(final String projectId,
                                                         final String datasourceName,
                                                         final String datasourceType,
                                                         final File dataSource,
                                                         final boolean overwrite,
                                                         final boolean append
    ) throws IOException, TsResponseException {
        checkSignedIn();

        // Initiate the file upload
        final FileUploadType fileUpload = invokeInitiateFileUpload();

        final double totalChunks = Math.ceil(1. * dataSource.length() / UPLOAD_CHUNK_SIZE);
        final byte[] buffer = new byte[UPLOAD_CHUNK_SIZE];
        int numReadBytes = 0;
        long uploadedChunks = 0;
        try (final FileInputStream inputStream = new FileInputStream(dataSource)) {
            //progress.setProgress(0);
            while ((numReadBytes = inputStream.read(buffer)) != -1) {
                invokeAppendFileUpload(fileUpload.getUploadSessionId(), datasourceName, buffer, numReadBytes);
                //progress.setProgress(++uploadedChunks / totalChunks);
                //progress.checkCanceled();
            }
        }

        return invokePublishDataSource(fileUpload.getUploadSessionId(), datasourceName, datasourceType, projectId,
                overwrite, append);
    }

    /**
     * Invokes a file upload to the given site.
     *
     * @return a {@link FileUploadType} which can be used to upload the file
     * @throws TsResponseException
     */
    private FileUploadType invokeInitiateFileUpload() throws TsResponseException {
        checkSignedIn();
        final String url = getUriBuilder().path(INITIATE_FILE_UPLOAD).build(m_siteId).toString();
        final TsResponse response = post(url, null);
        return response.getFileUpload();
    }

    /**
     * Invokes a append data for the given file upload.
     *
     * @param uploadSessionId the session id of the upload
     * @param fileName        name of the file uploaded
     * @param data            a byte array containing the raw data
     * @param numBytes        the number of bytes to send
     * @return a {@link FileUploadType}
     * @throws TsResponseException
     * @throws IOException
     */
    private FileUploadType invokeAppendFileUpload(final String uploadSessionId, final String fileName,
                                                  final byte[] data, final int numBytes) throws TsResponseException, IOException {
        checkSignedIn();
        final String url = getUriBuilder().path(APPEND_FILE_UPLOAD).build(m_siteId, uploadSessionId).toString();
        final String body = ""; // empty body

        // Create attachments
        final List<Attachment> atts = new LinkedList<>();

        // First attachment: The xml body
        final ContentDisposition cdBody = new ContentDisposition("name=\"request_payload\"");
        atts.add(new AttachmentBuilder().id("request_payload").mediaType(MediaType.TEXT_XML).contentDisposition(cdBody)
                .object(body).build());

        try (final InputStream inputStream = new ByteArrayInputStream(data, 0, numBytes)) {
            // Second attachment: The file
            final ContentDisposition cd =
                    new ContentDisposition("name=\"tableau_file\"; filename=\"" + fileName + "\"");
            atts.add(new Attachment("tableau_datasource", inputStream, cd));
            final TsResponse response = putMultipart(url, atts);
            return response.getFileUpload();
        }
    }

    private DataSourceType invokePublishDataSource(final String uploadSessionId, final String datasourceName,
                                                   final String datasourceType, final String projectId, final boolean overwrite, final boolean append)
            throws TsResponseException {
        checkSignedIn();
        final String url = getUriBuilder().path(PUBLISH_DATASOURCE) //
                .queryParam("uploadSessionId", uploadSessionId) //
                .queryParam("datasourceType", datasourceType) //
                .queryParam("overwrite", overwrite) //
                .queryParam("append", append) //
                .build(m_siteId).toString();

        // Create a datasource payload
        final ProjectType project = OBJECT_FACTORY.createProjectType();
        project.setId(projectId);
        final DataSourceType dataSource = OBJECT_FACTORY.createDataSourceType();
        dataSource.setName(datasourceName);
        dataSource.setProject(project);

        // Create a ts request
        final TsRequest payload = OBJECT_FACTORY.createTsRequest();
        payload.setDatasource(dataSource);

        // Create the attachment
        final List<Attachment> atts = new LinkedList<>();
        final ContentDisposition cdBody = new ContentDisposition("name=\"request_payload\"");
        atts.add(new AttachmentBuilder().id("request_payload").mediaType(MediaType.TEXT_XML).contentDisposition(cdBody)
                .object(payload).build());

        // Execute the post
        final TsResponse response = postMultipart(url, atts);
        return response.getDatasource();
    }

    private UriBuilder getUriBuilder() {
        return UriBuilder.fromPath(m_url + "/api/" + API_VERSION);
    }

    private synchronized void checkSignedIn() {
        if (!m_signedIn) {
            throw new IllegalStateException(
                    "Invoke login before communication with the server. This is a coding error.");
        }
    }

    private WebClient getClient(final String url) {
        final WebClient client = WebClient.create(url);

        // Set the timeout
        final HTTPConduit httpConduit = WebClient.getConfig(client).getHttpConduit();
        httpConduit.getClient().setConnectionTimeout(m_connectionTimeout);
        httpConduit.getClient().setReceiveTimeout(m_receiveTimeout);

        // Set the auth token if signed in
        if (m_signedIn) {
            client.header(TABLEAU_AUTH_HEADER, m_token);
        }
        return client;
    }

    private TsResponse post(final String url, final TsRequest requestPayload) throws TsResponseException {
        final WebClient client = getClient(url);
        ClientConfiguration config = WebClient.getConfig(client);
        config.getInInterceptors().add(new LoggingInInterceptor());
        config.getOutInterceptors().add(new LoggingOutInterceptor());

        client.accept(MediaType.APPLICATION_XML);
        final Response response = client.post(requestPayload);
        return checkResponse(response);
    }

    private TsResponse postMultipart(final String url, final List<Attachment> attachments) throws TsResponseException {
        final WebClient client = getClient(url);

        client.accept(MediaType.APPLICATION_XML);
        client.encoding("UTF-8");
        client.type("multipart/mixed");
        final Response response = client.post(new MultipartBody(attachments));
        return checkResponse(response);
    }

    private TsResponse putMultipart(final String url, final List<Attachment> attachments) throws TsResponseException {
        final WebClient client = getClient(url);
        client.accept(MediaType.APPLICATION_XML);
        client.encoding("UTF-8");
        client.type("multipart/mixed");
        final Response response = client.put(new MultipartBody(attachments));
        return checkResponse(response);
    }

    private TsResponse get(final String url) throws TsResponseException {
        final WebClient client = getClient(url);
        client.accept(MediaType.APPLICATION_XML);
        final Response response = client.get();
        return checkResponse(response);
    }

    private static TsResponse checkResponse(final Response response) throws TsResponseException {
        if (response.getStatusInfo().getFamily() != Family.SUCCESSFUL) {
            try {
                final ErrorType error = response.readEntity(TsResponse.class).getError();
                final String message =
                        error.getSummary() + ": " + error.getDetail() + " (Error code: " + error.getCode() + ").";
                throw new TsResponseException(message);
            } catch (final ProcessingException e) {
                final StatusType statusInfo = response.getStatusInfo();
                throw new TsResponseException("Invalid response from server: " + statusInfo.getReasonPhrase()
                        + " (Error Code: " + statusInfo.getStatusCode() + ")", e);
            }
        }
        return response.readEntity(TsResponse.class);
    }

    /**
     * Exception which describes a response from a tableau server with a meaningful message.
     */
    public static class TsResponseException extends Exception {

        private static final long serialVersionUID = 1L;

        private TsResponseException(final String message) {
            super(message);
        }

        private TsResponseException(final String message, final Exception cause) {
            super(message, cause);
        }
    }
}