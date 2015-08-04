package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.UserActivityLogDaoException;
import com.codeitek.pdp.model.UserActivityLog;
import com.codeitek.pdp.model.UserActivityLogPk;

import java.util.Date;
import java.util.List;

public interface UserActivityLogDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UserActivityLogPk
	 */
	public UserActivityLogPk insert(UserActivityLog dto);

	/** 
	 * Updates a single row in the USER_ACTIVITY_LOG table.
	 */
	public void update(UserActivityLogPk pk, UserActivityLog dto) throws UserActivityLogDaoException;

	/** 
	 * Deletes a single row in the USER_ACTIVITY_LOG table.
	 */
	public void delete(UserActivityLogPk pk) throws UserActivityLogDaoException;

	/** 
	 * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria 'ID = :id'.
	 */
	public UserActivityLog findByPrimaryKey(int id) throws UserActivityLogDaoException;

	/** 
	 * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria ''.
	 */
	public List<UserActivityLog> findAll() throws UserActivityLogDaoException;

	/** 
	 * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria 'ID = :id'.
	 */
	public List<UserActivityLog> findWhereIdEquals(int id) throws UserActivityLogDaoException;

	/** 
	 * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria 'LOG_DETAIL = :logDetail'.
	 */
	public List<UserActivityLog> findWhereLogDetailEquals(String logDetail) throws UserActivityLogDaoException;

	/** 
	 * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria 'LOG_DTM = :logDtm'.
	 */
	public List<UserActivityLog> findWhereLogDtmEquals(Date logDtm) throws UserActivityLogDaoException;

	/** 
	 * Returns the rows from the USER_ACTIVITY_LOG table that matches the specified primary-key value.
	 */
	public UserActivityLog findByPrimaryKey(UserActivityLogPk pk) throws UserActivityLogDaoException;

    /**
     * Returns all rows from the USER_ACTIVITY_LOG table that match the criteria 'USER_UUID = :userUuid'.
     */
    public List<UserActivityLog> findByUser(String userUuid) throws UserActivityLogDaoException;

}
