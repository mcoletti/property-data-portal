package com.codeitek.pdp.dal.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class GroupMembersDaoException extends DaoException {
    public GroupMembersDaoException(String message) {
        super(message);
    }

    public GroupMembersDaoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
