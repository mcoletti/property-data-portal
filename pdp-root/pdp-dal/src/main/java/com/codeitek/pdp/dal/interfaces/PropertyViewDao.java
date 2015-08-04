package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.model.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/29/13
 * Time: 5:34 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PropertyViewDao {

    public List<PropertyFeedView> selectByCustomer(String customerUUId);
    public List<PropertyFeedView> selectByUid(String customerUUId, String propertyDataUUId);
    public List<PropertyFeedView> selectByCity(String customerUUId, String city);
    public List<PropertyDataDetail> loadFullPropertyView(String customerUUId) throws Exception;
    public PropertyDataDetail loadFullPropertyViewByProperty(String customerUUId, String propertyDataUUId) throws Exception;
    public List<PropertyDataDetail> loadFullPropertyViewByCity(String customerUUId, String city) throws Exception;
    public List<PropertyDataDetail> loadFullPropertyViewByCity(String customerUUId, int cityId) throws Exception;



}
