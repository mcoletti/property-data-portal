package com.codeitek.pdp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the UI_SECTION_GROUPS table.
 */
public class UiSectionGroupsPk implements Serializable
{
	protected int aInt;

	/** 
	 * This attribute represents whether the primitive attribute aInt is null.
	 */
	protected boolean aIntNull;

	/** 
	 * Sets the value of aInt
	 */
	public void setAInt(int aInt)
	{
		this.aInt = aInt;
	}

	/** 
	 * Gets the value of aInt
	 */
	public int getAInt()
	{
		return aInt;
	}

	/**
	 * Method 'UiSectionGroupsPk'
	 * 
	 */
	public UiSectionGroupsPk()
	{
	}

	/**
	 * Method 'UiSectionGroupsPk'
	 * 
	 * @param aInt
	 */
	public UiSectionGroupsPk(final int aInt)
	{
		this.aInt = aInt;
	}

	/** 
	 * Sets the value of aIntNull
	 */
	public void setAIntNull(boolean aIntNull)
	{
		this.aIntNull = aIntNull;
	}

	/** 
	 * Gets the value of aIntNull
	 */
	public boolean isAIntNull()
	{
		return aIntNull;
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
		
		if (!(_other instanceof UiSectionGroupsPk)) {
			return false;
		}
		
		final UiSectionGroupsPk _cast = (UiSectionGroupsPk) _other;
		if (aInt != _cast.aInt) {
			return false;
		}
		
		if (aIntNull != _cast.aIntNull) {
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
		_hashCode = 29 * _hashCode + aInt;
		_hashCode = 29 * _hashCode + (aIntNull ? 1 : 0);
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
		ret.append( "com.codeitek.pdp.model.UiSectionGroupsPk: " );
		ret.append( "aInt=" + aInt );
		return ret.toString();
	}

}
