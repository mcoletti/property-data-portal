package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.Market;
import com.codeitek.pdp.model.MarketPk;

import java.util.List;

public interface MarketDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return MarketPk
	 */
	public MarketPk insert(Market dto);

	/** 
	 * Updates a single row in the MARKET table.
	 */
	public void update(MarketPk pk, Market dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the MARKET table.
	 */
	public void delete(MarketPk pk) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the MARKET table that match the criteria 'ID = :id'.
	 */
	public Market findByPrimaryKey(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the MARKET table that match the criteria ''.
	 */
	public List<Market> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the MARKET table that match the criteria 'ID = :id'.
	 */
	public List<Market> findWhereIdEquals(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the MARKET table that match the criteria 'NAME = :name'.
	 */
	public List<Market> findWhereNameEquals(String name) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the MARKET table that match the criteria 'DELETE_IND = :deleteInd'.
	 */
	public List<Market> findWhereDeleteIndEquals(short deleteInd) throws DataBaseJdbcException;

	/** 
	 * Returns the rows from the MARKET table that matches the specified primary-key value.
	 */
	public Market findByPrimaryKey(MarketPk pk) throws DataBaseJdbcException;

}
