package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/6/13
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class UiElementTypesDaoException extends DaoException {
    public UiElementTypesDaoException(String message) {
        super(message);
    }

    public UiElementTypesDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
