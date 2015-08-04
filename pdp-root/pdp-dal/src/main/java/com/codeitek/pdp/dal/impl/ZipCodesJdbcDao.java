package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.ZipCodesDaoException;
import com.codeitek.pdp.dal.interfaces.ZipCodesDao;
import com.codeitek.pdp.model.ZipCodes;
import com.codeitek.pdp.model.ZipCodesPk;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class ZipCodesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<ZipCodes>, ZipCodesDao
{


    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(ZipCodesJdbcDao.class);
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return ZipCodesPk
	 */
	@Transactional
	public ZipCodesPk insert(ZipCodes dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( ZIP_CODE, CITY_ID ) VALUES ( ?, ? )",dto.getZipCode(),dto.getCityId());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the ZIP_CODES table.
	 */
	@Transactional
	public void update(ZipCodesPk pk, ZipCodes dto) throws ZipCodesDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ZIP_CODE = ?, CITY_ID = ? WHERE ZIP_CODE = ?",dto.getZipCode(),dto.getCityId(),pk.getZipCode());
	}

	/** 
	 * Deletes a single row in the ZIP_CODES table.
	 */
	@Transactional
	public void delete(ZipCodesPk pk) throws ZipCodesDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ZIP_CODE = ?",pk.getZipCode());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return ZipCodes
	 */
	public ZipCodes mapRow(ResultSet rs, int row) throws SQLException
	{
		ZipCodes dto = new ZipCodes();
		dto.setZipCode( rs.getInt( 1 ) );
		dto.setCityId( rs.getInt( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "ZIP_CODES";
	}

	/** 
	 * Returns all rows from the ZIP_CODES table that match the criteria 'ZIP_CODE = :zipCode'.
	 */
	@Transactional
	public ZipCodes findByPrimaryKey(int zipCode) throws ZipCodesDaoException
	{
		try {
			List<ZipCodes> list = getJdbcTemplate().query("SELECT ZIP_CODE, CITY_ID FROM " + getTableName() + " WHERE ZIP_CODE = ?", this,zipCode);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new ZipCodesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ZIP_CODES table that match the criteria ''.
	 */
	@Transactional
	public List<ZipCodes> findAll() throws ZipCodesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ZIP_CODE, CITY_ID FROM " + getTableName() + " ORDER BY ZIP_CODE", this);
		}
		catch (Exception e) {
			throw new ZipCodesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ZIP_CODES table that match the criteria 'CITY_ID = :cityId'.
	 */
	@Transactional
	public List<ZipCodes> findByCity(int cityId) throws ZipCodesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ZIP_CODE, CITY_ID FROM " + getTableName() + " WHERE CITY_ID = ?", this,cityId);
		}
		catch (Exception e) {
			throw new ZipCodesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ZIP_CODES table that match the criteria 'ZIP_CODE = :zipCode'.
	 */
	@Transactional
	public List<ZipCodes> findWhereZipCodeEquals(int zipCode) throws ZipCodesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ZIP_CODE, CITY_ID FROM " + getTableName() + " WHERE ZIP_CODE = ? ORDER BY ZIP_CODE", this,zipCode);
		}
		catch (Exception e) {
			throw new ZipCodesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the ZIP_CODES table that match the criteria 'CITY_ID = :cityId'.
	 */
	@Transactional
	public List<ZipCodes> findWhereCityIdEquals(int cityId) throws ZipCodesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ZIP_CODE, CITY_ID FROM " + getTableName() + " WHERE CITY_ID = ? ORDER BY CITY_ID", this,cityId);
		}
		catch (Exception e) {
			throw new ZipCodesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the ZIP_CODES table that matches the specified primary-key value.
	 */
	public ZipCodes findByPrimaryKey(ZipCodesPk pk) throws ZipCodesDaoException
	{
		return findByPrimaryKey( pk.getZipCode() );
	}

}
