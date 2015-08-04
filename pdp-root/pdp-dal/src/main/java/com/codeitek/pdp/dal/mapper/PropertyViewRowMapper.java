package com.codeitek.pdp.dal.mapper;

import com.codeitek.pdp.dal.resultsets.PropertyViewResultSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/3/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyViewRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {

        PropertyViewResultSet propertyViewResultSet = new PropertyViewResultSet();
        return propertyViewResultSet.extractData(rs);
    }
}
