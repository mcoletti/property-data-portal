package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 12:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyTypeDaoException extends DaoException {
    public PropertyTypeDaoException(String message) {
        super(message);
    }

    public PropertyTypeDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
