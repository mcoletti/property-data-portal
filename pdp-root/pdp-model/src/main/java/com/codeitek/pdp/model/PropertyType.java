package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "propertyType")
@XmlType(name = "propertyType",namespace = PDPServiceConstants.NAMESPACE)
public class PropertyType implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the PROPERTY_TYPE table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column TYPE in the PROPERTY_TYPE table.
	 */
	private String type;

	/** 
	 * This attribute maps to the column DELETE_IND in the PROPERTY_TYPE table.
	 */
	private short deleteInd;

	/**
	 * Method 'PropertyType'
	 * 
	 */
	public PropertyType()
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
	 * Method 'getType'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getType()
	{
		return type;
	}

	/**
	 * Method 'setType'
	 * 
	 * @param type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Method 'getCustomerDeleteInd'
	 * 
	 * @return short
	 */
    @XmlElement
	public short getDeleteInd()
	{
		return deleteInd;
	}

	/**
	 * Method 'setCustomerDeleteInd'
	 * 
	 * @param deleteInd
	 */
	public void setDeleteInd(short deleteInd)
	{
		this.deleteInd = deleteInd;
	}



	/**
	 * Method 'createPk'
	 * 
	 * @return PropertyTypePk
	 */
	public PropertyTypePk createPk()
	{
		return new PropertyTypePk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.PropertyType: " );
		ret.append( "id=" + id );
		ret.append( ", type=" + type );
		ret.append( ", customerDeleteInd=" + deleteInd );
		return ret.toString();
	}

}
