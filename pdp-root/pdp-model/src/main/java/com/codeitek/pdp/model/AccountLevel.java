package com.codeitek.pdp.model;

import java.io.Serializable;

public class AccountLevel implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the ACCOUNT_LEVEL table.
	 */
	public int id;

	/** 
	 * This attribute maps to the column LEVEL in the ACCOUNT_LEVEL table.
	 */
	public String level;

	/** 
	 * This attribute maps to the column DETAIL in the ACCOUNT_LEVEL table.
	 */
	public String detail;

	/** 
	 * This attribute maps to the column DELETE_IND in the ACCOUNT_LEVEL table.
	 */
	public boolean deleteInd;

	/**
	 * Method 'AccountLevel'
	 * 
	 */
	public AccountLevel()
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
	 * Method 'getLevel'
	 * 
	 * @return String
	 */
	public String getLevel()
	{
		return level;
	}

	/**
	 * Method 'setLevel'
	 * 
	 * @param level
	 */
	public void setLevel(String level)
	{
		this.level = level;
	}

	/**
	 * Method 'getDetail'
	 * 
	 * @return String
	 */
	public String getDetail()
	{
		return detail;
	}

	/**
	 * Method 'setDetail'
	 * 
	 * @param detail
	 */
	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	/**
	 * Method 'getCustomerDeleteInd'
	 * 
	 * @return short
	 */
	public boolean getDeleteInd()
	{
		return deleteInd;
	}

	/**
	 * Method 'setCustomerDeleteInd'
	 * 
	 * @param deleteInd
	 */
	public void setDeleteInd(boolean deleteInd)
	{
		this.deleteInd = deleteInd;
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
		
		if (!(_other instanceof AccountLevel)) {
			return false;
		}
		
		final AccountLevel _cast = (AccountLevel) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (level == null ? _cast.level != level : !level.equals( _cast.level )) {
			return false;
		}
		
		if (detail == null ? _cast.detail != detail : !detail.equals( _cast.detail )) {
			return false;
		}
		
		if (deleteInd != _cast.deleteInd) {
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
		if (level != null) {
			_hashCode = 29 * _hashCode + level.hashCode();
		}
		
		if (detail != null) {
			_hashCode = 29 * _hashCode + detail.hashCode();
		}
		
		_hashCode = 29 * _hashCode + String.valueOf(deleteInd).hashCode();
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return AccountLevelPk
	 */
	public AccountLevelPk createPk()
	{
		return new AccountLevelPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.AccountLevel: " );
		ret.append( "id=" + id );
		ret.append( ", level=" + level );
		ret.append( ", detail=" + detail );
		ret.append( ", customerDeleteInd=" + deleteInd );
		return ret.toString();
	}

}
