package com.codeitek.pdp.dal.impl;

import org.apache.log4j.Logger;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.dal.interfaces.UiPageAttributesDao;
import com.codeitek.pdp.model.UiPageAttributes;
import com.codeitek.pdp.model.UiPageAttributesPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class UiPageAttributesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<UiPageAttributes>, UiPageAttributesDao
{
    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(UiPageAttributesJdbcDao.class);



	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiPageAttributesPk
	 */
	@Transactional
	public UiPageAttributesPk insert(UiPageAttributes dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( ATTRUIBUTE_VALUE, ATTRIBUTES_ID, UI_PAGE_LAYOUT_ID ) VALUES ( ?, ?, ? )", dto.getAttruibuteValue(), dto.getAttributesId(), dto.getUiPageLayoutId());
		UiPageAttributesPk pk = new UiPageAttributesPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the UI_PAGE_ATTRIBUTES table.
	 */
	@Transactional
	public void update(UiPageAttributesPk pk, UiPageAttributes dto)
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, ATTRUIBUTE_VALUE = ?, ATTRIBUTES_ID = ?, UI_PAGE_LAYOUT_ID = ? WHERE ID = ?", dto.getId(), dto.getAttruibuteValue(), dto.getAttributesId(), dto.getUiPageLayoutId(), pk.getId());
	}

	/** 
	 * Deletes a single row in the UI_PAGE_ATTRIBUTES table.
	 */
	@Transactional
	public void delete(UiPageAttributesPk pk)
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return UiPageAttributes
	 */
	public UiPageAttributes mapRow(ResultSet rs, int row) throws SQLException
	{
		UiPageAttributes dto = new UiPageAttributes();
		dto.setId( rs.getInt( 1 ) );
		dto.setAttruibuteValue( rs.getString( 2 ) );
		dto.setAttributesId( rs.getInt( 3 ) );
		dto.setUiPageLayoutId( rs.getInt( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "UI_PAGE_ATTRIBUTES";
	}

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public UiPageAttributes findByPrimaryKey(int id)
	{
		try {
			List<UiPageAttributes> list = getJdbcTemplate().query("SELECT ID, ATTRUIBUTE_VALUE, ATTRIBUTES_ID, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE ID = ?", this, id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria ''.
	 */
	@Transactional
	public List<UiPageAttributes> findAll()
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRUIBUTE_VALUE, ATTRIBUTES_ID, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	@Transactional
	public List<UiPageAttributes> findByAttributes(int attributesId)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRUIBUTE_VALUE, ATTRIBUTES_ID, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE ATTRIBUTES_ID = ?", this, attributesId);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'UI_PAGE_LAYOUT_ID = :uiPageLayoutId'.
	 */
	@Transactional
	public List<UiPageAttributes> findByUiPageLayout(int uiPageLayoutId)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRUIBUTE_VALUE, ATTRIBUTES_ID, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE UI_PAGE_LAYOUT_ID = ?", this, uiPageLayoutId);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<UiPageAttributes> findWhereIdEquals(int id)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRUIBUTE_VALUE, ATTRIBUTES_ID, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'ATTRUIBUTE_VALUE = :attruibuteValue'.
	 */
	@Transactional
	public List<UiPageAttributes> findWhereAttruibuteValueEquals(String attruibuteValue)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRUIBUTE_VALUE, ATTRIBUTES_ID, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE ATTRUIBUTE_VALUE = ? ORDER BY ATTRUIBUTE_VALUE", this, attruibuteValue);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	@Transactional
	public List<UiPageAttributes> findWhereAttributesIdEquals(int attributesId)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRUIBUTE_VALUE, ATTRIBUTES_ID, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE ATTRIBUTES_ID = ? ORDER BY ATTRIBUTES_ID", this, attributesId);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'UI_PAGE_LAYOUT_ID = :uiPageLayoutId'.
	 */
	@Transactional
	public List<UiPageAttributes> findWhereUiPageLayoutIdEquals(int uiPageLayoutId)
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRUIBUTE_VALUE, ATTRIBUTES_ID, UI_PAGE_LAYOUT_ID FROM " + getTableName() + " WHERE UI_PAGE_LAYOUT_ID = ? ORDER BY UI_PAGE_LAYOUT_ID", this, uiPageLayoutId);
		}
		catch (Exception e) {
            log.error("Query failed", e);
            return null;
		}
		
	}

	/** 
	 * Returns the rows from the UI_PAGE_ATTRIBUTES table that matches the specified primary-key value.
	 */
	public UiPageAttributes findByPrimaryKey(UiPageAttributesPk pk)
	{
		return findByPrimaryKey( pk.getId() );
	}

}
