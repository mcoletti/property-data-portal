package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.SystemGroupMembersDaoException;
import com.codeitek.pdp.dal.interfaces.SystemGroupMembersDao;
import com.codeitek.pdp.model.SystemGroupMembers;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SystemGroupMembersJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<SystemGroupMembers>, SystemGroupMembersDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 */
	public void insert(SystemGroupMembers dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( SYSTEM_ROLES_ID, GROUPS_ID, USER_UUID ) VALUES ( ?, ?, ? )",dto.getSystemRolesId(),dto.getGroupsId(),dto.getUserUuid());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return SystemGroupMembers
	 */
	public SystemGroupMembers mapRow(ResultSet rs, int row) throws SQLException
	{
		SystemGroupMembers dto = new SystemGroupMembers();
		dto.setSystemRolesId( rs.getInt( 1 ) );
		dto.setGroupsId( rs.getInt( 2 ) );
		dto.setUserUuid( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SYS_GRP_MEMS";
	}

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria ''.
	 */
	public List<SystemGroupMembers> findAll() throws SystemGroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT SYSTEM_ROLES_ID, GROUPS_ID, USER_UUID FROM " + getTableName() + "", this);
		}
		catch (Exception e) {
			throw new SystemGroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'SYSTEM_ROLES_ID = :systemRolesId'.
	 */
	public List<SystemGroupMembers> findBySystemRoles(int systemRolesId) throws SystemGroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT SYSTEM_ROLES_ID, GROUPS_ID, USER_UUID FROM " + getTableName() + " WHERE SYSTEM_ROLES_ID = ?", this,systemRolesId);
		}
		catch (Exception e) {
			throw new SystemGroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'GROUPS_ID = :groupsId'.
	 */
	public List<SystemGroupMembers> findByGroups(int groupsId) throws SystemGroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT SYSTEM_ROLES_ID, GROUPS_ID, USER_UUID FROM " + getTableName() + " WHERE GROUPS_ID = ?", this,groupsId);
		}
		catch (Exception e) {
			throw new SystemGroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<SystemGroupMembers> findByUser(String userUuid) throws SystemGroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT SYSTEM_ROLES_ID, GROUPS_ID, USER_UUID FROM " + getTableName() + " WHERE USER_UUID = ?", this,userUuid);
		}
		catch (Exception e) {
			throw new SystemGroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'SYSTEM_ROLES_ID = :systemRolesId'.
	 */
	public List<SystemGroupMembers> findWhereSystemRolesIdEquals(int systemRolesId) throws SystemGroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT SYSTEM_ROLES_ID, GROUPS_ID, USER_UUID FROM " + getTableName() + " WHERE SYSTEM_ROLES_ID = ? ORDER BY SYSTEM_ROLES_ID", this,systemRolesId);
		}
		catch (Exception e) {
			throw new SystemGroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'GROUPS_ID = :groupsId'.
	 */
	public List<SystemGroupMembers> findWhereGroupsIdEquals(int groupsId) throws SystemGroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT SYSTEM_ROLES_ID, GROUPS_ID, USER_UUID FROM " + getTableName() + " WHERE GROUPS_ID = ? ORDER BY GROUPS_ID", this,groupsId);
		}
		catch (Exception e) {
			throw new SystemGroupMembersDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYS_GRP_MEMS table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<SystemGroupMembers> findWhereUserUuidEquals(String userUuid) throws SystemGroupMembersDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT SYSTEM_ROLES_ID, GROUPS_ID, USER_UUID FROM " + getTableName() + " WHERE USER_UUID = ? ORDER BY USER_UUID", this,userUuid);
		}
		catch (Exception e) {
			throw new SystemGroupMembersDaoException("Query failed", e);
		}
		
	}

}
