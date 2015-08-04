package com.codeitek.pdp.core.utils;

import org.apache.commons.configuration.Configuration;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/23/13
 * Time: 4:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public interface PropertyLoader {

    public String getProperty(String resourceKey);

    public String getProperty(String resourceKey, URL resource);

    public String getPropertyByPreFix(String resourceKey, String preFix);

    /**
     * Retunrs a List of Configuration Objects
     *
     * @param preFix
     * @return
     * @throws Exception
     */
    public Configuration getConfigByPreFIx(String preFix);

    public Configuration getConfigByPreFIx(String preFix, URL resource);

    public URL getDefaultResourceUrl();
}
