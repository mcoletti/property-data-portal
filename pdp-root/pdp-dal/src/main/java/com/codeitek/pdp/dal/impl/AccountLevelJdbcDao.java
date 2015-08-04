package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOTableRef;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.interfaces.AccountLevelDao;
import com.codeitek.pdp.model.AccountLevel;
import com.codeitek.pdp.model.AccountLevelPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountLevelJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<AccountLevel>, AccountLevelDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return AccountLevelPk
	 */
	public AccountLevelPk insert(AccountLevel dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( LEVEL, DETAIL, DELETE_IND ) VALUES ( ?, ?, ? )",dto.getLevel(),dto.getDetail(),dto.getDeleteInd());
		AccountLevelPk pk = new AccountLevelPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the ACCOUNT_LEVEL table.
	 */
	public void update(AccountLevelPk pk, AccountLevel dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, LEVEL = ?, DETAIL = ?, DELETE_IND = ? WHERE ID = ?",dto.getId(),dto.getLevel(),dto.getDetail(),dto.getDeleteInd(),pk.getId());
	}

	/** 
	 * Deletes a single row in the ACCOUNT_LEVEL table.
	 */
	public void delete(AccountLevelPk pk) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return AccountLevel
	 */
	public AccountLevel mapRow(ResultSet rs, int row) throws SQLException
	{
		AccountLevel dto = new AccountLevel();
		dto.setId( rs.getInt( 1 ) );
		dto.setLevel( rs.getString( 2 ) );
		dto.setDetail( rs.getString( 3 ) );
		dto.setDeleteInd( rs.getBoolean( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return DAOTableRef.ACCT_LVL;
	}

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria 'ID = :id'.
	 */
	public AccountLevel findByPrimaryKey(int id) throws DataBaseJdbcException
	{
		try {
			List<AccountLevel> list = getJdbcTemplate().query("SELECT ID, LEVEL, DETAIL, DELETE_IND FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria ''.
	 */
	public List<AccountLevel> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, LEVEL, DETAIL, DELETE_IND FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria 'ID = :id'.
	 */
	public List<AccountLevel> findWhereIdEquals(int id) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, LEVEL, DETAIL, DELETE_IND FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria 'LEVEL = :level'.
	 */
	public List<AccountLevel> findWhereLevelEquals(String level) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, LEVEL, DETAIL, DELETE_IND FROM " + getTableName() + " WHERE LEVEL = ? ORDER BY LEVEL", this,level);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria 'DETAIL = :detail'.
	 */
	public List<AccountLevel> findWhereDetailEquals(String detail) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, LEVEL, DETAIL, DELETE_IND FROM " + getTableName() + " WHERE DETAIL = ? ORDER BY DETAIL", this,detail);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<AccountLevel> findWhereDeleteIndEquals(short deleteInd) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, LEVEL, DETAIL, DELETE_IND FROM " + getTableName() + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this,deleteInd);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the ACCOUNT_LEVEL table that matches the specified primary-key value.
	 */
	public AccountLevel findByPrimaryKey(AccountLevelPk pk) throws DataBaseJdbcException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
