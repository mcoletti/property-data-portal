package com.codeitek.pdp.core.impl;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/19/13
 * Time: 5:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class TalonClientException extends Exception {

    public TalonClientException() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public TalonClientException(String message) {
        super(message);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public TalonClientException(String message, Throwable cause) {
        super(message, cause);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public TalonClientException(Throwable cause) {
        super(cause);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
