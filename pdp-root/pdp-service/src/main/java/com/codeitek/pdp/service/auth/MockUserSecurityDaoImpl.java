package com.codeitek.pdp.service.auth;

import com.codeitek.pdp.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 8/1/13
 * Time: 6:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class MockUserSecurityDaoImpl implements UserSecurityDao {

    private User simulateFetchOfuser() {
        return new User("username", "api-1234", new ArrayList<GrantedAuthority>());
    }

    @Override
    public User getUserByUsername(String username) {
        User exampleUser = simulateFetchOfuser();

        if(username.equalsIgnoreCase(exampleUser.getUsername())){
            return exampleUser;
        }
        return null;
    }

    @Override
    public User getUserByApiKey(String apiKey) {
        User exampleUser = simulateFetchOfuser();
        if(apiKey.equals(exampleUser.getApiKey())){
            return exampleUser;
        }
        return null;
    }
}
