package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class SystemRolesDaoException extends DaoException {
    public SystemRolesDaoException(String message) {
        super(message);
    }

    public SystemRolesDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
