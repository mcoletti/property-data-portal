package com.codeitek.pdp.ui.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/20/13
 * Time: 4:05 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IUtil {
    long longParam(HttpServletRequest request, String key);

    long longParam(HttpServletRequest request, String key, long defaultValue);

    int intParam(HttpServletRequest request, String key);

    int intParam(HttpServletRequest request, String key, int defaultValue);

    String stringParam(HttpServletRequest request, String key);

    String stringParam(HttpServletRequest request, String key, String defaultValue);

    String showParams(HttpServletRequest request);

    boolean hasParam(HttpServletRequest request, String key);

    String showHashMap(HashMap map);

    Cookie getCookie(String cookieName, HttpServletRequest request);

    Cookie getCookie(String cookieName, HttpServletRequest request, PropertyConfigurator configurator);

    String getCustomerGUID(Cookie cookie);
}
