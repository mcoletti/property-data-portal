package com.codeitek.pdp.dal.resultsets;

import com.codeitek.pdp.model.City;
import com.codeitek.pdp.model.StateCity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/10/13
 * Time: 8:01 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class CityResultSet implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {


        return null;
    }
}
