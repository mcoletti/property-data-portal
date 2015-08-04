package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.UserAttributesDaoException;
import com.codeitek.pdp.model.UserAttributes;
import com.codeitek.pdp.model.UserAttributesPk;

import java.util.List;

public interface UserAttributesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UserAttributesPk
	 */
	public UserAttributesPk insert(UserAttributes dto);

	/** 
	 * Updates a single row in the USER_ATTRIBUTES table.
	 */
	public void update(UserAttributesPk pk, UserAttributes dto) throws UserAttributesDaoException;

	/** 
	 * Deletes a single row in the USER_ATTRIBUTES table.
	 */
	public void delete(UserAttributesPk pk) throws UserAttributesDaoException;

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public UserAttributes findByPrimaryKey(int id) throws UserAttributesDaoException;

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria ''.
	 */
	public List<UserAttributes> findAll() throws UserAttributesDaoException;

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<UserAttributes> findByUser(String userUuid) throws UserAttributesDaoException;

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public List<UserAttributes> findWhereIdEquals(int id) throws UserAttributesDaoException;

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'ATTRIBUTE_VALUE = :attributeValue'.
	 */
	public List<UserAttributes> findWhereAttributeValueEquals(String attributeValue) throws UserAttributesDaoException;

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	public List<UserAttributes> findWhereAttributesIdEquals(int attributesId) throws UserAttributesDaoException;

	/** 
	 * Returns all rows from the USER_ATTRIBUTES table that match the criteria 'USER_UUID = :userUuid'.
	 */
	public List<UserAttributes> findWhereUserUuidEquals(String userUuid) throws UserAttributesDaoException;

	/** 
	 * Returns the rows from the USER_ATTRIBUTES table that matches the specified primary-key value.
	 */
	public UserAttributes findByPrimaryKey(UserAttributesPk pk) throws UserAttributesDaoException;

}
