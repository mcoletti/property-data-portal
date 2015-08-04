package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.RoleDataDaoException;
import com.codeitek.pdp.dal.interfaces.RoleDataDao;
import com.codeitek.pdp.model.RoleData;
import com.codeitek.pdp.model.RoleDataPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDataJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<RoleData>, RoleDataDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return RoleDataPk
	 */
	public RoleDataPk insert(RoleData dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( ROLE_NAME, DELETE_IND ) VALUES ( ?, ? )",dto.getRoleName(),dto.getDeleteInd());
		RoleDataPk pk = new RoleDataPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the ROLE_DATA table.
	 */
	public void update(RoleDataPk pk, RoleData dto) throws RoleDataDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, ROLE_NAME = ?, DELETE_IND = ? WHERE ID = ?",dto.getId(),dto.getRoleName(),dto.getDeleteInd(),pk.getId());
	}

	/** 
	 * Deletes a single row in the ROLE_DATA table.
	 */
	public void delete(RoleDataPk pk) throws RoleDataDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return RoleData
	 */
	public RoleData mapRow(ResultSet rs, int row) throws SQLException
	{
		RoleData dto = new RoleData();
		dto.setId( rs.getInt( 1 ) );
		dto.setRoleName( rs.getString( 2 ) );
		dto.setDeleteInd( rs.getBoolean(3) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "ROLE_DATA";
	}

	/** 
	 * Returns all rows from the ROLE_DATA table that match the criteria 'ID = :id'.
	 */
	public RoleData findByPrimaryKey(int id) throws RoleDataDaoException
	{
		try {
			List<RoleData> list = getJdbcTemplate().query("SELECT ID, ROLE_NAME, DELETE_IND FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new RoleDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ROLE_DATA table that match the criteria ''.
	 */
	public List<RoleData> findAll() throws RoleDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ROLE_NAME, DELETE_IND FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new RoleDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ROLE_DATA table that match the criteria 'ID = :id'.
	 */
	public List<RoleData> findWhereIdEquals(int id) throws RoleDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ROLE_NAME, DELETE_IND FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new RoleDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ROLE_DATA table that match the criteria 'ROLE_NAME = :roleName'.
	 */
	public List<RoleData> findWhereRoleNameEquals(String roleName) throws RoleDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ROLE_NAME, DELETE_IND FROM " + getTableName() + " WHERE ROLE_NAME = ? ORDER BY ROLE_NAME", this,roleName);
		}
		catch (Exception e) {
			throw new RoleDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ROLE_DATA table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<RoleData> findWhereDeleteIndEquals(short deleteInd) throws RoleDataDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ROLE_NAME, DELETE_IND FROM " + getTableName() + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this,deleteInd);
		}
		catch (Exception e) {
			throw new RoleDataDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the ROLE_DATA table that matches the specified primary-key value.
	 */
	public RoleData findByPrimaryKey(RoleDataPk pk) throws RoleDataDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
