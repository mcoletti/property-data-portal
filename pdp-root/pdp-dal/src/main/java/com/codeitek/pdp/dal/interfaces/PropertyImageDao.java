package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.model.PropertyImageData;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/7/13
 * Time: 4:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public interface PropertyImageDao {


    public List<PropertyImageData> selectAll();
    public List<PropertyImageData> selectByProperty(int propertyDataId);

}
