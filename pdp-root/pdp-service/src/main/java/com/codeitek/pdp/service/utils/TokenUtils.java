package com.codeitek.pdp.service.utils;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/31/13
 * Time: 5:41 AM
 * To change this template use File | Settings | File Templates.
 */
public interface TokenUtils {
    User getUserFromToken(String token) throws DataBaseJdbcException;
    String getToken(String userUuid) throws DataBaseJdbcException;
    boolean validate(String token) throws DataBaseJdbcException;
}
