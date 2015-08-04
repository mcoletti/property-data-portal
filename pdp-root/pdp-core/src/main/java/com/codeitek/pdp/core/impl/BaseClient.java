package com.codeitek.pdp.core.impl;

import com.sun.jersey.api.client.ClientResponse;
import com.codeitek.pdp.core.client.HttpClient;
import com.codeitek.pdp.core.client.TalonClient;

import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/23/13
 * Time: 3:38 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseClient implements TalonClient {


    protected HttpClient httpClient;
    protected ClientResponse response;

    protected BaseClient(HttpClient httpClient) {

        this.httpClient =httpClient;

    }
}
