package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.exceptions.ZipCodesDaoException;
import com.codeitek.pdp.model.ZipCodes;
import com.codeitek.pdp.model.ZipCodesPk;

import java.util.List;

public interface ZipCodesDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return ZipCodesPk
	 */
	public ZipCodesPk insert(ZipCodes dto);

	/** 
	 * Updates a single row in the ZIP_CODES table.
	 */
	public void update(ZipCodesPk pk, ZipCodes dto) throws ZipCodesDaoException;

	/** 
	 * Deletes a single row in the ZIP_CODES table.
	 */
	public void delete(ZipCodesPk pk) throws ZipCodesDaoException;

	/** 
	 * Returns all rows from the ZIP_CODES table that match the criteria 'ZIP_CODE = :zipCode'.
	 */
	public ZipCodes findByPrimaryKey(int zipCode) throws ZipCodesDaoException;

	/** 
	 * Returns all rows from the ZIP_CODES table that match the criteria ''.
	 */
	public List<ZipCodes> findAll() throws ZipCodesDaoException;

	/** 
	 * Returns all rows from the ZIP_CODES table that match the criteria 'CITY_ID = :cityId'.
	 */
	public List<ZipCodes> findByCity(int cityId) throws ZipCodesDaoException;

	/** 
	 * Returns all rows from the ZIP_CODES table that match the criteria 'ZIP_CODE = :zipCode'.
	 */
	public List<ZipCodes> findWhereZipCodeEquals(int zipCode) throws ZipCodesDaoException;

	/** 
	 * Returns all rows from the ZIP_CODES table that match the criteria 'CITY_ID = :cityId'.
	 */
	public List<ZipCodes> findWhereCityIdEquals(int cityId) throws ZipCodesDaoException;

	/** 
	 * Returns the rows from the ZIP_CODES table that matches the specified primary-key value.
	 */
	public ZipCodes findByPrimaryKey(ZipCodesPk pk) throws ZipCodesDaoException;

}
