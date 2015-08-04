package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "state")
@XmlType(name = "state",namespace = PDPServiceConstants.NAMESPACE)
public class State implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the STATE table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column STATE in the STATE table.
	 */
	private String stateName;

	/** 
	 * This attribute maps to the column FULL_NAME in the STATE table.
	 */
	private String fullName;

	/**
	 * Method 'State'
	 * 
	 */
	public State()
	{
	}

    public State(int id, String stateName) {
        this.id = id;
        this.stateName = stateName;
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
	 * Method 'getStateName'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getStateName()
	{
		return stateName;
	}

	/**
	 * Method 'setStateName'
	 * 
	 * @param stateName
	 */
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

	/**
	 * Method 'getFullName'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getFullName()
	{
		return fullName;
	}

	/**
	 * Method 'setFullName'
	 * 
	 * @param fullName
	 */
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return StatePk
	 */
	public StatePk createPk()
	{
		return new StatePk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.State: " );
		ret.append( "id=" + id );
		ret.append( ", stateName=" + stateName);
		ret.append( ", fullName=" + fullName );
		return ret.toString();
	}

}
