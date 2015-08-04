package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.interfaces.CustomerAttributesDao;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.model.CustomerAttributes;
import com.codeitek.pdp.model.CustomerAttributesPk;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class CustomerAttributesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<CustomerAttributes>, CustomerAttributesDao
{

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(CustomerAttributesJdbcDao.class);

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return CustomerAttributesPk
	 */
	@Transactional
	public CustomerAttributesPk insert(CustomerAttributes dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( ATTRIBUTE_VALUE, CUSTOMER_UUID, ATTRIBUTES_ID ) VALUES ( ?, ?, ? )",dto.getAttributeValue(),dto.getCustomerUuid(),dto.getAttributesId());
		CustomerAttributesPk pk = new CustomerAttributesPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the CUSTOMER_ATTRIBUTES table.
	 */
	@Transactional
	public CustomerAttributesPk update(CustomerAttributesPk pk, CustomerAttributes dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, ATTRIBUTE_VALUE = ?, CUSTOMER_UUID = ?, ATTRIBUTES_ID = ? WHERE ID = ?",dto.getId(),dto.getAttributeValue(),dto.getCustomerUuid(),dto.getAttributesId(),pk.getId());
        return pk;
	}

	/** 
	 * Deletes a single row in the CUSTOMER_ATTRIBUTES table.
	 */
	@Transactional
	public void delete(CustomerAttributesPk pk) throws DataBaseJdbcException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?",pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return CustomerAttributes
	 */
	public CustomerAttributes mapRow(ResultSet rs, int row) throws SQLException
	{
		CustomerAttributes dto = new CustomerAttributes();
		dto.setId( rs.getInt( 1 ) );
		dto.setAttributeValue( rs.getString( 2 ) );
		dto.setCustomerUuid( rs.getString( 3 ) );
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
		return "CUSTOMER_ATTRIBUTES";
	}

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public CustomerAttributes findByPrimaryKey(int id) throws DataBaseJdbcException
	{
		try {
			List<CustomerAttributes> list = getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, CUSTOMER_UUID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE ID = ?", this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria ''.
	 */
	@Transactional
	public List<CustomerAttributes> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, CUSTOMER_UUID, ATTRIBUTES_ID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	@Transactional
	public List<CustomerAttributes> findByCustomer(String customerUuid) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, CUSTOMER_UUID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE CUSTOMER_UUID = ?", this,customerUuid);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	@Transactional
	public List<CustomerAttributes> findByAttributes(int attributesId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, CUSTOMER_UUID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE ATTRIBUTES_ID = ?", this,attributesId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<CustomerAttributes> findWhereIdEquals(int id) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, CUSTOMER_UUID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this,id);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'ATTRIBUTE_VALUE = :attributeValue'.
	 */
	@Transactional
	public List<CustomerAttributes> findWhereAttributeValueEquals(String attributeValue) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, CUSTOMER_UUID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE ATTRIBUTE_VALUE = ? ORDER BY ATTRIBUTE_VALUE", this,attributeValue);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	@Transactional
	public List<CustomerAttributes> findWhereCustomerUuidEquals(String customerUuid) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, CUSTOMER_UUID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE CUSTOMER_UUID = ? ORDER BY CUSTOMER_UUID", this,customerUuid);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	@Transactional
	public List<CustomerAttributes> findWhereAttributesIdEquals(int attributesId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, CUSTOMER_UUID, ATTRIBUTES_ID FROM " + getTableName() + " WHERE ATTRIBUTES_ID = ? ORDER BY ATTRIBUTES_ID", this,attributesId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the CUSTOMER_ATTRIBUTES table that matches the specified primary-key value.
	 */
	public CustomerAttributes findByPrimaryKey(CustomerAttributesPk pk) throws DataBaseJdbcException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
