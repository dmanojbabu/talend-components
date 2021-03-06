package com.virtusa.talend.components.binding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for siteUserAuthSettingType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="siteUserAuthSettingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ServerDefault"/>
 *     &lt;enumeration value="SAML"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "siteUserAuthSettingType")
@XmlEnum
public enum SiteUserAuthSettingType {

    @XmlEnumValue("ServerDefault")
    SERVER_DEFAULT("ServerDefault"),
    SAML("SAML");
    private final String value;

    SiteUserAuthSettingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SiteUserAuthSettingType fromValue(String v) {
        for (SiteUserAuthSettingType c: SiteUserAuthSettingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}