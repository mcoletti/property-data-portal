package com.codeitek.pdp.ui.common;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/22/13
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class BlacklistFilter extends OncePerRequestFilter {

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(BlacklistFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.debug("Running blacklist filter");

        // Retrieve user details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Filter only if user details is not empty; otherwise there's nothing to filter
        if (authentication != null) {

            // If the username is equal to mike, deny access
            if (authentication.getName().equals("mike") == true ) {
                log.error("Username and password match. Access denied!");
                throw new AccessDeniedException("Username and password match. Access denied!");
            }

        }

        // User details are not empty
        log.debug("Continue with remaining filters");
        filterChain.doFilter(request, response);
    }
}
