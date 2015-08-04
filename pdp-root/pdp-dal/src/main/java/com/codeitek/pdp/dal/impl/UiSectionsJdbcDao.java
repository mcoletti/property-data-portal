package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.interfaces.UiSectionsDao;
import com.codeitek.pdp.dal.exceptions.UiSectionsDaoException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.model.UiSections;
import com.codeitek.pdp.model.UiSectionsPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class UiSectionsJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<UiSections>, UiSectionsDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiSectionsPk
	 */
	@Transactional
	public UiSectionsPk insert(UiSections dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( SECTION_KEY, DISPLAY_NAME, SECTION_ORDER, UI_PAGE_LAYOUT_ID ) VALUES ( ?, ?, ?, ? )",dto.getSectionKey(),dto.getDisplayName(),dto.getSectionOrder(),dto.getUiPageLayoutId());
		UiSectionsPk pk = new UiSectionsPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the UI_SECTIONS table.
	 */
	@Transactional
	public void update(UiSectionsPk pk, UiSections dto) throws UiSectionsDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, SECTION_KEY = ?, DISPLAY_NAME = ?, SECTION_ORDER = ?, UI_PAGE_LAYOUT_ID = ? WHERE ID = ? AND SECTION_KEY = ?",dto.getId(),dto.getSectionKey(),dto.getDisplayName(),dto.getSectionOrder(),dto.getUiPageLayoutId(),pk.getId(),pk.getSectionKey());
	}

	/** 
	 * Deletes a single row in the UI_SECTIONS table.
	 */
	@Transactional
	public void delete(UiSectionsPk pk) throws UiSectionsDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ? AND SECTION_KEY = ?",pk.getId(),pk.getSectionKey());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return UiSections
	 */
	public UiSections mapRow(ResultSet rs, int row) throws SQLException
	{
		UiSections dto = new UiSections();
		dto.setId( rs.getInt( 1 ) );
		dto.setSectionKey( rs.getString( 2 ) );
		dto.setDisplayName( rs.getString( 3 ) );
		dto.setSectionOrder( rs.getInt( 4 ) );
		dto.setUiPageLayoutId( rs.getInt( 5 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "UI_SECTIONS";
	}

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'ID = :id AND SECTION_KEY = :sectionKey'.
	 */
	@Transactional
	public UiSections findByPrimaryKey(int id, String sectionKey) throws UiSectionsDaoException
	{
		try {
			List<UiSections> list = getJdbcTemplate().query("SELECT ID, SECTION_KEY, DISPLAY_NAME, SECTION_ORDER, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE ID = ? AND SECTION_KEY = ?", this,id,sectionKey);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new UiSectionsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria ''.
	 */
	@Transactional
	public List<UiSections> findAll() throws UiSectionsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, SECTION_KEY, DISPLAY_NAME, SECTION_ORDER, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new UiSectionsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'UI_PAGE_LAYOUT_ID = :uiPageLayoutId'.
	 */
	@Transactional
	public List<UiSections> findByUiPageLayout(int uiPageLayoutId) throws UiSectionsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, SECTION_KEY, DISPLAY_NAME, SECTION_ORDER, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE UI_PAGE_LAYOUT_ID = ?", this,uiPageLayoutId);
		}
		catch (Exception e) {
			throw new UiSectionsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<UiSections> findWhereIdEquals(int id) throws UiSectionsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, SECTION_KEY, DISPLAY_NAME, SECTION_ORDER, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new UiSectionsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'SECTION_KEY = :sectionKey'.
	 */
	@Transactional
	public List<UiSections> findWhereSectionKeyEquals(String sectionKey) throws UiSectionsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, SECTION_KEY, DISPLAY_NAME, SECTION_ORDER, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE SECTION_KEY = ? ORDER BY SECTION_KEY", this,sectionKey);
		}
		catch (Exception e) {
			throw new UiSectionsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'DISPLAY_NAME = :displayName'.
	 */
	@Transactional
	public List<UiSections> findWhereDisplayNameEquals(String displayName) throws UiSectionsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, SECTION_KEY, DISPLAY_NAME, SECTION_ORDER, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE DISPLAY_NAME = ? ORDER BY DISPLAY_NAME", this,displayName);
		}
		catch (Exception e) {
			throw new UiSectionsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'SECTION_ORDER = :sectionOrder'.
	 */
	@Transactional
	public List<UiSections> findWhereSectionOrderEquals(int sectionOrder) throws UiSectionsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, SECTION_KEY, DISPLAY_NAME, SECTION_ORDER, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE SECTION_ORDER = ? ORDER BY SECTION_ORDER", this,sectionOrder);
		}
		catch (Exception e) {
			throw new UiSectionsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'UI_PAGE_LAYOUT_ID = :uiPageLayoutId'.
	 */
	@Transactional
	public List<UiSections> findWhereUiPageLayoutIdEquals(int uiPageLayoutId) throws UiSectionsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, SECTION_KEY, DISPLAY_NAME, SECTION_ORDER, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE UI_PAGE_LAYOUT_ID = ? ORDER BY UI_PAGE_LAYOUT_ID", this,uiPageLayoutId);
		}
		catch (Exception e) {
			throw new UiSectionsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the UI_SECTIONS table that matches the specified primary-key value.
	 */
	public UiSections findByPrimaryKey(UiSectionsPk pk) throws UiSectionsDaoException
	{
		return findByPrimaryKey( pk.getId(), pk.getSectionKey() );
	}

}
