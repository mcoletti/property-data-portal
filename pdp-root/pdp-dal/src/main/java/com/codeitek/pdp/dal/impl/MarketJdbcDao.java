package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.interfaces.MarketDao;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.model.Market;
import com.codeitek.pdp.model.MarketPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class MarketJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<Market>, MarketDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return MarketPk
	 */
	@Transactional
	public MarketPk insert(Market dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( NAME, DELETE_IND ) VALUES ( ?, ? )",dto.getName(),dto.getDeleteInd());
		MarketPk pk = new MarketPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the MARKET table.
	 */
	@Transactional
	public void update(MarketPk pk, Market dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, NAME = ?, DELETE_IND = ? WHERE ID = ?",dto.getId(),dto.getName(),dto.getDeleteInd(),pk.getId());
	}

	/** 
	 * Deletes a single row in the MARKET table.
	 */
	@Transactional
	public void delete(MarketPk pk) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return Market
	 */
	public Market mapRow(ResultSet rs, int row) throws SQLException
	{
		Market dto = new Market();
		dto.setId( rs.getInt( 1 ) );
		dto.setName( rs.getString( 2 ) );
		dto.setDeleteInd( rs.getBoolean(3) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "MARKET";
	}

	/** 
	 * Returns all rows from the MARKET table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public Market findByPrimaryKey(int id) throws DataBaseJdbcException
	{
		try {
			List<Market> list = getJdbcTemplate().query("SELECT ID, NAME, DELETE_IND FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the MARKET table that match the criteria ''.
	 */
	@Transactional
	public List<Market> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, NAME, DELETE_IND FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the MARKET table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<Market> findWhereIdEquals(int id) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, NAME, DELETE_IND FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the MARKET table that match the criteria 'NAME = :name'.
	 */
	@Transactional
	public List<Market> findWhereNameEquals(String name) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, NAME, DELETE_IND FROM " + getTableName() + " WHERE NAME = ? ORDER BY NAME", this,name);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the MARKET table that match the criteria 'DELETE_IND = :deleteInd'.
	 */
	@Transactional
	public List<Market> findWhereDeleteIndEquals(short deleteInd) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, NAME, DELETE_IND FROM " + getTableName() + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this,deleteInd);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the MARKET table that matches the specified primary-key value.
	 */
	public Market findByPrimaryKey(MarketPk pk) throws DataBaseJdbcException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
