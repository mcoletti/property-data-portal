package com.codeitek.pdp.utils;

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
public interface IAppSettingsLoader {

    public String getProperty(String resourceKey);
    public String getProperty(String resourceKey, URL resource);
    public String getPropertyByPreFix(String resourceKey, String preFix);
    public Configuration getRootConfig();
    public Configuration getConfigByPreFIx(String preFix);
    public Configuration getConfigByPreFIx(String preFix, URL resource);
    public URL getDefaultResourceUrl();
}