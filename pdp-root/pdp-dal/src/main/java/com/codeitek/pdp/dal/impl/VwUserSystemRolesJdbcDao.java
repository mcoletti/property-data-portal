package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.VwUserSystemRolesDaoException;
import com.codeitek.pdp.dal.interfaces.VwUserSystemRolesDao;
import com.codeitek.pdp.model.VwUserSystemRoles;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class VwUserSystemRolesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<VwUserSystemRoles>, VwUserSystemRolesDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 */
	@Transactional
	public void insert(VwUserSystemRoles dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getUuid(),dto.getUserName(),dto.getFirstName(),dto.getLastName(),dto.getPrimaryEmail(),dto.getReferredBy(),dto.getGender(),dto.getDeleteInd(),dto.getCustomerUuid(),dto.getLastLoginDtm(),dto.getLockInd(),dto.getAccountLevelId(),dto.getSystemGroupMemberId(),dto.getSystemRoleId(),dto.getRoleName(),dto.getActiveInd(),dto.getCreUserId(),dto.getCreDtm());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return VwUserSystemRoles
	 */
	public VwUserSystemRoles mapRow(ResultSet rs, int row) throws SQLException
	{
		VwUserSystemRoles dto = new VwUserSystemRoles();
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
		dto.setSystemGroupMemberId( rs.getInt( 13 ) );
		dto.setSystemRoleId( rs.getInt( 14 ) );
		dto.setRoleName( rs.getString( 15 ) );
		dto.setActiveInd( rs.getShort( 16 ) );
		dto.setCreUserId( rs.getInt( 17 ) );
		dto.setCreDtm( rs.getTimestamp(18 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "vw_UserSystemRoles";
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria ''.
	 */
	@Transactional
	public List<VwUserSystemRoles> findAll() throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + "", this);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'UUID = :customerUuid'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereUuidEquals(String uuid) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE UUID = ? ORDER BY UUID", this,uuid);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'USER_NAME = :userName'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereUserNameEquals(String userName) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE USER_NAME = ? ORDER BY USER_NAME", this,userName);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'FIRST_NAME = :firstName'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereFirstNameEquals(String firstName) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE FIRST_NAME = ? ORDER BY FIRST_NAME", this,firstName);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'LAST_NAME = :lastName'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereLastNameEquals(String lastName) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE LAST_NAME = ? ORDER BY LAST_NAME", this,lastName);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'PRIMARY_EMAIL = :primaryEmail'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWherePrimaryEmailEquals(String primaryEmail) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE PRIMARY_EMAIL = ? ORDER BY PRIMARY_EMAIL", this,primaryEmail);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'REFERRED_BY = :referredBy'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereReferredByEquals(String referredBy) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE REFERRED_BY = ? ORDER BY REFERRED_BY", this,referredBy);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'GENDER = :gender'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereGenderEquals(String gender) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE GENDER = ? ORDER BY GENDER", this,gender);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereDeleteIndEquals(short deleteInd) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this,deleteInd);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereCustomerUuidEquals(String customerUuid) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE CUSTOMER_UUID = ? ORDER BY CUSTOMER_UUID", this,customerUuid);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'LAST_LOGIN_DTM = :lastLoginDtm'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereLastLoginDtmEquals(Date lastLoginDtm) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE LAST_LOGIN_DTM = ? ORDER BY LAST_LOGIN_DTM", this,lastLoginDtm);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'LOCK_IND = :lockInd'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereLockIndEquals(short lockInd) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE LOCK_IND = ? ORDER BY LOCK_IND", this,lockInd);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'ACCOUNT_LEVEL_ID = :accountLevelId'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereAccountLevelIdEquals(int accountLevelId) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE ACCOUNT_LEVEL_ID = ? ORDER BY ACCOUNT_LEVEL_ID", this,accountLevelId);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'SYSTEM_GROUP_MEMBER_ID = :systemGroupMemberId'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereSystemGroupMemberIdEquals(int systemGroupMemberId) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE SYSTEM_GROUP_MEMBER_ID = ? ORDER BY SYSTEM_GROUP_MEMBER_ID", this,systemGroupMemberId);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'SYSTEM_ROLE_ID = :systemRoleId'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereSystemRoleIdEquals(int systemRoleId) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE SYSTEM_ROLE_ID = ? ORDER BY SYSTEM_ROLE_ID", this,systemRoleId);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'ROLE_NAME = :roleName'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereRoleNameEquals(String roleName) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE ROLE_NAME = ? ORDER BY ROLE_NAME", this,roleName);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'ACTIVE_IND = :activeInd'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereActiveIndEquals(short activeInd) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE ACTIVE_IND = ? ORDER BY ACTIVE_IND", this,activeInd);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'CRE_USER_ID = :creUserId'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereCreUserIdEquals(int creUserId) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE CRE_USER_ID = ? ORDER BY CRE_USER_ID", this,creUserId);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'CRE_DTM = :creDtm'.
	 */
	@Transactional
	public List<VwUserSystemRoles> findWhereCreDtmEquals(Date creDtm) throws VwUserSystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, SYSTEM_GROUP_MEMBER_ID, SYSTEM_ROLE_ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE CRE_DTM = ? ORDER BY CRE_DTM", this,creDtm);
		}
		catch (Exception e) {
			throw new VwUserSystemRolesDaoException("Query failed", e);
		}
		
	}

}
