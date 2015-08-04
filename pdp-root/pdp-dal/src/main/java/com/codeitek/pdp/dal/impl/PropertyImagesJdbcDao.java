package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.PropertyImagesDaoException;
import com.codeitek.pdp.dal.interfaces.PropertyImagesDao;
import com.codeitek.pdp.model.PropertyImages;
import com.codeitek.pdp.model.PropertyImagesPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PropertyImagesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<PropertyImages>, PropertyImagesDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return PropertyImagesPk
	 */
	public PropertyImagesPk insert(PropertyImages dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( TITLE, TYPE, SIZE, SRC_URL, PROPERTY_DATA_UUID ) VALUES ( ?, ?, ?, ?, ? )",dto.getTitle(),dto.getType(),dto.getSize(),dto.getSrcUrl(),dto.getPropertyDataUuid());
		PropertyImagesPk pk = new PropertyImagesPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the PROPERTY_IMAGES table.
	 */
	public void update(PropertyImagesPk pk, PropertyImages dto) throws PropertyImagesDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, TITLE = ?, TYPE = ?, SIZE = ?, SRC_URL = ?, PROPERTY_DATA_UUID = ? WHERE ID = ?",dto.getId(),dto.getTitle(),dto.getType(),dto.getSize(),dto.getSrcUrl(),dto.getPropertyDataUuid(),pk.getId());
	}

	/** 
	 * Deletes a single row in the PROPERTY_IMAGES table.
	 */
	public void delete(PropertyImagesPk pk) throws PropertyImagesDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return PropertyImages
	 */
	public PropertyImages mapRow(ResultSet rs, int row) throws SQLException
	{
		PropertyImages dto = new PropertyImages();
		dto.setId( rs.getInt( 1 ) );
		dto.setTitle( rs.getString( 2 ) );
		dto.setType( rs.getString( 3 ) );
		dto.setSize( rs.getInt( 4 ) );
		dto.setSrcUrl( rs.getString( 5 ) );
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
		return "PROPERTY_IMAGES";
	}

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'ID = :id'.
	 */
	public PropertyImages findByPrimaryKey(int id) throws PropertyImagesDaoException
	{
		try {
			List<PropertyImages> list = getJdbcTemplate().query("SELECT ID, TITLE, TYPE, SIZE, SRC_URL, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new PropertyImagesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria ''.
	 */
	public List<PropertyImages> findAll() throws PropertyImagesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TITLE, TYPE, SIZE, SRC_URL, PROPERTY_DATA_UUID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new PropertyImagesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'PROPERTY_DATA_UUID = :propertyDataUuid'.
	 */
	public List<PropertyImages> findByPropertyData(String propertyDataUuid) throws PropertyImagesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TITLE, TYPE, SIZE, SRC_URL, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE PROPERTY_DATA_UUID = ?", this,propertyDataUuid);
		}
		catch (Exception e) {
			throw new PropertyImagesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'ID = :id'.
	 */
	public List<PropertyImages> findWhereIdEquals(int id) throws PropertyImagesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TITLE, TYPE, SIZE, SRC_URL, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new PropertyImagesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'TITLE = :title'.
	 */
	public List<PropertyImages> findWhereTitleEquals(String title) throws PropertyImagesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TITLE, TYPE, SIZE, SRC_URL, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE TITLE = ? ORDER BY TITLE", this,title);
		}
		catch (Exception e) {
			throw new PropertyImagesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'TYPE = :type'.
	 */
	public List<PropertyImages> findWhereTypeEquals(String type) throws PropertyImagesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TITLE, TYPE, SIZE, SRC_URL, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE TYPE = ? ORDER BY TYPE", this,type);
		}
		catch (Exception e) {
			throw new PropertyImagesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'SIZE = :size'.
	 */
	public List<PropertyImages> findWhereSizeEquals(int size) throws PropertyImagesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TITLE, TYPE, SIZE, SRC_URL, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE SIZE = ? ORDER BY SIZE", this,size);
		}
		catch (Exception e) {
			throw new PropertyImagesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'SRC_URL = :srcUrl'.
	 */
	public List<PropertyImages> findWhereSrcUrlEquals(String srcUrl) throws PropertyImagesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TITLE, TYPE, SIZE, SRC_URL, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE SRC_URL = ? ORDER BY SRC_URL", this,srcUrl);
		}
		catch (Exception e) {
			throw new PropertyImagesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'PROPERTY_DATA_UUID = :propertyDataUuid'.
	 */
	public List<PropertyImages> findWherePropertyDataUuidEquals(String propertyDataUuid) throws PropertyImagesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TITLE, TYPE, SIZE, SRC_URL, PROPERTY_DATA_UUID FROM " + getTableName() + " WHERE PROPERTY_DATA_UUID = ? ORDER BY PROPERTY_DATA_UUID", this,propertyDataUuid);
		}
		catch (Exception e) {
			throw new PropertyImagesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the PROPERTY_IMAGES table that matches the specified primary-key value.
	 */
	public PropertyImages findByPrimaryKey(PropertyImagesPk pk) throws PropertyImagesDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
