package com.codeitek.pdp.model;

import java.io.Serializable;

/** 
 * This class represents the primary key of the ZIP_CODES table.
 */
public class ZipCodesPk implements Serializable
{
	protected int zipCode;

	/** 
	 * This attribute represents whether the primitive attribute zipCode is null.
	 */
	protected boolean zipCodeNull;

	/** 
	 * Sets the value of zipCode
	 */
	public void setZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}

	/** 
	 * Gets the value of zipCode
	 */
	public int getZipCode()
	{
		return zipCode;
	}

	/**
	 * Method 'ZipCodesPk'
	 * 
	 */
	public ZipCodesPk()
	{
	}

	/**
	 * Method 'ZipCodesPk'
	 * 
	 * @param zipCode
	 */
	public ZipCodesPk(final int zipCode)
	{
		this.zipCode = zipCode;
	}

	/** 
	 * Sets the value of zipCodeNull
	 */
	public void setZipCodeNull(boolean zipCodeNull)
	{
		this.zipCodeNull = zipCodeNull;
	}

	/** 
	 * Gets the value of zipCodeNull
	 */
	public boolean isZipCodeNull()
	{
		return zipCodeNull;
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
		
		if (!(_other instanceof ZipCodesPk)) {
			return false;
		}
		
		final ZipCodesPk _cast = (ZipCodesPk) _other;
		if (zipCode != _cast.zipCode) {
			return false;
		}
		
		if (zipCodeNull != _cast.zipCodeNull) {
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
		_hashCode = 29 * _hashCode + zipCode;
		_hashCode = 29 * _hashCode + (zipCodeNull ? 1 : 0);
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
		ret.append( "com.codeitek.pdp.model.ZipCodesPk: " );
		ret.append( "zipCode=" + zipCode );
		return ret.toString();
	}

}
