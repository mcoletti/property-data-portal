package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.model.PropertyDataDetailList;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 3:36 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public interface PropertyService extends PropertyDataDao {

    public PropertyDataDetailList getPropertyDataFeedList(String customerUuid) throws  Exception;
    public PropertyDataDetailList getPropertyDataFeedList(String customerUuid,String propertyDataUuid) throws Exception;
    public PropertyDataDetailList getPropertyDataFeedListByCity(String customerUuid,String cityName) throws Exception;
    public PropertyDataDetailList getPropertyDataFeedListByCity(String customerUuid,int cityId) throws Exception;
    public PdpDaoService getPdpDaoService();



}
