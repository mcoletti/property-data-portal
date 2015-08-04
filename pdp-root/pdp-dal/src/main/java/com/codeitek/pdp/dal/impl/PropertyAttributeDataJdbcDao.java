package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.PropertyAttributeDataDaoException;
import com.codeitek.pdp.dal.interfaces.PropertyAttributeDataDao;
import com.codeitek.pdp.model.PropertyAttributeData;
import com.codeitek.pdp.model.PropertyAttributeDataPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PropertyAttributeDataJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<PropertyAttributeData>, PropertyAttributeDataDao
{
	
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return PropertyAttributeDataPk
	 */
	public PropertyAttributeDataPk insert(PropertyAttributeData dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( VALUE_PREFIX, SORT_ORDER, RAW_DATA_ID, PROPERTY_ATTRIBUTES_ID, PROPERTY_DATA_UUID ) VALUES ( ?, ?, ?, ?, ? )",dto.getValuePrefix(),dto.getSortOrder(),dto.isRawDataIdNull()?null:dto.getRawDataId(),dto.getPropertyAttributesId(),dto.getPropertyDataUuid());
		PropertyAttributeDataPk pk = new PropertyAttributeDataPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the PROPERTY_ATTRIBUTE_DATA table.
	 */
	public void update(PropertyAttributeDataPk pk, PropertyAttributeData dto) throws PropertyAttributeDataDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, VALUE_PREFIX = ?, SORT_ORDER = ?, RAW_DATA_ID = ?, PROPERTY_ATTRIBUTES_ID = ?, PROPERTY_DATA_UUID = ? WHERE ID = ?",dto.getId(),dto.getValuePrefix(),dto.getSortOrder(),dto.getRawDataId(),dto.getPropertyAttributesId(),dto.getPropertyDataUuid(),pk.getId());
	}

	/** 
	 * Deletes a single row in the PROPERTY_ATTRIBUTE_DATA table.
	 */
	public void delete(PropertyAttributeDataPk pk) throws PropertyAttributeDataDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return PropertyAttributeData
	 */
	public PropertyAttributeData mapRow(ResultSet rs, int row) throws SQLException
	{
		PropertyAttributeData dto = new PropertyAttributeData();
		dto.setId( rs.getInt( 1 ) );
		dto.setValuePrefix( rs.getString( 2 ) );
		dto.setSortOrder( rs.getInt( 3 ) );
		dto.setRawDataId( rs.getInt( 4 ) );
		if (rs.wasNull()) {
			dto.setRawDataIdNull( true );
		}
		
		dto.setPropertyAttributesId( rs.getInt( 5 ) );
		dto.setPropertyDataUuid( rs.getString( 6 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "PROPERTY_ATTRIBUTE_DATA";
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'ID = :id'.
	 */
	public PropertyAttributeData findByPrimaryKey(int id) throws PropertyAttributeDataDaoException
	{
		try {
			List<PropertyAttributeData> list = getJdbcTemplate().query("SELECT ID, VALUE_PREFIX, SORT_ORDER, RAW_DATA_ID, PROPERTY_ATTRIBUTES_ID, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new PropertyAttributeDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria ''.
	 */
	public List<PropertyAttributeData> findAll() throws PropertyAttributeDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, VALUE_PREFIX, SORT_ORDER, RAW_DATA_ID, PROPERTY_ATTRIBUTES_ID, PROPERTY_DATA_UUID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new PropertyAttributeDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'PROPERTY_ATTRIBUTES_ID = :propertyAttributesId'.
	 */
	public List<PropertyAttributeData> findByPropertyAttributes(int propertyAttributesId) throws PropertyAttributeDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, VALUE_PREFIX, SORT_ORDER, RAW_DATA_ID, PROPERTY_ATTRIBUTES_ID, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE PROPERTY_ATTRIBUTES_ID = ?", this,propertyAttributesId);
		}
		catch (Exception e) {
			throw new PropertyAttributeDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'ID = :id'.
	 */
	public List<PropertyAttributeData> findWhereIdEquals(int id) throws PropertyAttributeDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, VALUE_PREFIX, SORT_ORDER, RAW_DATA_ID, PROPERTY_ATTRIBUTES_ID, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new PropertyAttributeDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'VALUE_PREFIX = :valuePrefix'.
	 */
	public List<PropertyAttributeData> findWhereValuePrefixEquals(String valuePrefix) throws PropertyAttributeDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, VALUE_PREFIX, SORT_ORDER, RAW_DATA_ID, PROPERTY_ATTRIBUTES_ID, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE VALUE_PREFIX = ? ORDER BY VALUE_PREFIX", this,valuePrefix);
		}
		catch (Exception e) {
			throw new PropertyAttributeDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'SORT_ORDER = :sortOrder'.
	 */
	public List<PropertyAttributeData> findWhereSortOrderEquals(int sortOrder) throws PropertyAttributeDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, VALUE_PREFIX, SORT_ORDER, RAW_DATA_ID, PROPERTY_ATTRIBUTES_ID, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE SORT_ORDER = ? ORDER BY SORT_ORDER", this,sortOrder);
		}
		catch (Exception e) {
			throw new PropertyAttributeDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'RAW_DATA_ID = :rawDataId'.
	 */
	public List<PropertyAttributeData> findWhereRawDataIdEquals(int rawDataId) throws PropertyAttributeDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, VALUE_PREFIX, SORT_ORDER, RAW_DATA_ID, PROPERTY_ATTRIBUTES_ID, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE RAW_DATA_ID = ? ORDER BY RAW_DATA_ID", this,rawDataId);
		}
		catch (Exception e) {
			throw new PropertyAttributeDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'PROPERTY_ATTRIBUTES_ID = :propertyAttributesId'.
	 */
	public List<PropertyAttributeData> findWherePropertyAttributesIdEquals(int propertyAttributesId) throws PropertyAttributeDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, VALUE_PREFIX, SORT_ORDER, RAW_DATA_ID, PROPERTY_ATTRIBUTES_ID, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE PROPERTY_ATTRIBUTES_ID = ? ORDER BY PROPERTY_ATTRIBUTES_ID", this,propertyAttributesId);
		}
		catch (Exception e) {
			throw new PropertyAttributeDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'PROPERTY_DATA_UUID = :propertyDataUuid'.
	 */
	public List<PropertyAttributeData> findWherePropertyDataUuidEquals(String propertyDataUuid) throws PropertyAttributeDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, VALUE_PREFIX, SORT_ORDER, RAW_DATA_ID, PROPERTY_ATTRIBUTES_ID, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE PROPERTY_DATA_UUID = ? ORDER BY PROPERTY_DATA_UUID", this,propertyDataUuid);
		}
		catch (Exception e) {
			throw new PropertyAttributeDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the PROPERTY_ATTRIBUTE_DATA table that matches the specified primary-key value.
	 */
	public PropertyAttributeData findByPrimaryKey(PropertyAttributeDataPk pk) throws PropertyAttributeDataDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
