package com.virtusa.talend.components.binding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stateType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="stateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Suspended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "stateType")
@XmlEnum
public enum StateType {

    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("Suspended")
    SUSPENDED("Suspended");
    private final String value;

    StateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StateType fromValue(String v) {
        for (StateType c: StateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}