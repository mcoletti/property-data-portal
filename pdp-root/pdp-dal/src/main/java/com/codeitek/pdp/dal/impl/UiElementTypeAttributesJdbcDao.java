package com.codeitek.pdp.dal.impl;

import org.apache.log4j.Logger;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.dal.interfaces.UiElementTypeAttributesDao;
import com.codeitek.pdp.model.UiElementTypeAttributes;
import com.codeitek.pdp.model.UiElementTypeAttributesPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class UiElementTypeAttributesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<UiElementTypeAttributes>, UiElementTypeAttributesDao
{
    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(UiElementTypeAttributesJdbcDao.class);


	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiElementTypeAttributesPk
	 */
	@Transactional
	public UiElementTypeAttributesPk insert(UiElementTypeAttributes dto)
	{
        getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( ATTRIBUTE_VALUE, UI_ELEMENT_TYPES_ID, ATTRIBUTES_ID ) VALUES ( ?, ?, ? )", dto.getAttributeValue(), dto.getUiElementTypesId(), dto.getAttributesId());
		UiElementTypeAttributesPk pk = new UiElementTypeAttributesPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/**
	 * Updates a single row in the UI_ELEMENT_TYPE_ATTRIBUTES table.
	 */
	@Transactional
	public void update(UiElementTypeAttributesPk pk, UiElementTypeAttributes dto)
	{
        getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, ATTRIBUTE_VALUE = ?, UI_ELEMENT_TYPES_ID = ?, ATTRIBUTES_ID = ? WHERE ID = ?", dto.getId(), dto.getAttributeValue(), dto.getUiElementTypesId(), dto.getAttributesId(), pk.getId());
	}

	/** 
	 * Deletes a single row in the UI_ELEMENT_TYPE_ATTRIBUTES table.
	 */
	@Transactional
	public void delete(UiElementTypeAttributesPk pk)
        {
            getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return UiElementTypeAttributes
	 */
	public UiElementTypeAttributes mapRow(ResultSet rs, int row) throws SQLException
	{
		UiElementTypeAttributes dto = new UiElementTypeAttributes();
		dto.setId( rs.getInt( 1 ) );
		dto.setAttributeValue( rs.getString( 2 ) );
		dto.setUiElementTypesId( rs.getInt( 3 ) );
		dto.setAttributesId( rs.getInt( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "UI_ELEMENT_TYPE_ATTRIBUTES";
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public UiElementTypeAttributes findByPrimaryKey(int id)
	{
		try {
			List<UiElementTypeAttributes> list = getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, UI_ELEMENT_TYPES_ID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE ID = ?", this, id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria ''.
	 */
	@Transactional
	public List<UiElementTypeAttributes> findAll()
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, UI_ELEMENT_TYPES_ID, ATTRIBUTES_ID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'UI_ELEMENT_TYPES_ID = :uiElementTypesId'.
	 */
	@Transactional
	public List<UiElementTypeAttributes> findByUiElementTypes(int uiElementTypesId)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, UI_ELEMENT_TYPES_ID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE UI_ELEMENT_TYPES_ID = ?", this, uiElementTypesId);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	@Transactional
	public List<UiElementTypeAttributes> findByAttributes(int attributesId)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, UI_ELEMENT_TYPES_ID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE ATTRIBUTES_ID = ?", this, attributesId);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<UiElementTypeAttributes> findWhereIdEquals(int id)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, UI_ELEMENT_TYPES_ID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'ATTRIBUTE_VALUE = :attributeValue'.
	 */
	@Transactional
	public List<UiElementTypeAttributes> findWhereAttributeValueEquals(String attributeValue)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, UI_ELEMENT_TYPES_ID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE ATTRIBUTE_VALUE = ? ORDER BY ATTRIBUTE_VALUE", this,attributeValue);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'UI_ELEMENT_TYPES_ID = :uiElementTypesId'.
	 */
	@Transactional
	public List<UiElementTypeAttributes> findWhereUiElementTypesIdEquals(int uiElementTypesId)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, UI_ELEMENT_TYPES_ID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE UI_ELEMENT_TYPES_ID = ? ORDER BY UI_ELEMENT_TYPES_ID", this,uiElementTypesId);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	@Transactional
	public List<UiElementTypeAttributes> findWhereAttributesIdEquals(int attributesId)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, UI_ELEMENT_TYPES_ID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE ATTRIBUTES_ID = ? ORDER BY ATTRIBUTES_ID", this,attributesId);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns the rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that matches the specified primary-key value.
	 */
	public UiElementTypeAttributes findByPrimaryKey(UiElementTypeAttributesPk pk)
	{
		return findByPrimaryKey( pk.getId() );
	}

}
