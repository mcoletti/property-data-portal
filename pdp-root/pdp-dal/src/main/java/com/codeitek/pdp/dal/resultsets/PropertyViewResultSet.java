package com.codeitek.pdp.dal.resultsets;

import com.codeitek.pdp.model.PropertyFeedView;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/4/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class PropertyViewResultSet implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

//        PropertyFeedView pvf = new PropertyFeedView();
//        pvf.setId(rs.getInt(1));
//        pvf.setCustomerUuid(rs.getString(2));
//        pvf.setPropName(rs.getString(3));
//        pvf.setPrice(rs.getFloat(4));
//        pvf.setSqft(rs.getString(5));
//        pvf.setDescription(rs.getString(6));
//        pvf.setNumBeds(rs.getFloat(7));
//        pvf.setNumBaths(rs.getFloat(8));
//        pvf.setType(rs.getString(9));
//        pvf.setStatus(rs.getString(10));
//        pvf.setDataSourceId(rs.getInt(11));
//        pvf.setCustomerUUId(rs.getString(12));
//        pvf.setDataSource(rs.getString(13));
//        pvf.setStateName(rs.getString(14));
//        pvf.setCityName(rs.getString(15));
//        pvf.setZip(rs.getInt(16));
        return null;
    }
}
