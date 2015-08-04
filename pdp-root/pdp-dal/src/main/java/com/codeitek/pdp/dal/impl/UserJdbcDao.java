package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOQueries;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.interfaces.UserDao;
import com.codeitek.pdp.model.User;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<User>, UserDao
{


	/**
	 * Method 'insert'
	 * 
	 *
     * @param dto
     * @return UserPk
	 */
	public String insert(User dto)
	{
		dto.setUuid(UUID.randomUUID().toString());
        getJdbcTemplate().update(DAOQueries.I_USER, dto.getUuid(), dto.getUserName(), dto.getFirstName(), dto.getLastName(), dto.getPrimaryEmail(), dto.getReferredBy(), dto.getGender(), dto.getDeleteInd(), dto.getCustomerUuid(), dto.getLastLoginDtm(), dto.getLockInd(),dto.getApiKey(),dto.getApiKeyExpirationDate());
		return dto.getUuid();
	}

	/** 
	 * Updates a single row in the USER table.
	 */
	public String update(String uuid, User dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update(DAOQueries.U_USER, dto.getUuid(), dto.getUserName(), dto.getFirstName(), dto.getLastName(), dto.getPrimaryEmail(), dto.getReferredBy(), dto.getGender(), dto.getDeleteInd(), dto.getCustomerUuid(), dto.getLastLoginDtm(), dto.getLockInd(),dto.getApiKey(),dto.getApiKeyExpirationDate(), uuid);
        return uuid;
	}

	/** 
	 * Deletes a single row in the USER table.
	 */
	public void delete(String uuid) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE UUID = ?", uuid);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return User
	 */
	public User mapRow(ResultSet rs, int row) throws SQLException
	{
		User dto = new User();
		dto.setUuid( rs.getString( 1 ) );
		dto.setUserName(rs.getString(2));
		dto.setFirstName(rs.getString(3));
		dto.setLastName(rs.getString(4));
		dto.setPrimaryEmail(rs.getString(5));
		dto.setReferredBy(rs.getString(6));
		dto.setGender(rs.getString(7));
		dto.setDeleteInd(rs.getBoolean(8));
		dto.setCustomerUuid(rs.getString(9));
		dto.setLastLoginDtm(rs.getTimestamp(10));
        dto.setLockInd(rs.getBoolean(11));
		dto.setApiKey(rs.getString(12));
		dto.setApiKeyExpirationDate(rs.getDate(13));
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "USER";
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'UUID = :customerUuid'.
	 */
	public User findByPrimaryKey(String uuid) throws DataBaseJdbcException
	{
		try {
			List<User> list = getJdbcTemplate().query(DAOQueries.S_USER + " WHERE UUID = ?", this, uuid);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria ''.
	 */
	public List<User> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " ORDER BY UUID", this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'UUID = :customerUuid'.
	 */
	public List<User> findWhereUuidEquals(String uuid) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE UUID = ? ORDER BY UUID", this, uuid);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'USER_NAME = :userName'.
	 */
	public List<User> findWhereUserNameEquals(String userName) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE USER_NAME = ? ORDER BY USER_NAME", this, userName);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'FIRST_NAME = :firstName'.
	 */
	public List<User> findWhereFirstNameEquals(String firstName) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE FIRST_NAME = ? ORDER BY FIRST_NAME", this, firstName);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'LAST_NAME = :lastName'.
	 */
	public List<User> findWhereLastNameEquals(String lastName) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE LAST_NAME = ? ORDER BY LAST_NAME", this, lastName);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'PRIMARY_EMAIL = :primaryEmail'.
	 */
	public List<User> findWherePrimaryEmailEquals(String primaryEmail) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE PRIMARY_EMAIL = ? ORDER BY PRIMARY_EMAIL", this, primaryEmail);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'REFERRED_BY = :referredBy'.
	 */
	public List<User> findWhereReferredByEquals(String referredBy) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE REFERRED_BY = ? ORDER BY REFERRED_BY", this, referredBy);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'GENDER = :gender'.
	 */
	public List<User> findWhereGenderEquals(String gender) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE GENDER = ? ORDER BY GENDER", this, gender);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<User> findWhereDeleteIndEquals(short deleteInd) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this, deleteInd);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	public List<User> findWhereCustomerUuidEquals(String customerUuid) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE CUSTOMER_UUID = ? ORDER BY CUSTOMER_UUID", this, customerUuid);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'ROLE_DATA_ID = :roleDataId'.
	 */
	public List<User> findWhereRoleDataIdEquals(int roleDataId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE ROLE_DATA_ID = ? ORDER BY ROLE_DATA_ID", this, roleDataId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'LAST_LOGIN_DTM = :lastLoginDtm'.
	 */
	public List<User> findWhereLastLoginDtmEquals(Date lastLoginDtm) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE LAST_LOGIN_DTM = ? ORDER BY LAST_LOGIN_DTM", this, lastLoginDtm);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER table that match the criteria 'LOCK_IND = :lockInd'.
	 */
	public List<User> findWhereLockIndEquals(short lockInd) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_USER + " WHERE LOCK_IND = ? ORDER BY LOCK_IND", this, lockInd);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

    @Override
    public User getByAuthToken(String token) throws DataBaseJdbcException {
        try {
            List<User> list = getJdbcTemplate().query(DAOQueries.S_USER + " WHERE AUTH_TOKEN = ?", this, token);
            return list.size() == 0 ? null : list.get(0);
        }
        catch (Exception e) {
            throw new DataBaseJdbcException("Query failed", e);
        }
    }


}
