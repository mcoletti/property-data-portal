package com.codeitek.pdp.model;

import java.io.Serializable;

public class PropertyAttributeData implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the PROPERTY_ATTRIBUTE_DATA table.
	 */
	public int id;

	/** 
	 * This attribute maps to the column VALUE_PREFIX in the PROPERTY_ATTRIBUTE_DATA table.
	 */
	public String valuePrefix;

	/** 
	 * This attribute maps to the column SORT_ORDER in the PROPERTY_ATTRIBUTE_DATA table.
	 */
	public int sortOrder;

	/** 
	 * This attribute maps to the column RAW_DATA_ID in the PROPERTY_ATTRIBUTE_DATA table.
	 */
	public int rawDataId;

	/** 
	 * This attribute represents whether the primitive attribute rawDataId is null.
	 */
	public boolean rawDataIdNull = true;

	/** 
	 * This attribute maps to the column PROPERTY_ATTRIBUTES_ID in the PROPERTY_ATTRIBUTE_DATA table.
	 */
	public int propertyAttributesId;

	/** 
	 * This attribute maps to the column PROPERTY_DATA_UUID in the PROPERTY_ATTRIBUTE_DATA table.
	 */
	public String propertyDataUuid;

	/**
	 * Method 'PropertyAttributeData'
	 * 
	 */
	public PropertyAttributeData()
	{
	}

    /**
     * Full Constructor
     * @param id
     * @param valuePrefix
     * @param sortOrder
     * @param rawDataId
     * @param rawDataIdNull
     * @param propertyAttributesId
     * @param propertyDataUuid
     */
    public PropertyAttributeData(int id, String valuePrefix, int sortOrder, int rawDataId, boolean rawDataIdNull, int propertyAttributesId, String propertyDataUuid) {
        this.id = id;
        this.valuePrefix = valuePrefix;
        this.sortOrder = sortOrder;
        this.rawDataId = rawDataId;
        this.rawDataIdNull = rawDataIdNull;
        this.propertyAttributesId = propertyAttributesId;
        this.propertyDataUuid = propertyDataUuid;
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
	 * Method 'getValuePrefix'
	 * 
	 * @return String
	 */
	public String getValuePrefix()
	{
		return valuePrefix;
	}

	/**
	 * Method 'setValuePrefix'
	 * 
	 * @param valuePrefix
	 */
	public void setValuePrefix(String valuePrefix)
	{
		this.valuePrefix = valuePrefix;
	}

	/**
	 * Method 'getSortOrder'
	 * 
	 * @return int
	 */
	public int getSortOrder()
	{
		return sortOrder;
	}

	/**
	 * Method 'setSortOrder'
	 * 
	 * @param sortOrder
	 */
	public void setSortOrder(int sortOrder)
	{
		this.sortOrder = sortOrder;
	}

	/**
	 * Method 'getRawDataId'
	 * 
	 * @return int
	 */
	public int getRawDataId()
	{
		return rawDataId;
	}

	/**
	 * Method 'setRawDataId'
	 * 
	 * @param rawDataId
	 */
	public void setRawDataId(int rawDataId)
	{
		this.rawDataId = rawDataId;
		this.rawDataIdNull = false;
	}

	/**
	 * Method 'setRawDataIdNull'
	 * 
	 * @param value
	 */
	public void setRawDataIdNull(boolean value)
	{
		this.rawDataIdNull = value;
	}

	/**
	 * Method 'isRawDataIdNull'
	 * 
	 * @return boolean
	 */
	public boolean isRawDataIdNull()
	{
		return rawDataIdNull;
	}

	/**
	 * Method 'getPropertyAttributesId'
	 * 
	 * @return int
	 */
	public int getPropertyAttributesId()
	{
		return propertyAttributesId;
	}

	/**
	 * Method 'setPropertyAttributesId'
	 * 
	 * @param propertyAttributesId
	 */
	public void setPropertyAttributesId(int propertyAttributesId)
	{
		this.propertyAttributesId = propertyAttributesId;
	}

	/**
	 * Method 'getPropertyDataUuid'
	 * 
	 * @return String
	 */
	public String getPropertyDataUuid()
	{
		return propertyDataUuid;
	}

	/**
	 * Method 'setPropertyDataUuid'
	 * 
	 * @param propertyDataUuid
	 */
	public void setPropertyDataUuid(String propertyDataUuid)
	{
		this.propertyDataUuid = propertyDataUuid;
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
		
		if (!(_other instanceof PropertyAttributeData)) {
			return false;
		}
		
		final PropertyAttributeData _cast = (PropertyAttributeData) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (valuePrefix == null ? _cast.valuePrefix != valuePrefix : !valuePrefix.equals( _cast.valuePrefix )) {
			return false;
		}
		
		if (sortOrder != _cast.sortOrder) {
			return false;
		}
		
		if (rawDataId != _cast.rawDataId) {
			return false;
		}
		
		if (rawDataIdNull != _cast.rawDataIdNull) {
			return false;
		}
		
		if (propertyAttributesId != _cast.propertyAttributesId) {
			return false;
		}
		
		if (propertyDataUuid == null ? _cast.propertyDataUuid != propertyDataUuid : !propertyDataUuid.equals( _cast.propertyDataUuid )) {
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
		if (valuePrefix != null) {
			_hashCode = 29 * _hashCode + valuePrefix.hashCode();
		}
		
		_hashCode = 29 * _hashCode + sortOrder;
		_hashCode = 29 * _hashCode + rawDataId;
		_hashCode = 29 * _hashCode + (rawDataIdNull ? 1 : 0);
		_hashCode = 29 * _hashCode + propertyAttributesId;
		if (propertyDataUuid != null) {
			_hashCode = 29 * _hashCode + propertyDataUuid.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return PropertyAttributeDataPk
	 */
	public PropertyAttributeDataPk createPk()
	{
		return new PropertyAttributeDataPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.PropertyAttributeData: " );
		ret.append( "id=" + id );
		ret.append( ", valuePrefix=" + valuePrefix );
		ret.append( ", sortOrder=" + sortOrder );
		ret.append( ", rawDataId=" + rawDataId );
		ret.append( ", propertyAttributesId=" + propertyAttributesId );
		ret.append( ", propertyDataUuid=" + propertyDataUuid );
		return ret.toString();
	}

}
