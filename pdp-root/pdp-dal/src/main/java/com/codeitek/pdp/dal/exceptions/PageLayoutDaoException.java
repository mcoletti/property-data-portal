package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/6/13
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageLayoutDaoException extends DaoException {
    public PageLayoutDaoException(String message) {
        super(message);
    }

    public PageLayoutDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
