package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.model.UiElementTypeAttributes;
import com.codeitek.pdp.model.UiElementTypeAttributesPk;
import java.util.List;

public interface UiElementTypeAttributesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiElementTypeAttributesPk
	 */
	public UiElementTypeAttributesPk insert(UiElementTypeAttributes dto);

	/** 
	 * Updates a single row in the UI_ELEMENT_TYPE_ATTRIBUTES table.
	 */
	public void update(UiElementTypeAttributesPk pk, UiElementTypeAttributes dto);

	/** 
	 * Deletes a single row in the UI_ELEMENT_TYPE_ATTRIBUTES table.
	 */
	public void delete(UiElementTypeAttributesPk pk);

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public UiElementTypeAttributes findByPrimaryKey(int id);

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria ''.
	 */
	public List<UiElementTypeAttributes> findAll();

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'UI_ELEMENT_TYPES_ID = :uiElementTypesId'.
	 */
	public List<UiElementTypeAttributes> findByUiElementTypes(int uiElementTypesId) ;

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	public List<UiElementTypeAttributes> findByAttributes(int attributesId) ;

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public List<UiElementTypeAttributes> findWhereIdEquals(int id) ;

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'ATTRIBUTE_VALUE = :attributeValue'.
	 */
	public List<UiElementTypeAttributes> findWhereAttributeValueEquals(String attributeValue) ;

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'UI_ELEMENT_TYPES_ID = :uiElementTypesId'.
	 */
	public List<UiElementTypeAttributes> findWhereUiElementTypesIdEquals(int uiElementTypesId) ;

	/** 
	 * Returns all rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	public List<UiElementTypeAttributes> findWhereAttributesIdEquals(int attributesId) ;

	/** 
	 * Returns the rows from the UI_ELEMENT_TYPE_ATTRIBUTES table that matches the specified primary-key value.
	 */
	public UiElementTypeAttributes findByPrimaryKey(UiElementTypeAttributesPk pk) ;

}
