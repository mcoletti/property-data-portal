package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.CustomerDaoException;
import com.codeitek.pdp.model.Customer;
import com.codeitek.pdp.model.CustomerPk;

import java.util.List;

public interface CustomerDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param customer
	 * @return CustomerPk
	 */
	public String insert(Customer customer);

	/** 
	 * Updates a single row in the CUSTOMER table.
	 */
	public String update(String pk, Customer customer) throws CustomerDaoException;

	/** 
	 * Deletes a single row in the CUSTOMER table.
	 */
	public void delete(String pk) throws CustomerDaoException;

	/** 
	 * Returns all rows from the CUSTOMER table that match the criteria 'UUID = :customerUuid'.
	 */
	public Customer findByPrimaryKey(String uuid) throws CustomerDaoException;

	/** 
	 * Returns all rows from the CUSTOMER table that match the criteria ''.
	 */
	public List<Customer> findAll() throws CustomerDaoException;

	/** 
	 * Returns all rows from the CUSTOMER table that match the criteria 'UUID = :customerUuid'.
	 */
	public List<Customer> findWhereUuidEquals(String uuid) throws CustomerDaoException;

	/** 
	 * Returns all rows from the CUSTOMER table that match the criteria 'NAME = :customerName'.
	 */
	public List<Customer> findWhereNameEquals(String name) throws CustomerDaoException;

	/** 
	 * Returns all rows from the CUSTOMER table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
	public List<Customer> findWhereDeleteIndEquals(boolean deleteInd) throws CustomerDaoException;



}
