package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/13/13
 * Time: 3:21 AM
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "propertyDataDetail")
public class PropertyDataDetail extends PropertyData implements Serializable {

    /**
     * Default
     */

    private String state;
    private String city;
    private StateCity stateCity;
    private List<PropertyFinancial> financialList;
    private String customerUUId;
    private String dataSource;

    /**
     * Default Constructor
     */
    public PropertyDataDetail() {

    }


    /**
     * Minimal Constructor
     * @param pd
     */
    public PropertyDataDetail(PropertyData pd) {
        super(pd.getUuid(),pd.getPropName(),pd.getPrice(),pd.getSqft(),pd.getDescription(),pd.getNumBeds(),pd.getNumBaths(),pd.getDataSourceId(),pd.getZipCode(),pd.getPropertyStatusId(),pd.getPropertyTypeId(),pd.getMarketId(),pd.getYearBuilt(),pd.getLotSize());
    }

    /**
     * Full Constructor
     * @param uuid
     * @param propName
     * @param price
     * @param sqft
     * @param description
     * @param numBeds
     * @param numBaths
     * @param dataSourceId
     * @param zipCode
     * @param propertyStatusId
     * @param propertyTypeId
     * @param state
     * @param city
     * @param stateCity
     * @param financialList
     * @param customerUUId
     * @param dataSource
     */
    public PropertyDataDetail(String uuid, String propName, float price, float sqft, String description, float numBeds, float numBaths, int dataSourceId, int zipCode, int propertyStatusId, int propertyTypeId, String state, String city, StateCity stateCity, List<PropertyFinancial> financialList, String customerUUId, String dataSource,int marketId, int yearBuilt, float lotSize) {
        super(uuid,propName,price,sqft,description,numBeds,numBaths,dataSourceId,zipCode,propertyStatusId,propertyTypeId,marketId,yearBuilt,lotSize);
        this.state = state;
        this.city = city;
        this.stateCity = stateCity;
        this.financialList = financialList;
        this.customerUUId = customerUUId;
        this.dataSource = dataSource;
    }

    @XmlElement
    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @XmlElement
    public String getCustomerUUId() {
        return customerUUId;
    }

    public void setCustomerUUId(String customerUUId) {
        this.customerUUId = customerUUId;
    }


    @XmlElement
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlElement
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    @XmlElement
    public StateCity getStateCity() {
        return stateCity;
    }

    public void setStateCity(StateCity stateCity) {
        this.stateCity = stateCity;
    }

    @XmlElement
    public List<PropertyFinancial> getFinancialList() {
        return financialList;
    }

    public void setFinancialList(List<PropertyFinancial> financialList) {
        this.financialList = financialList;
    }
}
