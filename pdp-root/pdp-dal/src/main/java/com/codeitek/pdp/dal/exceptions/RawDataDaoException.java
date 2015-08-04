package com.codeitek.pdp.dal.exceptions;

import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 5:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class RawDataDaoException extends DaoException {

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(RawDataDaoException.class);
    public RawDataDaoException(String message) {
        super(message);
        log.error(message);
    }

    public RawDataDaoException(String message, Throwable throwable) {
        super(message, throwable);
        log.error(message);
    }
}
