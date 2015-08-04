package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement(name = "uiElementTypes")
public class UiElementTypes implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the UI_ELEMENT_TYPES table.
	 */
	protected int id;

	/** 
	 * This attribute maps to the column TYPE_KEY in the UI_ELEMENT_TYPES table.
	 */
	protected String typeKey;

	/**
	 * Method 'UiElementTypes'
	 * 
	 */
	public UiElementTypes()
	{
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
	 * Method 'getTypeKey'
	 * 
	 * @return String
	 */
	public String getTypeKey()
	{
		return typeKey;
	}

	/**
	 * Method 'setTypeKey'
	 * 
	 * @param typeKey
	 */
	public void setTypeKey(String typeKey)
	{
		this.typeKey = typeKey;
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
		
		if (!(_other instanceof UiElementTypes)) {
			return false;
		}
		
		final UiElementTypes _cast = (UiElementTypes) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (typeKey == null ? _cast.typeKey != typeKey : !typeKey.equals( _cast.typeKey )) {
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
		if (typeKey != null) {
			_hashCode = 29 * _hashCode + typeKey.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UiElementTypesPk
	 */
	public UiElementTypesPk createPk()
	{
		return new UiElementTypesPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.UiElementTypes: " );
		ret.append( "id=" + id );
		ret.append( ", typeKey=" + typeKey );
		return ret.toString();
	}

}
