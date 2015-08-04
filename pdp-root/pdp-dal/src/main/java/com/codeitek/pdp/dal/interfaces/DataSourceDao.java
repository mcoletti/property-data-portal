
package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.DataSource;
import com.codeitek.pdp.model.DataSourcePk;

import java.util.List;

public interface DataSourceDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return DataSourcePk
	 */
	public DataSourcePk insert(DataSource dto);

	/** 
	 * Updates a single row in the DATA_SOURCE table.
	 */
	public void update(DataSourcePk pk, DataSource dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the DATA_SOURCE table.
	 */
	public void delete(DataSourcePk pk) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria 'ID = :id'.
	 */
	public DataSource findByPrimaryKey(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria ''.
	 */
	public List<DataSource> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	public List<DataSource> findByCustomer(String customerUuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria 'ID = :id'.
	 */
	public List<DataSource> findWhereIdEquals(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria 'NAME = :customerName'.
	 */
	public List<DataSource> findWhereNameEquals(String name) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the DATA_SOURCE table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	public List<DataSource> findWhereCustomerUuidEquals(String customerUuid) throws DataBaseJdbcException;

	/** 
	 * Returns the rows from the DATA_SOURCE table that matches the specified primary-key value.
	 */
	public DataSource findByPrimaryKey(DataSourcePk pk) throws DataBaseJdbcException;

}
