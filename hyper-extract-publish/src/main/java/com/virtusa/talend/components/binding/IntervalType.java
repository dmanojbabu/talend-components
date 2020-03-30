package com.virtusa.talend.components.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Java class for intervalType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="intervalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="minutes">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *             &lt;enumeration value="15"/>
 *             &lt;enumeration value="30"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="hours">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="2"/>
 *             &lt;enumeration value="4"/>
 *             &lt;enumeration value="6"/>
 *             &lt;enumeration value="8"/>
 *             &lt;enumeration value="12"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="weekDay">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Monday"/>
 *             &lt;enumeration value="Tuesday"/>
 *             &lt;enumeration value="Wednesday"/>
 *             &lt;enumeration value="Thursday"/>
 *             &lt;enumeration value="Friday"/>
 *             &lt;enumeration value="Saturday"/>
 *             &lt;enumeration value="Sunday"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="monthDay">
 *         &lt;simpleType>
 *           &lt;union>
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                 &lt;minInclusive value="1"/>
 *                 &lt;maxInclusive value="31"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                 &lt;enumeration value="LastDay"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/union>
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
@XmlType(name = "intervalType")
public class IntervalType {

    @XmlAttribute(name = "minutes")
    protected BigInteger minutes;
    @XmlAttribute(name = "hours")
    protected BigInteger hours;
    @XmlAttribute(name = "weekDay")
    protected String weekDay;
    @XmlAttribute(name = "monthDay")
    protected String monthDay;

    /**
     * Gets the value of the minutes property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getMinutes() {
        return minutes;
    }

    /**
     * Sets the value of the minutes property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setMinutes(BigInteger value) {
        this.minutes = value;
    }

    /**
     * Gets the value of the hours property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getHours() {
        return hours;
    }

    /**
     * Sets the value of the hours property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setHours(BigInteger value) {
        this.hours = value;
    }

    /**
     * Gets the value of the weekDay property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWeekDay() {
        return weekDay;
    }

    /**
     * Sets the value of the weekDay property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWeekDay(String value) {
        this.weekDay = value;
    }

    /**
     * Gets the value of the monthDay property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMonthDay() {
        return monthDay;
    }

    /**
     * Sets the value of the monthDay property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMonthDay(String value) {
        this.monthDay = value;
    }

}