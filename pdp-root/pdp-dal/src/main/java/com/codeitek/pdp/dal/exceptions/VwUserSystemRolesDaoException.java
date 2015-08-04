package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class VwUserSystemRolesDaoException extends DaoException {
    public VwUserSystemRolesDaoException(String message) {
        super(message);
    }

    public VwUserSystemRolesDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
