package com.codeitek.pdp.model;

import java.io.Serializable;

public class DataSource implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the DATA_SOURCE table.
	 */
	public int id;

	/** 
	 * This attribute maps to the column NAME in the DATA_SOURCE table.
	 */
	public String name;

	/** 
	 * This attribute maps to the column CUSTOMER_UUID in the DATA_SOURCE table.
	 */
	public String customerUuid;

	/**
	 * Method 'DataSource'
	 * 
	 */
	public DataSource()
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
	 * Method 'getCustomerName'
	 * 
	 * @return String
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Method 'setCustomerName'
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Method 'getCustomerUuid'
	 * 
	 * @return String
	 */
	public String getCustomerUuid()
	{
		return customerUuid;
	}

	/**
	 * Method 'setCustomerUuid'
	 * 
	 * @param customerUuid
	 */
	public void setCustomerUuid(String customerUuid)
	{
		this.customerUuid = customerUuid;
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
		
		if (!(_other instanceof DataSource)) {
			return false;
		}
		
		final DataSource _cast = (DataSource) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (name == null ? _cast.name != name : !name.equals( _cast.name )) {
			return false;
		}
		
		if (customerUuid == null ? _cast.customerUuid != customerUuid : !customerUuid.equals( _cast.customerUuid )) {
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
		if (name != null) {
			_hashCode = 29 * _hashCode + name.hashCode();
		}
		
		if (customerUuid != null) {
			_hashCode = 29 * _hashCode + customerUuid.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return DataSourcePk
	 */
	public DataSourcePk createPk()
	{
		return new DataSourcePk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.DataSource: " );
		ret.append( "id=" + id );
		ret.append( ", customerName=" + name );
		ret.append( ", customerUuid=" + customerUuid );
		return ret.toString();
	}

}
