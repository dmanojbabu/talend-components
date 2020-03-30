package com.virtusa.talend.components.binding;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dataSourceType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="dataSourceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="connectionCredentials" type="{http://tableau.com/api}connectionCredentialsType" minOccurs="0"/>
 *         &lt;element name="site" type="{http://tableau.com/api}siteType" minOccurs="0"/>
 *         &lt;element name="project" type="{http://tableau.com/api}projectType" minOccurs="0"/>
 *         &lt;element name="owner" type="{http://tableau.com/api}userType" minOccurs="0"/>
 *         &lt;element name="tags" type="{http://tableau.com/api}tagListType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://tableau.com/api}resourceIdType" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="contentUrl" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="createdAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="updatedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="isCertified" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="certificationNote" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataSourceType", propOrder = {
        "connectionCredentials",
        "site",
        "project",
        "owner",
        "tags"
})
public class DataSourceType {

    protected ConnectionCredentialsType connectionCredentials;
    protected SiteType site;
    protected ProjectType project;
    protected UserType owner;
    protected TagListType tags;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "contentUrl")
    protected String contentUrl;
    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "createdAt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;
    @XmlAttribute(name = "updatedAt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedAt;
    @XmlAttribute(name = "isCertified")
    protected Boolean isCertified;
    @XmlAttribute(name = "certificationNote")
    protected String certificationNote;

    /**
     * Gets the value of the connectionCredentials property.
     *
     * @return
     *     possible object is
     *     {@link ConnectionCredentialsType }
     *
     */
    public ConnectionCredentialsType getConnectionCredentials() {
        return connectionCredentials;
    }

    /**
     * Sets the value of the connectionCredentials property.
     *
     * @param value
     *     allowed object is
     *     {@link ConnectionCredentialsType }
     *
     */
    public void setConnectionCredentials(ConnectionCredentialsType value) {
        this.connectionCredentials = value;
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
     * Gets the value of the owner property.
     *
     * @return
     *     possible object is
     *     {@link UserType }
     *
     */
    public UserType getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     *
     * @param value
     *     allowed object is
     *     {@link UserType }
     *
     */
    public void setOwner(UserType value) {
        this.owner = value;
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
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the contentUrl property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContentUrl() {
        return contentUrl;
    }

    /**
     * Sets the value of the contentUrl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContentUrl(String value) {
        this.contentUrl = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the createdAt property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the createdAt property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setCreatedAt(XMLGregorianCalendar value) {
        this.createdAt = value;
    }

    /**
     * Gets the value of the updatedAt property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the value of the updatedAt property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setUpdatedAt(XMLGregorianCalendar value) {
        this.updatedAt = value;
    }

    /**
     * Gets the value of the isCertified property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isIsCertified() {
        return isCertified;
    }

    /**
     * Sets the value of the isCertified property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setIsCertified(Boolean value) {
        this.isCertified = value;
    }

    /**
     * Gets the value of the certificationNote property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCertificationNote() {
        return certificationNote;
    }

    /**
     * Sets the value of the certificationNote property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCertificationNote(String value) {
        this.certificationNote = value;
    }

}