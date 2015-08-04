package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.GroupMembersDaoException;
import com.codeitek.pdp.model.GroupMembers;
import com.codeitek.pdp.model.GroupMembersPk;

import java.util.List;

public interface GroupMembersDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return GroupMembersPk
	 */
	public GroupMembersPk insert(GroupMembers dto);

	/** 
	 * Updates a single row in the GROUP_MEMBERS table.
	 */
	public void update(GroupMembersPk pk, GroupMembers dto) throws GroupMembersDaoException;

	/** 
	 * Deletes a single row in the GROUP_MEMBERS table.
	 */
	public void delete(GroupMembersPk pk) throws GroupMembersDaoException;

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'ID = :id'.
	 */
	public GroupMembers findByPrimaryKey(int id) throws GroupMembersDaoException;

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria ''.
	 */
	public List<GroupMembers> findAll() throws GroupMembersDaoException;

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<GroupMembers> findByUser(String userUuid) throws GroupMembersDaoException;

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'GROUPS_ID = :groupsId'.
	 */
	public List<GroupMembers> findByGroups(int groupsId) throws GroupMembersDaoException;

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'ID = :id'.
	 */
	public List<GroupMembers> findWhereIdEquals(int id) throws GroupMembersDaoException;

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<GroupMembers> findWhereUserUuidEquals(String userUuid) throws GroupMembersDaoException;

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'GROUPS_ID = :groupsId'.
	 */
	public List<GroupMembers> findWhereGroupsIdEquals(int groupsId) throws GroupMembersDaoException;

	/** 
	 * Returns the rows from the GROUP_MEMBERS table that matches the specified primary-key value.
	 */
	public GroupMembers findByPrimaryKey(GroupMembersPk pk) throws GroupMembersDaoException;

}
