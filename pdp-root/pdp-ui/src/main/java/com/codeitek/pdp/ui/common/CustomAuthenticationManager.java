package com.codeitek.pdp.ui.common;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/22/13
 * Time: 12:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomAuthenticationManager implements AuthenticationManager {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {



        String test = authentication.getName();





        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
