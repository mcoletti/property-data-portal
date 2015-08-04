package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.RawDataDaoException;
import com.codeitek.pdp.dal.interfaces.RawDataDao;
import com.codeitek.pdp.model.RawData;
import com.codeitek.pdp.model.RawDataPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RawDataJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<RawData>, RawDataDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return RawDataPk
	 */
	public RawDataPk insert(RawData dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( DATA_VALUE ) VALUES ( ? )",dto.getDataValue());
		RawDataPk pk = new RawDataPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the RAW_DATA table.
	 */
	public void update(RawDataPk pk, RawData dto) throws RawDataDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, DATA_VALUE = ? WHERE ID = ?",dto.getId(),dto.getDataValue(),pk.getId());
	}

	/** 
	 * Deletes a single row in the RAW_DATA table.
	 */
	public void delete(RawDataPk pk) throws RawDataDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return RawData
	 */
	public RawData mapRow(ResultSet rs, int row) throws SQLException
	{
		RawData dto = new RawData();
		dto.setId( rs.getInt( 1 ) );
		dto.setDataValue( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "RAW_DATA";
	}

	/** 
	 * Returns all rows from the RAW_DATA table that match the criteria 'ID = :id'.
	 */
	public RawData findByPrimaryKey(int id) throws RawDataDaoException
	{
		try {
			List<RawData> list = getJdbcTemplate().query("SELECT ID, DATA_VALUE FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new RawDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the RAW_DATA table that match the criteria ''.
	 */
	public List<RawData> findAll() throws RawDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, DATA_VALUE FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new RawDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the RAW_DATA table that match the criteria 'ID = :id'.
	 */
	public List<RawData> findWhereIdEquals(int id) throws RawDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, DATA_VALUE FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new RawDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the RAW_DATA table that match the criteria 'DATA_VALUE = :dataValue'.
	 */
	public List<RawData> findWhereDataValueEquals(String dataValue) throws RawDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, DATA_VALUE FROM " + getTableName() + " WHERE DATA_VALUE = ? ORDER BY DATA_VALUE", this,dataValue);
		}
		catch (Exception e) {
			throw new RawDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the RAW_DATA table that matches the specified primary-key value.
	 */
	public RawData findByPrimaryKey(RawDataPk pk) throws RawDataDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
