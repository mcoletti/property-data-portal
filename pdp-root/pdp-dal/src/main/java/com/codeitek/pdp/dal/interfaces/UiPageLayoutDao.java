package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.UiPageLayoutDaoException;
import com.codeitek.pdp.model.UiPageLayout;
import com.codeitek.pdp.model.UiPageLayoutPk;
import java.util.List;

public interface UiPageLayoutDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return UiPageLayoutPk
	 */
	public UiPageLayoutPk insert(UiPageLayout dto);

	/** 
	 * Updates a single row in the UI_PAGE_LAYOUT table.
	 */
	public void update(UiPageLayoutPk pk, UiPageLayout dto) throws UiPageLayoutDaoException;

	/** 
	 * Deletes a single row in the UI_PAGE_LAYOUT table.
	 */
	public void delete(UiPageLayoutPk pk) throws UiPageLayoutDaoException;

	/** 
	 * Returns all rows from the UI_PAGE_LAYOUT table that match the criteria 'ID = :id'.
	 */
	public UiPageLayout findByPrimaryKey(int id) throws UiPageLayoutDaoException;

	/** 
	 * Returns all rows from the UI_PAGE_LAYOUT table that match the criteria ''.
	 */
	public List<UiPageLayout> findAll() throws UiPageLayoutDaoException;

	/** 
	 * Returns all rows from the UI_PAGE_LAYOUT table that match the criteria 'ID = :id'.
	 */
	public List<UiPageLayout> findWhereIdEquals(int id) throws UiPageLayoutDaoException;

	/** 
	 * Returns all rows from the UI_PAGE_LAYOUT table that match the criteria 'UI_PAGE = :uiPage'.
	 */
	public List<UiPageLayout> findWhereUiPageEquals(String uiPage) throws UiPageLayoutDaoException;

	/** 
	 * Returns the rows from the UI_PAGE_LAYOUT table that matches the specified primary-key value.
	 */
	public UiPageLayout findByPrimaryKey(UiPageLayoutPk pk) throws UiPageLayoutDaoException;

}
