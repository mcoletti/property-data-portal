package com.codeitek.pdp.service.utils;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.User;
import com.codeitek.pdp.service.CoreDao;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/31/13
 * Time: 7:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class TokenUtilsImpl implements TokenUtils {



    private final CoreDao coreDao;

    public TokenUtilsImpl(CoreDao coreDao) {
        this.coreDao = coreDao;
    }


    @Override
    public User getUserFromToken(String token) throws DataBaseJdbcException {
        return coreDao.getUserDao().getByAuthToken(token);
    }



    @Override
    public String getToken(String userUuid) throws DataBaseJdbcException {
        return coreDao.getUserDao().findByPrimaryKey(userUuid).getApiKey();
    }


    @Override
    public boolean validate(String token) throws DataBaseJdbcException {


        User user = coreDao.getUserDao().getByAuthToken(token);
        Calendar cal = Calendar.getInstance();
        if(cal.before(user.getApiKeyExpirationDate())){
            return true;
        }
        return false;
    }
}
