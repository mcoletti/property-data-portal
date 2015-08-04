package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.GroupsDaoException;
import com.codeitek.pdp.dal.interfaces.GroupsDao;
import com.codeitek.pdp.model.Groups;
import com.codeitek.pdp.model.GroupsPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class GroupsJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<Groups>, GroupsDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return GroupsPk
	 */
	public GroupsPk insert(Groups dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( GROUP_NAME ) VALUES ( ? )",dto.getGroupName());
		GroupsPk pk = new GroupsPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the GROUPS table.
	 */
	public void update(GroupsPk pk, Groups dto) throws GroupsDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, GROUP_NAME = ? WHERE ID = ?",dto.getId(),dto.getGroupName(),pk.getId());
	}

	/** 
	 * Deletes a single row in the GROUPS table.
	 */
	public void delete(GroupsPk pk) throws GroupsDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return Groups
	 */
	public Groups mapRow(ResultSet rs, int row) throws SQLException
	{
		Groups dto = new Groups();
		dto.setId( rs.getInt( 1 ) );
		dto.setGroupName( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "GROUPS";
	}

	/** 
	 * Returns all rows from the GROUPS table that match the criteria 'ID = :id'.
	 */
	public Groups findByPrimaryKey(int id) throws GroupsDaoException
	{
		try {
			List<Groups> list = getJdbcTemplate().query("SELECT ID, GROUP_NAME FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new GroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the GROUPS table that match the criteria ''.
	 */
	public List<Groups> findAll() throws GroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, GROUP_NAME FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new GroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the GROUPS table that match the criteria 'ID = :id'.
	 */
	public List<Groups> findWhereIdEquals(int id) throws GroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, GROUP_NAME FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new GroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the GROUPS table that match the criteria 'GROUP_NAME = :groupName'.
	 */
	public List<Groups> findWhereGroupNameEquals(String groupName) throws GroupsDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, GROUP_NAME FROM " + getTableName() + " WHERE GROUP_NAME = ? ORDER BY GROUP_NAME", this,groupName);
		}
		catch (Exception e) {
			throw new GroupsDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the GROUPS table that matches the specified primary-key value.
	 */
	public Groups findByPrimaryKey(GroupsPk pk) throws GroupsDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
