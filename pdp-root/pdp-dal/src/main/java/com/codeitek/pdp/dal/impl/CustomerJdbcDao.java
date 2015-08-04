package com.codeitek.pdp.dal.impl;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.codeitek.pdp.dal.DAOTableRef;
import com.codeitek.pdp.dal.interfaces.CustomerDao;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.CustomerDaoException;
import com.codeitek.pdp.model.Customer;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class CustomerJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<Customer>, CustomerDao
{

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(CustomerJdbcDao.class);

    /**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return CustomerPk
	 */
//	@Transactional
	public String insert(Customer dto)
	{
		dto.setCustomerUuid(UUID.randomUUID().toString());
        getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( UUID, NAME, DELETE_IND ) VALUES ( ?, ?, ? )",dto.getCustomerUuid(),dto.getCustomerName(),dto.getCustomerDeleteInd());
		return dto.getCustomerUuid();
	}

	/** 
	 * Updates a single row in the CUSTOMER table.
	 */
//	@Transactional
	public String update(String pk, Customer dto) throws CustomerDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET UUID = ?, NAME = ?, DELETE_IND = ? WHERE UUID = ?",dto.getCustomerUuid(),dto.getCustomerName(),dto.getCustomerDeleteInd(),pk);
        return dto.getCustomerUuid();
	}

	/** 
	 * Deletes a single row in the CUSTOMER table.
	 */
//	@Transactional
	public void delete(String pk) throws CustomerDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE UUID = ?",pk);
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return Customer
	 */
	public Customer mapRow(ResultSet rs, int row) throws SQLException
	{
		Customer dto = new Customer();
		dto.setCustomerUuid(rs.getString(1));
		dto.setCustomerName(rs.getString(2));
		dto.setCustomerDeleteInd(rs.getBoolean(3));
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return DAOTableRef.CUSTOMER;
	}

	/** 
	 * Returns all rows from the CUSTOMER table that match the criteria 'UUID = :customerUuid'.
	 */
//	@Transactional
	public Customer findByPrimaryKey(String uuid) throws CustomerDaoException
	{
		try {
			List<Customer> list = getJdbcTemplate().query("SELECT UUID, NAME, DELETE_IND FROM " + getTableName() + " WHERE UUID = ?", this,uuid);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new CustomerDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER table that match the criteria ''.
	 */
//	@Transactional
	public List<Customer> findAll() throws CustomerDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, NAME, DELETE_IND FROM " + getTableName() + " ORDER BY UUID", this);
		}
		catch (Exception e) {
			throw new CustomerDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER table that match the criteria 'UUID = :customerUuid'.
	 */
//	@Transactional
	public List<Customer> findWhereUuidEquals(String uuid) throws CustomerDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, NAME, DELETE_IND FROM " + getTableName() + " WHERE UUID = ? ORDER BY UUID", this,uuid);
		}
		catch (Exception e) {
			throw new CustomerDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER table that match the criteria 'NAME = :customerName'.
	 */
//	@Transactional
	public List<Customer> findWhereNameEquals(String name) throws CustomerDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, NAME, DELETE_IND FROM " + getTableName() + " WHERE NAME = ? ORDER BY NAME", this,name);
		}
		catch (Exception e) {
			throw new CustomerDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the CUSTOMER table that match the criteria 'DELETE_IND = :customerDeleteInd'.
	 */
//	@Transactional
	public List<Customer> findWhereDeleteIndEquals(boolean deleteInd) throws CustomerDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT UUID, NAME, DELETE_IND FROM " + getTableName() + " WHERE DELETE_IND = ? ORDER BY DELETE_IND", this,deleteInd);
		}
		catch (Exception e) {
			throw new CustomerDaoException("Query failed", e);
		}
		
	}



}
