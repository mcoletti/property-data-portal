package com.codeitek.pdp.dal.resultsets;

import com.codeitek.pdp.model.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/7/13
 * Time: 5:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class CustomerResultsSet implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {


//        Customer c = new Customer();
//        c.setId(rs.getInt(1));
//        c.setCustomerUuid(rs.getString(2));
//        c.setCustName(rs.getString(3));
//        c.setEnabled(rs.getBoolean(4));
//        c.setFullName(rs.getString(5));
        return null;
    }
}
