package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.PropertyTypeDaoException;
import com.codeitek.pdp.model.PropertyType;
import com.codeitek.pdp.model.PropertyTypePk;

import java.util.List;

public interface PropertyTypeDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return PropertyTypePk
	 */
	public PropertyTypePk insert(PropertyType dto);

	/** 
	 * Updates a single row in the PROPERTY_TYPE table.
	 */
	public void update(PropertyTypePk pk, PropertyType dto) throws PropertyTypeDaoException;

	/** 
	 * Deletes a single row in the PROPERTY_TYPE table.
	 */
	public void delete(PropertyTypePk pk) throws PropertyTypeDaoException;

	/** 
	 * Returns all rows from the PROPERTY_TYPE table that match the criteria 'ID = :id'.
	 */
	public PropertyType findByPrimaryKey(int id) throws PropertyTypeDaoException;

	/** 
	 * Returns all rows from the PROPERTY_TYPE table that match the criteria ''.
	 */
	public List<PropertyType> findAll() throws PropertyTypeDaoException;

	/** 
	 * Returns all rows from the PROPERTY_TYPE table that match the criteria 'ID = :id'.
	 */
	public List<PropertyType> findWhereIdEquals(int id) throws PropertyTypeDaoException;

	/** 
	 * Returns all rows from the PROPERTY_TYPE table that match the criteria 'TYPE = :type'.
	 */
	public List<PropertyType> findWhereTypeEquals(String type) throws PropertyTypeDaoException;

	/** 
	 * Returns all rows from the PROPERTY_TYPE table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<PropertyType> findWhereDeleteIndEquals(short deleteInd) throws PropertyTypeDaoException;

	/** 
	 * Returns the rows from the PROPERTY_TYPE table that matches the specified primary-key value.
	 */
	public PropertyType findByPrimaryKey(PropertyTypePk pk) throws PropertyTypeDaoException;

}
