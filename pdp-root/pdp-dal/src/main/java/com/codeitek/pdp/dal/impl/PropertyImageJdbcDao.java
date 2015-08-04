package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOQueries;
import com.codeitek.pdp.dal.interfaces.PropertyImageDao;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.mapper.PropertyImageRowMapper;
import com.codeitek.pdp.model.PropertyImageData;

import java.util.List;

/**
 * Property image data access object.
 *
 * @author mcoletti@gmail.com
 */
@Deprecated
public class PropertyImageJdbcDao extends SpringJdbcSupport implements PropertyImageDao {

    private static final PropertyImageRowMapper PROPERTY_IMAGE_MAPPER = new PropertyImageRowMapper();

    @Override
    public List<PropertyImageData> selectAll() {
        return  getJdbcTemplate().query(DAOQueries.Q_PROPERTY_IMAGE_DATA, PROPERTY_IMAGE_MAPPER);
    }

    @Override
    public List<PropertyImageData> selectByProperty(int propertyDataId) {
        return  getJdbcTemplate().query(DAOQueries.Q_PROPERTY_IMAGE_DATA_BY_PROPERTY, PROPERTY_IMAGE_MAPPER, propertyDataId);
    }
}
