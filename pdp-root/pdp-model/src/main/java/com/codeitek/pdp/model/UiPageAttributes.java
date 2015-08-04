package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement(name = "uiPageAttributes")
public class UiPageAttributes implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the UI_PAGE_ATTRIBUTES table.
	 */
	protected int id;

	/** 
	 * This attribute maps to the column ATTRUIBUTE_VALUE in the UI_PAGE_ATTRIBUTES table.
	 */
	protected String attruibuteValue;

	/** 
	 * This attribute maps to the column ATTRIBUTES_ID in the UI_PAGE_ATTRIBUTES table.
	 */
	protected int attributesId;

	/** 
	 * This attribute maps to the column UI_PAGE_LAYOUT_ID in the UI_PAGE_ATTRIBUTES table.
	 */
	protected int uiPageLayoutId;

	/**
	 * Method 'UiPageAttributes'
	 * 
	 */
	public UiPageAttributes()
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
	 * Method 'getAttruibuteValue'
	 * 
	 * @return String
	 */
	public String getAttruibuteValue()
	{
		return attruibuteValue;
	}

	/**
	 * Method 'setAttruibuteValue'
	 * 
	 * @param attruibuteValue
	 */
	public void setAttruibuteValue(String attruibuteValue)
	{
		this.attruibuteValue = attruibuteValue;
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
	 * Method 'getUiPageLayoutId'
	 * 
	 * @return int
	 */
	public int getUiPageLayoutId()
	{
		return uiPageLayoutId;
	}

	/**
	 * Method 'setUiPageLayoutId'
	 * 
	 * @param uiPageLayoutId
	 */
	public void setUiPageLayoutId(int uiPageLayoutId)
	{
		this.uiPageLayoutId = uiPageLayoutId;
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
		
		if (!(_other instanceof UiPageAttributes)) {
			return false;
		}
		
		final UiPageAttributes _cast = (UiPageAttributes) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (attruibuteValue == null ? _cast.attruibuteValue != attruibuteValue : !attruibuteValue.equals( _cast.attruibuteValue )) {
			return false;
		}
		
		if (attributesId != _cast.attributesId) {
			return false;
		}
		
		if (uiPageLayoutId != _cast.uiPageLayoutId) {
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
		if (attruibuteValue != null) {
			_hashCode = 29 * _hashCode + attruibuteValue.hashCode();
		}
		
		_hashCode = 29 * _hashCode + attributesId;
		_hashCode = 29 * _hashCode + uiPageLayoutId;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UiPageAttributesPk
	 */
	public UiPageAttributesPk createPk()
	{
		return new UiPageAttributesPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.UiPageAttributes: " );
		ret.append( "id=" + id );
		ret.append( ", attruibuteValue=" + attruibuteValue );
		ret.append( ", attributesId=" + attributesId );
		ret.append( ", uiPageLayoutId=" + uiPageLayoutId );
		return ret.toString();
	}

}
