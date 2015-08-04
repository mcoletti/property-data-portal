package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.PropertyAttributesDaoException;
import com.codeitek.pdp.model.PropertyAttributes;
import com.codeitek.pdp.model.PropertyAttributesPk;

import java.util.List;

public interface PropertyAttributesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return PropertyAttributesPk
	 */
	public PropertyAttributesPk insert(PropertyAttributes dto);

	/** 
	 * Updates a single row in the PROPERTY_ATTRIBUTES table.
	 */
	public void update(PropertyAttributesPk pk, PropertyAttributes dto) throws PropertyAttributesDaoException;

	/** 
	 * Deletes a single row in the PROPERTY_ATTRIBUTES table.
	 */
	public void delete(PropertyAttributesPk pk) throws PropertyAttributesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public PropertyAttributes findByPrimaryKey(int id) throws PropertyAttributesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTES table that match the criteria ''.
	 */
	public List<PropertyAttributes> findAll() throws PropertyAttributesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public List<PropertyAttributes> findWhereIdEquals(int id) throws PropertyAttributesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTES table that match the criteria 'KEY = :key'.
	 */
	public List<PropertyAttributes> findWhereKeyEquals(String key) throws PropertyAttributesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTES table that match the criteria 'DATA_TYPE_ID = :dataTypeId'.
	 */
	public List<PropertyAttributes> findWhereDataTypeIdEquals(int dataTypeId) throws PropertyAttributesDaoException;

	/** 
	 * Returns the rows from the PROPERTY_ATTRIBUTES table that matches the specified primary-key value.
	 */
	public PropertyAttributes findByPrimaryKey(PropertyAttributesPk pk) throws PropertyAttributesDaoException;

}
