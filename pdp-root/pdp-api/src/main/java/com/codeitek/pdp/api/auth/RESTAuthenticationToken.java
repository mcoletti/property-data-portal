package com.codeitek.pdp.api.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 8/1/13
 * Time: 6:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class RESTAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public RESTAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public RESTAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
