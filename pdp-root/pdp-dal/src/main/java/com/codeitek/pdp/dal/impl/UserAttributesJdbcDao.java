package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.exceptions.UserAttributesDaoException;
import com.codeitek.pdp.dal.interfaces.UserAttributesDao;
import com.codeitek.pdp.model.UserAttributes;
import com.codeitek.pdp.model.UserAttributesPk;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserAttributesJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<UserAttributes>, UserAttributesDao
{

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UserAttributesPk
	 */
	public UserAttributesPk insert(UserAttributes dto)
	{
		getJdbcTemplate().update("INSERT INTO " + getTableName() + " ( ATTRIBUTE_VALUE, ATTRIBUTES_ID, USER_UUID ) VALUES ( ?, ?, ? )", dto.getAttributeValue(), dto.getAttributesId(), dto.getUserUuid());
		UserAttributesPk pk = new UserAttributesPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the USER_ATTRIBUTES table.
	 */
	public void update(UserAttributesPk pk, UserAttributes dto) throws UserAttributesDaoException
	{
		getJdbcTemplate().update("UPDATE " + getTableName() + " SET ID = ?, ATTRIBUTE_VALUE = ?, ATTRIBUTES_ID = ?, USER_UUID = ? WHERE ID = ?", dto.getId(), dto.getAttributeValue(), dto.getAttributesId(), dto.getUserUuid(), pk.getId());
	}

	/** 
	 * Deletes a single row in the USER_ATTRIBUTES table.
	 */
	public void delete(UserAttributesPk pk) throws UserAttributesDaoException
	{
		getJdbcTemplate().update("DELETE FROM " + getTableName() + " WHERE ID = ?", pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return UserAttributes
	 */
	public UserAttributes mapRow(ResultSet rs, int row) throws SQLException
	{
		UserAttributes dto = new UserAttributes();
		dto.setId( rs.getInt( 1 ) );
		dto.setAttributeValue( rs.getString( 2 ) );
		dto.setAttributesId( rs.getInt( 3 ) );
		dto.setUserUuid( rs.getString( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "USER_ATTRIBUTES";
	}

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public UserAttributes findByPrimaryKey(int id) throws UserAttributesDaoException
	{
		try {
			List<UserAttributes> list = getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, ATTRIBUTES_ID, USER_UUID FROM " + getTableName() + " WHERE ID = ?", this, id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new UserAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria ''.
	 */
	public List<UserAttributes> findAll() throws UserAttributesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, ATTRIBUTES_ID, USER_UUID FROM " + getTableName() + " ORDER BY ID", this);
		}
		catch (Exception e) {
			throw new UserAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<UserAttributes> findByUser(String userUuid) throws UserAttributesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, ATTRIBUTES_ID, USER_UUID FROM " + getTableName() + " WHERE USER_UUID = ?", this, userUuid);
		}
		catch (Exception e) {
			throw new UserAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public List<UserAttributes> findWhereIdEquals(int id) throws UserAttributesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, ATTRIBUTES_ID, USER_UUID FROM " + getTableName() + " WHERE ID = ? ORDER BY ID", this, id);
		}
		catch (Exception e) {
			throw new UserAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'ATTRIBUTE_VALUE = :attributeValue'.
	 */
	public List<UserAttributes> findWhereAttributeValueEquals(String attributeValue) throws UserAttributesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, ATTRIBUTES_ID, USER_UUID FROM " + getTableName() + " WHERE ATTRIBUTE_VALUE = ? ORDER BY ATTRIBUTE_VALUE", this, attributeValue);
		}
		catch (Exception e) {
			throw new UserAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	public List<UserAttributes> findWhereAttributesIdEquals(int attributesId) throws UserAttributesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, ATTRIBUTES_ID, USER_UUID FROM " + getTableName() + " WHERE ATTRIBUTES_ID = ? ORDER BY ATTRIBUTES_ID", this, attributesId);
		}
		catch (Exception e) {
			throw new UserAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<UserAttributes> findWhereUserUuidEquals(String userUuid) throws UserAttributesDaoException
	{
		try {
			return getJdbcTemplate().query("SELECT ID, ATTRIBUTE_VALUE, ATTRIBUTES_ID, USER_UUID FROM " + getTableName() + " WHERE USER_UUID = ? ORDER BY USER_UUID", this, userUuid);
		}
		catch (Exception e) {
			throw new UserAttributesDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the USER_ATTRIBUTES table that matches the specified primary-key value.
	 */
	public UserAttributes findByPrimaryKey(UserAttributesPk pk) throws UserAttributesDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
