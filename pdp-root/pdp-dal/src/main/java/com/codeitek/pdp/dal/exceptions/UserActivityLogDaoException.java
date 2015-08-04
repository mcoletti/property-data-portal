package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserActivityLogDaoException extends DaoException {
    public UserActivityLogDaoException(String message) {
        super(message);
    }

    public UserActivityLogDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
