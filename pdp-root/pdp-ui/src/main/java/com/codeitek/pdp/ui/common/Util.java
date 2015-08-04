package com.codeitek.pdp.ui.common;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/23/13
 * Time: 5:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Util implements IUtil {

    private static final Logger log = Logger.getLogger(Util.class);
    private PropertyConfigurator configurator;



    @Autowired
    public Util(PropertyConfigurator configurator) {
        this.configurator = configurator;
    }


    /**
     * longParam - returns a long for a given url parameter
     *
     * @param request
     * @param key
     * @return a long value or 0
     */
    @Override
    public long longParam(HttpServletRequest request, String key) {
        return longParam(request, key, 0);
    }

    /**
     * longParam - returns a long for a given url parameter
     *
     * @param request
     * @param key
     * @return a long value or the defaultValue
     */
    @Override
    public long longParam(HttpServletRequest request, String key, long defaultValue) {
        long retVal = defaultValue;

        // get the incoming url value
        String value = request.getParameter(key);

        // if it exists, then parse to long
        if (value != null && value.length() > 0) {
            try {
                retVal = Long.parseLong(value.trim());
            } catch (NumberFormatException nfe) {
            }
        }
        return retVal;
    }

    /**
     * longParam - returns a long for a given url parameter
     *
     * @param request
     * @param key
     * @return a long value or 0
     */
    @Override
    public int intParam(HttpServletRequest request, String key) {
        return intParam(request, key, 0);
    }

    /**
     * longParam - returns a long for a given url parameter
     *
     * @param request
     * @param key
     * @return a long value or the defaultValue
     */
    @Override
    public int intParam(HttpServletRequest request, String key, int defaultValue) {
        int retVal = defaultValue;

        // get the incoming url value
        String value = request.getParameter(key);

        // if it exists, then parse to long
        if (value != null && value.length() > 0) {
            try {
                retVal = Integer.parseInt(value.trim());
            } catch (NumberFormatException nfe) {
            }
        }
        return retVal;
    }

    /**
     * stringParam - returns a string for a given url parameter
     *
     * @param request
     * @param key
     * @return a string or ""
     */
    @Override
    public String stringParam(HttpServletRequest request, String key) {
        return stringParam(request, key, "");
    }

    /**
     * stringParam - returns a string for a given url parameter
     *
     * @param request
     * @param key
     * @return a string or defaultValue
     */
    @Override
    public String stringParam(HttpServletRequest request, String key, String defaultValue) {
        return (request.getParameter(key) != null && request.getParameter(key).length() > 0) ? request.getParameter(key) : defaultValue;
    }


    /**
     * showParams
     * <p/>
     * * @param request
     */
    @Override
    public String showParams(HttpServletRequest request) {
        String out = "";
        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String key = (String) names.nextElement();
            String value = request.getParameter(key);
            out += key + ":" + value + ", ";
        }
        return out;
    }

    /**
     * Has Parameter
     * <p/>
     * * @param request
     */
    @Override
    public boolean hasParam(HttpServletRequest request, String key) {

        try {
            if (request.getParameter(key) != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return false;
    }




    /**
     * showCustomJQGridResponse
     * <p/>
     * * @param request
     */
    @Override
    public String showHashMap(HashMap map) {

        String out = "";

        Level level = log.getEffectiveLevel();
        if (level.toInt() <= Level.TRACE.toInt()) {
            out += "HashMap:{";
            if (map != null) {
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pairs = (Map.Entry) it.next();
                    out += pairs.getKey() + ":" + pairs.getValue() + ",";
                }
            }
            out += "},";
        }
        return out;
    }

    @Override
    public Cookie getCookie(String cookieName, HttpServletRequest request){


        if(configurator.getResolvedProps().containsKey("customerUUid")){
            return new Cookie("pdp-custId",configurator.getResolvedProps().get("customerUUid"));
        }


        for(int i=0;i<request.getCookies().length;i++){

            Cookie cookie = request.getCookies()[i];
            if(cookie.getName().equals(cookieName)){
               return cookie;
            }

        }


        return null;
    }



    @Override
    public Cookie getCookie(String cookieName, HttpServletRequest request, PropertyConfigurator configurator){

        return new Cookie("pdp-custId",configurator.getResolvedProps().get("customerUUid"));
    }




    @Override
    public String getCustomerGUID(Cookie cookie){
        return configurator.getResolvedProps().get("customerUUid");
    }

}
