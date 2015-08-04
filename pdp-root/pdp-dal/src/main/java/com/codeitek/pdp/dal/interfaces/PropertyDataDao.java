package com.codeitek.pdp.dal.interfaces;


import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.PropertyData;
import com.codeitek.pdp.model.PropertyDataPk;

import java.util.List;

public interface PropertyDataDao
{
	/**
	 * Method 'insert'
	 * 
	 *
     * @param dto
     * @return PropertyDataPk
	 */
	public String insert(PropertyData dto);

	/** 
	 * Updates a single row in the PROPERTY_DATA table.
	 */
	public String update(String uuid, PropertyData dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the PROPERTY_DATA table.
	 */
	public void delete(String uuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'UUID = :customerUuid'.
	 */
	public PropertyData findByPrimaryKey(String uuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria ''.
	 */
	public List<PropertyData> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'DATA_SOURCE_ID = :dataSourceId'.
	 */
	public List<PropertyData> findByDataSource(int dataSourceId) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'ZIP_CODE = :zipCode'.
	 */
	public List<PropertyData> findByZipCodes(int zipCode) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PROPERTY_STATUS_ID = :propertyStatusId'.
	 */
	public List<PropertyData> findByPropertyStatus(int propertyStatusId) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PROPERTY_TYPE_ID = :propertyTypeId'.
	 */
	public List<PropertyData> findByPropertyType(int propertyTypeId) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'UUID = :customerUuid'.
	 */
	public List<PropertyData> findWhereUuidEquals(String uuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PROP_NAME = :propName'.
	 */
	public List<PropertyData> findWherePropNameEquals(String propName) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PRICE = :price'.
	 */
	public List<PropertyData> findWherePriceEquals(float price) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'SQFT = :sqft'.
	 */
	public List<PropertyData> findWhereSqftEquals(float sqft) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'DESCRIPTION = :description'.
	 */
	public List<PropertyData> findWhereDescriptionEquals(String description) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'NUM_BEDS = :numBeds'.
	 */
	public List<PropertyData> findWhereNumBedsEquals(float numBeds) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'NUM_BATHS = :numBaths'.
	 */
	public List<PropertyData> findWhereNumBathsEquals(float numBaths) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'DATA_SOURCE_ID = :dataSourceId'.
	 */
	public List<PropertyData> findWhereDataSourceIdEquals(int dataSourceId) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'ZIP_CODE = :zipCode'.
	 */
	public List<PropertyData> findWhereZipCodeEquals(int zipCode) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PROPERTY_STATUS_ID = :propertyStatusId'.
	 */
	public List<PropertyData> findWherePropertyStatusIdEquals(int propertyStatusId) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PROPERTY_TYPE_ID = :propertyTypeId'.
	 */
	public List<PropertyData> findWherePropertyTypeIdEquals(int propertyTypeId) throws DataBaseJdbcException;



}
