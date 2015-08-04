package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.AuthorityUserMap;
import com.codeitek.pdp.model.AuthorityUserMapPk;

import java.util.List;

public interface AuthorityUserMapDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return AuthorityUserMapPk
	 */
	public AuthorityUserMapPk insert(AuthorityUserMap dto);

	/** 
	 * Updates a single row in the AUTHORITY_USER_MAP table.
	 */
	public void update(AuthorityUserMapPk pk, AuthorityUserMap dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the AUTHORITY_USER_MAP table.
	 */
	public void delete(AuthorityUserMapPk pk) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria 'ID = :id'.
	 */
	public AuthorityUserMap findByPrimaryKey(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria ''.
	 */
	public List<AuthorityUserMap> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria 'DELETE_IND = :deleteInd'.
	 */
	public List<AuthorityUserMap> findWhereDeleteIndEquals(short deleteInd) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria 'AUTHORITY_UUID = :authorityUuid'.
	 */
	public List<AuthorityUserMap> findWhereAuthorityUuidEquals(String authorityUuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the AUTHORITY_USER_MAP table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<AuthorityUserMap> findWhereUserUuidEquals(String userUuid) throws DataBaseJdbcException;



}
