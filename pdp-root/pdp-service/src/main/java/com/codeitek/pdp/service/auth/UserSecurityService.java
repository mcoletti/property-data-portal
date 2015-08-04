package com.codeitek.pdp.service.auth;

import com.codeitek.pdp.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 8/1/13
 * Time: 6:55 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserSecurityService extends UserDetailsService {
    User getUserByApiKey(String apiKey) throws Exception;
}
