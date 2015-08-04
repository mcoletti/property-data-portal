package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/6/13
 * Time: 1:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class UiSectionsDaoException extends DaoException {
    public UiSectionsDaoException(String message) {
        super(message);
    }

    public UiSectionsDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
