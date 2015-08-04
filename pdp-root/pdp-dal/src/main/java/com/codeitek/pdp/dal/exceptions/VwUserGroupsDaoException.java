package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class VwUserGroupsDaoException extends DaoException {
    public VwUserGroupsDaoException(String message) {
        super(message);
    }

    public VwUserGroupsDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
