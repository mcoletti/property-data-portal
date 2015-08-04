package com.codeitek.pdp.service.auth;

import com.codeitek.pdp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 8/1/13
 * Time: 6:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserSecurityServiceImpl implements UserSecurityService {


    private final UserSecurityDao userSecurityDao;

    @Autowired
    public UserSecurityServiceImpl(UserSecurityDao userSecurityDao) {
        this.userSecurityDao = userSecurityDao;
    }

    @Override
    public User getUserByApiKey(String apiKey) throws Exception {
        User user = userSecurityDao.getUserByApiKey(apiKey);
        if(user == null){
            throw new Exception("User Not FOund");
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails userDetails = userSecurityDao.getUserByUsername(s);
        if(userDetails == null) {
            throw new UsernameNotFoundException("User not found using supplied username");
        }

        return userDetails;
    }
}
