package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.interfaces.PropertyStatusMapDao;
import com.codeitek.pdp.model.PropertyStatusMap;
import com.codeitek.pdp.model.PropertyStatusMapPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PropertyStatusMapJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<PropertyStatusMap>, PropertyStatusMapDao
{


    /**
     * Method 'insert'
     *
     * @param dto
     * @return PropertyStatusMapPk
     */
    public PropertyStatusMapPk insert(PropertyStatusMap dto)
    {
        getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( PROPERTY_DATA_UUID, STATUS_CODE_ID ) VALUES ( ?, ? )",dto.getPropertyDataUuid(),dto.getStatusCodeId());
        PropertyStatusMapPk pk = new PropertyStatusMapPk();
        pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
        return pk;
    }

    /**
     * Updates a single row in the PROPERTY_STATUS_MAP table.
     */
    public void update(PropertyStatusMapPk pk, PropertyStatusMap dto) throws DataBaseJdbcException
    {
        getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, PROPERTY_DATA_UUID = ?, STATUS_CODE_ID = ? WHERE ID = ?",dto.getId(),dto.getPropertyDataUuid(),dto.getStatusCodeId(),pk.getId());
    }

    /**
     * Deletes a single row in the PROPERTY_STATUS_MAP table.
     */
    public void delete(PropertyStatusMapPk pk) throws DataBaseJdbcException
    {
        getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
    }

    /**
     * Method 'mapRow'
     *
     * @param rs
     * @param row
     * @throws SQLException
     * @return PropertyStatusMap
     */
    public PropertyStatusMap mapRow(ResultSet rs, int row) throws SQLException
    {
        PropertyStatusMap dto = new PropertyStatusMap();
        dto.setId( rs.getInt( 1 ) );
        dto.setPropertyDataUuid( rs.getString( 2 ) );
        dto.setStatusCodeId( rs.getInt( 3 ) );
        return dto;
    }

    /**
     * Method 'getTableName'
     *
     * @return String
     */
    public String getTableName()
    {
        return "PROPERTY_STATUS_MAP";
    }

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria 'ID = :id'.
     */
    public PropertyStatusMap findByPrimaryKey(int id) throws DataBaseJdbcException
    {
        try {
            List<PropertyStatusMap> list = getJdbcTemplate().query("SELECT ID, PROPERTY_DATA_UUID, STATUS_CODE_ID FROM " + getTableName() + " WHERE ID = ?", this,id);
            return list.size() == 0 ? null : list.get(0);
        }
        catch (Exception e) {
            throw new DataBaseJdbcException("Query failed", e);
        }

    }

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria ''.
     */
    public List<PropertyStatusMap> findAll() throws DataBaseJdbcException
    {
        try {
            return getJdbcTemplate().query("SELECT ID, PROPERTY_DATA_UUID, STATUS_CODE_ID FROM " + getTableName() + " ORDER BY ID", this);
        }
        catch (Exception e) {
            throw new DataBaseJdbcException("Query failed", e);
        }

    }

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria 'STATUS_CODE_ID = :statusCodeId'.
     */
    public List<PropertyStatusMap> findByStatusCode(int statusCodeId) throws DataBaseJdbcException
    {
        try {
            return getJdbcTemplate().query("SELECT ID, PROPERTY_DATA_UUID, STATUS_CODE_ID FROM " + getTableName() + " WHERE STATUS_CODE_ID = ?", this,statusCodeId);
        }
        catch (Exception e) {
            throw new DataBaseJdbcException("Query failed", e);
        }

    }

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria 'ID = :id'.
     */
    public List<PropertyStatusMap> findWhereIdEquals(int id) throws DataBaseJdbcException
    {
        try {
            return getJdbcTemplate().query("SELECT ID, PROPERTY_DATA_UUID, STATUS_CODE_ID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
        }
        catch (Exception e) {
            throw new DataBaseJdbcException("Query failed", e);
        }

    }

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria 'PROPERTY_DATA_UUID = :propertyDataUuid'.
     */
    public List<PropertyStatusMap> findWherePropertyDataUuidEquals(String propertyDataUuid) throws DataBaseJdbcException
    {
        try {
            return getJdbcTemplate().query("SELECT ID, PROPERTY_DATA_UUID, STATUS_CODE_ID FROM " + getTableName() + " WHERE PROPERTY_DATA_UUID = ? ORDER BY PROPERTY_DATA_UUID", this,propertyDataUuid);
        }
        catch (Exception e) {
            throw new DataBaseJdbcException("Query failed", e);
        }

    }

    /**
     * Returns all rows from the PROPERTY_STATUS_MAP table that match the criteria 'STATUS_CODE_ID = :statusCodeId'.
     */
    public List<PropertyStatusMap> findWhereStatusCodeIdEquals(int statusCodeId) throws DataBaseJdbcException
    {
        try {
            return getJdbcTemplate().query("SELECT ID, PROPERTY_DATA_UUID, STATUS_CODE_ID FROM " + getTableName() + " WHERE STATUS_CODE_ID = ? ORDER BY STATUS_CODE_ID", this,statusCodeId);
        }
        catch (Exception e) {
            throw new DataBaseJdbcException("Query failed", e);
        }

    }

    /**
     * Returns the rows from the PROPERTY_STATUS_MAP table that matches the specified primary-key value.
     */
    public PropertyStatusMap findByPrimaryKey(PropertyStatusMapPk pk) throws DataBaseJdbcException
    {
        return findByPrimaryKey( pk.getId() );
    }
}
