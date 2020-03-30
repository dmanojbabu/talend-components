package com.virtusa.talend.components.binding;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for taskExtractRefreshType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="taskExtractRefreshType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="schedule" type="{http://tableau.com/api}scheduleType" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="view" type="{http://tableau.com/api}viewType"/>
 *           &lt;element name="workbook" type="{http://tableau.com/api}workbookType"/>
 *           &lt;element name="datasource" type="{http://tableau.com/api}dataSourceType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="consecutiveFailedCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="incremental" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskExtractRefreshType", propOrder = {
        "schedule",
        "view",
        "workbook",
        "datasource"
})
public class TaskExtractRefreshType {

    protected ScheduleType schedule;
    protected ViewType view;
    protected WorkbookType workbook;
    protected DataSourceType datasource;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "priority")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger priority;
    @XmlAttribute(name = "consecutiveFailedCount")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger consecutiveFailedCount;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "incremental")
    protected Boolean incremental;

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
     * Gets the value of the view property.
     *
     * @return
     *     possible object is
     *     {@link ViewType }
     *
     */
    public ViewType getView() {
        return view;
    }

    /**
     * Sets the value of the view property.
     *
     * @param value
     *     allowed object is
     *     {@link ViewType }
     *
     */
    public void setView(ViewType value) {
        this.view = value;
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
     * Gets the value of the consecutiveFailedCount property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getConsecutiveFailedCount() {
        return consecutiveFailedCount;
    }

    /**
     * Sets the value of the consecutiveFailedCount property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setConsecutiveFailedCount(BigInteger value) {
        this.consecutiveFailedCount = value;
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
     * Gets the value of the incremental property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isIncremental() {
        return incremental;
    }

    /**
     * Sets the value of the incremental property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setIncremental(Boolean value) {
        this.incremental = value;
    }

}