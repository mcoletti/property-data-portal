package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.dal.FilterBy;
import com.codeitek.pdp.model.CustomerList;
import com.codeitek.pdp.model.PropertyDataDetail;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/12/13
 * Time: 7:23 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public interface IFeedDataAdapter {



    public List<PropertyDataDetail> getPropertyFeed(String customerUUId);
    public List<PropertyDataDetail> getPropertyFeed(String customerUUId,String testProperty,FilterBy filterBy);
    public CustomerList getCustomerList(FilterBy filterBy);
    public CustomerList getCustomerList(String value,FilterBy filterBy);


    public ResultSet executeProcedure(String sql,String... params);

    List<String> getPropertyList(String customerUUId);
}
