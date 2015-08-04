package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOQueries;
import com.codeitek.pdp.dal.interfaces.FinancialKeyDao;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.dal.exceptions.FinancialKeyDaoException;
import com.codeitek.pdp.model.FinancialKey;
import com.codeitek.pdp.model.FinancialKeyPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;


public class FinancialKeyJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<FinancialKey>, FinancialKeyDao
{
	
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return FinancialKeyPk
	 */
	@Transactional
	public FinancialKeyPk insert(FinancialKey dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( KEY, DISPLAY_NAME, UI_SECTION_GROUP_KEY, FINACIAL_KEY_ORDER ) VALUES ( ?, ?, ?, ? )",dto.getKey(),dto.getDisplayName(),dto.getUiSectionGroupKey(),dto.getFinacialKeyOrder());
		FinancialKeyPk pk = new FinancialKeyPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the FINACIAL_KEY table.
	 */
	@Transactional
	public void update(FinancialKeyPk pk, FinancialKey dto) throws FinancialKeyDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, KEY = ?, DISPLAY_NAME = ?, UI_SECTION_GROUP_KEY = ?, FINACIAL_KEY_ORDER = ? WHERE ID = ?",dto.getId(),dto.getKey(),dto.getDisplayName(),dto.getUiSectionGroupKey(),dto.getFinacialKeyOrder(),pk.getId());
	}

	/** 
	 * Deletes a single row in the FINACIAL_KEY table.
	 */
	@Transactional
	public void delete(FinancialKeyPk pk) throws FinancialKeyDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return FinancialKey
	 */
	public FinancialKey mapRow(ResultSet rs, int row) throws SQLException
	{
		FinancialKey dto = new FinancialKey();
		dto.setId( rs.getInt( 1 ) );
		dto.setKey( rs.getString( 2 ) );
		dto.setDisplayName( rs.getString( 3 ) );
		dto.setUiSectionGroupKey( rs.getString( 4 ) );
		dto.setFinacialKeyOrder( rs.getInt( 5 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "FINACIAL_KEY";
	}

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public FinancialKey findByPrimaryKey(int id) throws FinancialKeyDaoException
	{
		try {
			List<FinancialKey> list = getJdbcTemplate().query(DAOQueries.Q_FINANCIAL_KEY_BY_ID, this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new FinancialKeyDaoException("Query failed", e);
		}
		
	}




	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria ''.
	 */
	@Transactional
	public List<FinancialKey> findAll() throws FinancialKeyDaoException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_FINANCIAL_KEY, this);
		}
		catch (Exception e) {
			throw new FinancialKeyDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<FinancialKey> findWhereIdEquals(int id) throws FinancialKeyDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY, DISPLAY_NAME, UI_SECTION_GROUP_KEY, FINACIAL_KEY_ORDER FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new FinancialKeyDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'KEY = :key'.
	 */
	@Transactional
	public List<FinancialKey> findWhereKeyEquals(String key) throws FinancialKeyDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY, DISPLAY_NAME, UI_SECTION_GROUP_KEY, FINACIAL_KEY_ORDER FROM " + getTableName() + " WHERE KEY = ? ORDER BY KEY", this,key);
		}
		catch (Exception e) {
			throw new FinancialKeyDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'DISPLAY_NAME = :displayName'.
	 */
	@Transactional
	public List<FinancialKey> findWhereDisplayNameEquals(String displayName) throws FinancialKeyDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY, DISPLAY_NAME, UI_SECTION_GROUP_KEY, FINACIAL_KEY_ORDER FROM " + getTableName() + " WHERE DISPLAY_NAME = ? ORDER BY DISPLAY_NAME", this,displayName);
		}
		catch (Exception e) {
			throw new FinancialKeyDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'UI_SECTION_GROUP_KEY = :uiSectionGroupKey'.
	 */
	@Transactional
	public List<FinancialKey> findWhereUiSectionGroupKeyEquals(String uiSectionGroupKey) throws FinancialKeyDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY, DISPLAY_NAME, UI_SECTION_GROUP_KEY, FINACIAL_KEY_ORDER FROM " + getTableName() + " WHERE UI_SECTION_GROUP_KEY = ? ORDER BY UI_SECTION_GROUP_KEY", this,uiSectionGroupKey);
		}
		catch (Exception e) {
			throw new FinancialKeyDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'FINACIAL_KEY_ORDER = :FinancialKeyOrder'.
	 */
	@Transactional
	public List<FinancialKey> findWhereFinancialKeyOrderEquals(int FinancialKeyOrder) throws FinancialKeyDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, KEY, DISPLAY_NAME, UI_SECTION_GROUP_KEY, FINACIAL_KEY_ORDER FROM " + getTableName() + " WHERE FINACIAL_KEY_ORDER = ? ORDER BY FINACIAL_KEY_ORDER", this,FinancialKeyOrder);
		}
		catch (Exception e) {
			throw new FinancialKeyDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the FINACIAL_KEY table that matches the specified primary-key value.
	 */
	public FinancialKey findByPrimaryKey(FinancialKeyPk pk) throws FinancialKeyDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
