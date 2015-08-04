package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/26/13
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataBaseJdbcException extends DaoException {
    public DataBaseJdbcException(String message) {
        super(message);
    }

    public DataBaseJdbcException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
