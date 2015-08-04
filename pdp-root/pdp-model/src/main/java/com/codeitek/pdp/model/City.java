package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "city")
@XmlType(name = "city",namespace = PDPServiceConstants.NAMESPACE)
public class City implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the CITY table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column CITY in the CITY table.
	 */
	private String cityName;

	/** 
	 * This attribute maps to the column SUMMARY in the CITY table.
	 */
	private String summary;

	/** 
	 * This attribute maps to the column IMAGE_URL in the CITY table.
	 */
	private String imageUrl;

	/** 
	 * This attribute maps to the column STATE_ID in the CITY table.
	 */
	private int stateId;

	/**
	 * Method 'City'
	 * 
	 */
	public City()
	{
	}

    /**
     * Full Constructor
     * @param id
     * @param cityName
     * @param summary
     * @param imageUrl
     * @param stateId
     */
    public City(int id, String cityName, String summary, String imageUrl, int stateId) {
        this.id = id;
        this.cityName = cityName;
        this.summary = summary;
        this.imageUrl = imageUrl;
        this.stateId = stateId;
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
	 * Method 'getCityName'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getCityName()
	{
		return cityName;
	}

	/**
	 * Method 'setCityName'
	 * 
	 * @param cityName
	 */
	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	/**
	 * Method 'getSummary'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getSummary()
	{
		return summary;
	}

	/**
	 * Method 'setSummary'
	 * 
	 * @param summary
	 */
	public void setSummary(String summary)
	{
		this.summary = summary;
	}

	/**
	 * Method 'getImageUrl'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getImageUrl()
	{
		return imageUrl;
	}

	/**
	 * Method 'setImageUrl'
	 * 
	 * @param imageUrl
	 */
	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}

	/**
	 * Method 'getStateId'
	 * 
	 * @return int
	 */
    @XmlElement
	public int getStateId()
	{
		return stateId;
	}

	/**
	 * Method 'setStateId'
	 * 
	 * @param stateId
	 */
	public void setStateId(int stateId)
	{
		this.stateId = stateId;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return CityPk
	 */
	public CityPk createPk()
	{
		return new CityPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.City: " );
		ret.append( "id=" + id );
		ret.append( ", cityName=" + cityName);
		ret.append( ", summary=" + summary );
		ret.append( ", imageUrl=" + imageUrl );
		ret.append( ", stateId=" + stateId );
		return ret.toString();
	}

}
