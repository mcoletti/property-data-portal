package com.codeitek.pdp.core.utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/23/13
 * Time: 4:47 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class PropertyLoaderImpl implements PropertyLoader {

    private static final Logger log = Logger.getLogger(PropertyLoaderImpl.class);
    private static final String DEFAULT_PROP_FILE = "/app.properties";
    private String resourceFileName;
    private URL defaultUrl;
    private Configuration config;
    private Configuration rootConfig;

    /**
     * Default Factory Method
     * @return
     */
    public static PropertyLoader getDefaultInstance(){
        return new PropertyLoaderImpl(null);
    }

    /**
     * Default constructor
     *
     * @param resourceFile
     */
    public PropertyLoaderImpl(String resourceFile) {

        this(resourceFile, null);
    }

    /**
     * Full Constructor
     *
     * @param resourceFile
     * @param path
     */
    public PropertyLoaderImpl(String resourceFile, String path) {
        resourceFileName = (resourceFile == null) ? DEFAULT_PROP_FILE : resourceFile;
        defaultUrl = (path == null) ? getDefaultResourceUrl() : createUrl(path);
        initPropertyService(defaultUrl,null);
    }

    public PropertyLoaderImpl(URL resourceFileUrl,String env) {

        initPropertyService(resourceFileUrl,env);
    }

    private void initPropertyService(URL url,String env){

        try {

            config = new PropertiesConfiguration(url);
            if (env!=null) {
                rootConfig = config.subset(env);
            }
        } catch (ConfigurationException e) {
            log.error("Error loading PropertyFile from file:" + url.getPath() + " - " + e.getMessage());
        }
    }

    @Override
    public String getProperty(String resourceKey) {


        return getProperty(resourceKey, defaultUrl);
    }

    @Override
    public String getProperty(String resourceKey, URL resource) {

        try {
            config = new PropertiesConfiguration(resource);
        } catch (ConfigurationException e) {
            log.error("Error on Get Property" + e.getMessage());
        }
        return config.getProperty(resourceKey).toString();
    }

    @Override
    public String getPropertyByPreFix(String resourceKey, String preFix) {

        config = getConfigByPreFIx(preFix);
        return config.getString(resourceKey);
    }

    @Override
    public Configuration getConfigByPreFIx(String preFix) {


        return getConfigByPreFIx(preFix, defaultUrl);
    }

    @Override
    public Configuration getConfigByPreFIx(String preFix, URL resource) {

        try {
            config = new PropertiesConfiguration(resource);
            rootConfig = config.subset(preFix);
        } catch (ConfigurationException e) {
            log.error("Error on loading config subset:" + e.getMessage());
        }
        return rootConfig;
    }

    @Override
    public URL getDefaultResourceUrl() {

        return PropertyLoaderImpl.class.getResource(resourceFileName);
    }

    private URL createUrl(String path) {


        URL url = null;
        try {
            File file = new File(path + resourceFileName);
            url = file.toURI().toURL();
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }
        return url;
    }
}
