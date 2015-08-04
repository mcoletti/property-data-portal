package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOQueries;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.interfaces.PropertyDataDao;
import com.codeitek.pdp.model.PropertyData;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class PropertyDataJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<PropertyData>, PropertyDataDao
{


	/**
	 * Method 'insert'
	 * 
	 *
     * @param dto
     * @return PropertyDataPk
	 */
	public String insert(PropertyData dto)
	{
        dto.setUuid(UUID.randomUUID().toString());
        getJdbcTemplate().update(DAOQueries.I_PROP_DATA, dto.getUuid(), dto.getPropName(), dto.getPrice(), dto.getSqft(), dto.getDescription(), dto.getNumBeds(), dto.getNumBaths(), dto.getDataSourceId(), dto.getZipCode(), dto.getPropertyTypeId(),dto.getYearBuilt(),dto.getLotSize(),dto.getMarketId());
		return dto.getUuid();
	}

	/** 
	 * Updates a single row in the PROPERTY_DATA table.
	 */
	public String update(String uuid, PropertyData dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update(DAOQueries.U_PROP_DATA, dto.getUuid(), dto.getPropName(), dto.getPrice(), dto.getSqft(), dto.getDescription(), dto.getNumBeds(), dto.getNumBaths(),dto.getYearBuilt(),dto.getLotSize(), dto.getDataSourceId(), dto.getZipCode(), dto.getPropertyTypeId(),dto.getMarketId(), uuid);
        return uuid;
	}

	/** 
	 * Deletes a single row in the PROPERTY_DATA table.
	 */
	public void delete(String uuid) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE UUID = ?",uuid);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return PropertyData
	 */
	public PropertyData mapRow(ResultSet rs, int row) throws SQLException
	{
		PropertyData dto = new PropertyData();
		dto.setUuid( rs.getString( 1 ) );
		dto.setPropName(rs.getString(2));
		dto.setPrice(rs.getFloat(3));
		dto.setSqft(rs.getFloat(4));
		dto.setDescription(rs.getString(5));
		dto.setNumBeds(rs.getFloat(6));
		dto.setNumBaths(rs.getFloat(7));
		dto.setYearBuilt(rs.getInt(8));
		dto.setLotSize(rs.getFloat(9));
		dto.setDataSourceId(rs.getInt(10));
		dto.setZipCode(rs.getInt(11));
		dto.setPropertyStatusId(rs.getInt(12));
		dto.setPropertyTypeId(rs.getInt(13));
		dto.setMarketId(rs.getInt(14));
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "PROPERTY_DATA";
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'UUID = :customerUuid'.
	 */
	public PropertyData findByPrimaryKey(String uuid) throws DataBaseJdbcException
	{
		try {
			List<PropertyData> list = getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE UUID = ?", this,uuid);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria ''.
	 */
	public List<PropertyData> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA, this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'DATA_SOURCE_ID = :dataSourceId'.
	 */
	public List<PropertyData> findByDataSource(int dataSourceId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE DATA_SOURCE_ID = ?", this,dataSourceId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'ZIP_CODE = :zipCode'.
	 */
	public List<PropertyData> findByZipCodes(int zipCode) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE ZIP_CODE = ?", this,zipCode);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PROPERTY_STATUS_ID = :propertyStatusId'.
	 */
	public List<PropertyData> findByPropertyStatus(int propertyStatusId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE PROPERTY_STATUS_ID = ?", this,propertyStatusId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PROPERTY_TYPE_ID = :propertyTypeId'.
	 */
	public List<PropertyData> findByPropertyType(int propertyTypeId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE PROPERTY_TYPE_ID = ?", this,propertyTypeId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'UUID = :customerUuid'.
	 */
	public List<PropertyData> findWhereUuidEquals(String uuid) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE UUID = ? ORDER BY UUID", this,uuid);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PROP_NAME = :propName'.
	 */
	public List<PropertyData> findWherePropNameEquals(String propName) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE PROP_NAME = ? ORDER BY PROP_NAME", this,propName);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PRICE = :price'.
	 */
	public List<PropertyData> findWherePriceEquals(float price) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE PRICE = ? ORDER BY PRICE", this,price);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'SQFT = :sqft'.
	 */
	public List<PropertyData> findWhereSqftEquals(float sqft) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE SQFT = ? ORDER BY SQFT", this,sqft);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'DESCRIPTION = :description'.
	 */
	public List<PropertyData> findWhereDescriptionEquals(String description) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE DESCRIPTION = ? ORDER BY DESCRIPTION", this,description);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'NUM_BEDS = :numBeds'.
	 */
	public List<PropertyData> findWhereNumBedsEquals(float numBeds) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE NUM_BEDS = ? ORDER BY NUM_BEDS", this,numBeds);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'NUM_BATHS = :numBaths'.
	 */
	public List<PropertyData> findWhereNumBathsEquals(float numBaths) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE NUM_BATHS = ? ORDER BY NUM_BATHS", this,numBaths);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'DATA_SOURCE_ID = :dataSourceId'.
	 */
	public List<PropertyData> findWhereDataSourceIdEquals(int dataSourceId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE DATA_SOURCE_ID = ? ORDER BY DATA_SOURCE_ID", this,dataSourceId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'ZIP_CODE = :zipCode'.
	 */
	public List<PropertyData> findWhereZipCodeEquals(int zipCode) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE ZIP_CODE = ? ORDER BY ZIP_CODE", this,zipCode);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PROPERTY_STATUS_ID = :propertyStatusId'.
	 */
	public List<PropertyData> findWherePropertyStatusIdEquals(int propertyStatusId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE PROPERTY_STATUS_ID = ? ORDER BY PROPERTY_STATUS_ID", this,propertyStatusId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_DATA table that match the criteria 'PROPERTY_TYPE_ID = :propertyTypeId'.
	 */
	public List<PropertyData> findWherePropertyTypeIdEquals(int propertyTypeId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROP_DATA + " WHERE PROPERTY_TYPE_ID = ? ORDER BY PROPERTY_TYPE_ID", this,propertyTypeId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}



}
