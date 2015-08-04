package com.codeitek.pdp.model;

import java.io.Serializable;

/** 
 * This class represents the primary key of the vw_UserSystemRoles table.
 */
public class VwUserSystemRolesPk implements Serializable
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
		
		if (!(_other instanceof VwUserSystemRolesPk)) {
			return false;
		}
		
		final VwUserSystemRolesPk _cast = (VwUserSystemRolesPk) _other;
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
		ret.append( "com.codeitek.pdp.model.VwUsersystemrolesPk: " );
		return ret.toString();
	}

}
