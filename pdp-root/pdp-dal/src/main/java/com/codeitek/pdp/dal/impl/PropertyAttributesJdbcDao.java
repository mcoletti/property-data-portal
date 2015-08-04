package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.PropertyAttributesDaoException;
import com.codeitek.pdp.dal.interfaces.PropertyAttributesDao;
import com.codeitek.pdp.model.PropertyAttributes;
import com.codeitek.pdp.model.PropertyAttributesPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PropertyAttributesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<PropertyAttributes>, PropertyAttributesDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return PropertyAttributesPk
	 */
	public PropertyAttributesPk insert(PropertyAttributes dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( KEY, DATA_TYPE_ID ) VALUES ( ?, ? )",dto.getKey(),dto.getDataTypeId());
		PropertyAttributesPk pk = new PropertyAttributesPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the PROPERTY_ATTRIBUTES table.
	 */
	public void update(PropertyAttributesPk pk, PropertyAttributes dto) throws PropertyAttributesDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, KEY = ?, DATA_TYPE_ID = ? WHERE ID = ?",dto.getId(),dto.getKey(),dto.getDataTypeId(),pk.getId());
	}

	/** 
	 * Deletes a single row in the PROPERTY_ATTRIBUTES table.
	 */
	public void delete(PropertyAttributesPk pk) throws PropertyAttributesDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return PropertyAttributes
	 */
	public PropertyAttributes mapRow(ResultSet rs, int row) throws SQLException
	{
		PropertyAttributes dto = new PropertyAttributes();
		dto.setId( rs.getInt( 1 ) );
		dto.setKey( rs.getString( 2 ) );
		dto.setDataTypeId( rs.getInt( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "PROPERTY_ATTRIBUTES";
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public PropertyAttributes findByPrimaryKey(int id) throws PropertyAttributesDaoException
	{
		try {
			List<PropertyAttributes> list = getJdbcTemplate().query("SELECT ID, KEY, DATA_TYPE_ID FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new PropertyAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTES table that match the criteria ''.
	 */
	public List<PropertyAttributes> findAll() throws PropertyAttributesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY, DATA_TYPE_ID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new PropertyAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public List<PropertyAttributes> findWhereIdEquals(int id) throws PropertyAttributesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY, DATA_TYPE_ID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new PropertyAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTES table that match the criteria 'KEY = :key'.
	 */
	public List<PropertyAttributes> findWhereKeyEquals(String key) throws PropertyAttributesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY, DATA_TYPE_ID FROM " + getTableName() + " WHERE KEY = ? ORDER BY KEY", this,key);
		}
		catch (Exception e) {
			throw new PropertyAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTES table that match the criteria 'DATA_TYPE_ID = :dataTypeId'.
	 */
	public List<PropertyAttributes> findWhereDataTypeIdEquals(int dataTypeId) throws PropertyAttributesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY, DATA_TYPE_ID FROM " + getTableName() + " WHERE DATA_TYPE_ID = ? ORDER BY DATA_TYPE_ID", this,dataTypeId);
		}
		catch (Exception e) {
			throw new PropertyAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the PROPERTY_ATTRIBUTES table that matches the specified primary-key value.
	 */
	public PropertyAttributes findByPrimaryKey(PropertyAttributesPk pk) throws PropertyAttributesDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
