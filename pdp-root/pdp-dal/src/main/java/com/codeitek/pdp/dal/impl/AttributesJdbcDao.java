package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.interfaces.AttributesDao;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.model.Attributes;
import com.codeitek.pdp.model.AttributesPk;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class AttributesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<Attributes>, AttributesDao
{

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(AttributesJdbcDao.class);
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return AttributesPk
	 */
	public AttributesPk insert(Attributes dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( KEY ) VALUES ( ? )",dto.getKey());
		AttributesPk pk = new AttributesPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the ATTRIBUTES table.
	 */
	public AttributesPk update(AttributesPk pk, Attributes dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, KEY = ? WHERE ID = ?",dto.getId(),dto.getKey(),pk.getId());
	    return pk;
    }

	/** 
	 * Deletes a single row in the ATTRIBUTES table.
	 */
	public void delete(AttributesPk pk) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return Attributes
	 */
	public Attributes mapRow(ResultSet rs, int row) throws SQLException
	{
		Attributes dto = new Attributes();
		dto.setId( rs.getInt( 1 ) );
		dto.setKey( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "ATTRIBUTES";
	}

	/** 
	 * Returns all rows from the ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public Attributes findByPrimaryKey(int id) throws DataBaseJdbcException
	{
		try {
			List<Attributes> list = getJdbcTemplate().query("SELECT ID, KEY FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ATTRIBUTES table that match the criteria ''.
	 */
	public List<Attributes> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public List<Attributes> findWhereIdEquals(int id) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ATTRIBUTES table that match the criteria 'KEY = :key'.
	 */
	public List<Attributes> findWhereKeyEquals(String key) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY FROM " + getTableName() + " WHERE KEY = ? ORDER BY KEY", this,key);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the ATTRIBUTES table that matches the specified primary-key value.
	 */
	public Attributes findByPrimaryKey(AttributesPk pk) throws DataBaseJdbcException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
