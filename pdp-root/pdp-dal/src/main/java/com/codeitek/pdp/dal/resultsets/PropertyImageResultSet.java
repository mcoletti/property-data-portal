package com.codeitek.pdp.dal.resultsets;

import com.codeitek.pdp.model.PropertyImageData;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/7/13
 * Time: 4:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyImageResultSet implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

        PropertyImageData pid = new PropertyImageData();
        pid.setId(rs.getInt(1));
        pid.setImageTitle(rs.getString(2));
        pid.setImageType(rs.getString(3));
        pid.setImageUrl(rs.getString(5));
        pid.setPropertyDataId(rs.getInt(6));
        return pid;
    }
}
