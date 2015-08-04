package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement(name = "uiElementTypeAttributes")
public class UiPageLayout implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the UI_PAGE_LAYOUT table.
	 */
	protected int id;

	/** 
	 * This attribute maps to the column UI_PAGE in the UI_PAGE_LAYOUT table.
	 */
	protected String uiPage;

	/**
	 * Method 'UiPageLayout'
	 * 
	 */
	public UiPageLayout()
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
	 * Method 'getUiPage'
	 * 
	 * @return String
	 */
	public String getUiPage()
	{
		return uiPage;
	}

	/**
	 * Method 'setUiPage'
	 * 
	 * @param uiPage
	 */
	public void setUiPage(String uiPage)
	{
		this.uiPage = uiPage;
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
		
		if (!(_other instanceof UiPageLayout)) {
			return false;
		}
		
		final UiPageLayout _cast = (UiPageLayout) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (uiPage == null ? _cast.uiPage != uiPage : !uiPage.equals( _cast.uiPage )) {
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
		if (uiPage != null) {
			_hashCode = 29 * _hashCode + uiPage.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UiPageLayoutPk
	 */
	public UiPageLayoutPk createPk()
	{
		return new UiPageLayoutPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.UiPageLayout: " );
		ret.append( "id=" + id );
		ret.append( ", uiPage=" + uiPage );
		return ret.toString();
	}

}
