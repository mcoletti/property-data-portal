package com.codeitek.pdp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the PROPERTY_DATA table.
 */
@Deprecated
public class PropertyDataPk implements Serializable
{
	protected String uuid;

	/** 
	 * Sets the value of customerUuid
	 */
	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	/** 
	 * Gets the value of customerUuid
	 */
	public String getUuid()
	{
		return uuid;
	}

	/**
	 * Method 'PropertyDataPk'
	 * 
	 */
	public PropertyDataPk()
	{
	}

	/**
	 * Method 'PropertyDataPk'
	 * 
	 * @param uuid
	 */
	public PropertyDataPk(final String uuid)
	{
		this.uuid = uuid;
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
		
		if (!(_other instanceof PropertyDataPk)) {
			return false;
		}
		
		final PropertyDataPk _cast = (PropertyDataPk) _other;
		if (uuid == null ? _cast.uuid != uuid : !uuid.equals( _cast.uuid )) {
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
		if (uuid != null) {
			_hashCode = 29 * _hashCode + uuid.hashCode();
		}
		
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
		ret.append( "com.codeitek.pdp.model.PropertyDataPk: " );
		ret.append( "customerUuid=" + uuid );
		return ret.toString();
	}

}
