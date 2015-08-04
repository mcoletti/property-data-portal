package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyStatusDaoException extends DaoException {
    public PropertyStatusDaoException(String message) {
        super(message);
    }

    public PropertyStatusDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
