package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "pageLayout")
public class Pagelayout implements Serializable
{
	/** 
	 * This attribute maps to the column PAGE_ID in the vw_PageLayout table.
	 */
	protected int pageId;

	/** 
	 * This attribute maps to the column PAGE in the vw_PageLayout table.
	 */
	protected String page;

	/** 
	 * This attribute maps to the column PAGE_SEC_ID in the vw_PageLayout table.
	 */
	protected int pageSecId;

	/** 
	 * This attribute maps to the column PAGE_SEC_KEY in the vw_PageLayout table.
	 */
	protected String pageSecKey;

	/** 
	 * This attribute maps to the column PAGE_SEC_DSP_NAME in the vw_PageLayout table.
	 */
	protected String pageSecDspName;

	/** 
	 * This attribute maps to the column PAGE_SEC_ORDER in the vw_PageLayout table.
	 */
	protected int pageSecOrder;

	/** 
	 * This attribute maps to the column SEC_GRP_KEY in the vw_PageLayout table.
	 */
	protected String secGrpKey;

	/** 
	 * This attribute maps to the column SEC_GRP_DSP_NAME in the vw_PageLayout table.
	 */
	protected String secGrpDspName;

	/** 
	 * This attribute maps to the column SEC_GRP_ORDER in the vw_PageLayout table.
	 */
	protected int secGrpOrder;

	/** 
	 * This attribute maps to the column SEC_GRP_DEFAULT_IND in the vw_PageLayout table.
	 */
	protected short secGrpDefaultInd;

	/** 
	 * This attribute maps to the column GRP_ELEMENT_ID in the vw_PageLayout table.
	 */
	protected int grpElementId;

	/** 
	 * This attribute maps to the column GRP_ELEMENT_TYPE in the vw_PageLayout table.
	 */
	protected String grpElementType;

	/**
	 * Method 'Pagelayout'
	 * 
	 */
	public Pagelayout()
	{
	}

	/**
	 * Method 'getPageId'
	 * 
	 * @return int
	 */
	public int getPageId()
	{
		return pageId;
	}

	/**
	 * Method 'setPageId'
	 * 
	 * @param pageId
	 */
	public void setPageId(int pageId)
	{
		this.pageId = pageId;
	}

	/**
	 * Method 'getPage'
	 * 
	 * @return String
	 */
	public String getPage()
	{
		return page;
	}

	/**
	 * Method 'setPage'
	 * 
	 * @param page
	 */
	public void setPage(String page)
	{
		this.page = page;
	}

	/**
	 * Method 'getPageSecId'
	 * 
	 * @return int
	 */
	public int getPageSecId()
	{
		return pageSecId;
	}

	/**
	 * Method 'setPageSecId'
	 * 
	 * @param pageSecId
	 */
	public void setPageSecId(int pageSecId)
	{
		this.pageSecId = pageSecId;
	}

	/**
	 * Method 'getPageSecKey'
	 * 
	 * @return String
	 */
	public String getPageSecKey()
	{
		return pageSecKey;
	}

	/**
	 * Method 'setPageSecKey'
	 * 
	 * @param pageSecKey
	 */
	public void setPageSecKey(String pageSecKey)
	{
		this.pageSecKey = pageSecKey;
	}

	/**
	 * Method 'getPageSecDspName'
	 * 
	 * @return String
	 */
	public String getPageSecDspName()
	{
		return pageSecDspName;
	}

	/**
	 * Method 'setPageSecDspName'
	 * 
	 * @param pageSecDspName
	 */
	public void setPageSecDspName(String pageSecDspName)
	{
		this.pageSecDspName = pageSecDspName;
	}

	/**
	 * Method 'getPageSecOrder'
	 * 
	 * @return int
	 */
	public int getPageSecOrder()
	{
		return pageSecOrder;
	}

	/**
	 * Method 'setPageSecOrder'
	 * 
	 * @param pageSecOrder
	 */
	public void setPageSecOrder(int pageSecOrder)
	{
		this.pageSecOrder = pageSecOrder;
	}

	/**
	 * Method 'getSecGrpKey'
	 * 
	 * @return String
	 */
	public String getSecGrpKey()
	{
		return secGrpKey;
	}

	/**
	 * Method 'setSecGrpKey'
	 * 
	 * @param secGrpKey
	 */
	public void setSecGrpKey(String secGrpKey)
	{
		this.secGrpKey = secGrpKey;
	}

	/**
	 * Method 'getSecGrpDspName'
	 * 
	 * @return String
	 */
	public String getSecGrpDspName()
	{
		return secGrpDspName;
	}

	/**
	 * Method 'setSecGrpDspName'
	 * 
	 * @param secGrpDspName
	 */
	public void setSecGrpDspName(String secGrpDspName)
	{
		this.secGrpDspName = secGrpDspName;
	}

	/**
	 * Method 'getSecGrpOrder'
	 * 
	 * @return int
	 */
	public int getSecGrpOrder()
	{
		return secGrpOrder;
	}

	/**
	 * Method 'setSecGrpOrder'
	 * 
	 * @param secGrpOrder
	 */
	public void setSecGrpOrder(int secGrpOrder)
	{
		this.secGrpOrder = secGrpOrder;
	}

	/**
	 * Method 'getSecGrpDefaultInd'
	 * 
	 * @return short
	 */
	public short getSecGrpDefaultInd()
	{
		return secGrpDefaultInd;
	}

	/**
	 * Method 'setSecGrpDefaultInd'
	 * 
	 * @param secGrpDefaultInd
	 */
	public void setSecGrpDefaultInd(short secGrpDefaultInd)
	{
		this.secGrpDefaultInd = secGrpDefaultInd;
	}

	/**
	 * Method 'getGrpElementId'
	 * 
	 * @return int
	 */
	public int getGrpElementId()
	{
		return grpElementId;
	}

	/**
	 * Method 'setGrpElementId'
	 * 
	 * @param grpElementId
	 */
	public void setGrpElementId(int grpElementId)
	{
		this.grpElementId = grpElementId;
	}

	/**
	 * Method 'getGrpElementType'
	 * 
	 * @return String
	 */
	public String getGrpElementType()
	{
		return grpElementType;
	}

	/**
	 * Method 'setGrpElementType'
	 * 
	 * @param grpElementType
	 */
	public void setGrpElementType(String grpElementType)
	{
		this.grpElementType = grpElementType;
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
		
		if (!(_other instanceof Pagelayout)) {
			return false;
		}
		
		final Pagelayout _cast = (Pagelayout) _other;
		if (pageId != _cast.pageId) {
			return false;
		}
		
		if (page == null ? !_cast.page.equals(page) : !page.equals( _cast.page )) {
			return false;
		}
		
		if (pageSecId != _cast.pageSecId) {
			return false;
		}
		
		if (pageSecKey == null ? !_cast.pageSecKey.equals(pageSecKey) : !pageSecKey.equals( _cast.pageSecKey )) {
			return false;
		}
		
		if (pageSecDspName == null ? !_cast.pageSecDspName.equals(pageSecDspName) : !pageSecDspName.equals( _cast.pageSecDspName )) {
			return false;
		}
		
		if (pageSecOrder != _cast.pageSecOrder) {
			return false;
		}
		
		if (secGrpKey == null ? _cast.secGrpKey != secGrpKey : !secGrpKey.equals( _cast.secGrpKey )) {
			return false;
		}
		
		if (secGrpDspName == null ? _cast.secGrpDspName != secGrpDspName : !secGrpDspName.equals( _cast.secGrpDspName )) {
			return false;
		}
		
		if (secGrpOrder != _cast.secGrpOrder) {
			return false;
		}
		
		if (secGrpDefaultInd != _cast.secGrpDefaultInd) {
			return false;
		}
		
		if (grpElementId != _cast.grpElementId) {
			return false;
		}
		
		if (grpElementType == null ? _cast.grpElementType != grpElementType : !grpElementType.equals( _cast.grpElementType )) {
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
		_hashCode = 29 * _hashCode + pageId;
		if (page != null) {
			_hashCode = 29 * _hashCode + page.hashCode();
		}
		
		_hashCode = 29 * _hashCode + pageSecId;
		if (pageSecKey != null) {
			_hashCode = 29 * _hashCode + pageSecKey.hashCode();
		}
		
		if (pageSecDspName != null) {
			_hashCode = 29 * _hashCode + pageSecDspName.hashCode();
		}
		
		_hashCode = 29 * _hashCode + pageSecOrder;
		if (secGrpKey != null) {
			_hashCode = 29 * _hashCode + secGrpKey.hashCode();
		}
		
		if (secGrpDspName != null) {
			_hashCode = 29 * _hashCode + secGrpDspName.hashCode();
		}
		
		_hashCode = 29 * _hashCode + secGrpOrder;
		_hashCode = 29 * _hashCode + (int) secGrpDefaultInd;
		_hashCode = 29 * _hashCode + grpElementId;
		if (grpElementType != null) {
			_hashCode = 29 * _hashCode + grpElementType.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.Pagelayout: " );
		ret.append( "pageId=" + pageId );
		ret.append( ", page=" + page );
		ret.append( ", pageSecId=" + pageSecId );
		ret.append( ", pageSecKey=" + pageSecKey );
		ret.append( ", pageSecDspName=" + pageSecDspName );
		ret.append( ", pageSecOrder=" + pageSecOrder );
		ret.append( ", secGrpKey=" + secGrpKey );
		ret.append( ", secGrpDspName=" + secGrpDspName );
		ret.append( ", secGrpOrder=" + secGrpOrder );
		ret.append( ", secGrpDefaultInd=" + secGrpDefaultInd );
		ret.append( ", grpElementId=" + grpElementId );
		ret.append( ", grpElementType=" + grpElementType );
		return ret.toString();
	}

}
