package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.interfaces.StateDao;
import com.codeitek.pdp.dal.exceptions.StateDaoException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.model.State;
import com.codeitek.pdp.model.StatePk;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class StateJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<State>, StateDao
{

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(StateJdbcDao.class);
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return StatePk
	 */
	@Transactional
	public StatePk insert(State dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( STATE, FULL_NAME ) VALUES ( ?, ? )", dto.getStateName(), dto.getFullName());
		StatePk pk = new StatePk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the STATE table.
	 */
	@Transactional
	public StatePk update(StatePk pk, State dto) throws StateDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, STATE = ?, FULL_NAME = ? WHERE ID = ?", dto.getId(), dto.getStateName(), dto.getFullName(), pk.getId());
	    return pk;
    }

	/** 
	 * Deletes a single row in the STATE table.
	 */
	@Transactional
	public void delete(StatePk pk) throws StateDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return State
	 */
	public State mapRow(ResultSet rs, int row) throws SQLException
	{
		State dto = new State();
		dto.setId( rs.getInt( 1 ) );
		dto.setStateName(rs.getString(2));
		dto.setFullName( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "STATE";
	}

	/** 
	 * Returns all rows from the STATE table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public State findByPrimaryKey(int id) throws StateDaoException
	{
		try {
			List<State> list = getJdbcTemplate().query("SELECT ID, STATE, FULL_NAME FROM " + getTableName() + " WHERE ID = ?", this, id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new StateDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the STATE table that match the criteria ''.
	 */
	@Transactional
	public List<State> findAll() throws StateDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, STATE, FULL_NAME FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new StateDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the STATE table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<State> findWhereIdEquals(int id) throws StateDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, STATE, FULL_NAME FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
		}
		catch (Exception e) {
			throw new StateDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the STATE table that match the criteria 'STATE = :stateName'.
	 */
	@Transactional
	public List<State> findWhereStateEquals(String state) throws StateDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, STATE, FULL_NAME FROM " + getTableName() + " WHERE STATE = ? ORDER BY STATE", this, state);
		}
		catch (Exception e) {
			throw new StateDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the STATE table that match the criteria 'FULL_NAME = :fullName'.
	 */
	@Transactional
	public List<State> findWhereFullNameEquals(String fullName) throws StateDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, STATE, FULL_NAME FROM " + getTableName() + " WHERE FULL_NAME = ? ORDER BY FULL_NAME", this, fullName);
		}
		catch (Exception e) {
			throw new StateDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the STATE table that matches the specified primary-key value.
	 */
	public State findByPrimaryKey(StatePk pk) throws StateDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
