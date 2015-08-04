package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class GroupsDaoException extends DaoException {
    public GroupsDaoException(String message) {
        super(message);
    }

    public GroupsDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
