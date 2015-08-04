package com.codeitek.pdp.model;

import java.io.Serializable;

/** 
 * This class represents the primary key of the MARKET table.
 */
public class MarketPk implements Serializable
{
	private int id;

	/** 
	 * This attribute represents whether the primitive attribute id is null.
	 */
    private boolean idNull;

	/** 
	 * Sets the value of id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/** 
	 * Gets the value of id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Method 'MarketPk'
	 * 
	 */
	public MarketPk()
	{
	}

	/**
	 * Method 'MarketPk'
	 * 
	 * @param id
	 */
	public MarketPk(final int id)
	{
		this.id = id;
	}

	/** 
	 * Sets the value of idNull
	 */
	public void setIdNull(boolean idNull)
	{
		this.idNull = idNull;
	}

	/** 
	 * Gets the value of idNull
	 */
	public boolean isIdNull()
	{
		return idNull;
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
		
		if (!(_other instanceof MarketPk)) {
			return false;
		}
		
		final MarketPk _cast = (MarketPk) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (idNull != _cast.idNull) {
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
		_hashCode = 29 * _hashCode + (idNull ? 1 : 0);
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
		ret.append( "com.codeitek.pdp.dto.MarketPk: " );
		ret.append( "id=" + id );
		return ret.toString();
	}

}
