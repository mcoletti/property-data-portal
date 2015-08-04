package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.interfaces.*;
import com.codeitek.pdp.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 2:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class PdpJdbcDaoService implements PdpDaoService {


    private final AttributesDao attributesDao;
    private final CustomerDao customerDao;
    private final DataSourceDao dataSourceDao;
    private final CustomerAttributesDao customerAttributesDao;
    private final StateDao stateDao;
    private final CityDao cityDao;
    private final ZipCodesDao zipCodesDao;
    private final PropertyDataDao propertyDataDao;
    private final PropertyTypeDao propertyTypeDao;
    private final PropertyStatusMapDao propertyStatusDao;
    private final PropertyFinancialDao propertyFinancialDao;
    private final FinancialKeyDao financialKeyDao;
    private final PropertyImagesDao propertyImagesDao;
    private final PropertyAttributesDao propertyAttributesDao;
    private final PropertyAttributeDataDao propertyAttributeDataDao;

    @Autowired
    public PdpJdbcDaoService(AttributesDao attributesDao, CustomerDao customerDao, DataSourceDao dataSourceDao, CustomerAttributesDao customerAttributesDao, StateDao stateDao, CityDao cityDao, ZipCodesDao zipCodesDao, PropertyDataDao propertyDataDao, PropertyTypeDao propertyTypeDao, PropertyStatusMapDao propertyStatusDao, PropertyFinancialDao propertyFinancialDao, FinancialKeyDao financialKeyDao, PropertyImagesDao propertyImagesDao, PropertyAttributesDao propertyAttributesDao, PropertyAttributeDataDao propertyAttributeDataDao) {
        this.attributesDao = attributesDao;
        this.customerDao = customerDao;
        this.dataSourceDao = dataSourceDao;
        this.customerAttributesDao = customerAttributesDao;
        this.stateDao = stateDao;
        this.cityDao = cityDao;
        this.zipCodesDao = zipCodesDao;
        this.propertyDataDao = propertyDataDao;
        this.propertyTypeDao = propertyTypeDao;
        this.propertyStatusDao = propertyStatusDao;
        this.propertyFinancialDao = propertyFinancialDao;
        this.financialKeyDao = financialKeyDao;
        this.propertyImagesDao = propertyImagesDao;
        this.propertyAttributesDao = propertyAttributesDao;
        this.propertyAttributeDataDao = propertyAttributeDataDao;
    }

    @Override
    public AttributesDao getAttributesDao() {
        return attributesDao;
    }
    @Override
    public CustomerDao getCustomerDao() {
        return customerDao;
    }
    @Override
    public CustomerAttributesDao getCustomerAttributesDao() {
        return customerAttributesDao;
    }
    @Override
    public StateDao getStateDao() {
        return stateDao;
    }
    @Override
    public CityDao getCityDao() {
        return cityDao;
    }
    @Override
    public ZipCodesDao getZipCodesDao() {
        return zipCodesDao;
    }
    @Override
    public PropertyDataDao getPropertyDataDao() {
        return propertyDataDao;
    }
    @Override
    public PropertyTypeDao getPropertyTypeDao() {
        return propertyTypeDao;
    }
    @Override
    public PropertyStatusMapDao getPropertyStatusDao() {
        return propertyStatusDao;
    }
    @Override
    public PropertyFinancialDao getPropertyFinancialDao() {
        return propertyFinancialDao;
    }
    @Override
    public FinancialKeyDao getFinancialKeyDao() {
        return financialKeyDao;
    }
    @Override
    public PropertyImagesDao getPropertyImagesDao() {
        return propertyImagesDao;
    }
    @Override
    public PropertyAttributesDao getPropertyAttributesDao() {
        return propertyAttributesDao;
    }
    @Override
    public PropertyAttributeDataDao getPropertyAttributeDataDao() {
        return propertyAttributeDataDao;
    }

    @Override
    public DataSourceDao getDataSourceDao() {
        return dataSourceDao;
    }

    @Override
    public List<StateCity> getStateCityList(String customerUuid) throws Exception{
        List<StateCity> stateCityList = new ArrayList<StateCity>();
        List<DataSource> dataSources = dataSourceDao.findByCustomer(customerUuid);
        DataSource ds = dataSources.size() == 0 ? null : dataSources.get(0);
        setStateCityList(ds,stateCityList);
        return stateCityList;
    }
    private void setStateCityList(DataSource ds,List<StateCity> stateCityList) throws Exception{

        ZipCodes zipCodes;
        City city;
        State state;
        StateCity stateCity;
        for (PropertyData pd : propertyDataDao.findByDataSource(ds.getId())){
            zipCodes = zipCodesDao.findByPrimaryKey(pd.getZipCode());
            city = cityDao.findByPrimaryKey(zipCodes.getCityId());
            state = stateDao.findByPrimaryKey(city.getStateId());
            stateCity = new StateCity(state,city);
            stateCityList.add(stateCity);
        }


    }
}
