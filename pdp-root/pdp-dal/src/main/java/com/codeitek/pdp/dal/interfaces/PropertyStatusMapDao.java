package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.PropertyStatusMap;
import com.codeitek.pdp.model.PropertyStatusMapPk;

import java.util.List;

public interface PropertyStatusMapDao
{
    /**
     * Method 'insert'
     *
     * @param dto
     * @return PropertyStatusMapPk
     */
    public PropertyStatusMapPk insert(PropertyStatusMap dto);

    /**
     * Updates a single row in the PROPERTY_STATUS_MAP table.
     */
    public void update(PropertyStatusMapPk pk, PropertyStatusMap dto) throws DataBaseJdbcException;

    /**
     * Deletes a single row in the PROPERTY_STATUS_MAP table.
     */
    public void delete(PropertyStatusMapPk pk) throws DataBaseJdbcException;

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria 'ID = :id'.
     */
    public PropertyStatusMap findByPrimaryKey(int id) throws DataBaseJdbcException;

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria ''.
     */
    public List<PropertyStatusMap> findAll() throws DataBaseJdbcException;

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria 'STATUS_CODE_ID = :statusCodeId'.
     */
    public List<PropertyStatusMap> findByStatusCode(int statusCodeId) throws DataBaseJdbcException;

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria 'ID = :id'.
     */
    public List<PropertyStatusMap> findWhereIdEquals(int id) throws DataBaseJdbcException;

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria 'PROPERTY_DATA_UUID = :propertyDataUuid'.
     */
    public List<PropertyStatusMap> findWherePropertyDataUuidEquals(String propertyDataUuid) throws DataBaseJdbcException;

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria 'STATUS_CODE_ID = :statusCodeId'.
     */
    public List<PropertyStatusMap> findWhereStatusCodeIdEquals(int statusCodeId) throws DataBaseJdbcException;

    /**
     * Returns the rows from the PROPERTY_STATUS_MAP table that matches the specified primary-key value.
     */
    public PropertyStatusMap findByPrimaryKey(PropertyStatusMapPk pk) throws DataBaseJdbcException;
}
