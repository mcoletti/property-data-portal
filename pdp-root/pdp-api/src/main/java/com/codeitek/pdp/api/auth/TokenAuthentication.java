package com.codeitek.pdp.api.auth;

import com.codeitek.pdp.service.AdministrationService;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/31/13
 * Time: 8:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class TokenAuthentication implements Authentication, CredentialsContainer {


    private final Collection<? extends GrantedAuthority> authorities;
    private final String token;
    private final AdministrationService administrationService;


    public TokenAuthentication(Collection<? extends GrantedAuthority> authorities, String token, AdministrationService administrationService) {

        this.authorities = authorities;
        this.token = token;
        this.administrationService = administrationService;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {


       Iterator<? extends GrantedAuthority> iterator = authorities.iterator();

       while (iterator.hasNext()){
           String authority = iterator.next().getAuthority();

       }


        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getDetails() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getPrincipal() {


        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAuthenticated() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void eraseCredentials() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
