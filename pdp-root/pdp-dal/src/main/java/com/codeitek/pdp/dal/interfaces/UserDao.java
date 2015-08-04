package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.User;
import com.codeitek.pdp.model.UserPk;

import java.util.Date;
import java.util.List;

public interface UserDao
{
	/**
	 * Method 'insert'
	 * 
	 *
     * @param dto
     * @return UserPk
	 */
	public String insert(User dto);

	/** 
	 * Updates a single row in the USER table.
	 */
	public String update(String uuid, User dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the USER table.
	 */
	public void delete(String uuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'UUID = :customerUuid'.
	 */
	public User findByPrimaryKey(String uuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria ''.
	 */
	public List<User> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'UUID = :customerUuid'.
	 */
	public List<User> findWhereUuidEquals(String uuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'USER_NAME = :userName'.
	 */
	public List<User> findWhereUserNameEquals(String userName) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'FIRST_NAME = :firstName'.
	 */
	public List<User> findWhereFirstNameEquals(String firstName) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'LAST_NAME = :lastName'.
	 */
	public List<User> findWhereLastNameEquals(String lastName) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'PRIMARY_EMAIL = :primaryEmail'.
	 */
	public List<User> findWherePrimaryEmailEquals(String primaryEmail) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'REFERRED_BY = :referredBy'.
	 */
	public List<User> findWhereReferredByEquals(String referredBy) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'GENDER = :gender'.
	 */
	public List<User> findWhereGenderEquals(String gender) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<User> findWhereDeleteIndEquals(short deleteInd) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	public List<User> findWhereCustomerUuidEquals(String customerUuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'ROLE_DATA_ID = :roleDataId'.
	 */
	public List<User> findWhereRoleDataIdEquals(int roleDataId) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'LAST_LOGIN_DTM = :lastLoginDtm'.
	 */
	public List<User> findWhereLastLoginDtmEquals(Date lastLoginDtm) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'LOCK_IND = :lockInd'.
	 */
	public List<User> findWhereLockIndEquals(short lockInd) throws DataBaseJdbcException;


    public User getByAuthToken(String token) throws DataBaseJdbcException;
}
