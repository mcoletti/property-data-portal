package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "statusCode")
@XmlType(name = "statusCode",namespace = PDPServiceConstants.NAMESPACE)
public class StatusCode implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the STATUS_CODE table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column CODE_NAME in the STATUS_CODE table.
	 */
    private String codeName;

	/** 
	 * This attribute maps to the column CODE_VALUE in the STATUS_CODE table.
	 */
    private String codeValue;

	/** 
	 * This attribute maps to the column DELETE_IND in the STATUS_CODE table.
	 */
    private short deleteInd;

	/**
	 * Method 'StatusCode'
	 * 
	 */
	public StatusCode()
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
	 * Method 'getCodeName'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getCodeName()
	{
		return codeName;
	}

	/**
	 * Method 'setCodeName'
	 * 
	 * @param codeName
	 */
	public void setCodeName(String codeName)
	{
		this.codeName = codeName;
	}

	/**
	 * Method 'getCodeValue'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getCodeValue()
	{
		return codeValue;
	}

	/**
	 * Method 'setCodeValue'
	 * 
	 * @param codeValue
	 */
	public void setCodeValue(String codeValue)
	{
		this.codeValue = codeValue;
	}

	/**
	 * Method 'getDeleteInd'
	 * 
	 * @return short
	 */
    @XmlElement
	public short getDeleteInd()
	{
		return deleteInd;
	}

	/**
	 * Method 'setDeleteInd'
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
	 * @return StatusCodePk
	 */
	public StatusCodePk createPk()
	{
		return new StatusCodePk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.StatusCode: " );
		ret.append( "id=" + id );
		ret.append( ", codeName=" + codeName );
		ret.append( ", codeValue=" + codeValue );
		ret.append( ", deleteInd=" + deleteInd );
		return ret.toString();
	}

}
