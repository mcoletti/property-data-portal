package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.UiSectionGroupsDaoException;
import com.codeitek.pdp.model.UiSectionGroups;
import com.codeitek.pdp.model.UiSectionGroupsPk;
import java.util.List;

public interface UiSectionGroupsDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiSectionGroupsPk
	 */
	public UiSectionGroupsPk insert(UiSectionGroups dto);

	/** 
	 * Updates a single row in the UI_SECTION_GROUPS table.
	 */
	public void update(UiSectionGroupsPk pk, UiSectionGroups dto) throws UiSectionGroupsDaoException;

	/** 
	 * Deletes a single row in the UI_SECTION_GROUPS table.
	 */
	public void delete(UiSectionGroupsPk pk) throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'INT = :aInt'.
	 */
	public UiSectionGroups findByPrimaryKey(int aInt) throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria ''.
	 */
	public List<UiSectionGroups> findAll() throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'SECTION_KEY = :sectionKey'.
	 */
	public List<UiSectionGroups> findByUiSections(String sectionKey) throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'UI_ELEMENT_TYPES_ID = :uiElementTypesId'.
	 */
	public List<UiSectionGroups> findByUiElementTypes(int uiElementTypesId) throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'INT = :aInt'.
	 */
	public List<UiSectionGroups> findWhereAIntEquals(int aInt) throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'GROUP_KEY = :groupKey'.
	 */
	public List<UiSectionGroups> findWhereGroupKeyEquals(String groupKey) throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'DISPLAY_NAME = :displayName'.
	 */
	public List<UiSectionGroups> findWhereDisplayNameEquals(String displayName) throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'GROUP_ORDER = :groupOrder'.
	 */
	public List<UiSectionGroups> findWhereGroupOrderEquals(int groupOrder) throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'SECTION_KEY = :sectionKey'.
	 */
	public List<UiSectionGroups> findWhereSectionKeyEquals(String sectionKey) throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'DEFAULT_GROUP = :defaultGroup'.
	 */
	public List<UiSectionGroups> findWhereDefaultGroupEquals(short defaultGroup) throws UiSectionGroupsDaoException;

	/** 
	 * Returns all rows from the UI_SECTION_GROUPS table that match the criteria 'UI_ELEMENT_TYPES_ID = :uiElementTypesId'.
	 */
	public List<UiSectionGroups> findWhereUiElementTypesIdEquals(int uiElementTypesId) throws UiSectionGroupsDaoException;

	/** 
	 * Returns the rows from the UI_SECTION_GROUPS table that matches the specified primary-key value.
	 */
	public UiSectionGroups findByPrimaryKey(UiSectionGroupsPk pk) throws UiSectionGroupsDaoException;

}
