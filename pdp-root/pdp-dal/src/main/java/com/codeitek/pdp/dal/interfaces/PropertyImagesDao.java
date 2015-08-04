package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.PropertyImagesDaoException;
import com.codeitek.pdp.model.PropertyImages;
import com.codeitek.pdp.model.PropertyImagesPk;

import java.util.List;

public interface PropertyImagesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return PropertyImagesPk
	 */
	public PropertyImagesPk insert(PropertyImages dto);

	/** 
	 * Updates a single row in the PROPERTY_IMAGES table.
	 */
	public void update(PropertyImagesPk pk, PropertyImages dto) throws PropertyImagesDaoException;

	/** 
	 * Deletes a single row in the PROPERTY_IMAGES table.
	 */
	public void delete(PropertyImagesPk pk) throws PropertyImagesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'ID = :id'.
	 */
	public PropertyImages findByPrimaryKey(int id) throws PropertyImagesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria ''.
	 */
	public List<PropertyImages> findAll() throws PropertyImagesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'PROPERTY_DATA_UUID = :propertyDataUuid'.
	 */
	public List<PropertyImages> findByPropertyData(String propertyDataUuid) throws PropertyImagesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'ID = :id'.
	 */
	public List<PropertyImages> findWhereIdEquals(int id) throws PropertyImagesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'TITLE = :title'.
	 */
	public List<PropertyImages> findWhereTitleEquals(String title) throws PropertyImagesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'TYPE = :type'.
	 */
	public List<PropertyImages> findWhereTypeEquals(String type) throws PropertyImagesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'SIZE = :size'.
	 */
	public List<PropertyImages> findWhereSizeEquals(int size) throws PropertyImagesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'SRC_URL = :srcUrl'.
	 */
	public List<PropertyImages> findWhereSrcUrlEquals(String srcUrl) throws PropertyImagesDaoException;

	/** 
	 * Returns all rows from the PROPERTY_IMAGES table that match the criteria 'PROPERTY_DATA_UUID = :propertyDataUuid'.
	 */
	public List<PropertyImages> findWherePropertyDataUuidEquals(String propertyDataUuid) throws PropertyImagesDaoException;

	/** 
	 * Returns the rows from the PROPERTY_IMAGES table that matches the specified primary-key value.
	 */
	public PropertyImages findByPrimaryKey(PropertyImagesPk pk) throws PropertyImagesDaoException;

}
