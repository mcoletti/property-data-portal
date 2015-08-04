package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOQueries;
import com.codeitek.pdp.dal.interfaces.PageLayoutDao;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.PageLayoutDaoException;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.model.Pagelayout;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class PageLayoutJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<Pagelayout>, PageLayoutDao
{
	



	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return Pagelayout
	 */
	public Pagelayout mapRow(ResultSet rs, int row) throws SQLException
	{
		Pagelayout dto = new Pagelayout();
		dto.setPageId( rs.getInt( 1 ) );
		dto.setPage( rs.getString( 2 ) );
		dto.setPageSecId( rs.getInt( 3 ) );
		dto.setPageSecKey( rs.getString( 4 ) );
		dto.setPageSecDspName( rs.getString( 5 ) );
		dto.setPageSecOrder( rs.getInt( 6 ) );
		dto.setSecGrpKey( rs.getString( 7 ) );
		dto.setSecGrpDspName( rs.getString( 8 ) );
		dto.setSecGrpOrder( rs.getInt( 9 ) );
		dto.setSecGrpDefaultInd( rs.getShort( 10 ) );
		dto.setGrpElementId( rs.getInt( 11 ) );
		dto.setGrpElementType( rs.getString( 12 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "vw_PageLayout";
	}

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria ''.
	 */
	@Transactional
	public List<Pagelayout> findAll() throws PageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PAGE_LAYOUT_VIEW + "", this);
		}
		catch (Exception e) {
			throw new PageLayoutDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'PAGE_ID = :pageId'.
	 */
	@Transactional
	public List<Pagelayout> findWherePageIdEquals(int pageId) throws PageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PAGE_LAYOUT_VIEW_BY_ID, this,pageId);
		}
		catch (Exception e) {
			throw new PageLayoutDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'PAGE = :page'.
	 */
	@Transactional
	public List<Pagelayout> findWherePageEquals(String page) throws PageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PAGE_LAYOUT_VIEW_BY_PAGE, this,page);
		}
		catch (Exception e) {
			throw new PageLayoutDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'PAGE_SEC_ID = :pageSecId'.
	 */
	@Transactional
	public List<Pagelayout> findWherePageSecIdEquals(int pageSecId) throws PageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PAGE_LAYOUT_VIEW_BY_SEC_ID, this,pageSecId);
		}
		catch (Exception e) {
			throw new PageLayoutDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'PAGE_SEC_KEY = :pageSecKey'.
	 */
	@Transactional
	public List<Pagelayout> findWherePageSecKeyEquals(String pageSecKey) throws PageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PAGE_LAYOUT_VIEW_BY_SEC_KEY, this,pageSecKey);
		}
		catch (Exception e) {
			throw new PageLayoutDaoException("Query failed", e);
		}
		
	}




	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'SEC_GRP_KEY = :secGrpKey'.
	 */
	@Transactional
	public List<Pagelayout> findWhereSecGrpKeyEquals(String secGrpKey) throws PageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PAGE_LAYOUT_VIEW_BY_SEC_GRP_KEY, this,secGrpKey);
		}
		catch (Exception e) {
			throw new PageLayoutDaoException("Query failed", e);
		}
		
	}




	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'SEC_GRP_DEFAULT_IND = :secGrpDefaultInd'.
	 */
	@Transactional
	public List<Pagelayout> findWhereSecGrpDefaultIndEquals(short secGrpDefaultInd) throws PageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PAGE_LAYOUT_VIEW_BY_SEC_GRP_DEFAULT_IND, this,secGrpDefaultInd);
		}
		catch (Exception e) {
			throw new PageLayoutDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_PageLayout table that match the criteria 'GRP_ELEMENT_ID = :grpElementId'.
	 */
	@Transactional
	public List<Pagelayout> findWhereGrpElementIdEquals(int grpElementId) throws PageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PAGE_LAYOUT_VIEW_BY_SEC_GRP_ELEMENT_ID, this,grpElementId);
		}
		catch (Exception e) {
			throw new PageLayoutDaoException("Query failed", e);
		}
		
	}



}
