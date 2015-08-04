package com.codeitek.pdp.api.auth;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.Authority;
import com.codeitek.pdp.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/31/13
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class AuthorizedAuthority implements GrantedAuthority {


    private final AdministrationService service;

    @Autowired
    public AuthorizedAuthority(AdministrationService service) {
        this.service = service;
    }


    @Override
    public String getAuthority() {


        Authority authority = null;
        try {
            authority = service.getAuthorizedAuthority();
        } catch (DataBaseJdbcException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return authority.getAuthority();
    }
}
