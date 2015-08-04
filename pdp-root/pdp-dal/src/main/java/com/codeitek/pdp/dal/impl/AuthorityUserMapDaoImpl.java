package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.interfaces.AuthorityUserMapDao;
import com.codeitek.pdp.model.AuthorityUserMap;
import com.codeitek.pdp.model.AuthorityUserMapPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorityUserMapDaoImpl extends SpringJdbcSupport implements ParameterizedRowMapper<AuthorityUserMap>, AuthorityUserMapDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return AuthorityUserMapPk
	 */
	@Transactional
	public AuthorityUserMapPk insert(AuthorityUserMap dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( DELETE_IND, AUTHORITY_UUID, USER_UUID ) VALUES ( ?, ?, ? )",dto.getDeleteInd(),dto.getAuthorityUuid(),dto.getUserUuid());
		AuthorityUserMapPk pk = new AuthorityUserMapPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the AUTHORITY_USER_MAP table.
	 */
	@Transactional
	public void update(AuthorityUserMapPk pk, AuthorityUserMap dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, DELETE_IND = ?, AUTHORITY_UUID = ?, USER_UUID = ? WHERE ID = ?",dto.getId(),dto.getDeleteInd(),dto.getAuthorityUuid(),dto.getUserUuid(),pk.getId());
	}

	/** 
	 * Deletes a single row in the AUTHORITY_USER_MAP table.
	 */
	@Transactional
	public void delete(AuthorityUserMapPk pk) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return AuthorityUserMap
	 */
	public AuthorityUserMap mapRow(ResultSet rs, int row) throws SQLException
	{
		AuthorityUserMap dto = new AuthorityUserMap();
		dto.setId( rs.getInt( 1 ) );
		dto.setDeleteInd( rs.getBoolean( 2 ) );
		dto.setAuthorityUuid( rs.getString( 3 ) );
		dto.setUserUuid( rs.getString( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "AUTHORITY_USER_MAP";
	}

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public AuthorityUserMap findByPrimaryKey(int id) throws DataBaseJdbcException
	{
		try {
			List<AuthorityUserMap> list = getJdbcTemplate().query("SELECT ID, DELETE_IND, AUTHORITY_UUID, USER_UUID FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria ''.
	 */
	@Transactional
	public List<AuthorityUserMap> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, DELETE_IND, AUTHORITY_UUID, USER_UUID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<AuthorityUserMap> findWhereIdEquals(int id) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, DELETE_IND, AUTHORITY_UUID, USER_UUID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria 'DELETE_IND = :deleteInd'.
	 */
	@Transactional
	public List<AuthorityUserMap> findWhereDeleteIndEquals(short deleteInd) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, DELETE_IND, AUTHORITY_UUID, USER_UUID FROM " + getTableName() + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this,deleteInd);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria 'AUTHORITY_UUID = :authorityUuid'.
	 */
	@Transactional
	public List<AuthorityUserMap> findWhereAuthorityUuidEquals(String authorityUuid) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, DELETE_IND, AUTHORITY_UUID, USER_UUID FROM " + getTableName() + " WHERE AUTHORITY_UUID = ? ORDER BY AUTHORITY_UUID", this,authorityUuid);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria 'USER_UUID = :userUuid'.
	 */
	@Transactional
	public List<AuthorityUserMap> findWhereUserUuidEquals(String userUuid) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, DELETE_IND, AUTHORITY_UUID, USER_UUID FROM " + getTableName() + " WHERE USER_UUID = ? ORDER BY USER_UUID", this,userUuid);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the AUTHORITY_USER_MAP table that matches the specified primary-key value.
	 */
	public AuthorityUserMap findByPrimaryKey(AuthorityUserMapPk pk) throws DataBaseJdbcException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
