package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.VwUserGroupsDaoException;
import com.codeitek.pdp.model.VwUserGroups;

import java.util.Date;
import java.util.List;

public interface VwUserGroupsDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 */
	public void insert(VwUserGroups dto);

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria ''.
	 */
	public List<VwUserGroups> findAll() throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'UUID = :customerUuid'.
	 */
	public List<VwUserGroups> findWhereUuidEquals(String uuid) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'USER_NAME = :userName'.
	 */
	public List<VwUserGroups> findWhereUserNameEquals(String userName) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'FIRST_NAME = :firstName'.
	 */
	public List<VwUserGroups> findWhereFirstNameEquals(String firstName) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'LAST_NAME = :lastName'.
	 */
	public List<VwUserGroups> findWhereLastNameEquals(String lastName) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'PRIMARY_EMAIL = :primaryEmail'.
	 */
	public List<VwUserGroups> findWherePrimaryEmailEquals(String primaryEmail) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'REFERRED_BY = :referredBy'.
	 */
	public List<VwUserGroups> findWhereReferredByEquals(String referredBy) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'GENDER = :gender'.
	 */
	public List<VwUserGroups> findWhereGenderEquals(String gender) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<VwUserGroups> findWhereDeleteIndEquals(short deleteInd) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	public List<VwUserGroups> findWhereCustomerUuidEquals(String customerUuid) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'LAST_LOGIN_DTM = :lastLoginDtm'.
	 */
	public List<VwUserGroups> findWhereLastLoginDtmEquals(Date lastLoginDtm) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'LOCK_IND = :lockInd'.
	 */
	public List<VwUserGroups> findWhereLockIndEquals(short lockInd) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'ACCOUNT_LEVEL_ID = :accountLevelId'.
	 */
	public List<VwUserGroups> findWhereAccountLevelIdEquals(int accountLevelId) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'GROUP_MEMBER_ID = :groupMemberId'.
	 */
	public List<VwUserGroups> findWhereGroupMemberIdEquals(int groupMemberId) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'GROUP_ID = :groupId'.
	 */
	public List<VwUserGroups> findWhereGroupIdEquals(int groupId) throws VwUserGroupsDaoException;

	/** 
	 * Returns all rows from the vw_UserGroups table that match the criteria 'GROUP_NAME = :groupName'.
	 */
	public List<VwUserGroups> findWhereGroupNameEquals(String groupName) throws VwUserGroupsDaoException;

}
