package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyAttributesDaoException extends DaoException {
    public PropertyAttributesDaoException(String message) {
        super(message);
    }

    public PropertyAttributesDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
