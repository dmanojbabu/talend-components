//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.07 at 05:07:04 PM CET 
//


package com.virtusa.talend.components.binding;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


/**
 * <p>Java class for revisionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="revisionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="publisher" type="{http://tableau.com/api}userType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="revisionNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="publishedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="current" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="sizeInBytes" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "revisionType", propOrder = {
    "publisher"
})
public class RevisionType {

    protected UserType publisher;
    @XmlAttribute(name = "revisionNumber")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger revisionNumber;
    @XmlAttribute(name = "publishedAt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar publishedAt;
    @XmlAttribute(name = "deleted")
    protected Boolean deleted;
    @XmlAttribute(name = "current")
    protected Boolean current;
    @XmlAttribute(name = "sizeInBytes")
    protected Long sizeInBytes;

    /**
     * Gets the value of the publisher property.
     * 
     * @return
     *     possible object is
     *     {@link UserType }
     *     
     */
    public UserType getPublisher() {
        return publisher;
    }

    /**
     * Sets the value of the publisher property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserType }
     *     
     */
    public void setPublisher(UserType value) {
        this.publisher = value;
    }

    /**
     * Gets the value of the revisionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRevisionNumber() {
        return revisionNumber;
    }

    /**
     * Sets the value of the revisionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRevisionNumber(BigInteger value) {
        this.revisionNumber = value;
    }

    /**
     * Gets the value of the publishedAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPublishedAt() {
        return publishedAt;
    }

    /**
     * Sets the value of the publishedAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPublishedAt(XMLGregorianCalendar value) {
        this.publishedAt = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleted(Boolean value) {
        this.deleted = value;
    }

    /**
     * Gets the value of the current property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCurrent() {
        return current;
    }

    /**
     * Sets the value of the current property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCurrent(Boolean value) {
        this.current = value;
    }

    /**
     * Gets the value of the sizeInBytes property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSizeInBytes() {
        return sizeInBytes;
    }

    /**
     * Sets the value of the sizeInBytes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSizeInBytes(Long value) {
        this.sizeInBytes = value;
    }

}
