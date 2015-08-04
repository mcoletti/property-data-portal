package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.PropertyTypeDaoException;
import com.codeitek.pdp.dal.interfaces.PropertyTypeDao;
import com.codeitek.pdp.model.PropertyType;
import com.codeitek.pdp.model.PropertyTypePk;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PropertyTypeJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<PropertyType>, PropertyTypeDao
{

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(PropertyTypeJdbcDao.class);
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return PropertyTypePk
	 */
	public PropertyTypePk insert(PropertyType dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( TYPE, DELETE_IND ) VALUES ( ?, ? )",dto.getType(),dto.getDeleteInd());
		PropertyTypePk pk = new PropertyTypePk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the PROPERTY_TYPE table.
	 */
	public void update(PropertyTypePk pk, PropertyType dto) throws PropertyTypeDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, TYPE = ?, DELETE_IND = ? WHERE ID = ?",dto.getId(),dto.getType(),dto.getDeleteInd(),pk.getId());
	}

	/** 
	 * Deletes a single row in the PROPERTY_TYPE table.
	 */
	public void delete(PropertyTypePk pk) throws PropertyTypeDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return PropertyType
	 */
	public PropertyType mapRow(ResultSet rs, int row) throws SQLException
	{
		PropertyType dto = new PropertyType();
		dto.setId( rs.getInt( 1 ) );
		dto.setType( rs.getString( 2 ) );
		dto.setDeleteInd( rs.getShort( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "PROPERTY_TYPE";
	}

	/** 
	 * Returns all rows from the PROPERTY_TYPE table that match the criteria 'ID = :id'.
	 */
	public PropertyType findByPrimaryKey(int id) throws PropertyTypeDaoException
	{
		try {
			List<PropertyType> list = getJdbcTemplate().query("SELECT ID, TYPE, DELETE_IND FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new PropertyTypeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_TYPE table that match the criteria ''.
	 */
	public List<PropertyType> findAll() throws PropertyTypeDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TYPE, DELETE_IND FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new PropertyTypeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_TYPE table that match the criteria 'ID = :id'.
	 */
	public List<PropertyType> findWhereIdEquals(int id) throws PropertyTypeDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TYPE, DELETE_IND FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new PropertyTypeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_TYPE table that match the criteria 'TYPE = :type'.
	 */
	public List<PropertyType> findWhereTypeEquals(String type) throws PropertyTypeDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TYPE, DELETE_IND FROM " + getTableName() + " WHERE TYPE = ? ORDER BY TYPE", this,type);
		}
		catch (Exception e) {
			throw new PropertyTypeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_TYPE table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<PropertyType> findWhereDeleteIndEquals(short deleteInd) throws PropertyTypeDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, TYPE, DELETE_IND FROM " + getTableName() + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this,deleteInd);
		}
		catch (Exception e) {
			throw new PropertyTypeDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the PROPERTY_TYPE table that matches the specified primary-key value.
	 */
	public PropertyType findByPrimaryKey(PropertyTypePk pk) throws PropertyTypeDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
