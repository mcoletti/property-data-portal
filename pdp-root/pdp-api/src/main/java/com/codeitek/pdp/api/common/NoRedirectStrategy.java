package com.codeitek.pdp.api.common;

import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 8/1/13
 * Time: 7:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class NoRedirectStrategy implements RedirectStrategy {
    @Override
    public void sendRedirect(HttpServletRequest request, HttpServletResponse httpServletResponse, String s) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
