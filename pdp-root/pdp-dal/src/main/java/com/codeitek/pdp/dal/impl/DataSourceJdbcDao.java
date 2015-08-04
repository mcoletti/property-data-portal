package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.interfaces.DataSourceDao;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.model.DataSource;
import com.codeitek.pdp.model.DataSourcePk;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class DataSourceJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<DataSource>, DataSourceDao
{

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(DataSourceJdbcDao.class);
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return DataSourcePk
	 */
	@Transactional
	public DataSourcePk insert(DataSource dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( NAME, CUSTOMER_UUID ) VALUES ( ?, ? )",dto.getName(),dto.getCustomerUuid());
		DataSourcePk pk = new DataSourcePk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the DATA_SOURCE table.
	 */
	@Transactional
	public void update(DataSourcePk pk, DataSource dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, NAME = ?, CUSTOMER_UUID = ? WHERE ID = ?",dto.getId(),dto.getName(),dto.getCustomerUuid(),pk.getId());
	}

	/** 
	 * Deletes a single row in the DATA_SOURCE table.
	 */
	@Transactional
	public void delete(DataSourcePk pk) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return DataSource
	 */
	public DataSource mapRow(ResultSet rs, int row) throws SQLException
	{
		DataSource dto = new DataSource();
		dto.setId( rs.getInt( 1 ) );
		dto.setName( rs.getString( 2 ) );
		dto.setCustomerUuid( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "PDPDB.DATA_SOURCE";
	}

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public DataSource findByPrimaryKey(int id) throws DataBaseJdbcException
	{
		try {
			List<DataSource> list = getJdbcTemplate().query("SELECT ID, NAME, CUSTOMER_UUID FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria ''.
	 */
	@Transactional
	public List<DataSource> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, NAME, CUSTOMER_UUID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	@Transactional
	public List<DataSource> findByCustomer(String customerUuid) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, NAME, CUSTOMER_UUID FROM " + getTableName() + " WHERE CUSTOMER_UUID = ?", this,customerUuid);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<DataSource> findWhereIdEquals(int id) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, NAME, CUSTOMER_UUID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria 'NAME = :customerName'.
	 */
	@Transactional
	public List<DataSource> findWhereNameEquals(String name) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, NAME, CUSTOMER_UUID FROM " + getTableName() + " WHERE NAME = ? ORDER BY NAME", this,name);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	@Transactional
	public List<DataSource> findWhereCustomerUuidEquals(String customerUuid) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, NAME, CUSTOMER_UUID FROM " + getTableName() + " WHERE CUSTOMER_UUID = ? ORDER BY CUSTOMER_UUID", this,customerUuid);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the DATA_SOURCE table that matches the specified primary-key value.
	 */
	public DataSource findByPrimaryKey(DataSourcePk pk) throws DataBaseJdbcException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
