package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.RawDataDaoException;
import com.codeitek.pdp.model.RawData;
import com.codeitek.pdp.model.RawDataPk;

import java.util.List;

public interface RawDataDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return RawDataPk
	 */
	public RawDataPk insert(RawData dto);

	/** 
	 * Updates a single row in the RAW_DATA table.
	 */
	public void update(RawDataPk pk, RawData dto) throws RawDataDaoException;

	/** 
	 * Deletes a single row in the RAW_DATA table.
	 */
	public void delete(RawDataPk pk) throws RawDataDaoException;

	/** 
	 * Returns all rows from the RAW_DATA table that match the criteria 'ID = :id'.
	 */
	public RawData findByPrimaryKey(int id) throws RawDataDaoException;

	/** 
	 * Returns all rows from the RAW_DATA table that match the criteria ''.
	 */
	public List<RawData> findAll() throws RawDataDaoException;

	/** 
	 * Returns all rows from the RAW_DATA table that match the criteria 'ID = :id'.
	 */
	public List<RawData> findWhereIdEquals(int id) throws RawDataDaoException;

	/** 
	 * Returns all rows from the RAW_DATA table that match the criteria 'DATA_VALUE = :dataValue'.
	 */
	public List<RawData> findWhereDataValueEquals(String dataValue) throws RawDataDaoException;

	/** 
	 * Returns the rows from the RAW_DATA table that matches the specified primary-key value.
	 */
	public RawData findByPrimaryKey(RawDataPk pk) throws RawDataDaoException;

}
