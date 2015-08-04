package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.PropertyAttributeDataDaoException;
import com.codeitek.pdp.model.PropertyAttributeData;
import com.codeitek.pdp.model.PropertyAttributeDataPk;

import java.util.List;

public interface PropertyAttributeDataDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return PropertyAttributeDataPk
	 */
	public PropertyAttributeDataPk insert(PropertyAttributeData dto);

	/** 
	 * Updates a single row in the PROPERTY_ATTRIBUTE_DATA table.
	 */
	public void update(PropertyAttributeDataPk pk, PropertyAttributeData dto) throws PropertyAttributeDataDaoException;

	/** 
	 * Deletes a single row in the PROPERTY_ATTRIBUTE_DATA table.
	 */
	public void delete(PropertyAttributeDataPk pk) throws PropertyAttributeDataDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'ID = :id'.
	 */
	public PropertyAttributeData findByPrimaryKey(int id) throws PropertyAttributeDataDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria ''.
	 */
	public List<PropertyAttributeData> findAll() throws PropertyAttributeDataDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'PROPERTY_ATTRIBUTES_ID = :propertyAttributesId'.
	 */
	public List<PropertyAttributeData> findByPropertyAttributes(int propertyAttributesId) throws PropertyAttributeDataDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'ID = :id'.
	 */
	public List<PropertyAttributeData> findWhereIdEquals(int id) throws PropertyAttributeDataDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'VALUE_PREFIX = :valuePrefix'.
	 */
	public List<PropertyAttributeData> findWhereValuePrefixEquals(String valuePrefix) throws PropertyAttributeDataDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'SORT_ORDER = :sortOrder'.
	 */
	public List<PropertyAttributeData> findWhereSortOrderEquals(int sortOrder) throws PropertyAttributeDataDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'RAW_DATA_ID = :rawDataId'.
	 */
	public List<PropertyAttributeData> findWhereRawDataIdEquals(int rawDataId) throws PropertyAttributeDataDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'PROPERTY_ATTRIBUTES_ID = :propertyAttributesId'.
	 */
	public List<PropertyAttributeData> findWherePropertyAttributesIdEquals(int propertyAttributesId) throws PropertyAttributeDataDaoException;

	/** 
	 * Returns all rows from the PROPERTY_ATTRIBUTE_DATA table that match the criteria 'PROPERTY_DATA_UUID = :propertyDataUuid'.
	 */
	public List<PropertyAttributeData> findWherePropertyDataUuidEquals(String propertyDataUuid) throws PropertyAttributeDataDaoException;

	/** 
	 * Returns the rows from the PROPERTY_ATTRIBUTE_DATA table that matches the specified primary-key value.
	 */
	public PropertyAttributeData findByPrimaryKey(PropertyAttributeDataPk pk) throws PropertyAttributeDataDaoException;

}
