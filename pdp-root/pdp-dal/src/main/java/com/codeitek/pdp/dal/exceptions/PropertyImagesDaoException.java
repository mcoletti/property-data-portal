package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyImagesDaoException extends DaoException {
    public PropertyImagesDaoException(String message) {
        super(message);
    }

    public PropertyImagesDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
