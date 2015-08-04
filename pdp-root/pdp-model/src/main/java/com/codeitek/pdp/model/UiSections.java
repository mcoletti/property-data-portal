package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "uiSections")
public class UiSections implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the UI_SECTIONS table.
	 */
	protected int id;

	/** 
	 * This attribute maps to the column SECTION_KEY in the UI_SECTIONS table.
	 */
	protected String sectionKey;

	/** 
	 * This attribute maps to the column DISPLAY_NAME in the UI_SECTIONS table.
	 */
	protected String displayName;

	/** 
	 * This attribute maps to the column SECTION_ORDER in the UI_SECTIONS table.
	 */
	protected int sectionOrder;

	/** 
	 * This attribute maps to the column UI_PAGE_LAYOUT_ID in the UI_SECTIONS table.
	 */
	protected int uiPageLayoutId;

	/**
	 * Method 'UiSections'
	 * 
	 */
	public UiSections()
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
	 * Method 'getSectionKey'
	 * 
	 * @return String
	 */
	public String getSectionKey()
	{
		return sectionKey;
	}

	/**
	 * Method 'setSectionKey'
	 * 
	 * @param sectionKey
	 */
	public void setSectionKey(String sectionKey)
	{
		this.sectionKey = sectionKey;
	}

	/**
	 * Method 'getDisplayName'
	 * 
	 * @return String
	 */
	public String getDisplayName()
	{
		return displayName;
	}

	/**
	 * Method 'setDisplayName'
	 * 
	 * @param displayName
	 */
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	/**
	 * Method 'getSectionOrder'
	 * 
	 * @return int
	 */
	public int getSectionOrder()
	{
		return sectionOrder;
	}

	/**
	 * Method 'setSectionOrder'
	 * 
	 * @param sectionOrder
	 */
	public void setSectionOrder(int sectionOrder)
	{
		this.sectionOrder = sectionOrder;
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
		
		if (!(_other instanceof UiSections)) {
			return false;
		}
		
		final UiSections _cast = (UiSections) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (sectionKey == null ? _cast.sectionKey != sectionKey : !sectionKey.equals( _cast.sectionKey )) {
			return false;
		}
		
		if (displayName == null ? _cast.displayName != displayName : !displayName.equals( _cast.displayName )) {
			return false;
		}
		
		if (sectionOrder != _cast.sectionOrder) {
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
		if (sectionKey != null) {
			_hashCode = 29 * _hashCode + sectionKey.hashCode();
		}
		
		if (displayName != null) {
			_hashCode = 29 * _hashCode + displayName.hashCode();
		}
		
		_hashCode = 29 * _hashCode + sectionOrder;
		_hashCode = 29 * _hashCode + uiPageLayoutId;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UiSectionsPk
	 */
	public UiSectionsPk createPk()
	{
		return new UiSectionsPk(id, sectionKey);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.UiSections: " );
		ret.append( "id=" + id );
		ret.append( ", sectionKey=" + sectionKey );
		ret.append( ", displayName=" + displayName );
		ret.append( ", sectionOrder=" + sectionOrder );
		ret.append( ", uiPageLayoutId=" + uiPageLayoutId );
		return ret.toString();
	}

}
