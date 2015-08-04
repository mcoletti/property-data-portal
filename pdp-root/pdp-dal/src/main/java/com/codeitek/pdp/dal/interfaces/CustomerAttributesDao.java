package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.CustomerAttributes;
import com.codeitek.pdp.model.CustomerAttributesPk;

import java.util.List;

public interface CustomerAttributesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return CustomerAttributesPk
	 */
	public CustomerAttributesPk insert(CustomerAttributes dto);

	/** 
	 * Updates a single row in the CUSTOMER_ATTRIBUTES table.
	 */
	public CustomerAttributesPk update(CustomerAttributesPk pk, CustomerAttributes dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the CUSTOMER_ATTRIBUTES table.
	 */
	public void delete(CustomerAttributesPk pk) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public CustomerAttributes findByPrimaryKey(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria ''.
	 */
	public List<CustomerAttributes> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	public List<CustomerAttributes> findByCustomer(String customerUuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	public List<CustomerAttributes> findByAttributes(int attributesId) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public List<CustomerAttributes> findWhereIdEquals(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'ATTRIBUTE_VALUE = :attributeValue'.
	 */
	public List<CustomerAttributes> findWhereAttributeValueEquals(String attributeValue) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'CUSTOMER_UUID = :customerUuid'.
	 */
	public List<CustomerAttributes> findWhereCustomerUuidEquals(String customerUuid) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the CUSTOMER_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	public List<CustomerAttributes> findWhereAttributesIdEquals(int attributesId) throws DataBaseJdbcException;

	/**
	 * Returns the rows from the CUSTOMER_ATTRIBUTES table that matches the specified primary-key value.
	 */
	public CustomerAttributes findByPrimaryKey(CustomerAttributesPk pk) throws DataBaseJdbcException;

}
