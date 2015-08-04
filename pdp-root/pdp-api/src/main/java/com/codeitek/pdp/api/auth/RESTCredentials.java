package com.codeitek.pdp.api.auth;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 8/1/13
 * Time: 6:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class RESTCredentials {
    private String requestSalt;
    private String secureHash;

    private RESTCredentials() {
    }

    public RESTCredentials(String requestSalt, String secureHash) {
        this.requestSalt = requestSalt;
        this.secureHash = secureHash;
    }

    public String getRequestSalt() {
        return requestSalt;
    }

    public String getSecureHash() {
        return secureHash;
    }
}
