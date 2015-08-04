package com.codeitek.pdp.model;

import java.io.Serializable;

public class PropertyImages implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the PROPERTY_IMAGES table.
	 */
	public int id;

	/** 
	 * This attribute maps to the column TITLE in the PROPERTY_IMAGES table.
	 */
	public String title;

	/** 
	 * This attribute maps to the column TYPE in the PROPERTY_IMAGES table.
	 */
	public String type;

	/** 
	 * This attribute maps to the column SIZE in the PROPERTY_IMAGES table.
	 */
	public int size;

	/** 
	 * This attribute maps to the column SRC_URL in the PROPERTY_IMAGES table.
	 */
	public String srcUrl;

	/** 
	 * This attribute maps to the column PROPERTY_DATA_UUID in the PROPERTY_IMAGES table.
	 */
	public String propertyDataUuid;

	/**
	 * Method 'PropertyImages'
	 * 
	 */
	public PropertyImages()
	{
	}

    /**
     * Full Constructor
     * @param id
     * @param title
     * @param type
     * @param size
     * @param srcUrl
     * @param propertyDataUuid
     */
    public PropertyImages(int id, String title, String type, int size, String srcUrl, String propertyDataUuid) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.size = size;
        this.srcUrl = srcUrl;
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
	 * Method 'getTitle'
	 * 
	 * @return String
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Method 'setTitle'
	 * 
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * Method 'getType'
	 * 
	 * @return String
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Method 'setType'
	 * 
	 * @param type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Method 'getSize'
	 * 
	 * @return int
	 */
	public int getSize()
	{
		return size;
	}

	/**
	 * Method 'setSize'
	 * 
	 * @param size
	 */
	public void setSize(int size)
	{
		this.size = size;
	}

	/**
	 * Method 'getSrcUrl'
	 * 
	 * @return String
	 */
	public String getSrcUrl()
	{
		return srcUrl;
	}

	/**
	 * Method 'setSrcUrl'
	 * 
	 * @param srcUrl
	 */
	public void setSrcUrl(String srcUrl)
	{
		this.srcUrl = srcUrl;
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
		
		if (!(_other instanceof PropertyImages)) {
			return false;
		}
		
		final PropertyImages _cast = (PropertyImages) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (title == null ? _cast.title != title : !title.equals( _cast.title )) {
			return false;
		}
		
		if (type == null ? _cast.type != type : !type.equals( _cast.type )) {
			return false;
		}
		
		if (size != _cast.size) {
			return false;
		}
		
		if (srcUrl == null ? _cast.srcUrl != srcUrl : !srcUrl.equals( _cast.srcUrl )) {
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
		if (title != null) {
			_hashCode = 29 * _hashCode + title.hashCode();
		}
		
		if (type != null) {
			_hashCode = 29 * _hashCode + type.hashCode();
		}
		
		_hashCode = 29 * _hashCode + size;
		if (srcUrl != null) {
			_hashCode = 29 * _hashCode + srcUrl.hashCode();
		}
		
		if (propertyDataUuid != null) {
			_hashCode = 29 * _hashCode + propertyDataUuid.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return PropertyImagesPk
	 */
	public PropertyImagesPk createPk()
	{
		return new PropertyImagesPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.PropertyImages: " );
		ret.append( "id=" + id );
		ret.append( ", title=" + title );
		ret.append( ", type=" + type );
		ret.append( ", size=" + size );
		ret.append( ", srcUrl=" + srcUrl );
		ret.append( ", propertyDataUuid=" + propertyDataUuid );
		return ret.toString();
	}

}
