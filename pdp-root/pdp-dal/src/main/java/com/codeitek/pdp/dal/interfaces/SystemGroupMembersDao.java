package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.SystemGroupMembersDaoException;
import com.codeitek.pdp.model.SystemGroupMembers;

import java.util.List;

public interface SystemGroupMembersDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 */
	public void insert(SystemGroupMembers dto);

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria ''.
	 */
	public List<SystemGroupMembers> findAll() throws SystemGroupMembersDaoException;

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'SYSTEM_ROLES_ID = :systemRolesId'.
	 */
	public List<SystemGroupMembers> findBySystemRoles(int systemRolesId) throws SystemGroupMembersDaoException;

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'GROUPS_ID = :groupsId'.
	 */
	public List<SystemGroupMembers> findByGroups(int groupsId) throws SystemGroupMembersDaoException;

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<SystemGroupMembers> findByUser(String userUuid) throws SystemGroupMembersDaoException;

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'SYSTEM_ROLES_ID = :systemRolesId'.
	 */
	public List<SystemGroupMembers> findWhereSystemRolesIdEquals(int systemRolesId) throws SystemGroupMembersDaoException;

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'GROUPS_ID = :groupsId'.
	 */
	public List<SystemGroupMembers> findWhereGroupsIdEquals(int groupsId) throws SystemGroupMembersDaoException;

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<SystemGroupMembers> findWhereUserUuidEquals(String userUuid) throws SystemGroupMembersDaoException;

}
