package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "propertyData")
@XmlType(name = "propertyData",namespace = PDPServiceConstants.NAMESPACE)
public class PropertyData implements Serializable
{
    /**
     * This attribute maps to the column UUID in the PROPERTY_DATA table.
     */
    private String uuid;

    /**
     * This attribute maps to the column PROP_NAME in the PROPERTY_DATA table.
     */
    private String propName;

    /**
     * This attribute maps to the column PRICE in the PROPERTY_DATA table.
     */
    private float price;

    /**
     * This attribute maps to the column SQFT in the PROPERTY_DATA table.
     */
    private float sqft;

    /**
     * This attribute maps to the column DESCRIPTION in the PROPERTY_DATA table.
     */
    private String description;

    /**
     * This attribute maps to the column NUM_BEDS in the PROPERTY_DATA table.
     */
    private float numBeds;

    /**
     * This attribute maps to the column NUM_BATHS in the PROPERTY_DATA table.
     */
    private float numBaths;

    /**
     * This attribute maps to the column DATA_SOURCE_ID in the PROPERTY_DATA table.
     */
    private int dataSourceId;

    /**
     * This attribute maps to the column ZIP_CODE in the PROPERTY_DATA table.
     */
    private int zipCode;

    /**
     * This attribute maps to the column PROPERTY_STATUS_ID in the PROPERTY_DATA table.
     */
    private int propertyStatusId;

    /**
     * This attribute maps to the column PROPERTY_TYPE_ID in the PROPERTY_DATA table.
     */
    private int propertyTypeId;

    /**
     * This attribute maps to the column MARKET_ID in the PROPERTY_DATA table.
     */
    private int marketId;

    /**
     * This attribute maps to the column YEAR_BUILT in the PROPERTY_DATA table.
     */
    private int yearBuilt;

    /**
     * This attribute maps to the column LOT_SIZE in the PROPERTY_DATA table.
     */
    private float lotSize;

    /**
     * Method 'PropertyData'
     *
     */
    public PropertyData()
    {
    }

    /**
     *
     * @param uuid
     * @param propName
     * @param price
     * @param sqft
     * @param description
     * @param numBeds
     * @param numBaths
     * @param dataSourceId
     * @param zipCode
     * @param propertyStatusId
     * @param propertyTypeId
     * @param marketId
     * @param yearBuilt
     * @param lotSize
     */
    public PropertyData(String uuid, String propName, float price, float sqft, String description, float numBeds, float numBaths, int dataSourceId, int zipCode, int propertyStatusId, int propertyTypeId, int marketId, int yearBuilt, float lotSize) {
        this.uuid = uuid;
        this.propName = propName;
        this.price = price;
        this.sqft = sqft;
        this.description = description;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
        this.dataSourceId = dataSourceId;
        this.zipCode = zipCode;
        this.propertyStatusId = propertyStatusId;
        this.propertyTypeId = propertyTypeId;
        this.marketId = marketId;
        this.yearBuilt = yearBuilt;
        this.lotSize = lotSize;
    }

    /**
     * Method 'getCustomerUuid'
     *
     * @return String
     */
    @XmlElement
    public String getUuid()
    {
        return uuid;
    }

    /**
     * Method 'setCustomerUuid'
     *
     * @param uuid
     */
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    /**
     * Method 'getPropName'
     *
     * @return String
     */
    @XmlElement
    public String getPropName()
    {
        return propName;
    }

    /**
     * Method 'setPropName'
     *
     * @param propName
     */
    public void setPropName(String propName)
    {
        this.propName = propName;
    }

    /**
     * Method 'getPrice'
     *
     * @return float
     */
    @XmlElement
    public float getPrice()
    {
        return price;
    }

    /**
     * Method 'setPrice'
     *
     * @param price
     */
    public void setPrice(float price)
    {
        this.price = price;
    }

    /**
     * Method 'getSqft'
     *
     * @return float
     */
    @XmlElement
    public float getSqft()
    {
        return sqft;
    }

    /**
     * Method 'setSqft'
     *
     * @param sqft
     */
    public void setSqft(float sqft)
    {
        this.sqft = sqft;
    }

    /**
     * Method 'getDescription'
     *
     * @return String
     */
    @XmlElement
    public String getDescription()
    {
        return description;
    }

    /**
     * Method 'setDescription'
     *
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Method 'getNumBeds'
     *
     * @return float
     */
    @XmlElement
    public float getNumBeds()
    {
        return numBeds;
    }

    /**
     * Method 'setNumBeds'
     *
     * @param numBeds
     */
    public void setNumBeds(float numBeds)
    {
        this.numBeds = numBeds;
    }

    /**
     * Method 'getNumBaths'
     *
     * @return float
     */
    @XmlElement
    public float getNumBaths()
    {
        return numBaths;
    }

    /**
     * Method 'setNumBaths'
     *
     * @param numBaths
     */
    public void setNumBaths(float numBaths)
    {
        this.numBaths = numBaths;
    }

    /**
     * Method 'getDataSourceId'
     *
     * @return int
     */
    @XmlElement
    public int getDataSourceId()
    {
        return dataSourceId;
    }

    /**
     * Method 'setDataSourceId'
     *
     * @param dataSourceId
     */
    public void setDataSourceId(int dataSourceId)
    {
        this.dataSourceId = dataSourceId;
    }

    /**
     * Method 'getZipCode'
     *
     * @return int
     */
    @XmlElement
    public int getZipCode()
    {
        return zipCode;
    }

    /**
     * Method 'setZipCode'
     *
     * @param zipCode
     */
    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    /**
     * Method 'getPropertyStatusId'
     *
     * @return int
     */
    @XmlElement
    public int getPropertyStatusId()
    {
        return propertyStatusId;
    }

    /**
     * Method 'setPropertyStatusId'
     *
     * @param propertyStatusId
     */
    public void setPropertyStatusId(int propertyStatusId)
    {
        this.propertyStatusId = propertyStatusId;
    }

    /**
     * Method 'getPropertyTypeId'
     *
     * @return int
     */
    @XmlElement
    public int getPropertyTypeId()
    {
        return propertyTypeId;
    }

    /**
     * Method 'setPropertyTypeId'
     *
     * @param propertyTypeId
     */
    public void setPropertyTypeId(int propertyTypeId)
    {
        this.propertyTypeId = propertyTypeId;
    }

    /**
     * Method 'getYearBuilt'
     *
     * @return int
     */
    @XmlElement
    public int getYearBuilt()
    {
        return yearBuilt;
    }

    /**
     * Method 'setYearBuilt'
     *
     * @param yearBuilt
     */
    public void setYearBuilt(int yearBuilt)
    {
        this.yearBuilt = yearBuilt;
    }

    /**
     * Method 'getLotSize'
     *
     * @return float
     */
    @XmlElement
    public float getLotSize()
    {
        return lotSize;
    }

    /**
     * Method 'setLotSize'
     *
     * @param lotSize
     */
    public void setLotSize(float lotSize)
    {
        this.lotSize = lotSize;
    }

    /**
     * Method 'getMarketId'
     *
     * @return int
     */
    @XmlElement
    public int getMarketId()
    {
        return marketId;
    }

    /**
     * Method 'setMarketId'
     *
     * @param marketId
     */
    public void setMarketId(int marketId)
    {
        this.marketId = marketId;
    }


    /**
     * Method 'toString'
     *
     * @return String
     */
    public String toString()
    {
        StringBuffer ret = new StringBuffer();
        ret.append( "com.codeitek.pdp.model.PropertyData: " );
        ret.append( "customerUuid=" + uuid );
        ret.append( ", propName=" + propName );
        ret.append( ", price=" + price );
        ret.append( ", sqft=" + sqft );
        ret.append( ", description=" + description );
        ret.append( ", numBeds=" + numBeds );
        ret.append( ", numBaths=" + numBaths );
        ret.append( ", dataSourceId=" + dataSourceId );
        ret.append( ", zipCode=" + zipCode );
        ret.append( ", propertyStatusId=" + propertyStatusId );
        ret.append( ", yearBuilt=" + yearBuilt );
        ret.append( ", lotSize=" + lotSize );
        ret.append( ", marketId=" + marketId );
        return ret.toString();
    }

}
