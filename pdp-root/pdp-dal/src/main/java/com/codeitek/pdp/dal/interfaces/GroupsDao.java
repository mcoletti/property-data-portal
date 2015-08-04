package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.GroupsDaoException;
import com.codeitek.pdp.model.Groups;
import com.codeitek.pdp.model.GroupsPk;

import java.util.List;

public interface GroupsDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return GroupsPk
	 */
	public GroupsPk insert(Groups dto);

	/** 
	 * Updates a single row in the GROUPS table.
	 */
	public void update(GroupsPk pk, Groups dto) throws GroupsDaoException;

	/** 
	 * Deletes a single row in the GROUPS table.
	 */
	public void delete(GroupsPk pk) throws GroupsDaoException;

	/** 
	 * Returns all rows from the GROUPS table that match the criteria 'ID = :id'.
	 */
	public Groups findByPrimaryKey(int id) throws GroupsDaoException;

	/** 
	 * Returns all rows from the GROUPS table that match the criteria ''.
	 */
	public List<Groups> findAll() throws GroupsDaoException;

	/** 
	 * Returns all rows from the GROUPS table that match the criteria 'ID = :id'.
	 */
	public List<Groups> findWhereIdEquals(int id) throws GroupsDaoException;

	/** 
	 * Returns all rows from the GROUPS table that match the criteria 'GROUP_NAME = :groupName'.
	 */
	public List<Groups> findWhereGroupNameEquals(String groupName) throws GroupsDaoException;

	/** 
	 * Returns the rows from the GROUPS table that matches the specified primary-key value.
	 */
	public Groups findByPrimaryKey(GroupsPk pk) throws GroupsDaoException;

}
