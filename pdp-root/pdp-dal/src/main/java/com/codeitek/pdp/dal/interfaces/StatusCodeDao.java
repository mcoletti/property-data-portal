package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.StatusCode;
import com.codeitek.pdp.model.StatusCodePk;

import java.util.List;

public interface StatusCodeDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return StatusCodePk
	 */
	public StatusCodePk insert(StatusCode dto);

	/** 
	 * Updates a single row in the STATUS_CODE table.
	 */
	public void update(StatusCodePk pk, StatusCode dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the STATUS_CODE table.
	 */
	public void delete(StatusCodePk pk) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria 'ID = :id'.
	 */
	public StatusCode findByPrimaryKey(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria ''.
	 */
	public List<StatusCode> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria 'ID = :id'.
	 */
	public List<StatusCode> findWhereIdEquals(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria 'CODE_NAME = :codeName'.
	 */
	public List<StatusCode> findWhereCodeNameEquals(String codeName) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria 'CODE_VALUE = :codeValue'.
	 */
	public List<StatusCode> findWhereCodeValueEquals(String codeValue) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the STATUS_CODE table that match the criteria 'DELETE_IND = :deleteInd'.
	 */
	public List<StatusCode> findWhereDeleteIndEquals(short deleteInd) throws DataBaseJdbcException;

	/** 
	 * Returns the rows from the STATUS_CODE table that matches the specified primary-key value.
	 */
	public StatusCode findByPrimaryKey(StatusCodePk pk) throws DataBaseJdbcException;

}
