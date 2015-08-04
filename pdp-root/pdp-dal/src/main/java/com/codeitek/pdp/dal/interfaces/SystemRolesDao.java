package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.SystemRolesDaoException;
import com.codeitek.pdp.model.SystemRoles;
import com.codeitek.pdp.model.SystemRolesPk;

import java.util.Date;
import java.util.List;

public interface SystemRolesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SystemRolesPk
	 */
	public SystemRolesPk insert(SystemRoles dto);

	/** 
	 * Updates a single row in the SYSTEM_ROLES table.
	 */
	public void update(SystemRolesPk pk, SystemRoles dto) throws SystemRolesDaoException;

	/** 
	 * Deletes a single row in the SYSTEM_ROLES table.
	 */
	public void delete(SystemRolesPk pk) throws SystemRolesDaoException;

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'ID = :id'.
	 */
	public SystemRoles findByPrimaryKey(int id) throws SystemRolesDaoException;

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria ''.
	 */
	public List<SystemRoles> findAll() throws SystemRolesDaoException;

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'ID = :id'.
	 */
	public List<SystemRoles> findWhereIdEquals(int id) throws SystemRolesDaoException;

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'ROLE_NAME = :roleName'.
	 */
	public List<SystemRoles> findWhereRoleNameEquals(String roleName) throws SystemRolesDaoException;

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'ACTIVE_IND = :activeInd'.
	 */
	public List<SystemRoles> findWhereActiveIndEquals(short activeInd) throws SystemRolesDaoException;

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'CRE_USER_ID = :creUserId'.
	 */
	public List<SystemRoles> findWhereCreUserIdEquals(int creUserId) throws SystemRolesDaoException;

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'CRE_DTM = :creDtm'.
	 */
	public List<SystemRoles> findWhereCreDtmEquals(Date creDtm) throws SystemRolesDaoException;

	/** 
	 * Returns the rows from the SYSTEM_ROLES table that matches the specified primary-key value.
	 */
	public SystemRoles findByPrimaryKey(SystemRolesPk pk) throws SystemRolesDaoException;

}
