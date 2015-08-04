package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "attributes")
@XmlType(name = "attributes",namespace = PDPServiceConstants.NAMESPACE)
public class Attributes implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the ATTRIBUTES table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column KEY in the ATTRIBUTES table.
	 */
	private String key;

	/**
	 * Method 'Attributes'
	 * 
	 */
	public Attributes()
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
	 * Method 'getKey'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getKey()
	{
		return key;
	}

	/**
	 * Method 'setKey'
	 * 
	 * @param key
	 */
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return AttributesPk
	 */
	public AttributesPk createPk()
	{
		return new AttributesPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.Attributes: " );
		ret.append( "id=" + id );
		ret.append( ", key=" + key );
		return ret.toString();
	}

}
