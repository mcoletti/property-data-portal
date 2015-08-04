package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "uiElementTypeAttributes")
public class UiElementTypeAttributes implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the UI_ELEMENT_TYPE_ATTRIBUTES table.
	 */
	protected int id;

	/** 
	 * This attribute maps to the column ATTRIBUTE_VALUE in the UI_ELEMENT_TYPE_ATTRIBUTES table.
	 */
	protected String attributeValue;

	/** 
	 * This attribute maps to the column UI_ELEMENT_TYPES_ID in the UI_ELEMENT_TYPE_ATTRIBUTES table.
	 */
	protected int uiElementTypesId;

	/** 
	 * This attribute maps to the column ATTRIBUTES_ID in the UI_ELEMENT_TYPE_ATTRIBUTES table.
	 */
	protected int attributesId;

	/**
	 * Method 'UiElementTypeAttributes'
	 * 
	 */
	public UiElementTypeAttributes()
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
	 * Method 'getAttributeValue'
	 * 
	 * @return String
	 */
	public String getAttributeValue()
	{
		return attributeValue;
	}

	/**
	 * Method 'setAttributeValue'
	 * 
	 * @param attributeValue
	 */
	public void setAttributeValue(String attributeValue)
	{
		this.attributeValue = attributeValue;
	}

	/**
	 * Method 'getUiElementTypesId'
	 * 
	 * @return int
	 */
	public int getUiElementTypesId()
	{
		return uiElementTypesId;
	}

	/**
	 * Method 'setUiElementTypesId'
	 * 
	 * @param uiElementTypesId
	 */
	public void setUiElementTypesId(int uiElementTypesId)
	{
		this.uiElementTypesId = uiElementTypesId;
	}

	/**
	 * Method 'getAttributesId'
	 * 
	 * @return int
	 */
	public int getAttributesId()
	{
		return attributesId;
	}

	/**
	 * Method 'setAttributesId'
	 * 
	 * @param attributesId
	 */
	public void setAttributesId(int attributesId)
	{
		this.attributesId = attributesId;
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
		
		if (!(_other instanceof UiElementTypeAttributes)) {
			return false;
		}
		
		final UiElementTypeAttributes _cast = (UiElementTypeAttributes) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (attributeValue == null ? _cast.attributeValue != attributeValue : !attributeValue.equals( _cast.attributeValue )) {
			return false;
		}
		
		if (uiElementTypesId != _cast.uiElementTypesId) {
			return false;
		}
		
		if (attributesId != _cast.attributesId) {
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
		if (attributeValue != null) {
			_hashCode = 29 * _hashCode + attributeValue.hashCode();
		}
		
		_hashCode = 29 * _hashCode + uiElementTypesId;
		_hashCode = 29 * _hashCode + attributesId;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UiElementTypeAttributesPk
	 */
	public UiElementTypeAttributesPk createPk()
	{
		return new UiElementTypeAttributesPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.UiElementTypeAttributes: " );
		ret.append( "id=" + id );
		ret.append( ", attributeValue=" + attributeValue );
		ret.append( ", uiElementTypesId=" + uiElementTypesId );
		ret.append( ", attributesId=" + attributesId );
		return ret.toString();
	}

}
