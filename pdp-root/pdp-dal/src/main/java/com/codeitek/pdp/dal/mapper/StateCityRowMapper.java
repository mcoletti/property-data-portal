package com.codeitek.pdp.dal.mapper;

import com.codeitek.pdp.dal.resultsets.StateCityResultSet;
import com.codeitek.pdp.dal.resultsets.StateCityViewResultSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/10/13
 * Time: 8:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class StateCityRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        StateCityResultSet detailResultSet = new StateCityResultSet();
        return detailResultSet.extractData(resultSet);
    }
}
