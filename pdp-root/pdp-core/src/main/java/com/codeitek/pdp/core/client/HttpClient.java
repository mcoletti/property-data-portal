package com.codeitek.pdp.core.client;

import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/16/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface HttpClient {

    public ClientResponse get(String type, String path, MultivaluedMap<String, String> parameters);
    public <T> ClientResponse post(String type, String path, MultivaluedMap<String, String> parameters, T item);
    public ClientResponse delete(String type, String path, MultivaluedMap<String, String> parameters);
    public <T> ClientResponse put(String type, String path, MultivaluedMap<String, String> parameters, T item);
}
