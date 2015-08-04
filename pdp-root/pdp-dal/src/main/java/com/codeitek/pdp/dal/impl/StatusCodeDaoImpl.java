package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.dal.interfaces.StatusCodeDao;
import com.codeitek.pdp.model.StatusCode;
import com.codeitek.pdp.model.StatusCodePk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class StatusCodeDaoImpl extends SpringJdbcSupport implements ParameterizedRowMapper<StatusCode>, StatusCodeDao
{
	

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return StatusCodePk
	 */
	public StatusCodePk insert(StatusCode dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( CODE_NAME, CODE_VALUE, DELETE_IND ) VALUES ( ?, ?, ? )",dto.getCodeName(),dto.getCodeValue(),dto.getDeleteInd());
		StatusCodePk pk = new StatusCodePk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the STATUS_CODE table.
	 */
	public void update(StatusCodePk pk, StatusCode dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, CODE_NAME = ?, CODE_VALUE = ?, DELETE_IND = ? WHERE ID = ?",dto.getId(),dto.getCodeName(),dto.getCodeValue(),dto.getDeleteInd(),pk.getId());
	}

	/** 
	 * Deletes a single row in the STATUS_CODE table.
	 */
	public void delete(StatusCodePk pk) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return StatusCode
	 */
	public StatusCode mapRow(ResultSet rs, int row) throws SQLException
	{
		StatusCode dto = new StatusCode();
		dto.setId( rs.getInt( 1 ) );
		dto.setCodeName( rs.getString( 2 ) );
		dto.setCodeValue( rs.getString( 3 ) );
		dto.setDeleteInd( rs.getShort( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "STATUS_CODE";
	}

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria 'ID = :id'.
	 */
	public StatusCode findByPrimaryKey(int id) throws DataBaseJdbcException
	{
		try {
			List<StatusCode> list = getJdbcTemplate().query("SELECT ID, CODE_NAME, CODE_VALUE, DELETE_IND FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria ''.
	 */
	public List<StatusCode> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CODE_NAME, CODE_VALUE, DELETE_IND FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria 'ID = :id'.
	 */
	public List<StatusCode> findWhereIdEquals(int id) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CODE_NAME, CODE_VALUE, DELETE_IND FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria 'CODE_NAME = :codeName'.
	 */
	public List<StatusCode> findWhereCodeNameEquals(String codeName) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CODE_NAME, CODE_VALUE, DELETE_IND FROM " + getTableName() + " WHERE CODE_NAME = ? ORDER BY CODE_NAME", this,codeName);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria 'CODE_VALUE = :codeValue'.
	 */
	public List<StatusCode> findWhereCodeValueEquals(String codeValue) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CODE_NAME, CODE_VALUE, DELETE_IND FROM " + getTableName() + " WHERE CODE_VALUE = ? ORDER BY CODE_VALUE", this,codeValue);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria 'DELETE_IND = :deleteInd'.
	 */
	public List<StatusCode> findWhereDeleteIndEquals(short deleteInd) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CODE_NAME, CODE_VALUE, DELETE_IND FROM " + getTableName() + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this,deleteInd);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the STATUS_CODE table that matches the specified primary-key value.
	 */
	public StatusCode findByPrimaryKey(StatusCodePk pk) throws DataBaseJdbcException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
