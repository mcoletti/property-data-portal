package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/25/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "propertyDataView")
@Deprecated
public class PropertyFeedView extends PropertyData implements Serializable {


    private String customerUUId;
    private String dataSource;
    private String city;
    private String state;

    /**
     * Default Constructor
     */
    public PropertyFeedView() {
    }



    public String getCustomerUUId() {
        return customerUUId;
    }

    public void setCustomerUUId(String customerUUId) {
        this.customerUUId = customerUUId;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
