package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "groups")
public class Groups implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the GROUPS table.
	 */
	public int id;

	/** 
	 * This attribute maps to the column GROUP_NAME in the GROUPS table.
	 */
	public String groupName;

	/**
	 * Method 'Groups'
	 * 
	 */
	public Groups()
	{
	}

    /**
     * Full Constructor
     * @param id
     * @param groupName
     */
    public Groups(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    /**
	 * Method 'getId'
	 * 
	 * @return int
	 */
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
	 * Method 'getGroupName'
	 * 
	 * @return String
	 */
	public String getGroupName()
	{
		return groupName;
	}

	/**
	 * Method 'setGroupName'
	 * 
	 * @param groupName
	 */
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof Groups)) {
			return false;
		}
		
		final Groups _cast = (Groups) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (groupName == null ? _cast.groupName != groupName : !groupName.equals( _cast.groupName )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + id;
		if (groupName != null) {
			_hashCode = 29 * _hashCode + groupName.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return GroupsPk
	 */
	public GroupsPk createPk()
	{
		return new GroupsPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.Groups: " );
		ret.append( "id=" + id );
		ret.append( ", groupName=" + groupName );
		return ret.toString();
	}

}
