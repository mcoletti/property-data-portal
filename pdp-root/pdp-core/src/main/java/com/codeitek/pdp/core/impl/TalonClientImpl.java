package com.codeitek.pdp.core.impl;

import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.apache.commons.lang.NotImplementedException;
import com.codeitek.pdp.core.client.HttpClient;
import com.codeitek.pdp.core.client.TalonClient;
import com.codeitek.pdp.model.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

import static javax.ws.rs.core.Response.Status;

/**
 * pdp web service client.
 *
 * @author mcoletti@gmail.com wchoules@gmail.com
 */
public class TalonClientImpl extends BaseClient implements TalonClient {

    public TalonClientImpl(HttpClient httpClient) {
        super(httpClient);
    }

    @Override
    public PropertyDataDetailList getPropertyFeed(String customUId) {
        String url = String.format(ApiConstants.PROPERTY_FEED + "/customer/%s",customUId);
        response = httpClient.get(MediaType.APPLICATION_XML, url,null);
        PropertyDataDetailList list = response.getEntity(PropertyDataDetailList.class);
        return list;
    }

    @Override
    public PropertyDataDetail getPropertyFeedByProperty(String customUId, String propertyUId) {
        String url = String.format(ApiConstants.PROPERTY_FEED + "/customer/%s/property/%s",customUId,propertyUId);
        response = httpClient.get(MediaType.APPLICATION_XML, url,null);
        PropertyDataDetail pf = response.getEntity(PropertyDataDetail.class);
        return pf;
    }

    @Override
    public PropertyDataDetailList getPropertyFeedByCity(String customerUUid, int cityId) {
        String url = String.format(ApiConstants.PROPERTY_FEED + "/customer/%s/cityId/%s",customerUUid, cityId);
        response = httpClient.get(MediaType.APPLICATION_XML, url,null);
        PropertyDataDetailList pfl = response.getEntity(PropertyDataDetailList.class);
        return pfl;
    }

    @Override
    public PropertyDataDetailList getPropertyFeedByCity(String customerUUid, String city) {
        String url = String.format(ApiConstants.PROPERTY_FEED + "/customer/%s/cityName/%s",customerUUid,city);
        response = httpClient.get(MediaType.APPLICATION_XML, url,null);
        PropertyDataDetailList pfl = response.getEntity(PropertyDataDetailList.class);
        return pfl;
    }

    @Override
    public CustomerList getCustomerList() {
        response = httpClient.get(MediaType.APPLICATION_XML, ApiConstants.ADMIN_MP + "/customer/list",null);
        CustomerList list = response.getEntity(CustomerList.class);
        return list;
    }

    @Override
    public Customer getCustomer(String customerName) {
        response = httpClient.get(MediaType.APPLICATION_XML, ApiConstants.ADMIN_MP + "/customer/customerName/" + customerName,null);
        Customer customer = response.getEntity(Customer.class);
        return customer;
    }

    @Override
    public Customer getCustomerByUUId(String customerUUId) {

        response = httpClient.get(MediaType.APPLICATION_XML, ApiConstants.ADMIN_MP + "/customer/customerUuid/" + customerUUId,null);
        Customer customer = response.getEntity(Customer.class);
        return customer;
    }

    @Override
    public List<StateCity> getStateCityList(String customerUUId) {


        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        parameters.add("customerUUId",customerUUId);
        response = httpClient.get(MediaType.APPLICATION_XML, ApiConstants.ADMIN_MP + "/stateCity/customer",parameters);
        StateCityList stateCityList = response.getEntity(StateCityList.class);
        return stateCityList.getList();
    }

    @Override
    public City getCity(int cityId) {
        throw new NotImplementedException();
    }

    @Override
    public List<StateCity> getStateCity(String city) {
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        parameters.add("cityName",city);
        response = httpClient.get(MediaType.APPLICATION_XML, ApiConstants.ADMIN_MP + "/stateCity/cityName",parameters);
        StateCityList stateCityList = response.getEntity(StateCityList.class);
        return stateCityList.getList();
    }
    @Override
    public List<StateCityView> getStateCity(int zipCode) {
        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        parameters.add("zip",String.valueOf(zipCode));
        response = httpClient.get(MediaType.APPLICATION_XML, ApiConstants.ADMIN_MP + "/stateCity/zip",parameters);
        StateCityViewList stateCityViewList = response.getEntity(StateCityViewList.class);
        return stateCityViewList.getList();
    }

    @Override
    public List<Pagelayout> getPageLayout(String pageName) throws TalonClientException{
        response = httpClient.get(MediaType.APPLICATION_XML, ApiConstants.ADMIN_MP + "/pageLayout/page/" + pageName,null);


        if (response.getStatus() != Status.ACCEPTED.getStatusCode()){
              throw new TalonClientException(String.format("Error Getting Page Layout for Page:%s Response Status Code from API:%s",pageName,response.getStatus()));
        }

        PageLayoutList pageLayoutList = response.getEntity(PageLayoutList.class);
        return pageLayoutList.getList();
    }
}
