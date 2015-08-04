package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.FinancialKeyDaoException;
import com.codeitek.pdp.model.FinancialKey;
import com.codeitek.pdp.model.FinancialKeyPk;

import java.util.List;

public interface FinancialKeyDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return FinancialKeyPk
	 */
	public FinancialKeyPk insert(FinancialKey dto);

	/** 
	 * Updates a single row in the FINACIAL_KEY table.
	 */
	public void update(FinancialKeyPk pk, FinancialKey dto) throws FinancialKeyDaoException;

	/** 
	 * Deletes a single row in the FINACIAL_KEY table.
	 */
	public void delete(FinancialKeyPk pk) throws FinancialKeyDaoException;

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'ID = :id'.
	 */
	public FinancialKey findByPrimaryKey(int id) throws FinancialKeyDaoException;

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria ''.
	 */
	public List<FinancialKey> findAll() throws FinancialKeyDaoException;

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'ID = :id'.
	 */
	public List<FinancialKey> findWhereIdEquals(int id) throws FinancialKeyDaoException;

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'KEY = :key'.
	 */
	public List<FinancialKey> findWhereKeyEquals(String key) throws FinancialKeyDaoException;

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'DISPLAY_NAME = :displayName'.
	 */
	public List<FinancialKey> findWhereDisplayNameEquals(String displayName) throws FinancialKeyDaoException;

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'UI_SECTION_GROUP_KEY = :uiSectionGroupKey'.
	 */
	public List<FinancialKey> findWhereUiSectionGroupKeyEquals(String uiSectionGroupKey) throws FinancialKeyDaoException;

	/** 
	 * Returns all rows from the FINACIAL_KEY table that match the criteria 'FINACIAL_KEY_ORDER = :FinancialKeyOrder'.
	 */
	public List<FinancialKey> findWhereFinancialKeyOrderEquals(int FinancialKeyOrder) throws FinancialKeyDaoException;

	/** 
	 * Returns the rows from the FINACIAL_KEY table that matches the specified primary-key value.
	 */
	public FinancialKey findByPrimaryKey(FinancialKeyPk pk) throws FinancialKeyDaoException;

}
