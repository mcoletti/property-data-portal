package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 9:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class VwUserRolesDaoException extends DaoException {
    public VwUserRolesDaoException(String message) {
        super(message);
    }

    public VwUserRolesDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
