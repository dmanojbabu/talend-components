//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.07 at 05:07:04 PM CET 
//

package com.virtusa.talend.components.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;group ref="{http://tableau.com/api}paginatedResponseGroup"/>
 *         &lt;element name="connection" type="{http://tableau.com/api}connectionType"/>
 *         &lt;element name="connections" type="{http://tableau.com/api}connectionListType"/>
 *         &lt;element name="credentials" type="{http://tableau.com/api}tableauCredentialsType"/>
 *         &lt;element name="datasource" type="{http://tableau.com/api}dataSourceType"/>
 *         &lt;element name="error" type="{http://tableau.com/api}errorType"/>
 *         &lt;element name="favorites" type="{http://tableau.com/api}favoriteListType"/>
 *         &lt;element name="fileUpload" type="{http://tableau.com/api}fileUploadType"/>
 *         &lt;element name="group" type="{http://tableau.com/api}groupType"/>
 *         &lt;element name="job" type="{http://tableau.com/api}jobType"/>
 *         &lt;element name="permissions" type="{http://tableau.com/api}permissionsType"/>
 *         &lt;element name="project" type="{http://tableau.com/api}projectType"/>
 *         &lt;element name="schedule" type="{http://tableau.com/api}scheduleType"/>
 *         &lt;element name="serverInfo" type="{http://tableau.com/api}serverInfo"/>
 *         &lt;element name="site" type="{http://tableau.com/api}siteType"/>
 *         &lt;element name="tags" type="{http://tableau.com/api}tagListType"/>
 *         &lt;element name="user" type="{http://tableau.com/api}userType"/>
 *         &lt;element name="views" type="{http://tableau.com/api}viewListType"/>
 *         &lt;element name="workbook" type="{http://tableau.com/api}workbookType"/>
 *         &lt;element name="subscription" type="{http://tableau.com/api}subscriptionType"/>
 *         &lt;element name="task" type="{http://tableau.com/api}taskType"/>
 *         &lt;element name="tasks" type="{http://tableau.com/api}taskListType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pagination",
    "datasources",
    "extracts",
    "groups",
    "projects",
    "revisions",
    "schedules",
    "sites",
    "users",
    "workbooks",
    "subscriptions",
    "connection",
    "connections",
    "credentials",
    "datasource",
    "error",
    "favorites",
    "fileUpload",
    "group",
    "job",
    "permissions",
    "project",
    "schedule",
    "serverInfo",
    "site",
    "tags",
    "user",
    "views",
    "workbook",
    "subscription",
    "task",
    "tasks"
})
@XmlRootElement(name = "tsResponse")
public class TsResponse {

    protected PaginationType pagination;
    protected DataSourceListType datasources;
    protected ExtractListType extracts;
    protected GroupListType groups;
    protected ProjectListType projects;
    protected RevisionListType revisions;
    protected ScheduleListType schedules;
    protected SiteListType sites;
    protected UserListType users;
    protected WorkbookListType workbooks;
    protected SubscriptionListType subscriptions;
    protected ConnectionType connection;
    protected ConnectionListType connections;
    protected TableauCredentialsType credentials;
    protected DataSourceType datasource;
    protected ErrorType error;
    protected FavoriteListType favorites;
    protected FileUploadType fileUpload;
    protected GroupType group;
    protected JobType job;
    protected PermissionsType permissions;
    protected ProjectType project;
    protected ScheduleType schedule;
    protected ServerInfo serverInfo;
    protected SiteType site;
    protected TagListType tags;
    protected UserType user;
    protected ViewListType views;
    protected WorkbookType workbook;
    protected SubscriptionType subscription;
    protected TaskType task;
    protected TaskListType tasks;

    /**
     * Gets the value of the pagination property.
     * 
     * @return
     *     possible object is
     *     {@link PaginationType }
     *     
     */
    public PaginationType getPagination() {
        return pagination;
    }

    /**
     * Sets the value of the pagination property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaginationType }
     *     
     */
    public void setPagination(PaginationType value) {
        this.pagination = value;
    }

    /**
     * Gets the value of the datasources property.
     * 
     * @return
     *     possible object is
     *     {@link DataSourceListType }
     *     
     */
    public DataSourceListType getDatasources() {
        return datasources;
    }

    /**
     * Sets the value of the datasources property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSourceListType }
     *     
     */
    public void setDatasources(DataSourceListType value) {
        this.datasources = value;
    }

    /**
     * Gets the value of the extracts property.
     * 
     * @return
     *     possible object is
     *     {@link ExtractListType }
     *     
     */
    public ExtractListType getExtracts() {
        return extracts;
    }

    /**
     * Sets the value of the extracts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtractListType }
     *     
     */
    public void setExtracts(ExtractListType value) {
        this.extracts = value;
    }

    /**
     * Gets the value of the groups property.
     * 
     * @return
     *     possible object is
     *     {@link GroupListType }
     *     
     */
    public GroupListType getGroups() {
        return groups;
    }

    /**
     * Sets the value of the groups property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupListType }
     *     
     */
    public void setGroups(GroupListType value) {
        this.groups = value;
    }

    /**
     * Gets the value of the projects property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectListType }
     *     
     */
    public ProjectListType getProjects() {
        return projects;
    }

    /**
     * Sets the value of the projects property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectListType }
     *     
     */
    public void setProjects(ProjectListType value) {
        this.projects = value;
    }

    /**
     * Gets the value of the revisions property.
     * 
     * @return
     *     possible object is
     *     {@link RevisionListType }
     *     
     */
    public RevisionListType getRevisions() {
        return revisions;
    }

    /**
     * Sets the value of the revisions property.
     * 
     * @param value
     *     allowed object is
     *     {@link RevisionListType }
     *     
     */
    public void setRevisions(RevisionListType value) {
        this.revisions = value;
    }

    /**
     * Gets the value of the schedules property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleListType }
     *     
     */
    public ScheduleListType getSchedules() {
        return schedules;
    }

    /**
     * Sets the value of the schedules property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleListType }
     *     
     */
    public void setSchedules(ScheduleListType value) {
        this.schedules = value;
    }

    /**
     * Gets the value of the sites property.
     * 
     * @return
     *     possible object is
     *     {@link SiteListType }
     *     
     */
    public SiteListType getSites() {
        return sites;
    }

    /**
     * Sets the value of the sites property.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteListType }
     *     
     */
    public void setSites(SiteListType value) {
        this.sites = value;
    }

    /**
     * Gets the value of the users property.
     * 
     * @return
     *     possible object is
     *     {@link UserListType }
     *     
     */
    public UserListType getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserListType }
     *     
     */
    public void setUsers(UserListType value) {
        this.users = value;
    }

    /**
     * Gets the value of the workbooks property.
     * 
     * @return
     *     possible object is
     *     {@link WorkbookListType }
     *     
     */
    public WorkbookListType getWorkbooks() {
        return workbooks;
    }

    /**
     * Sets the value of the workbooks property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkbookListType }
     *     
     */
    public void setWorkbooks(WorkbookListType value) {
        this.workbooks = value;
    }

    /**
     * Gets the value of the subscriptions property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionListType }
     *     
     */
    public SubscriptionListType getSubscriptions() {
        return subscriptions;
    }

    /**
     * Sets the value of the subscriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionListType }
     *     
     */
    public void setSubscriptions(SubscriptionListType value) {
        this.subscriptions = value;
    }

    /**
     * Gets the value of the connection property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectionType }
     *     
     */
    public ConnectionType getConnection() {
        return connection;
    }

    /**
     * Sets the value of the connection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectionType }
     *     
     */
    public void setConnection(ConnectionType value) {
        this.connection = value;
    }

    /**
     * Gets the value of the connections property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectionListType }
     *     
     */
    public ConnectionListType getConnections() {
        return connections;
    }

    /**
     * Sets the value of the connections property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectionListType }
     *     
     */
    public void setConnections(ConnectionListType value) {
        this.connections = value;
    }

    /**
     * Gets the value of the credentials property.
     * 
     * @return
     *     possible object is
     *     {@link TableauCredentialsType }
     *     
     */
    public TableauCredentialsType getCredentials() {
        return credentials;
    }

    /**
     * Sets the value of the credentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauCredentialsType }
     *     
     */
    public void setCredentials(TableauCredentialsType value) {
        this.credentials = value;
    }

    /**
     * Gets the value of the datasource property.
     * 
     * @return
     *     possible object is
     *     {@link DataSourceType }
     *     
     */
    public DataSourceType getDatasource() {
        return datasource;
    }

    /**
     * Sets the value of the datasource property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSourceType }
     *     
     */
    public void setDatasource(DataSourceType value) {
        this.datasource = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorType }
     *     
     */
    public ErrorType getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorType }
     *     
     */
    public void setError(ErrorType value) {
        this.error = value;
    }

    /**
     * Gets the value of the favorites property.
     * 
     * @return
     *     possible object is
     *     {@link FavoriteListType }
     *     
     */
    public FavoriteListType getFavorites() {
        return favorites;
    }

    /**
     * Sets the value of the favorites property.
     * 
     * @param value
     *     allowed object is
     *     {@link FavoriteListType }
     *     
     */
    public void setFavorites(FavoriteListType value) {
        this.favorites = value;
    }

    /**
     * Gets the value of the fileUpload property.
     * 
     * @return
     *     possible object is
     *     {@link FileUploadType }
     *     
     */
    public FileUploadType getFileUpload() {
        return fileUpload;
    }

    /**
     * Sets the value of the fileUpload property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileUploadType }
     *     
     */
    public void setFileUpload(FileUploadType value) {
        this.fileUpload = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link GroupType }
     *     
     */
    public GroupType getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupType }
     *     
     */
    public void setGroup(GroupType value) {
        this.group = value;
    }

    /**
     * Gets the value of the job property.
     * 
     * @return
     *     possible object is
     *     {@link JobType }
     *     
     */
    public JobType getJob() {
        return job;
    }

    /**
     * Sets the value of the job property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobType }
     *     
     */
    public void setJob(JobType value) {
        this.job = value;
    }

    /**
     * Gets the value of the permissions property.
     * 
     * @return
     *     possible object is
     *     {@link PermissionsType }
     *     
     */
    public PermissionsType getPermissions() {
        return permissions;
    }

    /**
     * Sets the value of the permissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link PermissionsType }
     *     
     */
    public void setPermissions(PermissionsType value) {
        this.permissions = value;
    }

    /**
     * Gets the value of the project property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectType }
     *     
     */
    public ProjectType getProject() {
        return project;
    }

    /**
     * Sets the value of the project property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectType }
     *     
     */
    public void setProject(ProjectType value) {
        this.project = value;
    }

    /**
     * Gets the value of the schedule property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleType }
     *     
     */
    public ScheduleType getSchedule() {
        return schedule;
    }

    /**
     * Sets the value of the schedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleType }
     *     
     */
    public void setSchedule(ScheduleType value) {
        this.schedule = value;
    }

    /**
     * Gets the value of the serverInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ServerInfo }
     *     
     */
    public ServerInfo getServerInfo() {
        return serverInfo;
    }

    /**
     * Sets the value of the serverInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServerInfo }
     *     
     */
    public void setServerInfo(ServerInfo value) {
        this.serverInfo = value;
    }

    /**
     * Gets the value of the site property.
     * 
     * @return
     *     possible object is
     *     {@link SiteType }
     *     
     */
    public SiteType getSite() {
        return site;
    }

    /**
     * Sets the value of the site property.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteType }
     *     
     */
    public void setSite(SiteType value) {
        this.site = value;
    }

    /**
     * Gets the value of the tags property.
     * 
     * @return
     *     possible object is
     *     {@link TagListType }
     *     
     */
    public TagListType getTags() {
        return tags;
    }

    /**
     * Sets the value of the tags property.
     * 
     * @param value
     *     allowed object is
     *     {@link TagListType }
     *     
     */
    public void setTags(TagListType value) {
        this.tags = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link UserType }
     *     
     */
    public UserType getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserType }
     *     
     */
    public void setUser(UserType value) {
        this.user = value;
    }

    /**
     * Gets the value of the views property.
     * 
     * @return
     *     possible object is
     *     {@link ViewListType }
     *     
     */
    public ViewListType getViews() {
        return views;
    }

    /**
     * Sets the value of the views property.
     * 
     * @param value
     *     allowed object is
     *     {@link ViewListType }
     *     
     */
    public void setViews(ViewListType value) {
        this.views = value;
    }

    /**
     * Gets the value of the workbook property.
     * 
     * @return
     *     possible object is
     *     {@link WorkbookType }
     *     
     */
    public WorkbookType getWorkbook() {
        return workbook;
    }

    /**
     * Sets the value of the workbook property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkbookType }
     *     
     */
    public void setWorkbook(WorkbookType value) {
        this.workbook = value;
    }

    /**
     * Gets the value of the subscription property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionType }
     *     
     */
    public SubscriptionType getSubscription() {
        return subscription;
    }

    /**
     * Sets the value of the subscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionType }
     *     
     */
    public void setSubscription(SubscriptionType value) {
        this.subscription = value;
    }

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link TaskType }
     *     
     */
    public TaskType getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskType }
     *     
     */
    public void setTask(TaskType value) {
        this.task = value;
    }

    /**
     * Gets the value of the tasks property.
     * 
     * @return
     *     possible object is
     *     {@link TaskListType }
     *     
     */
    public TaskListType getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskListType }
     *     
     */
    public void setTasks(TaskListType value) {
        this.tasks = value;
    }

}
