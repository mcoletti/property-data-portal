package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.UiElementTypesDaoException;
import com.codeitek.pdp.model.UiElementTypes;
import com.codeitek.pdp.model.UiElementTypesPk;

import java.util.List;

public interface UiElementTypesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiElementTypesPk
	 */
	public UiElementTypesPk insert(UiElementTypes dto);

	/** 
	 * Updates a single row in the UI_ELEMENT_TYPES table.
	 */
	public void update(UiElementTypesPk pk, UiElementTypes dto) throws UiElementTypesDaoException;

	/** 
	 * Deletes a single row in the UI_ELEMENT_TYPES table.
	 */
	public void delete(UiElementTypesPk pk) throws UiElementTypesDaoException;

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPES table that match the criteria 'ID = :id'.
	 */
	public UiElementTypes findByPrimaryKey(int id) throws UiElementTypesDaoException;

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPES table that match the criteria ''.
	 */
	public List<UiElementTypes> findAll() throws UiElementTypesDaoException;

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPES table that match the criteria 'ID = :id'.
	 */
	public List<UiElementTypes> findWhereIdEquals(int id) throws UiElementTypesDaoException;

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPES table that match the criteria 'TYPE_KEY = :typeKey'.
	 */
	public List<UiElementTypes> findWhereTypeKeyEquals(String typeKey) throws UiElementTypesDaoException;

	/** 
	 * Returns the rows from the UI_ELEMENT_TYPES table that matches the specified primary-key value.
	 */
	public UiElementTypes findByPrimaryKey(UiElementTypesPk pk) throws UiElementTypesDaoException;

}
