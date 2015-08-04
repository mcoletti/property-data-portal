package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "userGroups")
@XmlType(name = "userGroups",namespace = PDPServiceConstants.NAMESPACE)
public class ZipCodes implements Serializable
{
	/** 
	 * This attribute maps to the column ZIP_CODE in the ZIP_CODES table.
	 */
	private int zipCode;

	/** 
	 * This attribute maps to the column CITY_ID in the ZIP_CODES table.
	 */
	private int cityId;

	/**
	 * Method 'ZipCodes'
	 * 
	 */
	public ZipCodes()
	{
	}

    /**
     * Full Constructor
     * @param zipCode
     * @param cityId
     */
    public ZipCodes(int zipCode, int cityId) {
        this.zipCode = zipCode;
        this.cityId = cityId;
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
	 * Method 'getCityId'
	 * 
	 * @return int
	 */
    @XmlElement
	public int getCityId()
	{
		return cityId;
	}

	/**
	 * Method 'setCityId'
	 * 
	 * @param cityId
	 */
	public void setCityId(int cityId)
	{
		this.cityId = cityId;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return ZipCodesPk
	 */
	public ZipCodesPk createPk()
	{
		return new ZipCodesPk(zipCode);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.ZipCodes: " );
		ret.append( "zipCode=" + zipCode );
		ret.append( ", cityId=" + cityId );
		return ret.toString();
	}

}
