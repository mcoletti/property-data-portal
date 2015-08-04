package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.Attributes;
import com.codeitek.pdp.model.AttributesPk;

import java.util.List;

public interface AttributesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return AttributesPk
	 */
	public AttributesPk insert(Attributes dto);

	/** 
	 * Updates a single row in the ATTRIBUTES table.
	 */
	public AttributesPk update(AttributesPk pk, Attributes dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the ATTRIBUTES table.
	 */
	public void delete(AttributesPk pk) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public Attributes findByPrimaryKey(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the ATTRIBUTES table that match the criteria ''.
	 */
	public List<Attributes> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public List<Attributes> findWhereIdEquals(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the ATTRIBUTES table that match the criteria 'KEY = :key'.
	 */
	public List<Attributes> findWhereKeyEquals(String key) throws DataBaseJdbcException;

	/** 
	 * Returns the rows from the ATTRIBUTES table that matches the specified primary-key value.
	 */
	public Attributes findByPrimaryKey(AttributesPk pk) throws DataBaseJdbcException;

}
