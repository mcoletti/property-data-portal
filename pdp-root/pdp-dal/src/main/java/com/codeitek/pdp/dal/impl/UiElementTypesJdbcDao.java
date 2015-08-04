package com.codeitek.pdp.dal.impl;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.interfaces.UiElementTypesDao;
import com.codeitek.pdp.dal.exceptions.UiElementTypesDaoException;
import com.codeitek.pdp.model.UiElementTypes;
import com.codeitek.pdp.model.UiElementTypesPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class UiElementTypesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<UiElementTypes>, UiElementTypesDao
{

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiElementTypesPk
	 */
	@Transactional
	public UiElementTypesPk insert(UiElementTypes dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( TYPE_KEY ) VALUES ( ? )",dto.getTypeKey());
		UiElementTypesPk pk = new UiElementTypesPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the UI_ELEMENT_TYPES table.
	 */
	@Transactional
	public void update(UiElementTypesPk pk, UiElementTypes dto) throws UiElementTypesDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, TYPE_KEY = ? WHERE ID = ?",dto.getId(),dto.getTypeKey(),pk.getId());
	}

	/** 
	 * Deletes a single row in the UI_ELEMENT_TYPES table.
	 */
	@Transactional
	public void delete(UiElementTypesPk pk) throws UiElementTypesDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return UiElementTypes
	 */
	public UiElementTypes mapRow(ResultSet rs, int row) throws SQLException
	{
		UiElementTypes dto = new UiElementTypes();
		dto.setId( rs.getInt( 1 ) );
		dto.setTypeKey( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "UI_ELEMENT_TYPES";
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPES table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public UiElementTypes findByPrimaryKey(int id) throws UiElementTypesDaoException
	{
		try {
			List<UiElementTypes> list = getJdbcTemplate().query("SELECT ID, TYPE_KEY FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new UiElementTypesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPES table that match the criteria ''.
	 */
	@Transactional
	public List<UiElementTypes> findAll() throws UiElementTypesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TYPE_KEY FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new UiElementTypesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPES table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<UiElementTypes> findWhereIdEquals(int id) throws UiElementTypesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TYPE_KEY FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new UiElementTypesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPES table that match the criteria 'TYPE_KEY = :typeKey'.
	 */
	@Transactional
	public List<UiElementTypes> findWhereTypeKeyEquals(String typeKey) throws UiElementTypesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TYPE_KEY FROM " + getTableName() + " WHERE TYPE_KEY = ? ORDER BY TYPE_KEY", this,typeKey);
		}
		catch (Exception e) {
			throw new UiElementTypesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the UI_ELEMENT_TYPES table that matches the specified primary-key value.
	 */
	public UiElementTypes findByPrimaryKey(UiElementTypesPk pk) throws UiElementTypesDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
