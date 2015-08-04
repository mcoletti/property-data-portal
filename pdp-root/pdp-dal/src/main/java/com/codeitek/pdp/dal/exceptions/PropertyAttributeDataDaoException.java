package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyAttributeDataDaoException extends DaoException {
    public PropertyAttributeDataDaoException(String message) {
        super(message);
    }

    public PropertyAttributeDataDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
