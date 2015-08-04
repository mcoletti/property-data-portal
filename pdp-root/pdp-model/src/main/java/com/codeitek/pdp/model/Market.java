package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "market")
@XmlType(name = "market",namespace = PDPServiceConstants.NAMESPACE)
public class Market implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the MARKET table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column NAME in the MARKET table.
	 */
    private String name;

	/** 
	 * This attribute maps to the column DELETE_IND in the MARKET table.
	 */
    private boolean deleteInd;

	/**
	 * Method 'Market'
	 * 
	 */
	public Market()
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
	 * Method 'getName'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getName()
	{
		return name;
	}

	/**
	 * Method 'setName'
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Method 'getDeleteInd'
	 * 
	 * @return short
	 */
    @XmlElement
	public boolean getDeleteInd()
	{
		return deleteInd;
	}

	/**
	 * Method 'setDeleteInd'
	 * 
	 * @param deleteInd
	 */
	public void setDeleteInd(boolean deleteInd)
	{
		this.deleteInd = deleteInd;
	}



	/**
	 * Method 'createPk'
	 * 
	 * @return MarketPk
	 */
	public MarketPk createPk()
	{
		return new MarketPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.Market: " );
		ret.append( "id=" + id );
		ret.append( ", name=" + name );
		ret.append( ", deleteInd=" + deleteInd );
		return ret.toString();
	}

}
