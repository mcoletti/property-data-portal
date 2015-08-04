package com.codeitek.pdp.ui.common;

import com.codeitek.pdp.model.PropertyDataDetailList;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.codeitek.pdp.core.client.HttpClient;
import com.codeitek.pdp.core.impl.HttpClientImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/16/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApiService {

    private HttpClient httpClient;

    public ApiService(String apiServiceUrl) {
        httpClient = new HttpClientImpl(apiServiceUrl);
    }


    public PropertyDataDetailList getPropertiesFeed() {

        ClientResponse response = httpClient.get(MediaType.APPLICATION_XML, "", null);
        return response.getEntity(PropertyDataDetailList.class);
    }
    public PropertyDataDetailList getPropertiesFeed(String customer) {


        MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
        parameters.add("customer",customer);



        ClientResponse response = httpClient.get(MediaType.APPLICATION_XML, "", null);
        return response.getEntity(PropertyDataDetailList.class);
    }


}
