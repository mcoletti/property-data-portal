package com.codeitek.pdp.service.auth;

import com.codeitek.pdp.model.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 8/1/13
 * Time: 6:57 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserSecurityDao {
    User getUserByUsername(String username);
    User getUserByApiKey(String apiKey);
}
