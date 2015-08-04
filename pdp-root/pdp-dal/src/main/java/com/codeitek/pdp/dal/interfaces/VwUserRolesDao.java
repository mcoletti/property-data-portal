package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.VwUserRolesDaoException;
import com.codeitek.pdp.model.VwUserRoles;

import java.util.Date;
import java.util.List;

public interface VwUserRolesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 */
	public void insert(VwUserRoles dto);

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria ''.
	 */
	public List<VwUserRoles> findAll() throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'UUID = :customerUuid'.
	 */
	public List<VwUserRoles> findWhereUuidEquals(String uuid) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'USER_NAME = :userName'.
	 */
	public List<VwUserRoles> findWhereUserNameEquals(String userName) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'FIRST_NAME = :firstName'.
	 */
	public List<VwUserRoles> findWhereFirstNameEquals(String firstName) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'LAST_NAME = :lastName'.
	 */
	public List<VwUserRoles> findWhereLastNameEquals(String lastName) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'PRIMARY_EMAIL = :primaryEmail'.
	 */
	public List<VwUserRoles> findWherePrimaryEmailEquals(String primaryEmail) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'REFERRED_BY = :referredBy'.
	 */
	public List<VwUserRoles> findWhereReferredByEquals(String referredBy) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'GENDER = :gender'.
	 */
	public List<VwUserRoles> findWhereGenderEquals(String gender) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<VwUserRoles> findWhereDeleteIndEquals(short deleteInd) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	public List<VwUserRoles> findWhereCustomerUuidEquals(String customerUuid) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'LAST_LOGIN_DTM = :lastLoginDtm'.
	 */
	public List<VwUserRoles> findWhereLastLoginDtmEquals(Date lastLoginDtm) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'LOCK_IND = :lockInd'.
	 */
	public List<VwUserRoles> findWhereLockIndEquals(short lockInd) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'ACCOUNT_LEVEL_ID = :accountLevelId'.
	 */
	public List<VwUserRoles> findWhereAccountLevelIdEquals(int accountLevelId) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'USER_ROLE_ID = :userRoleId'.
	 */
	public List<VwUserRoles> findWhereUserRoleIdEquals(int userRoleId) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'ROLE_DATA_ID = :roleDataId'.
	 */
	public List<VwUserRoles> findWhereRoleDataIdEquals(int roleDataId) throws VwUserRolesDaoException;

	/** 
	 * Returns all rows from the vw_UserRoles table that match the criteria 'ROLE_NAME = :roleName'.
	 */
	public List<VwUserRoles> findWhereRoleNameEquals(String roleName) throws VwUserRolesDaoException;

}
