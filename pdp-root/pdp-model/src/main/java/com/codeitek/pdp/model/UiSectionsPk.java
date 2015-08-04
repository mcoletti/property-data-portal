package com.codeitek.pdp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the UI_SECTIONS table.
 */
public class UiSectionsPk implements Serializable
{
	protected int id;

	protected String sectionKey;

	/** 
	 * This attribute represents whether the primitive attribute id is null.
	 */
	protected boolean idNull;

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
	 * Sets the value of sectionKey
	 */
	public void setSectionKey(String sectionKey)
	{
		this.sectionKey = sectionKey;
	}

	/** 
	 * Gets the value of sectionKey
	 */
	public String getSectionKey()
	{
		return sectionKey;
	}

	/**
	 * Method 'UiSectionsPk'
	 * 
	 */
	public UiSectionsPk()
	{
	}

	/**
	 * Method 'UiSectionsPk'
	 * 
	 * @param id
	 * @param sectionKey
	 */
	public UiSectionsPk(final int id, final String sectionKey)
	{
		this.id = id;
		this.sectionKey = sectionKey;
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
		
		if (!(_other instanceof UiSectionsPk)) {
			return false;
		}
		
		final UiSectionsPk _cast = (UiSectionsPk) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (sectionKey == null ? _cast.sectionKey != sectionKey : !sectionKey.equals( _cast.sectionKey )) {
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
		if (sectionKey != null) {
			_hashCode = 29 * _hashCode + sectionKey.hashCode();
		}
		
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
		ret.append( "com.codeitek.pdp.model.UiSectionsPk: " );
		ret.append( "id=" + id );
		ret.append( ", sectionKey=" + sectionKey );
		return ret.toString();
	}

}
