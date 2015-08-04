package com.codeitek.pdp.dal.resultsets;

import com.codeitek.pdp.model.StateCity;
import com.codeitek.pdp.model.StateCityView;
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
public class StateCityResultSet implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

//        StateCity sc = new StateCity();
//        sc.setState(rs.getString(1));
//        sc.setCity(rs.getString(2));
//        sc.setSummary(rs.getString(3));
//        sc.setImageUrl(rs.getString(4));
//        sc.setStateId(rs.getInt(5));
//        sc.setCityId(rs.getInt(6));
        return null;
    }
}
