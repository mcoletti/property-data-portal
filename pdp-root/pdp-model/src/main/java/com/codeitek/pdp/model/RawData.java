package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "rawData")
@XmlType(name = "rawData",namespace = PDPServiceConstants.NAMESPACE)
public class RawData implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the RAW_DATA table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column DATA_VALUE in the RAW_DATA table.
	 */
	private String dataValue;

	/**
	 * Method 'RawData'
	 * 
	 */
	public RawData()
	{
	}

    /**
     * Full Constructor
     * @param id
     * @param dataValue
     */

    public RawData(int id, String dataValue) {
        this.id = id;
        this.dataValue = dataValue;
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
	 * Method 'getDataValue'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getDataValue()
	{
		return dataValue;
	}

	/**
	 * Method 'setDataValue'
	 * 
	 * @param dataValue
	 */
	public void setDataValue(String dataValue)
	{
		this.dataValue = dataValue;
	}



	/**
	 * Method 'createPk'
	 * 
	 * @return RawDataPk
	 */
	public RawDataPk createPk()
	{
		return new RawDataPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.RawData: " );
		ret.append( "id=" + id );
		ret.append( ", dataValue=" + dataValue );
		return ret.toString();
	}

}
