package com.codeitek.pdp.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "propertyStatusMap")
@XmlType(name = "propertyStatusMap",namespace = PDPServiceConstants.NAMESPACE)
public class PropertyStatusMap implements Serializable
{
    /**
     * This attribute maps to the column ID in the PROPERTY_STATUS_MAP table.
     */
    public int id;

    /**
     * This attribute maps to the column PROPERTY_DATA_UUID in the PROPERTY_STATUS_MAP table.
     */
    public String propertyDataUuid;

    /**
     * This attribute maps to the column STATUS_CODE_ID in the PROPERTY_STATUS_MAP table.
     */
    public int statusCodeId;

    /**
     * Method 'PropertyStatusMap'
     *
     */
    public PropertyStatusMap()
    {
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
     * Method 'setPropertyDataUuid'
     *
     * @param propertyDataUuid
     */
    public void setPropertyDataUuid(String propertyDataUuid)
    {
        this.propertyDataUuid = propertyDataUuid;
    }

    /**
     * Method 'getStatusCodeId'
     *
     * @return int
     */
    @XmlElement
    public int getStatusCodeId()
    {
        return statusCodeId;
    }

    /**
     * Method 'setStatusCodeId'
     *
     * @param statusCodeId
     */
    public void setStatusCodeId(int statusCodeId)
    {
        this.statusCodeId = statusCodeId;
    }



    /**
     * Method 'createPk'
     *
     * @return PropertyStatusMapPk
     */
    public PropertyStatusMapPk createPk()
    {
        return new PropertyStatusMapPk(id);
    }

    /**
     * Method 'toString'
     *
     * @return String
     */
    public String toString()
    {
        StringBuffer ret = new StringBuffer();
        ret.append( "com.codeitek.pdp.model.PropertyStatusMap: " );
        ret.append( "id=" + id );
        ret.append( ", propertyDataUuid=" + propertyDataUuid );
        ret.append( ", statusCodeId=" + statusCodeId );
        return ret.toString();
    }

}
