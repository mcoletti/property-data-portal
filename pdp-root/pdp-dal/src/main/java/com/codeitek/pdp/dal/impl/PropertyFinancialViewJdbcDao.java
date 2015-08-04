package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOQueries;
import com.codeitek.pdp.dal.interfaces.PropertyFinancialViewDao;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.mapper.PropertyFinancialViewRowMapper;
import com.codeitek.pdp.model.PropertyFinancialView;

import java.util.List;

/**
 * Property financial view data access object.
 *
 * @author mcoletti@gmail.com
 */
@Deprecated
public class PropertyFinancialViewJdbcDao extends SpringJdbcSupport implements PropertyFinancialViewDao {

    private static final PropertyFinancialViewRowMapper PROPERTY_FINANCIAL_VIEW_MAPPER = new PropertyFinancialViewRowMapper();

    @Override
    public List<PropertyFinancialView> selectAll() {
        return  getJdbcTemplate().query(DAOQueries.S_PROPERTY_FINANCIAL_VIEW, PROPERTY_FINANCIAL_VIEW_MAPPER);
    }

    @Override
    public List<PropertyFinancialView> selectByProperty(String propertyDataUUId) {
        return  getJdbcTemplate().query(DAOQueries.S_PROPERTY_FINANCIAL_VIEW_BY_PROPERTY, PROPERTY_FINANCIAL_VIEW_MAPPER, propertyDataUUId);
    }
}
