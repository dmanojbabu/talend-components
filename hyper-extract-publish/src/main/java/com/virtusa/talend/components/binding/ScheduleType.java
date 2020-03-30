package com.virtusa.talend.components.binding;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


/**
 * <p>Java class for scheduleType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="scheduleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="frequencyDetails" type="{http://tableau.com/api}frequencyDetailsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://tableau.com/api}resourceIdType" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="state" type="{http://tableau.com/api}stateType" />
 *       &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="createdAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="updatedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Extract"/>
 *             &lt;enumeration value="Subscription"/>
 *             &lt;enumeration value="ActiveDirectorySync"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="frequency">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Hourly"/>
 *             &lt;enumeration value="Daily"/>
 *             &lt;enumeration value="Weekly"/>
 *             &lt;enumeration value="Monthly"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="nextRunAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="endScheduleAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="executionOrder">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Parallel"/>
 *             &lt;enumeration value="Serial"/>
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
@XmlType(name = "scheduleType", propOrder = {
        "frequencyDetails"
})
public class ScheduleType {

    protected FrequencyDetailsType frequencyDetails;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "state")
    protected StateType state;
    @XmlAttribute(name = "priority")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger priority;
    @XmlAttribute(name = "createdAt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;
    @XmlAttribute(name = "updatedAt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedAt;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "frequency")
    protected String frequency;
    @XmlAttribute(name = "nextRunAt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextRunAt;
    @XmlAttribute(name = "endScheduleAt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endScheduleAt;
    @XmlAttribute(name = "executionOrder")
    protected String executionOrder;

    /**
     * Gets the value of the frequencyDetails property.
     *
     * @return
     *     possible object is
     *     {@link FrequencyDetailsType }
     *
     */
    public FrequencyDetailsType getFrequencyDetails() {
        return frequencyDetails;
    }

    /**
     * Sets the value of the frequencyDetails property.
     *
     * @param value
     *     allowed object is
     *     {@link FrequencyDetailsType }
     *
     */
    public void setFrequencyDetails(FrequencyDetailsType value) {
        this.frequencyDetails = value;
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
     * Gets the value of the state property.
     *
     * @return
     *     possible object is
     *     {@link StateType }
     *
     */
    public StateType getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value
     *     allowed object is
     *     {@link StateType }
     *
     */
    public void setState(StateType value) {
        this.state = value;
    }

    /**
     * Gets the value of the priority property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setPriority(BigInteger value) {
        this.priority = value;
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
     * Gets the value of the frequency property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFrequency(String value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the nextRunAt property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getNextRunAt() {
        return nextRunAt;
    }

    /**
     * Sets the value of the nextRunAt property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setNextRunAt(XMLGregorianCalendar value) {
        this.nextRunAt = value;
    }

    /**
     * Gets the value of the endScheduleAt property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getEndScheduleAt() {
        return endScheduleAt;
    }

    /**
     * Sets the value of the endScheduleAt property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setEndScheduleAt(XMLGregorianCalendar value) {
        this.endScheduleAt = value;
    }

    /**
     * Gets the value of the executionOrder property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExecutionOrder() {
        return executionOrder;
    }

    /**
     * Sets the value of the executionOrder property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExecutionOrder(String value) {
        this.executionOrder = value;
    }

}