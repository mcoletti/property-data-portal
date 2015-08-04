package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "userAttributes")
@XmlType(name = "userAttributes",namespace = PDPServiceConstants.NAMESPACE)
public class UserAttributes implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the USER_ATTRIBUTES table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column ATTRIBUTE_VALUE in the USER_ATTRIBUTES table.
	 */
	private String attributeValue;

	/** 
	 * This attribute maps to the column ATTRIBUTES_ID in the USER_ATTRIBUTES table.
	 */
	private int attributesId;

	/** 
	 * This attribute maps to the column USER_UUID in the USER_ATTRIBUTES table.
	 */
	private String userUuid;

	/**
	 * Method 'UserAttributes'
	 * 
	 */
	public UserAttributes()
	{
	}

    /**
     * Full Constructor
     * @param id
     * @param attributeValue
     * @param attributesId
     * @param userUuid
     */
    public UserAttributes(int id, String attributeValue, int attributesId, String userUuid) {
        this.id = id;
        this.attributeValue = attributeValue;
        this.attributesId = attributesId;
        this.userUuid = userUuid;
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
	 * Method 'getAttributeValue'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getAttributeValue()
	{
		return attributeValue;
	}

	/**
	 * Method 'setAttributeValue'
	 * 
	 * @param attributeValue
	 */
	public void setAttributeValue(String attributeValue)
	{
		this.attributeValue = attributeValue;
	}

	/**
	 * Method 'getAttributesId'
	 * 
	 * @return int
	 */
    @XmlElement
	public int getAttributesId()
	{
		return attributesId;
	}

	/**
	 * Method 'setAttributesId'
	 * 
	 * @param attributesId
	 */
	public void setAttributesId(int attributesId)
	{
		this.attributesId = attributesId;
	}

	/**
	 * Method 'getUserUuid'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getUserUuid()
	{
		return userUuid;
	}

	/**
	 * Method 'setUserUuid'
	 * 
	 * @param userUuid
	 */
	public void setUserUuid(String userUuid)
	{
		this.userUuid = userUuid;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UserAttributesPk
	 */
	public UserAttributesPk createPk()
	{
		return new UserAttributesPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.UserAttributes: " );
		ret.append( "id=" + id );
		ret.append( ", attributeValue=" + attributeValue );
		ret.append( ", attributesId=" + attributesId );
		ret.append( ", userUuid=" + userUuid );
		return ret.toString();
	}

}
