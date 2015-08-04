package com.codeitek.pdp.dal.impl;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.dal.interfaces.CityDao;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.City;
import com.codeitek.pdp.model.CityPk;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class CityJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<City>, CityDao
{


    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(CityJdbcDao.class);

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return CityPk
	 */
	public CityPk insert(City dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( CITY, SUMMARY, IMAGE_URL, STATE_ID ) VALUES ( ?, ?, ?, ? )",dto.getCityName(),dto.getSummary(),dto.getImageUrl(),dto.getStateId());
		CityPk pk = new CityPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the CITY table.
	 */
	public CityPk update(CityPk pk, City dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, CITY = ?, SUMMARY = ?, IMAGE_URL = ?, STATE_ID = ? WHERE ID = ?",dto.getId(),dto.getCityName(),dto.getSummary(),dto.getImageUrl(),dto.getStateId(),pk.getId());
	    return pk;
    }

	/** 
	 * Deletes a single row in the CITY table.
	 */
	public void delete(CityPk pk) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return City
	 */
	public City mapRow(ResultSet rs, int row) throws SQLException
	{
		City dto = new City();
		dto.setId( rs.getInt( 1 ) );
		dto.setCityName(rs.getString(2));
		dto.setSummary( rs.getString( 3 ) );
		dto.setImageUrl( rs.getString( 4 ) );
		dto.setStateId( rs.getInt( 5 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "CITY";
	}

	/** 
	 * Returns all rows from the CITY table that match the criteria 'ID = :id'.
	 */
	public City findByPrimaryKey(int id) throws DataBaseJdbcException
	{
		try {
			List<City> list = getJdbcTemplate().query("SELECT ID, CITY, SUMMARY, IMAGE_URL, STATE_ID FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CITY table that match the criteria ''.
	 */
	public List<City> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CITY, SUMMARY, IMAGE_URL, STATE_ID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CITY table that match the criteria 'STATE_ID = :stateId'.
	 */
	public List<City> findByState(int stateId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CITY, SUMMARY, IMAGE_URL, STATE_ID FROM " + getTableName() + " WHERE STATE_ID = ?", this,stateId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CITY table that match the criteria 'ID = :id'.
	 */
	public List<City> findWhereIdEquals(int id) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CITY, SUMMARY, IMAGE_URL, STATE_ID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CITY table that match the criteria 'CITY = :cityName'.
	 */
	public List<City> findWhereCityEquals(String city) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CITY, SUMMARY, IMAGE_URL, STATE_ID FROM " + getTableName() + " WHERE CITY = ? ORDER BY CITY", this,city);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CITY table that match the criteria 'SUMMARY = :summary'.
	 */
	public List<City> findWhereSummaryEquals(String summary) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CITY, SUMMARY, IMAGE_URL, STATE_ID FROM " + getTableName() + " WHERE SUMMARY = ? ORDER BY SUMMARY", this,summary);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CITY table that match the criteria 'IMAGE_URL = :imageUrl'.
	 */
	public List<City> findWhereImageUrlEquals(String imageUrl) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CITY, SUMMARY, IMAGE_URL, STATE_ID FROM " + getTableName() + " WHERE IMAGE_URL = ? ORDER BY IMAGE_URL", this,imageUrl);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CITY table that match the criteria 'STATE_ID = :stateId'.
	 */
	public List<City> findWhereStateIdEquals(int stateId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, CITY, SUMMARY, IMAGE_URL, STATE_ID FROM " + getTableName() + " WHERE STATE_ID = ? ORDER BY STATE_ID", this,stateId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the CITY table that matches the specified primary-key value.
	 */
	public City findByPrimaryKey(CityPk pk) throws DataBaseJdbcException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
