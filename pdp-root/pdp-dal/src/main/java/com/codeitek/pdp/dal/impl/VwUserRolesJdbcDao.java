package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.VwUserRolesDaoException;
import com.codeitek.pdp.dal.interfaces.VwUserRolesDao;
import com.codeitek.pdp.model.VwUserRoles;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class VwUserRolesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<VwUserRoles>, VwUserRolesDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 */
	@Transactional
	public void insert(VwUserRoles dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getUuid(),dto.getUserName(),dto.getFirstName(),dto.getLastName(),dto.getPrimaryEmail(),dto.getReferredBy(),dto.getGender(),dto.getDeleteInd(),dto.getCustomerUuid(),dto.getLastLoginDtm(),dto.getLockInd(),dto.getAccountLevelId(),dto.getUserRoleId(),dto.getRoleDataId(),dto.getRoleName());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return VwUserRoles
	 */
	public VwUserRoles mapRow(ResultSet rs, int row) throws SQLException
	{
		VwUserRoles dto = new VwUserRoles();
		dto.setUuid( rs.getString( 1 ) );
		dto.setUserName( rs.getString( 2 ) );
		dto.setFirstName( rs.getString( 3 ) );
		dto.setLastName( rs.getString( 4 ) );
		dto.setPrimaryEmail( rs.getString( 5 ) );
		dto.setReferredBy( rs.getString( 6 ) );
		dto.setGender( rs.getString( 7 ) );
		dto.setDeleteInd( rs.getShort( 8 ) );
		dto.setCustomerUuid( rs.getString( 9 ) );
		dto.setLastLoginDtm( rs.getTimestamp(10 ) );
		dto.setLockInd( rs.getShort( 11 ) );
		dto.setAccountLevelId( rs.getInt( 12 ) );
		dto.setUserRoleId( rs.getInt( 13 ) );
		dto.setRoleDataId( rs.getInt( 14 ) );
		dto.setRoleName( rs.getString( 15 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "vw_UserRoles";
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria ''.
	 */
	@Transactional
	public List<VwUserRoles> findAll() throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + "", this);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'UUID = :customerUuid'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereUuidEquals(String uuid) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE UUID = ? ORDER BY UUID", this,uuid);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'USER_NAME = :userName'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereUserNameEquals(String userName) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE USER_NAME = ? ORDER BY USER_NAME", this,userName);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'FIRST_NAME = :firstName'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereFirstNameEquals(String firstName) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE FIRST_NAME = ? ORDER BY FIRST_NAME", this,firstName);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'LAST_NAME = :lastName'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereLastNameEquals(String lastName) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE LAST_NAME = ? ORDER BY LAST_NAME", this,lastName);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'PRIMARY_EMAIL = :primaryEmail'.
	 */
	@Transactional
	public List<VwUserRoles> findWherePrimaryEmailEquals(String primaryEmail) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE PRIMARY_EMAIL = ? ORDER BY PRIMARY_EMAIL", this,primaryEmail);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'REFERRED_BY = :referredBy'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereReferredByEquals(String referredBy) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE REFERRED_BY = ? ORDER BY REFERRED_BY", this,referredBy);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'GENDER = :gender'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereGenderEquals(String gender) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE GENDER = ? ORDER BY GENDER", this,gender);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereDeleteIndEquals(short deleteInd) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this,deleteInd);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereCustomerUuidEquals(String customerUuid) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE CUSTOMER_UUID = ? ORDER BY CUSTOMER_UUID", this,customerUuid);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'LAST_LOGIN_DTM = :lastLoginDtm'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereLastLoginDtmEquals(Date lastLoginDtm) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE LAST_LOGIN_DTM = ? ORDER BY LAST_LOGIN_DTM", this,lastLoginDtm);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'LOCK_IND = :lockInd'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereLockIndEquals(short lockInd) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE LOCK_IND = ? ORDER BY LOCK_IND", this,lockInd);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'ACCOUNT_LEVEL_ID = :accountLevelId'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereAccountLevelIdEquals(int accountLevelId) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE ACCOUNT_LEVEL_ID = ? ORDER BY ACCOUNT_LEVEL_ID", this,accountLevelId);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'USER_ROLE_ID = :userRoleId'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereUserRoleIdEquals(int userRoleId) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE USER_ROLE_ID = ? ORDER BY USER_ROLE_ID", this,userRoleId);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'ROLE_DATA_ID = :roleDataId'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereRoleDataIdEquals(int roleDataId) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE ROLE_DATA_ID = ? ORDER BY ROLE_DATA_ID", this,roleDataId);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'ROLE_NAME = :roleName'.
	 */
	@Transactional
	public List<VwUserRoles> findWhereRoleNameEquals(String roleName) throws VwUserRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, USER_ROLE_ID, ROLE_DATA_ID, ROLE_NAME FROM " + getTableName() + " WHERE ROLE_NAME = ? ORDER BY ROLE_NAME", this,roleName);
		}
		catch (Exception e) {
			throw new VwUserRolesDaoException("Query failed", e);
		}
		
	}

}
