package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.VwUserSystemRolesDaoException;
import com.codeitek.pdp.model.VwUserSystemRoles;

import java.util.Date;
import java.util.List;

public interface VwUserSystemRolesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 */
	public void insert(VwUserSystemRoles dto);

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria ''.
	 */
	public List<VwUserSystemRoles> findAll() throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'UUID = :customerUuid'.
	 */
	public List<VwUserSystemRoles> findWhereUuidEquals(String uuid) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'USER_NAME = :userName'.
	 */
	public List<VwUserSystemRoles> findWhereUserNameEquals(String userName) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'FIRST_NAME = :firstName'.
	 */
	public List<VwUserSystemRoles> findWhereFirstNameEquals(String firstName) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'LAST_NAME = :lastName'.
	 */
	public List<VwUserSystemRoles> findWhereLastNameEquals(String lastName) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'PRIMARY_EMAIL = :primaryEmail'.
	 */
	public List<VwUserSystemRoles> findWherePrimaryEmailEquals(String primaryEmail) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'REFERRED_BY = :referredBy'.
	 */
	public List<VwUserSystemRoles> findWhereReferredByEquals(String referredBy) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'GENDER = :gender'.
	 */
	public List<VwUserSystemRoles> findWhereGenderEquals(String gender) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<VwUserSystemRoles> findWhereDeleteIndEquals(short deleteInd) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	public List<VwUserSystemRoles> findWhereCustomerUuidEquals(String customerUuid) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'LAST_LOGIN_DTM = :lastLoginDtm'.
	 */
	public List<VwUserSystemRoles> findWhereLastLoginDtmEquals(Date lastLoginDtm) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'LOCK_IND = :lockInd'.
	 */
	public List<VwUserSystemRoles> findWhereLockIndEquals(short lockInd) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'ACCOUNT_LEVEL_ID = :accountLevelId'.
	 */
	public List<VwUserSystemRoles> findWhereAccountLevelIdEquals(int accountLevelId) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'SYSTEM_GROUP_MEMBER_ID = :systemGroupMemberId'.
	 */
	public List<VwUserSystemRoles> findWhereSystemGroupMemberIdEquals(int systemGroupMemberId) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'SYSTEM_ROLE_ID = :systemRoleId'.
	 */
	public List<VwUserSystemRoles> findWhereSystemRoleIdEquals(int systemRoleId) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'ROLE_NAME = :roleName'.
	 */
	public List<VwUserSystemRoles> findWhereRoleNameEquals(String roleName) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'ACTIVE_IND = :activeInd'.
	 */
	public List<VwUserSystemRoles> findWhereActiveIndEquals(short activeInd) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'CRE_USER_ID = :creUserId'.
	 */
	public List<VwUserSystemRoles> findWhereCreUserIdEquals(int creUserId) throws VwUserSystemRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserSystemRoles table that match the criteria 'CRE_DTM = :creDtm'.
	 */
	public List<VwUserSystemRoles> findWhereCreDtmEquals(Date creDtm) throws VwUserSystemRolesDaoException;

}
