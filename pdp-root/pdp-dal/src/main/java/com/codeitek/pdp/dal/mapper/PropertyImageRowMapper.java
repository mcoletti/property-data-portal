package com.codeitek.pdp.dal.mapper;

import com.codeitek.pdp.dal.resultsets.PropertyImageResultSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/7/13
 * Time: 4:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyImageRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        PropertyImageResultSet imageResultSet = new PropertyImageResultSet();
        return imageResultSet.extractData(resultSet);

    }
}
