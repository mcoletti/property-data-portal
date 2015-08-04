package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.model.PropertyFinancial;
import com.codeitek.pdp.model.PropertyFinancialView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/7/13
 * Time: 4:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public interface PropertyFinancialViewDao {


    public List<PropertyFinancialView> selectAll();
    public List<PropertyFinancialView> selectByProperty(String propertyDataUUId);



}
