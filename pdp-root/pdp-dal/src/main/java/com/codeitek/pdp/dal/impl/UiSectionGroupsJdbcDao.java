package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.interfaces.UiSectionGroupsDao;
import com.codeitek.pdp.dal.exceptions.UiSectionGroupsDaoException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.model.UiSectionGroups;
import com.codeitek.pdp.model.UiSectionGroupsPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class UiSectionGroupsJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<UiSectionGroups>, UiSectionGroupsDao
{



	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiSectionGroupsPk
	 */
	@Transactional
	public UiSectionGroupsPk insert(UiSectionGroups dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID ) VALUES ( ?, ?, ?, ?, ?, ? )", dto.getGroupKey(), dto.getDisplayName(), dto.getGroupOrder(), dto.getSectionKey(), dto.getDefaultGroup(), dto.isUiElementTypesIdNull() ? null : dto.getUiElementTypesId());
		UiSectionGroupsPk pk = new UiSectionGroupsPk();
		pk.setAInt( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the UI_SECTION_GROUPS table.
	 */
	@Transactional
	public void update(UiSectionGroupsPk pk, UiSectionGroups dto) throws UiSectionGroupsDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET INT = ?, GROUP_KEY = ?, DISPLAY_NAME = ?, GROUP_ORDER = ?, SECTION_KEY = ?, DEFAULT_GROUP = ?, UI_ELEMENT_TYPES_ID = ? WHERE INT = ?", dto.getAInt(), dto.getGroupKey(), dto.getDisplayName(), dto.getGroupOrder(), dto.getSectionKey(), dto.getDefaultGroup(), dto.getUiElementTypesId(), pk.getAInt());
	}

	/** 
	 * Deletes a single row in the UI_SECTION_GROUPS table.
	 */
	@Transactional
	public void delete(UiSectionGroupsPk pk) throws UiSectionGroupsDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE INT = ?", pk.getAInt());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return UiSectionGroups
	 */
	public UiSectionGroups mapRow(ResultSet rs, int row) throws SQLException
	{
		UiSectionGroups dto = new UiSectionGroups();
		dto.setAInt( rs.getInt( 1 ) );
		dto.setGroupKey( rs.getString( 2 ) );
		dto.setDisplayName( rs.getString( 3 ) );
		dto.setGroupOrder( rs.getInt( 4 ) );
		dto.setSectionKey( rs.getString( 5 ) );
		dto.setDefaultGroup( rs.getShort( 6 ) );
		dto.setUiElementTypesId( rs.getInt( 7 ) );
		if (rs.wasNull()) {
			dto.setUiElementTypesIdNull( true );
		}
		
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "UI_SECTION_GROUPS";
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'INT = :aInt'.
	 */
	@Transactional
	public UiSectionGroups findByPrimaryKey(int aInt) throws UiSectionGroupsDaoException
	{
		try {
			List<UiSectionGroups> list = getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " WHERE INT = ?", this, aInt);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria ''.
	 */
	@Transactional
	public List<UiSectionGroups> findAll() throws UiSectionGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " ORDER BY INT", this);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'SECTION_KEY = :sectionKey'.
	 */
	@Transactional
	public List<UiSectionGroups> findByUiSections(String sectionKey) throws UiSectionGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " WHERE SECTION_KEY = ?", this, sectionKey);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'UI_ELEMENT_TYPES_ID = :uiElementTypesId'.
	 */
	@Transactional
	public List<UiSectionGroups> findByUiElementTypes(int uiElementTypesId) throws UiSectionGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " WHERE UI_ELEMENT_TYPES_ID = ?", this, uiElementTypesId);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'INT = :aInt'.
	 */
	@Transactional
	public List<UiSectionGroups> findWhereAIntEquals(int aInt) throws UiSectionGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " WHERE INT = ? ORDER BY INT", this, aInt);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'GROUP_KEY = :groupKey'.
	 */
	@Transactional
	public List<UiSectionGroups> findWhereGroupKeyEquals(String groupKey) throws UiSectionGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " WHERE GROUP_KEY = ? ORDER BY GROUP_KEY", this, groupKey);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'DISPLAY_NAME = :displayName'.
	 */
	@Transactional
	public List<UiSectionGroups> findWhereDisplayNameEquals(String displayName) throws UiSectionGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " WHERE DISPLAY_NAME = ? ORDER BY DISPLAY_NAME", this, displayName);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'GROUP_ORDER = :groupOrder'.
	 */
	@Transactional
	public List<UiSectionGroups> findWhereGroupOrderEquals(int groupOrder) throws UiSectionGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " WHERE GROUP_ORDER = ? ORDER BY GROUP_ORDER", this, groupOrder);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'SECTION_KEY = :sectionKey'.
	 */
	@Transactional
	public List<UiSectionGroups> findWhereSectionKeyEquals(String sectionKey) throws UiSectionGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " WHERE SECTION_KEY = ? ORDER BY SECTION_KEY", this, sectionKey);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'DEFAULT_GROUP = :defaultGroup'.
	 */
	@Transactional
	public List<UiSectionGroups> findWhereDefaultGroupEquals(short defaultGroup) throws UiSectionGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " WHERE DEFAULT_GROUP = ? ORDER BY DEFAULT_GROUP", this, defaultGroup);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'UI_ELEMENT_TYPES_ID = :uiElementTypesId'.
	 */
	@Transactional
	public List<UiSectionGroups> findWhereUiElementTypesIdEquals(int uiElementTypesId) throws UiSectionGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT INT, GROUP_KEY, DISPLAY_NAME, GROUP_ORDER, SECTION_KEY, DEFAULT_GROUP, UI_ELEMENT_TYPES_ID FROM " + getTableName() + " WHERE UI_ELEMENT_TYPES_ID = ? ORDER BY UI_ELEMENT_TYPES_ID", this, uiElementTypesId);
		}
		catch (Exception e) {
			throw new UiSectionGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the UI_SECTION_GROUPS table that matches the specified primary-key value.
	 */
	public UiSectionGroups findByPrimaryKey(UiSectionGroupsPk pk) throws UiSectionGroupsDaoException
	{
		return findByPrimaryKey( pk.getAInt() );
	}

}
