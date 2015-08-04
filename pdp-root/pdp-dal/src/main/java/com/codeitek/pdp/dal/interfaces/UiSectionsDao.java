package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.UiSectionsDaoException;
import com.codeitek.pdp.model.UiSections;
import com.codeitek.pdp.model.UiSectionsPk;
import java.util.List;

public interface UiSectionsDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiSectionsPk
	 */
	public UiSectionsPk insert(UiSections dto);

	/** 
	 * Updates a single row in the UI_SECTIONS table.
	 */
	public void update(UiSectionsPk pk, UiSections dto) throws UiSectionsDaoException;

	/** 
	 * Deletes a single row in the UI_SECTIONS table.
	 */
	public void delete(UiSectionsPk pk) throws UiSectionsDaoException;

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'ID = :id AND SECTION_KEY = :sectionKey'.
	 */
	public UiSections findByPrimaryKey(int id, String sectionKey) throws UiSectionsDaoException;

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria ''.
	 */
	public List<UiSections> findAll() throws UiSectionsDaoException;

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'UI_PAGE_LAYOUT_ID = :uiPageLayoutId'.
	 */
	public List<UiSections> findByUiPageLayout(int uiPageLayoutId) throws UiSectionsDaoException;

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'ID = :id'.
	 */
	public List<UiSections> findWhereIdEquals(int id) throws UiSectionsDaoException;

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'SECTION_KEY = :sectionKey'.
	 */
	public List<UiSections> findWhereSectionKeyEquals(String sectionKey) throws UiSectionsDaoException;

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'DISPLAY_NAME = :displayName'.
	 */
	public List<UiSections> findWhereDisplayNameEquals(String displayName) throws UiSectionsDaoException;

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'SECTION_ORDER = :sectionOrder'.
	 */
	public List<UiSections> findWhereSectionOrderEquals(int sectionOrder) throws UiSectionsDaoException;

	/** 
	 * Returns all rows from the UI_SECTIONS table that match the criteria 'UI_PAGE_LAYOUT_ID = :uiPageLayoutId'.
	 */
	public List<UiSections> findWhereUiPageLayoutIdEquals(int uiPageLayoutId) throws UiSectionsDaoException;

	/** 
	 * Returns the rows from the UI_SECTIONS table that matches the specified primary-key value.
	 */
	public UiSections findByPrimaryKey(UiSectionsPk pk) throws UiSectionsDaoException;

}
