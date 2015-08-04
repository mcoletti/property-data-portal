package com.codeitek.pdp.service;

import com.codeitek.pdp.cache.CacheItemKeys;
import com.codeitek.pdp.cache.CacheManager;
import com.codeitek.pdp.cache.CacheStore;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.interfaces.*;
import com.codeitek.pdp.model.*;
import com.codeitek.pdp.service.helpers.PropertyServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/27/13
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyServiceImpl extends BaseService implements PropertyService {


    private final PropertyDataDao propertyDataDao;
    private final PropertyCoreDao coreDao;
    private final PropertyServiceHelper serviceHelper;
    private PropertyDataDetailList pdfl;
    private List<PropertyData> pdl;
    private List<DataSource> dsl;

    @Autowired
    public PropertyServiceImpl(CacheManager cacheManager, PropertyCoreDao coreDao) {
        super(cacheManager);

        this.coreDao = coreDao;
        this.serviceHelper = new PropertyServiceHelper(this, coreDao);
        this.propertyDataDao = coreDao.getPropertyDataDao();
    }

    @Override
    public PropertyData addUpdatePropertyData(PropertyData propertyData, boolean update) throws DataBaseJdbcException {

        PropertyData pd;
        String propertyDataUuid = (update == true) ? propertyDataDao.update(propertyData.getUuid(), propertyData) : propertyDataDao.insert(propertyData);
        pd = propertyDataDao.findByPrimaryKey(propertyDataUuid);
        if (getCacheManager().isCacheEnabled()) {

            //TODO Add Cache Implementation to Modify PropertyData Cache Item
        }
        return pd;
    }

    @Override
    public void bulkAddUpdatePropertyData(List<PropertyData> propertyDataList, boolean update) throws DataBaseJdbcException {

        List<PropertyData> upPropertyDataList = new ArrayList<PropertyData>();
        for (PropertyData pd : propertyDataList) {
            upPropertyDataList.add(addUpdatePropertyData(pd, update));
        }
    }

    @Override
    public PropertyFinancialList getPropertyFinancials(String propertyDataUuid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyFinancialList getPropertyFinancials(String propertyDataUuid, int financialKeyId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyFinancialDetailList getPropertyFinancialDetailList(String propertyDataUuid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyFinancialDetailList getPropertyFinancialDetailList(String propertyDataUuid, int financialKeyId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addUpdatePropertyFinancials(List<PropertyFinancial> propertyFinancialList, boolean update) throws DataBaseJdbcException {

        PropertyFinancialPk pk;
        for (PropertyFinancial pf : propertyFinancialList) {
            pk = serviceHelper.addUpdateFinacial(pf, update);

            if (pk.isIdNull()) {
                throw new DataBaseJdbcException(String.format("Error Adding new Financial with value:%s for PropertyUuid of:%s", pf.getValue().toString(), pf.getPropertyDataUuid()));
            }
        }
    }

    @Override
    public void addUpdateFinancialKey(List<FinancialKey> financialKeyList) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyData addPropertyFinancialKey(PropertyFinancial propertyFinancial) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyDataDetailList getPropertyDataFeedList(String customerUuid) throws Exception {

        pdfl = new PropertyDataDetailList();

        if (getCacheManager().isCacheEnabled()) {
            pdfl = null;
        } else {
            DataSource ds = dsl.size() == 0 ? null : dsl.get(0);
            pdl = propertyDataDao.findByDataSource(ds.getId());
            serviceHelper.getPropertyDataFeedList(pdfl, pdl, ds.getName());
            dsl = coreDao.getDataSourceDao().findByCustomer(customerUuid);
        }
        return pdfl;
    }

    @Override
    public PropertyDataDetailList getPropertyDataFeedListByProperty(String propertyDataUuid) throws Exception {
        pdfl = new PropertyDataDetailList();
        PropertyData pd = propertyDataDao.findByPrimaryKey(propertyDataUuid);
        pdl = new ArrayList<PropertyData>();
        pdl.add(pd);
        DataSource ds = coreDao.getDataSourceDao().findByPrimaryKey(pd.getDataSourceId());
        serviceHelper.getPropertyDataFeedList(pdfl, pdl, ds.getName());
        return pdfl;
    }

    @Override
    public PropertyDataDetailList getPropertyDataFeedListByCity(String cityName) throws Exception {
        pdfl = new PropertyDataDetailList();
        if (!getCacheManager().isCacheEnabled()) {
            List<City> cityList = coreDao.getCityDao().findWhereCityEquals(cityName);
            City city = cityList.size() == 0 ? null : cityList.get(0);
            List<ZipCodes> zcl = coreDao.getZipCodesDao().findByCity(city.getId());
            ZipCodes zipCodes = zcl.size() == 0 ? null : zcl.get(0);
            pdl = propertyDataDao.findByZipCodes(zipCodes.getZipCode());
            DataSource ds = (pdl.size() == 0) ? null : coreDao.getDataSourceDao().findByPrimaryKey(pdl.get(0).getDataSourceId());
            serviceHelper.getPropertyDataFeedList(pdfl, pdl, ds.getName());
        } else {

            pdfl = getCacheManager().getCacheItem(CreateCacheKey(CacheItemKeys.PROP_DATA_FEED, cityName), CacheStore.PROPERTY_DATA);
        }
        return pdfl;
    }

    @Override
    public PropertyDataDetailList getPropertyDataFeedListByCity(int cityId) throws Exception {
        pdfl = new PropertyDataDetailList();
        if (!getCacheManager().isCacheEnabled()) {
            City city = coreDao.getCityDao().findByPrimaryKey(cityId);
            List<ZipCodes> zcl = coreDao.getZipCodesDao().findByCity(city.getId());
            ZipCodes zipCodes = zcl.size() == 0 ? null : zcl.get(0);
            pdl = propertyDataDao.findByZipCodes(zipCodes.getZipCode());
            DataSource ds = (pdl.size() == 0) ? null : coreDao.getDataSourceDao().findByPrimaryKey(pdl.get(0).getDataSourceId());
            serviceHelper.getPropertyDataFeedList(pdfl, pdl, ds.getName());
        } else {

            pdfl = getCacheManager().getCacheItem(CreateCacheKey(CacheItemKeys.PROP_DATA_FEED, String.valueOf(cityId)), CacheStore.PROPERTY_DATA);
        }
        return pdfl;
    }


}
