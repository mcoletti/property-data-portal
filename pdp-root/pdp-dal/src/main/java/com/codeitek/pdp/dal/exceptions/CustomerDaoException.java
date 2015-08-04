package com.codeitek.pdp.dal.exceptions;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/24/13
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDaoException extends DaoException {

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(CustomerDaoException.class);
    public CustomerDaoException(String message) {
        super(message);
        log.error(message);
    }

    public CustomerDaoException(String message, Throwable throwable) {
        super(message, throwable);
        log.error(message);
    }
}
