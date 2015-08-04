package com.codeitek.pdp.model;

import java.io.Serializable;

/** 
 * This class represents the primary key of the vw_UserGroups table.
 */
public class VwUserGroupsPk implements Serializable
{
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
		
		if (!(_other instanceof VwUserGroupsPk)) {
			return false;
		}
		
		final VwUserGroupsPk _cast = (VwUserGroupsPk) _other;
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
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.VwUsergroupsPk: " );
		return ret.toString();
	}

}
