package com.codeitek.pdp.service;

import com.codeitek.pdp.dal.interfaces.*;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/27/13
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PropertyCoreDao {

    public AttributesDao getAttributesDao();
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
}
