package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 12:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class ZipCodesDaoException extends DaoException {
    public ZipCodesDaoException(String message) {
        super(message);
    }

    public ZipCodesDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
