package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/24/13
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class StateDaoException extends DaoException {
    public StateDaoException(String message) {
        super(message);
    }

    public StateDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
