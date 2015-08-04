package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.GroupMembersDaoException;
import com.codeitek.pdp.dal.interfaces.GroupMembersDao;
import com.codeitek.pdp.model.GroupMembers;
import com.codeitek.pdp.model.GroupMembersPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GroupMembersJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<GroupMembers>, GroupMembersDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return GroupMembersPk
	 */
	public GroupMembersPk insert(GroupMembers dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( USER_UUID, GROUPS_ID ) VALUES ( ?, ? )",dto.getUserUuid(),dto.getGroupsId());
		GroupMembersPk pk = new GroupMembersPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the GROUP_MEMBERS table.
	 */
	public void update(GroupMembersPk pk, GroupMembers dto) throws GroupMembersDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, USER_UUID = ?, GROUPS_ID = ? WHERE ID = ?",dto.getId(),dto.getUserUuid(),dto.getGroupsId(),pk.getId());
	}

	/** 
	 * Deletes a single row in the GROUP_MEMBERS table.
	 */
	public void delete(GroupMembersPk pk) throws GroupMembersDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return GroupMembers
	 */
	public GroupMembers mapRow(ResultSet rs, int row) throws SQLException
	{
		GroupMembers dto = new GroupMembers();
		dto.setId( rs.getInt( 1 ) );
		dto.setUserUuid( rs.getString( 2 ) );
		dto.setGroupsId( rs.getInt( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "GROUP_MEMBERS";
	}

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'ID = :id'.
	 */
	public GroupMembers findByPrimaryKey(int id) throws GroupMembersDaoException
	{
		try {
			List<GroupMembers> list = getJdbcTemplate().query("SELECT ID, USER_UUID, GROUPS_ID FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new GroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria ''.
	 */
	public List<GroupMembers> findAll() throws GroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, USER_UUID, GROUPS_ID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new GroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<GroupMembers> findByUser(String userUuid) throws GroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, USER_UUID, GROUPS_ID FROM " + getTableName() + " WHERE USER_UUID = ?", this,userUuid);
		}
		catch (Exception e) {
			throw new GroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'GROUPS_ID = :groupsId'.
	 */
	public List<GroupMembers> findByGroups(int groupsId) throws GroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, USER_UUID, GROUPS_ID FROM " + getTableName() + " WHERE GROUPS_ID = ?", this,groupsId);
		}
		catch (Exception e) {
			throw new GroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'ID = :id'.
	 */
	public List<GroupMembers> findWhereIdEquals(int id) throws GroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, USER_UUID, GROUPS_ID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new GroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<GroupMembers> findWhereUserUuidEquals(String userUuid) throws GroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, USER_UUID, GROUPS_ID FROM " + getTableName() + " WHERE USER_UUID = ? ORDER BY USER_UUID", this,userUuid);
		}
		catch (Exception e) {
			throw new GroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the GROUP_MEMBERS table that match the criteria 'GROUPS_ID = :groupsId'.
	 */
	public List<GroupMembers> findWhereGroupsIdEquals(int groupsId) throws GroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, USER_UUID, GROUPS_ID FROM " + getTableName() + " WHERE GROUPS_ID = ? ORDER BY GROUPS_ID", this,groupsId);
		}
		catch (Exception e) {
			throw new GroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the GROUP_MEMBERS table that matches the specified primary-key value.
	 */
	public GroupMembers findByPrimaryKey(GroupMembersPk pk) throws GroupMembersDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
