package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class SystemGroupMembersDaoException extends DaoException {
    public SystemGroupMembersDaoException(String message) {
        super(message);
    }

    public SystemGroupMembersDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
