package com.virtusa.talend.components.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for projectType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="projectType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="owner" type="{http://tableau.com/api}userType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://tableau.com/api}resourceIdType" />
 *       &lt;attribute name="parentProjectId" type="{http://tableau.com/api}resourceIdType" />
 *       &lt;attribute name="topLevelProject" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="contentPermissions">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="LockedToProject"/>
 *             &lt;enumeration value="ManagedByOwner"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projectType", propOrder = {
        "owner"
})
public class ProjectType {

    protected UserType owner;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "parentProjectId")
    protected String parentProjectId;
    @XmlAttribute(name = "topLevelProject")
    protected Boolean topLevelProject;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "contentPermissions")
    protected String contentPermissions;

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
     * Gets the value of the parentProjectId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getParentProjectId() {
        return parentProjectId;
    }

    /**
     * Sets the value of the parentProjectId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setParentProjectId(String value) {
        this.parentProjectId = value;
    }

    /**
     * Gets the value of the topLevelProject property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isTopLevelProject() {
        return topLevelProject;
    }

    /**
     * Sets the value of the topLevelProject property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setTopLevelProject(Boolean value) {
        this.topLevelProject = value;
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
     * Gets the value of the contentPermissions property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContentPermissions() {
        return contentPermissions;
    }

    /**
     * Sets the value of the contentPermissions property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContentPermissions(String value) {
        this.contentPermissions = value;
    }

}