package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserAttributesDaoException extends DaoException {
    public UserAttributesDaoException(String message) {
        super(message);
    }

    public UserAttributesDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
