package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOQueries;
import com.codeitek.pdp.dal.DAOTableRef;
import com.codeitek.pdp.dal.interfaces.PropertyFinancialDao;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import java.math.BigDecimal;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.PropertyFinancial;
import com.codeitek.pdp.model.PropertyFinancialPk;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class PropertyFinancialJdbcDao extends SpringJdbcSupport implements ParameterizedRowMapper<PropertyFinancial>, PropertyFinancialDao
{

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(PropertyFinancialJdbcDao.class);
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return PropertyFinancialPk
	 */
	@Transactional
	public PropertyFinancialPk insert(PropertyFinancial dto)
	{
		getJdbcTemplate().update(DAOQueries.I_PROP_FINANCIAL,dto.getValue(),dto.getFinancialKeyId(),dto.getPropertyDataUuid());
		PropertyFinancialPk pk = new PropertyFinancialPk();
		pk.setId( getJdbcTemplate().queryForInt("select last_insert_id()") );
		return pk;
	}

	/** 
	 * Updates a single row in the PROPERTY_FINACIAL table.
	 */
	@Transactional
	public PropertyFinancialPk update(PropertyFinancialPk pk, PropertyFinancial dto) throws DataBaseJdbcException
	{
		getJdbcTemplate().update(DAOQueries.U_PROP_FINANCIAL,dto.getId(),dto.getValue(),dto.getFinancialKeyId(),dto.getPropertyDataUuid(),pk.getId());
        return pk;
	}

	/** 
	 * Deletes a single row in the PROPERTY_FINACIAL table.
	 */
	@Transactional
	public void delete(PropertyFinancialPk pk) throws DataBaseJdbcException
	{
		getJdbcTemplate().update(DAOQueries.D_PROP_FINANCIAL,pk.getId());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws java.sql.SQLException
	 * @return PropertyFinancial
	 */
	public PropertyFinancial mapRow(ResultSet rs, int row) throws SQLException
	{
		PropertyFinancial dto = new PropertyFinancial();
		dto.setId( rs.getInt( 1 ) );
		dto.setValue( rs.getBigDecimal(2));
		dto.setFinancialKeyId( rs.getInt( 3 ) );
		dto.setPropertyDataUuid( rs.getString( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return DAOTableRef.PROP_FINANCIAL;
	}

	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public PropertyFinancial findByPrimaryKey(int id) throws DataBaseJdbcException
	{
		try {
			List<PropertyFinancial> list = getJdbcTemplate().query(DAOQueries.Q_PROPERTY_FINANCIAL_BY_ID, this,id);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/**
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria ''.
	 */
	@Transactional
	public List<PropertyFinancial> findAll() throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.S_PROPERTY_FINANCIAL, this);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}


	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria 'ID = :id'.
	 */
	@Transactional
	public List<PropertyFinancial> findWhereIdEquals(int id) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PROPERTY_FINANCIAL_BY_ID, this,id);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria 'VALUE = :value'.
	 */
	@Transactional
	public List<PropertyFinancial> findWhereValueEquals(BigDecimal value) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PROPERTY_FINANCIAL_BY_VALUE, this,value);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria 'FINACIAL_KEY_ID = :finacialKeyId'.
	 */
	@Transactional
	public List<PropertyFinancial> findWhereFinacialKeyIdEquals(int finacialKeyId) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PROPERTY_FINANCIAL_BY_FINANCIAL_KEY_ID, this,finacialKeyId);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the PROPERTY_FINACIAL table that match the criteria 'PROPERTY_DATA_UUID = :propertyDataUuid'.
	 */
	@Transactional
	public List<PropertyFinancial> findWherePropertyDataUuidEquals(String propertyDataUuid) throws DataBaseJdbcException
	{
		try {
			return getJdbcTemplate().query(DAOQueries.Q_PROPERTY_FINANCIAL_BY_PROPERTY, this,propertyDataUuid);
		}
		catch (Exception e) {
			throw new DataBaseJdbcException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the PROPERTY_FINACIAL table that matches the specified primary-key value.
	 */
	public PropertyFinancial findByPrimaryKey(PropertyFinancialPk pk) throws DataBaseJdbcException
	{
		return findByPrimaryKey( pk.getId() );
	}

}
