package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.VwUserGroupsDaoException;
import com.codeitek.pdp.dal.interfaces.VwUserGroupsDao;
import com.codeitek.pdp.model.VwUserGroups;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class VwUserGroupsJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<VwUserGroups>, VwUserGroupsDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 */
	@Transactional
	public void insert(VwUserGroups dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getUuid(),dto.getUserName(),dto.getFirstName(),dto.getLastName(),dto.getPrimaryEmail(),dto.getReferredBy(),dto.getGender(),dto.getDeleteInd(),dto.getCustomerUuid(),dto.getLastLoginDtm(),dto.getLockInd(),dto.getAccountLevelId(),dto.getGroupMemberId(),dto.getGroupId(),dto.getGroupName());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return VwUserGroups
	 */
	public VwUserGroups mapRow(ResultSet rs, int row) throws SQLException
	{
		VwUserGroups dto = new VwUserGroups();
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
		dto.setGroupMemberId( rs.getInt( 13 ) );
		dto.setGroupId( rs.getInt( 14 ) );
		dto.setGroupName( rs.getString( 15 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "vw_UserGroups";
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria ''.
	 */
	@Transactional
	public List<VwUserGroups> findAll() throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + "", this);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'UUID = :customerUuid'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereUuidEquals(String uuid) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE UUID = ? ORDER BY UUID", this,uuid);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'USER_NAME = :userName'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereUserNameEquals(String userName) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE USER_NAME = ? ORDER BY USER_NAME", this,userName);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'FIRST_NAME = :firstName'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereFirstNameEquals(String firstName) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE FIRST_NAME = ? ORDER BY FIRST_NAME", this,firstName);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'LAST_NAME = :lastName'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereLastNameEquals(String lastName) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE LAST_NAME = ? ORDER BY LAST_NAME", this,lastName);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'PRIMARY_EMAIL = :primaryEmail'.
	 */
	@Transactional
	public List<VwUserGroups> findWherePrimaryEmailEquals(String primaryEmail) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE PRIMARY_EMAIL = ? ORDER BY PRIMARY_EMAIL", this,primaryEmail);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'REFERRED_BY = :referredBy'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereReferredByEquals(String referredBy) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE REFERRED_BY = ? ORDER BY REFERRED_BY", this,referredBy);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'GENDER = :gender'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereGenderEquals(String gender) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE GENDER = ? ORDER BY GENDER", this,gender);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereDeleteIndEquals(short deleteInd) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this,deleteInd);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereCustomerUuidEquals(String customerUuid) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE CUSTOMER_UUID = ? ORDER BY CUSTOMER_UUID", this,customerUuid);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'LAST_LOGIN_DTM = :lastLoginDtm'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereLastLoginDtmEquals(Date lastLoginDtm) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE LAST_LOGIN_DTM = ? ORDER BY LAST_LOGIN_DTM", this,lastLoginDtm);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'LOCK_IND = :lockInd'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereLockIndEquals(short lockInd) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE LOCK_IND = ? ORDER BY LOCK_IND", this,lockInd);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'ACCOUNT_LEVEL_ID = :accountLevelId'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereAccountLevelIdEquals(int accountLevelId) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE ACCOUNT_LEVEL_ID = ? ORDER BY ACCOUNT_LEVEL_ID", this,accountLevelId);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'GROUP_MEMBER_ID = :groupMemberId'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereGroupMemberIdEquals(int groupMemberId) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE GROUP_MEMBER_ID = ? ORDER BY GROUP_MEMBER_ID", this,groupMemberId);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'GROUP_ID = :groupId'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereGroupIdEquals(int groupId) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE GROUP_ID = ? ORDER BY GROUP_ID", this,groupId);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'GROUP_NAME = :groupName'.
	 */
	@Transactional
	public List<VwUserGroups> findWhereGroupNameEquals(String groupName) throws VwUserGroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, ACCOUNT_LEVEL_ID, GROUP_MEMBER_ID, GROUP_ID, GROUP_NAME FROM " + getTableName() + " WHERE GROUP_NAME = ? ORDER BY GROUP_NAME", this,groupName);
		}
		catch (Exception e) {
			throw new VwUserGroupsDaoException("Query failed", e);
		}
		
	}

}
