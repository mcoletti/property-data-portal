package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.interfaces.UiPageLayoutDao;
import com.codeitek.pdp.dal.exceptions.UiPageLayoutDaoException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.model.UiPageLayout;
import com.codeitek.pdp.model.UiPageLayoutPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class UiPageLayoutJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<UiPageLayout>, UiPageLayoutDao
{


	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiPageLayoutPk
	 */
	@Transactional
	public UiPageLayoutPk insert(UiPageLayout dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( UI_PAGE ) VALUES ( ? )", dto.getUiPage());
		UiPageLayoutPk pk = new UiPageLayoutPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the UI_PAGE_LAYOUT table.
	 */
	@Transactional
	public void update(UiPageLayoutPk pk, UiPageLayout dto) throws UiPageLayoutDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, UI_PAGE = ? WHERE ID = ?", dto.getId(), dto.getUiPage(), pk.getId());
	}

	/** 
	 * Deletes a single row in the UI_PAGE_LAYOUT table.
	 */
	@Transactional
	public void delete(UiPageLayoutPk pk) throws UiPageLayoutDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return UiPageLayout
	 */
	public UiPageLayout mapRow(ResultSet rs, int row) throws SQLException
	{
		UiPageLayout dto = new UiPageLayout();
		dto.setId( rs.getInt( 1 ) );
		dto.setUiPage( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "UI_PAGE_LAYOUT";
	}

	/** 
	 * Returns all rows from the UI_PAGE_LAYOUT table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public UiPageLayout findByPrimaryKey(int id) throws UiPageLayoutDaoException
	{
		try {
			List<UiPageLayout> list = getJdbcTemplate().query("SELECT ID, UI_PAGE FROM " + getTableName() + " WHERE ID = ?", this, id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new UiPageLayoutDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_PAGE_LAYOUT table that match the criteria ''.
	 */
	@Transactional
	public List<UiPageLayout> findAll() throws UiPageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, UI_PAGE FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new UiPageLayoutDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_PAGE_LAYOUT table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<UiPageLayout> findWhereIdEquals(int id) throws UiPageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, UI_PAGE FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
		}
		catch (Exception e) {
			throw new UiPageLayoutDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_PAGE_LAYOUT table that match the criteria 'UI_PAGE = :uiPage'.
	 */
	@Transactional
	public List<UiPageLayout> findWhereUiPageEquals(String uiPage) throws UiPageLayoutDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, UI_PAGE FROM " + getTableName() + " WHERE UI_PAGE = ? ORDER BY UI_PAGE", this, uiPage);
		}
		catch (Exception e) {
			throw new UiPageLayoutDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the UI_PAGE_LAYOUT table that matches the specified primary-key value.
	 */
	public UiPageLayout findByPrimaryKey(UiPageLayoutPk pk) throws UiPageLayoutDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
