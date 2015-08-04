package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.RoleDataDaoException;
import com.codeitek.pdp.model.RoleData;
import com.codeitek.pdp.model.RoleDataPk;

import java.util.List;

public interface RoleDataDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return RoleDataPk
	 */
	public RoleDataPk insert(RoleData dto);

	/** 
	 * Updates a single row in the ROLE_DATA table.
	 */
	public void update(RoleDataPk pk, RoleData dto) throws RoleDataDaoException;

	/** 
	 * Deletes a single row in the ROLE_DATA table.
	 */
	public void delete(RoleDataPk pk) throws RoleDataDaoException;

	/** 
	 * Returns all rows from the ROLE_DATA table that match the criteria 'ID = :id'.
	 */
	public RoleData findByPrimaryKey(int id) throws RoleDataDaoException;

	/** 
	 * Returns all rows from the ROLE_DATA table that match the criteria ''.
	 */
	public List<RoleData> findAll() throws RoleDataDaoException;

	/** 
	 * Returns all rows from the ROLE_DATA table that match the criteria 'ID = :id'.
	 */
	public List<RoleData> findWhereIdEquals(int id) throws RoleDataDaoException;

	/** 
	 * Returns all rows from the ROLE_DATA table that match the criteria 'ROLE_NAME = :roleName'.
	 */
	public List<RoleData> findWhereRoleNameEquals(String roleName) throws RoleDataDaoException;

	/** 
	 * Returns all rows from the ROLE_DATA table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<RoleData> findWhereDeleteIndEquals(short deleteInd) throws RoleDataDaoException;

	/** 
	 * Returns the rows from the ROLE_DATA table that matches the specified primary-key value.
	 */
	public RoleData findByPrimaryKey(RoleDataPk pk) throws RoleDataDaoException;

}
