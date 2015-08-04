package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.UserActivityLogDaoException;
import com.codeitek.pdp.dal.interfaces.UserActivityLogDao;
import com.codeitek.pdp.model.UserActivityLog;
import com.codeitek.pdp.model.UserActivityLogPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserActivityLogJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<UserActivityLog>, UserActivityLogDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UserActivityLogPk
	 */
	public UserActivityLogPk insert(UserActivityLog dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( LOG_DETAIL, LOG_DTM ) VALUES ( ?, ? )", dto.getLogDetail(), dto.getLogDtm());
		UserActivityLogPk pk = new UserActivityLogPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the USER_ACTIVITY_LOG table.
	 */
	public void update(UserActivityLogPk pk, UserActivityLog dto) throws UserActivityLogDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, LOG_DETAIL = ?, LOG_DTM = ? WHERE ID = ?", dto.getId(), dto.getLogDetail(), dto.getLogDtm(), pk.getId());
	}

	/** 
	 * Deletes a single row in the USER_ACTIVITY_LOG table.
	 */
	public void delete(UserActivityLogPk pk) throws UserActivityLogDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return UserActivityLog
	 */
	public UserActivityLog mapRow(ResultSet rs, int row) throws SQLException
	{
		UserActivityLog dto = new UserActivityLog();
		dto.setId( rs.getInt( 1 ) );
		dto.setLogDetail( rs.getString( 2 ) );
		dto.setLogDtm( rs.getTimestamp(3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "USER_ACTIVITY_LOG";
	}

	/** 
	 * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria 'ID = :id'.
	 */
	public UserActivityLog findByPrimaryKey(int id) throws UserActivityLogDaoException
	{
		try {
			List<UserActivityLog> list = getJdbcTemplate().query("SELECT ID, LOG_DETAIL, LOG_DTM FROM " + getTableName() + " WHERE ID = ?", this, id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new UserActivityLogDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria ''.
	 */
	public List<UserActivityLog> findAll() throws UserActivityLogDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, LOG_DETAIL, LOG_DTM FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new UserActivityLogDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria 'ID = :id'.
	 */
	public List<UserActivityLog> findWhereIdEquals(int id) throws UserActivityLogDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, LOG_DETAIL, LOG_DTM FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
		}
		catch (Exception e) {
			throw new UserActivityLogDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria 'LOG_DETAIL = :logDetail'.
	 */
	public List<UserActivityLog> findWhereLogDetailEquals(String logDetail) throws UserActivityLogDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, LOG_DETAIL, LOG_DTM FROM " + getTableName() + " WHERE LOG_DETAIL = ? ORDER BY LOG_DETAIL", this, logDetail);
		}
		catch (Exception e) {
			throw new UserActivityLogDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria 'LOG_DTM = :logDtm'.
	 */
	public List<UserActivityLog> findWhereLogDtmEquals(Date logDtm) throws UserActivityLogDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, LOG_DETAIL, LOG_DTM FROM " + getTableName() + " WHERE LOG_DTM = ? ORDER BY LOG_DTM", this, logDtm);
		}
		catch (Exception e) {
			throw new UserActivityLogDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the USER_ACTIVITY_LOG table that matches the specified primary-key value.
	 */
	public UserActivityLog findByPrimaryKey(UserActivityLogPk pk) throws UserActivityLogDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

    /**
     * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria 'USER_UUID = :userUuid'.
     */
    public List<UserActivityLog> findByUser(String userUuid) throws UserActivityLogDaoException
    {
        try {
            return getJdbcTemplate().query("SELECT ID, LOG_DETAIL, LOG_DTM, USER_UUID FROM " + getTableName() + " WHERE USER_UUID = ?", this,userUuid);
        }
        catch (Exception e) {
            throw new UserActivityLogDaoException("Query failed", e);
        }

    }

}
