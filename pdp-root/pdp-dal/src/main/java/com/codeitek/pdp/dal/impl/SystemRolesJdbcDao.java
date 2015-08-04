package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.SystemRolesDaoException;
import com.codeitek.pdp.dal.interfaces.SystemRolesDao;
import com.codeitek.pdp.model.SystemRoles;
import com.codeitek.pdp.model.SystemRolesPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SystemRolesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<SystemRoles>, SystemRolesDao
{

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SystemRolesPk
	 */
	public SystemRolesPk insert(SystemRoles dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM ) VALUES ( ?, ?, ?, ? )", dto.getRoleName(), dto.getDeleteInd(), dto.getCreUserId(), dto.getCreDtm());
		SystemRolesPk pk = new SystemRolesPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the SYSTEM_ROLES table.
	 */
	public void update(SystemRolesPk pk, SystemRoles dto) throws SystemRolesDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, ROLE_NAME = ?, ACTIVE_IND = ?, CRE_USER_ID = ?, CRE_DTM = ? WHERE ID = ?", dto.getId(), dto.getRoleName(), dto.getDeleteInd(), dto.getCreUserId(), dto.getCreDtm(), pk.getId());
	}

	/** 
	 * Deletes a single row in the SYSTEM_ROLES table.
	 */
	public void delete(SystemRolesPk pk) throws SystemRolesDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return SystemRoles
	 */
	public SystemRoles mapRow(ResultSet rs, int row) throws SQLException
	{
		SystemRoles dto = new SystemRoles();
		dto.setId( rs.getInt( 1 ) );
		dto.setRoleName( rs.getString( 2 ) );
		dto.setDeleteInd(rs.getBoolean(3));
		dto.setCreUserId( rs.getInt( 4 ) );
		dto.setCreDtm( rs.getTimestamp(5 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SYSTEM_ROLES";
	}

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'ID = :id'.
	 */
	public SystemRoles findByPrimaryKey(int id) throws SystemRolesDaoException
	{
		try {
			List<SystemRoles> list = getJdbcTemplate().query("SELECT ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE ID = ?", this, id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria ''.
	 */
	public List<SystemRoles> findAll() throws SystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new SystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'ID = :id'.
	 */
	public List<SystemRoles> findWhereIdEquals(int id) throws SystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
		}
		catch (Exception e) {
			throw new SystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'ROLE_NAME = :roleName'.
	 */
	public List<SystemRoles> findWhereRoleNameEquals(String roleName) throws SystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE ROLE_NAME = ? ORDER BY ROLE_NAME", this, roleName);
		}
		catch (Exception e) {
			throw new SystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'ACTIVE_IND = :activeInd'.
	 */
	public List<SystemRoles> findWhereActiveIndEquals(short activeInd) throws SystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE ACTIVE_IND = ? ORDER BY ACTIVE_IND", this, activeInd);
		}
		catch (Exception e) {
			throw new SystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'CRE_USER_ID = :creUserId'.
	 */
	public List<SystemRoles> findWhereCreUserIdEquals(int creUserId) throws SystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE CRE_USER_ID = ? ORDER BY CRE_USER_ID", this, creUserId);
		}
		catch (Exception e) {
			throw new SystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SYSTEM_ROLES table that match the criteria 'CRE_DTM = :creDtm'.
	 */
	public List<SystemRoles> findWhereCreDtmEquals(Date creDtm) throws SystemRolesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ROLE_NAME, ACTIVE_IND, CRE_USER_ID, CRE_DTM FROM " + getTableName() + " WHERE CRE_DTM = ? ORDER BY CRE_DTM", this, creDtm);
		}
		catch (Exception e) {
			throw new SystemRolesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SYSTEM_ROLES table that matches the specified primary-key value.
	 */
	public SystemRoles findByPrimaryKey(SystemRolesPk pk) throws SystemRolesDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
