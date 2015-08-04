package com.codeitek.pdp.ui.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/23/13
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationContextHelper {

    private ApplicationContext appContext;
    private Properties props;
    public static ApplicationContextHelper appConfigHelper;

    public void AppConfigHelper() {

        appContext = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"});
    }

    public static ApplicationContextHelper init(){

        if(appConfigHelper==null){
            appConfigHelper = new ApplicationContextHelper();
        }

        return appConfigHelper;

    }


}
