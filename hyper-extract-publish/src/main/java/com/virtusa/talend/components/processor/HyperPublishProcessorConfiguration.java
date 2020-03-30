package com.virtusa.talend.components.processor;

import java.io.Serializable;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.configuration.ui.widget.Credential;
import org.talend.sdk.component.api.meta.Documentation;

@GridLayout({
    // the generated layout put one configuration entry per line,
    // customize it as much as needed
    @GridLayout.Row({ "hostName" }),
    @GridLayout.Row({ "username" }),
    @GridLayout.Row({ "password" }),
    @GridLayout.Row({ "contentUrl" }),
    @GridLayout.Row({ "projectId" }),
    @GridLayout.Row({ "datasourceName" }),
    @GridLayout.Row({ "datasourceType" }),
    @GridLayout.Row({ "dataSourcePath" }),
    @GridLayout.Row({ "overwrite" }),
    @GridLayout.Row({ "append" })
})
@Documentation("TODO fill the documentation for this configuration")
public class HyperPublishProcessorConfiguration implements Serializable {
    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String hostName;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String username;

    @Credential
    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String password;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String contentUrl;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String projectId;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String datasourceName;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String datasourceType;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String dataSourcePath;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private boolean overwrite;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private boolean append;

    public String getHostName() {
        return hostName;
    }

    public HyperPublishProcessorConfiguration setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public HyperPublishProcessorConfiguration setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public HyperPublishProcessorConfiguration setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public HyperPublishProcessorConfiguration setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public HyperPublishProcessorConfiguration setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getDatasourceName() {
        return datasourceName;
    }

    public HyperPublishProcessorConfiguration setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
        return this;
    }

    public String getDatasourceType() {
        return datasourceType;
    }

    public HyperPublishProcessorConfiguration setDatasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
        return this;
    }

    public String getDataSourcePath() {
        return dataSourcePath;
    }

    public HyperPublishProcessorConfiguration setDataSourcePath(String dataSourcePath) {
        this.dataSourcePath = dataSourcePath;
        return this;
    }

    public boolean getOverwrite() {
        return overwrite;
    }

    public HyperPublishProcessorConfiguration setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
        return this;
    }

    public boolean getAppend() {
        return append;
    }

    public HyperPublishProcessorConfiguration setAppend(boolean append) {
        this.append = append;
        return this;
    }
}