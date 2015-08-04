package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.model.UiPageAttributes;
import com.codeitek.pdp.model.UiPageAttributesPk;
import java.util.List;

public interface UiPageAttributesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiPageAttributesPk
	 */
	public UiPageAttributesPk insert(UiPageAttributes dto);

	/** 
	 * Updates a single row in the UI_PAGE_ATTRIBUTES table.
	 */
	public void update(UiPageAttributesPk pk, UiPageAttributes dto) ;

	/** 
	 * Deletes a single row in the UI_PAGE_ATTRIBUTES table.
	 */
	public void delete(UiPageAttributesPk pk) ;

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public UiPageAttributes findByPrimaryKey(int id) ;

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria ''.
	 */
	public List<UiPageAttributes> findAll() ;

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	public List<UiPageAttributes> findByAttributes(int attributesId) ;

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'UI_PAGE_LAYOUT_ID = :uiPageLayoutId'.
	 */
	public List<UiPageAttributes> findByUiPageLayout(int uiPageLayoutId) ;

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'ID = :id'.
	 */
	public List<UiPageAttributes> findWhereIdEquals(int id) ;

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'ATTRUIBUTE_VALUE = :attruibuteValue'.
	 */
	public List<UiPageAttributes> findWhereAttruibuteValueEquals(String attruibuteValue) ;

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'ATTRIBUTES_ID = :attributesId'.
	 */
	public List<UiPageAttributes> findWhereAttributesIdEquals(int attributesId) ;

	/** 
	 * Returns all rows from the UI_PAGE_ATTRIBUTES table that match the criteria 'UI_PAGE_LAYOUT_ID = :uiPageLayoutId'.
	 */
	public List<UiPageAttributes> findWhereUiPageLayoutIdEquals(int uiPageLayoutId) ;

	/** 
	 * Returns the rows from the UI_PAGE_ATTRIBUTES table that matches the specified primary-key value.
	 */
	public UiPageAttributes findByPrimaryKey(UiPageAttributesPk pk) ;

}
