package com.codeitek.pdp.dal.mapper;

import com.codeitek.pdp.dal.resultsets.PropertyFinancialViewResultSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/7/13
 * Time: 4:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyFinancialViewRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        PropertyFinancialViewResultSet financialViewResultSet = new PropertyFinancialViewResultSet();
        return financialViewResultSet.extractData(resultSet);
    }
}
