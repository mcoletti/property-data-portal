package com.codeitek.pdp.core.impl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/16/13
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpClientImpl implements com.codeitek.pdp.core.client.HttpClient {

    private final WebResource resource;

    public HttpClientImpl(String serviceUri) {
        DefaultClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(ClientConfig.FEATURE_DISABLE_XML_SECURITY, true);

        Client client = Client.create(config);
        resource = client.resource(serviceUri);

    }

    @Override
    public ClientResponse get(String type, String path, MultivaluedMap<String, String> parameters) {

        WebResource wr = resource.path(path);

        if(parameters != null) {
            wr = wr.queryParams(parameters);
        }

        return wr.type(type).get(ClientResponse.class);
    }

    @Override
    public <T> ClientResponse post(String type, String path, MultivaluedMap<String, String> parameters, T item) {

        WebResource wr = resource.path(path);

        if(parameters != null) {
            wr = wr.queryParams(parameters);
        }

        return wr.type(type).post(ClientResponse.class, item);
    }

    @Override
    public ClientResponse delete(String type, String path, MultivaluedMap<String, String> parameters) {

        WebResource wr = resource.path(path);

        if(parameters != null) {
            wr = wr.queryParams(parameters);
        }

        return wr.type(type).delete(ClientResponse.class);
    }

    @Override
    public <T> ClientResponse put(String type, String path, MultivaluedMap<String, String> parameters, T item) {

        WebResource wr = resource.path(path);

        if(parameters != null) {
            wr = wr.queryParams(parameters);
        }

        return wr.type(type).put(ClientResponse.class, item);
    }
}
