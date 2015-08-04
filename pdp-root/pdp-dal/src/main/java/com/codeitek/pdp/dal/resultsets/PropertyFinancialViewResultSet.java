package com.codeitek.pdp.dal.resultsets;

import com.codeitek.pdp.model.PropertyFinancialView;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/7/13
 * Time: 4:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyFinancialViewResultSet implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        PropertyFinancialView pf = new PropertyFinancialView();
        pf.setId(rs.getInt(1));
        pf.setPropertyDataUuid(rs.getString(2));
        pf.setValue(rs.getBigDecimal(3));
        pf.setFinancialKey(rs.getString(4));
        pf.setFinancialKeyId(rs.getInt(5));
        pf.setDisplayName(rs.getString(6));
        return pf;
    }
}
