package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;
@XmlRootElement(name = "propertyFinancial")
@XmlType(name = "propertyFinancial",namespace = PDPServiceConstants.NAMESPACE)
public class PropertyFinancial implements Serializable
{
    /**
     * This attribute maps to the column ID in the PROPERTY_FINACIAL table.
     */
    private int id;

    /**
     * This attribute maps to the column VALUE in the PROPERTY_FINACIAL table.
     */
    private BigDecimal value;

    /**
     * This attribute maps to the column FINACIAL_KEY_ID in the PROPERTY_FINACIAL table.
     */
    private int financialKeyId;

    /**
     * This attribute maps to the column PROPERTY_DATA_UUID in the PROPERTY_FINACIAL table.
     */
    private String propertyDataUuid;




    private FinancialKey financialKey;


    /**
     * Method 'PropertyFinacial'
     *
     */
    public PropertyFinancial()
    {
    }

    /**
     * Full Constructor
     * @param id
     * @param value
     * @param financialKeyId
     * @param propertyDataUuid
     * @param financialKey
     */
    public PropertyFinancial(int id, BigDecimal value, int financialKeyId, String propertyDataUuid, FinancialKey financialKey) {
        this.id = id;
        this.value = value;
        this.financialKeyId = financialKeyId;
        this.propertyDataUuid = propertyDataUuid;
        this.financialKey = financialKey;
    }

    /**
     * Method 'getId'
     *
     * @return int
     */
    @XmlElement
    public int getId()
    {
        return id;
    }

    /**
     * Method 'setId'
     *
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Method 'getValue'
     *
     * @return BigDecimal
     */
    @XmlElement
    public BigDecimal getValue()
    {
        return value;
    }

    /**
     * Method 'setValue'
     *
     * @param value
     */
    public void setValue(BigDecimal value)
    {
        this.value = value;
    }

    /**
     * Method 'getFinancialKeyId'
     *
     * @return int
     */
    @XmlElement
    public int getFinancialKeyId()
    {
        return financialKeyId;
    }

    /**
     * Method 'setFinancialKeyId'
     *
     * @param financialKeyId
     */
    public void setFinancialKeyId(int financialKeyId)
    {
        this.financialKeyId = financialKeyId;
    }

    /**
     * Method 'getPropertyDataUuid'
     *
     * @return String
     */
    @XmlElement
    public String getPropertyDataUuid()
    {
        return propertyDataUuid;
    }

    /**
     * Method 'createPk'
     *
     * @return PropertyFinacialPk
     */
    public PropertyFinancialPk createPk()
    {
        return new PropertyFinancialPk(id);
    }

    /**
     * Method 'setPropertyDataUuid'
     *
     * @param propertyDataUuid
     */
    public void setPropertyDataUuid(String propertyDataUuid)
    {
        this.propertyDataUuid = propertyDataUuid;
    }

    /**
     * Method Get the Property Financial Key Data Object
     * @return
     */
    @XmlElement
    public FinancialKey getFinancialKey() {
        return financialKey;
    }

    public void setFinancialKey(FinancialKey financialKey) {
        this.financialKey = financialKey;
    }
    /**
     * Method 'toString'
     *
     * @return String
     */
    public String toString()
    {
        StringBuffer ret = new StringBuffer();
        ret.append( "com.codeitek.pdp.model.PropertyFinacial: " );
        ret.append( "id=" + id );
        ret.append( ", value=" + value );
        ret.append( ", financialKeyId=" + financialKeyId);
        ret.append( ", propertyDataUuid=" + propertyDataUuid );
        return ret.toString();
    }

}
