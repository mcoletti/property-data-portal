package com.codeitek.pdp.service;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/27/13
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PropertyService {

    public PropertyData addUpdatePropertyData(PropertyData propertyData,boolean update) throws DataBaseJdbcException;
    public void bulkAddUpdatePropertyData(List<PropertyData> propertyDataList,boolean update) throws DataBaseJdbcException;
    public PropertyFinancialList getPropertyFinancials(String propertyDataUuid);
    public PropertyFinancialList getPropertyFinancials(String propertyDataUuid,int financialKeyId);
    public PropertyFinancialDetailList getPropertyFinancialDetailList(String propertyDataUuid);
    public PropertyFinancialDetailList getPropertyFinancialDetailList(String propertyDataUuid,int financialKeyId);
    public void addUpdatePropertyFinancials(List<PropertyFinancial> propertyFinancialList,boolean update) throws DataBaseJdbcException;
    public void addUpdateFinancialKey(List<FinancialKey> financialKeyList);
    public PropertyData addPropertyFinancialKey(PropertyFinancial propertyFinancial);
    public PropertyDataDetailList getPropertyDataFeedList(String customerUuid) throws  Exception;
    public PropertyDataDetailList getPropertyDataFeedListByProperty(String propertyDataUuid) throws Exception;
    public PropertyDataDetailList getPropertyDataFeedListByCity(String cityName) throws Exception;
    public PropertyDataDetailList getPropertyDataFeedListByCity(int cityId) throws Exception;
}
