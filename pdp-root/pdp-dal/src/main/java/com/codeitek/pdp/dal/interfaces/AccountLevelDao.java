package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.AccountLevel;
import com.codeitek.pdp.model.AccountLevelPk;

import java.util.List;

public interface AccountLevelDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return AccountLevelPk
	 */
	public AccountLevelPk insert(AccountLevel dto);

	/** 
	 * Updates a single row in the ACCOUNT_LEVEL table.
	 */
	public void update(AccountLevelPk pk, AccountLevel dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the ACCOUNT_LEVEL table.
	 */
	public void delete(AccountLevelPk pk) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria 'ID = :id'.
	 */
	public AccountLevel findByPrimaryKey(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria ''.
	 */
	public List<AccountLevel> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria 'ID = :id'.
	 */
	public List<AccountLevel> findWhereIdEquals(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria 'LEVEL = :level'.
	 */
	public List<AccountLevel> findWhereLevelEquals(String level) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria 'DETAIL = :detail'.
	 */
	public List<AccountLevel> findWhereDetailEquals(String detail) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the ACCOUNT_LEVEL table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<AccountLevel> findWhereDeleteIndEquals(short deleteInd) throws DataBaseJdbcException;

	/** 
	 * Returns the rows from the ACCOUNT_LEVEL table that matches the specified primary-key value.
	 */
	public AccountLevel findByPrimaryKey(AccountLevelPk pk) throws DataBaseJdbcException;

}
