package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.model.StateCity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/6/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PdpDaoService {


    public AttributesDao getAttributesDao();
    public CustomerDao getCustomerDao();
    public CustomerAttributesDao getCustomerAttributesDao();
    public StateDao getStateDao();
    public CityDao getCityDao();
    public ZipCodesDao getZipCodesDao();
    public PropertyTypeDao getPropertyTypeDao();
    public PropertyStatusMapDao getPropertyStatusDao();
    public PropertyDataDao getPropertyDataDao();
    public PropertyFinancialDao getPropertyFinancialDao();
    public FinancialKeyDao getFinancialKeyDao();
    public PropertyImagesDao getPropertyImagesDao();
    public PropertyAttributesDao getPropertyAttributesDao();
    public PropertyAttributeDataDao getPropertyAttributeDataDao();
    public DataSourceDao getDataSourceDao();
    public List<StateCity> getStateCityList(String customerUuid) throws Exception;






}
