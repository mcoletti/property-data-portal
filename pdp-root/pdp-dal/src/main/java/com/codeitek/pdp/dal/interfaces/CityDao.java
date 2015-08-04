package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.City;
import com.codeitek.pdp.model.CityPk;

import java.util.List;

public interface CityDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return CityPk
	 */
	public CityPk insert(City dto);

	/** 
	 * Updates a single row in the CITY table.
	 */
	public CityPk update(CityPk pk, City dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the CITY table.
	 */
	public void delete(CityPk pk) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CITY table that match the criteria 'ID = :id'.
	 */
	public City findByPrimaryKey(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CITY table that match the criteria ''.
	 */
	public List<City> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CITY table that match the criteria 'STATE_ID = :stateId'.
	 */
	public List<City> findByState(int stateId) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CITY table that match the criteria 'ID = :id'.
	 */
	public List<City> findWhereIdEquals(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CITY table that match the criteria 'CITY = :cityName'.
	 */
	public List<City> findWhereCityEquals(String city) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CITY table that match the criteria 'SUMMARY = :summary'.
	 */
	public List<City> findWhereSummaryEquals(String summary) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CITY table that match the criteria 'IMAGE_URL = :imageUrl'.
	 */
	public List<City> findWhereImageUrlEquals(String imageUrl) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CITY table that match the criteria 'STATE_ID = :stateId'.
	 */
	public List<City> findWhereStateIdEquals(int stateId) throws DataBaseJdbcException;

	/** 
	 * Returns the rows from the CITY table that matches the specified primary-key value.
	 */
	public City findByPrimaryKey(CityPk pk) throws DataBaseJdbcException;

}
