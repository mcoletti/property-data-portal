package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/20/13
 * Time: 5:10 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
@XmlRootElement(name = "propertyFinancialView")
public class PropertyFinancialView implements Serializable {

    /**
     * Default Constructor
     */
    public PropertyFinancialView() {
    }

    /**
     *
     * @param id
     * @param propertyDataUuid
     * @param value
     * @param financialKey
     * @param displayName
     * @param financialKeyId
     */
    public PropertyFinancialView(int id, String propertyDataUuid, BigDecimal value, String financialKey, String displayName, int financialKeyId) {
        this.id = id;
        this.propertyDataUuid = propertyDataUuid;
        this.value = value;
        this.financialKey = financialKey;
        this.displayName = displayName;
        this.financialKeyId = financialKeyId;
    }

    private int id;
    private String propertyDataUuid;
    private BigDecimal value;
    private String financialKey;
    private String displayName;
    private int financialKeyId;


    @XmlElement
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @XmlElement
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @XmlElement
    public int getFinancialKeyId() {
        return financialKeyId;
    }

    public void setFinancialKeyId(int financialKeyId) {
        this.financialKeyId = financialKeyId;
    }

    @XmlElement
    public String getPropertyDataUuid() {
        return propertyDataUuid;
    }

    public void setPropertyDataUuid(String propertyDataUuid) {
        this.propertyDataUuid = propertyDataUuid;
    }

    @XmlElement
    public String getFinancialKey() {
        return financialKey;
    }

    public void setFinancialKey(String financialKey) {
        this.financialKey = financialKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyFinancialView that = (PropertyFinancialView) o;

        if (financialKeyId != that.financialKeyId) return false;
        if (id != that.id) return false;
//        if (Float.compare(that.value, value) != 0) return false;
        if (propertyDataUuid != null ? !propertyDataUuid.equals(that.propertyDataUuid) : that.propertyDataUuid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
//        result = 31 * result + (value != +0.0f ? Float.floatToIntBits(value) : 0);
        result = 31 * result + financialKeyId;
        result = 31 * result + (propertyDataUuid != null ? propertyDataUuid.hashCode() : 0);
        return result;
    }
}
