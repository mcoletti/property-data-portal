package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.Authority;

import java.util.List;

public interface AuthorityDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return AuthoritiesPk
	 */
	public String insert(Authority dto);

	/** 
	 * Updates a single row in the AUTHORITIES table.
	 */
	public void update(String pk, Authority dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the AUTHORITIES table.
	 */
	public void delete(String pk) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the AUTHORITIES table that match the criteria 'ID = :id'.
	 */
	public Authority findByPrimaryKey(String uuid) throws DataBaseJdbcException;

    /**
     *
     * @param authority
     * @return
     * @throws DataBaseJdbcException
     */
    public List<Authority> findWhereAuthorityEquals(String authority) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the AUTHORITIES table that match the criteria ''.
	 */
	public List<Authority> findAll() throws DataBaseJdbcException;


	/** 
	 * Returns all rows from the AUTHORITIES table that match the criteria 'ENABLED = :enabled'.
	 */
	public List<Authority> findWhereEnabledEquals(boolean enabled) throws DataBaseJdbcException;

    /**
	 * Returns all rows from the AUTHORITIES table that match the criteria 'ENABLED = :enabled'.
	 */
	public List<Authority> findWhereDeleteIndEquals(boolean deleteInd) throws DataBaseJdbcException;





}
