package com.codeitek.pdp.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/1/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyDataDetailBuilder {

    private PropertyData propertyData;
    private List<PropertyFinancial> financialList;
    private List<PropertyImages> imagesList;



    private StateCity stateCity;
    private String state;
    private String city;
    private String dataSource;


    /**
     * Minimal Constructor
     * @param pd PropertyData
     */
    public PropertyDataDetailBuilder(PropertyData pd){
       propertyData = new PropertyData(pd.getUuid(),pd.getPropName(),pd.getPrice(),pd.getSqft(),pd.getDescription(),pd.getNumBeds(),pd.getNumBaths(),pd.getDataSourceId(),pd.getZipCode(),pd.getPropertyStatusId(),pd.getPropertyTypeId(),pd.getMarketId(),pd.getYearBuilt(),pd.getLotSize());
    }

    /**
     * Full Constructor
     * @param uuid
     * @param propName
     * @param sqft
     * @param description
     * @param price
     * @param numBeds
     * @param numBaths
     * @param dataSourceId
     * @param zip
     */
    public PropertyDataDetailBuilder(String uuid, String propName, float sqft, String description, float price, float numBeds, int propertyTypeId, int propertyStatusId, float numBaths, int dataSourceId, int zip, int marketId, int yearBuilt, float lotSize) {
       propertyData = new PropertyData(uuid,propName,price,sqft,description,numBeds,numBaths,dataSourceId,zip,propertyStatusId,propertyTypeId,marketId,yearBuilt,lotSize);
    }



    public PropertyDataDetailBuilder setFinancialList(List<PropertyFinancial> financialList) {
        this.financialList = financialList;
        return this;
    }



    public PropertyDataDetailBuilder setImageList(List<PropertyImages> imagesList){
        this.imagesList = imagesList;
        return this;
    }

    public PropertyDataDetailBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public PropertyDataDetailBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public PropertyDataDetailBuilder setStateCity(StateCity stateCity) {
        this.stateCity = stateCity;
        return this;
    }


    public PropertyDataDetailBuilder setDataSource(String dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    public PropertyDataDetailBuilder setPropertyData(PropertyData propertyData) {
        this.propertyData = propertyData;
        return this;
    }

    public PropertyDataDetail build(){

        PropertyDataDetail pf = new PropertyDataDetail(this.propertyData);
        pf.setState(this.state);
        pf.setCity(this.city);
        pf.setDataSource(this.dataSource);
        pf.setStateCity(this.stateCity);
        pf.setFinancialList(this.financialList);
        return pf;
    }
}
