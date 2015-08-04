package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement(name = "uiSectionGroups")
public class UiSectionGroups implements Serializable
{
	/** 
	 * This attribute maps to the column INT in the UI_SECTION_GROUPS table.
	 */
	protected int aInt;

	/** 
	 * This attribute maps to the column GROUP_KEY in the UI_SECTION_GROUPS table.
	 */
	protected String groupKey;

	/** 
	 * This attribute maps to the column DISPLAY_NAME in the UI_SECTION_GROUPS table.
	 */
	protected String displayName;

	/** 
	 * This attribute maps to the column GROUP_ORDER in the UI_SECTION_GROUPS table.
	 */
	protected int groupOrder;

	/** 
	 * This attribute maps to the column SECTION_KEY in the UI_SECTION_GROUPS table.
	 */
	protected String sectionKey;

	/** 
	 * This attribute maps to the column DEFAULT_GROUP in the UI_SECTION_GROUPS table.
	 */
	protected short defaultGroup;

	/** 
	 * This attribute maps to the column UI_ELEMENT_TYPES_ID in the UI_SECTION_GROUPS table.
	 */
	protected int uiElementTypesId;

	/** 
	 * This attribute represents whether the primitive attribute uiElementTypesId is null.
	 */
	protected boolean uiElementTypesIdNull = true;

	/**
	 * Method 'UiSectionGroups'
	 * 
	 */
	public UiSectionGroups()
	{
	}

	/**
	 * Method 'getAInt'
	 * 
	 * @return int
	 */
	public int getAInt()
	{
		return aInt;
	}

	/**
	 * Method 'setAInt'
	 * 
	 * @param aInt
	 */
	public void setAInt(int aInt)
	{
		this.aInt = aInt;
	}

	/**
	 * Method 'getGroupKey'
	 * 
	 * @return String
	 */
	public String getGroupKey()
	{
		return groupKey;
	}

	/**
	 * Method 'setGroupKey'
	 * 
	 * @param groupKey
	 */
	public void setGroupKey(String groupKey)
	{
		this.groupKey = groupKey;
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
	 * Method 'getGroupOrder'
	 * 
	 * @return int
	 */
	public int getGroupOrder()
	{
		return groupOrder;
	}

	/**
	 * Method 'setGroupOrder'
	 * 
	 * @param groupOrder
	 */
	public void setGroupOrder(int groupOrder)
	{
		this.groupOrder = groupOrder;
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
	 * Method 'getDefaultGroup'
	 * 
	 * @return short
	 */
	public short getDefaultGroup()
	{
		return defaultGroup;
	}

	/**
	 * Method 'setDefaultGroup'
	 * 
	 * @param defaultGroup
	 */
	public void setDefaultGroup(short defaultGroup)
	{
		this.defaultGroup = defaultGroup;
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
		this.uiElementTypesIdNull = false;
	}

	/**
	 * Method 'setUiElementTypesIdNull'
	 * 
	 * @param value
	 */
	public void setUiElementTypesIdNull(boolean value)
	{
		this.uiElementTypesIdNull = value;
	}

	/**
	 * Method 'isUiElementTypesIdNull'
	 * 
	 * @return boolean
	 */
	public boolean isUiElementTypesIdNull()
	{
		return uiElementTypesIdNull;
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
		
		if (!(_other instanceof UiSectionGroups)) {
			return false;
		}
		
		final UiSectionGroups _cast = (UiSectionGroups) _other;
		if (aInt != _cast.aInt) {
			return false;
		}
		
		if (groupKey == null ? _cast.groupKey != groupKey : !groupKey.equals( _cast.groupKey )) {
			return false;
		}
		
		if (displayName == null ? _cast.displayName != displayName : !displayName.equals( _cast.displayName )) {
			return false;
		}
		
		if (groupOrder != _cast.groupOrder) {
			return false;
		}
		
		if (sectionKey == null ? _cast.sectionKey != sectionKey : !sectionKey.equals( _cast.sectionKey )) {
			return false;
		}
		
		if (defaultGroup != _cast.defaultGroup) {
			return false;
		}
		
		if (uiElementTypesId != _cast.uiElementTypesId) {
			return false;
		}
		
		if (uiElementTypesIdNull != _cast.uiElementTypesIdNull) {
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
		if (groupKey != null) {
			_hashCode = 29 * _hashCode + groupKey.hashCode();
		}
		
		if (displayName != null) {
			_hashCode = 29 * _hashCode + displayName.hashCode();
		}
		
		_hashCode = 29 * _hashCode + groupOrder;
		if (sectionKey != null) {
			_hashCode = 29 * _hashCode + sectionKey.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) defaultGroup;
		_hashCode = 29 * _hashCode + uiElementTypesId;
		_hashCode = 29 * _hashCode + (uiElementTypesIdNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UiSectionGroupsPk
	 */
	public UiSectionGroupsPk createPk()
	{
		return new UiSectionGroupsPk(aInt);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.UiSectionGroups: " );
		ret.append( "aInt=" + aInt );
		ret.append( ", groupKey=" + groupKey );
		ret.append( ", displayName=" + displayName );
		ret.append( ", groupOrder=" + groupOrder );
		ret.append( ", sectionKey=" + sectionKey );
		ret.append( ", defaultGroup=" + defaultGroup );
		ret.append( ", uiElementTypesId=" + uiElementTypesId );
		return ret.toString();
	}

}
