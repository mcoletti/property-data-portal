package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.PageLayoutDaoException;
import com.codeitek.pdp.model.Pagelayout;

import java.util.List;

public interface PageLayoutDao
{

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria ''.
	 */
	public List<Pagelayout> findAll() throws PageLayoutDaoException;

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'PAGE_ID = :pageId'.
	 */
	public List<Pagelayout> findWherePageIdEquals(int pageId) throws PageLayoutDaoException;

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'PAGE = :page'.
	 */
	public List<Pagelayout> findWherePageEquals(String page) throws PageLayoutDaoException;

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'PAGE_SEC_ID = :pageSecId'.
	 */
	public List<Pagelayout> findWherePageSecIdEquals(int pageSecId) throws PageLayoutDaoException;

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'PAGE_SEC_KEY = :pageSecKey'.
	 */
	public List<Pagelayout> findWherePageSecKeyEquals(String pageSecKey) throws PageLayoutDaoException;


	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'SEC_GRP_KEY = :secGrpKey'.
	 */
	public List<Pagelayout> findWhereSecGrpKeyEquals(String secGrpKey) throws PageLayoutDaoException;


	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'SEC_GRP_DEFAULT_IND = :secGrpDefaultInd'.
	 */
	public List<Pagelayout> findWhereSecGrpDefaultIndEquals(short secGrpDefaultInd) throws PageLayoutDaoException;

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'GRP_ELEMENT_ID = :grpElementId'.
	 */
	public List<Pagelayout> findWhereGrpElementIdEquals(int grpElementId) throws PageLayoutDaoException;



}
