package com.codeitek.pdp.model;

import java.io.Serializable;

public class PropertyAttributes implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the PROPERTY_ATTRIBUTES table.
	 */
	public int id;

	/** 
	 * This attribute maps to the column KEY in the PROPERTY_ATTRIBUTES table.
	 */
	public String key;

	/** 
	 * This attribute maps to the column DATA_TYPE_ID in the PROPERTY_ATTRIBUTES table.
	 */
	public int dataTypeId;

	/**
	 * Method 'PropertyAttributes'
	 * 
	 */
	public PropertyAttributes()
	{
	}

    /**
     * Full Constructor
     * @param id
     * @param key
     * @param dataTypeId
     */
    public PropertyAttributes(int id, String key, int dataTypeId) {
        this.id = id;
        this.key = key;
        this.dataTypeId = dataTypeId;
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
	 * Method 'getKey'
	 * 
	 * @return String
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * Method 'setKey'
	 * 
	 * @param key
	 */
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	 * Method 'getDataTypeId'
	 * 
	 * @return int
	 */
	public int getDataTypeId()
	{
		return dataTypeId;
	}

	/**
	 * Method 'setDataTypeId'
	 * 
	 * @param dataTypeId
	 */
	public void setDataTypeId(int dataTypeId)
	{
		this.dataTypeId = dataTypeId;
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
		
		if (!(_other instanceof PropertyAttributes)) {
			return false;
		}
		
		final PropertyAttributes _cast = (PropertyAttributes) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (key == null ? _cast.key != key : !key.equals( _cast.key )) {
			return false;
		}
		
		if (dataTypeId != _cast.dataTypeId) {
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
		if (key != null) {
			_hashCode = 29 * _hashCode + key.hashCode();
		}
		
		_hashCode = 29 * _hashCode + dataTypeId;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return PropertyAttributesPk
	 */
	public PropertyAttributesPk createPk()
	{
		return new PropertyAttributesPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.PropertyAttributes: " );
		ret.append( "id=" + id );
		ret.append( ", key=" + key );
		ret.append( ", dataTypeId=" + dataTypeId );
		return ret.toString();
	}

}
