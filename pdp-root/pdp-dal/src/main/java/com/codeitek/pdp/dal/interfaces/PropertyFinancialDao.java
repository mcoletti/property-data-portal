package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.PropertyFinancial;
import com.codeitek.pdp.model.PropertyFinancialPk;

import java.math.BigDecimal;
import java.util.List;

public interface PropertyFinancialDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return PropertyFinancialPk
	 */
	public PropertyFinancialPk insert(PropertyFinancial dto);

	/** 
	 * Updates a single row in the PROPERTY_FINACIAL table.
	 */
	public PropertyFinancialPk update(PropertyFinancialPk pk, PropertyFinancial dto) throws DataBaseJdbcException;

	/** 
	 * Deletes a single row in the PROPERTY_FINACIAL table.
	 */
	public void delete(PropertyFinancialPk pk) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria 'ID = :id'.
	 */
	public PropertyFinancial findByPrimaryKey(int id) throws DataBaseJdbcException;


	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria ''.
	 */
	public List<PropertyFinancial> findAll() throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria 'ID = :id'.
	 */
	public List<PropertyFinancial> findWhereIdEquals(int id) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria 'VALUE = :value'.
	 */
	public List<PropertyFinancial> findWhereValueEquals(BigDecimal value) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria 'FINACIAL_KEY_ID = :finacialKeyId'.
	 */
	public List<PropertyFinancial> findWhereFinacialKeyIdEquals(int finacialKeyId) throws DataBaseJdbcException;

	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria 'PROPERTY_DATA_UUID = :propertyDataUuid'.
	 */
	public List<PropertyFinancial> findWherePropertyDataUuidEquals(String propertyDataUuid) throws DataBaseJdbcException;


	/**
	 * Returns the rows from the PROPERTY_FINACIAL table that matches the specified primary-key value.
	 */
	public PropertyFinancial findByPrimaryKey(PropertyFinancialPk pk) throws DataBaseJdbcException;

}
