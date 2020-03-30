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
 *         &lt;element name="connection" type="{http://tableau.com/api}connectionType"/>
 *         &lt;element name="credentials" type="{http://tableau.com/api}tableauCredentialsType"/>
 *         &lt;element name="datasource" type="{http://tableau.com/api}dataSourceType"/>
 *         &lt;element name="favorite" type="{http://tableau.com/api}favoriteType"/>
 *         &lt;element name="group" type="{http://tableau.com/api}groupType"/>
 *         &lt;element name="permissions" type="{http://tableau.com/api}permissionsType"/>
 *         &lt;element name="project" type="{http://tableau.com/api}projectType"/>
 *         &lt;element name="schedule" type="{http://tableau.com/api}scheduleType"/>
 *         &lt;element name="site" type="{http://tableau.com/api}siteType"/>
 *         &lt;element name="tags" type="{http://tableau.com/api}tagListType"/>
 *         &lt;element name="user" type="{http://tableau.com/api}userType"/>
 *         &lt;element name="workbook" type="{http://tableau.com/api}workbookType"/>
 *         &lt;element name="subscription" type="{http://tableau.com/api}subscriptionType"/>
 *         &lt;element name="task" type="{http://tableau.com/api}taskType"/>
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
        "connection",
        "credentials",
        "datasource",
        "favorite",
        "group",
        "permissions",
        "project",
        "schedule",
        "site",
        "tags",
        "user",
        "workbook",
        "subscription",
        "task"
})
@XmlRootElement(name = "tsRequest")
public class TsRequest {

    protected ConnectionType connection;
    protected TableauCredentialsType credentials;
    protected DataSourceType datasource;
    protected FavoriteType favorite;
    protected GroupType group;
    protected PermissionsType permissions;
    protected ProjectType project;
    protected ScheduleType schedule;
    protected SiteType site;
    protected TagListType tags;
    protected UserType user;
    protected WorkbookType workbook;
    protected SubscriptionType subscription;
    protected TaskType task;

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
     * Gets the value of the favorite property.
     *
     * @return
     *     possible object is
     *     {@link FavoriteType }
     *
     */
    public FavoriteType getFavorite() {
        return favorite;
    }

    /**
     * Sets the value of the favorite property.
     *
     * @param value
     *     allowed object is
     *     {@link FavoriteType }
     *
     */
    public void setFavorite(FavoriteType value) {
        this.favorite = value;
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

}