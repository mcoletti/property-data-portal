package com.codeitek.pdp.ui.common;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/16/13
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConfigPropertiesListener implements ServletContextListener {

    public static final String DEFAULT_PROPERTIES_BEAN_NAME = "propertyConfigurer";
    public static final String DEFAULT_CONTEXT_PROPERTY = "configProperties";
    private String propertiesBeanName = DEFAULT_PROPERTIES_BEAN_NAME;
    private String contextProperty = DEFAULT_CONTEXT_PROPERTY;

    public void contextDestroyed(ServletContextEvent sce) {
    }

    public void contextInitialized(ServletContextEvent sce) {
        // TODO add ability to configure non default values via serveltContexParams

        // get the servlet context from the context event
        ServletContext servletContext = sce.getServletContext();

        // get the WebApplicationContext given the servlet context
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        // from the WebApplicationContext, get the ExposablePropertyPlaceholderConfigurer we defined for fetching config properties.
        PropertyConfigurator configurer = (PropertyConfigurator)context.getBean(propertiesBeanName);

        // then from the servlet context event, get the context and set the bean as an attribute.  Being an attribute seems to make it visible via EL
        servletContext.setAttribute(contextProperty, configurer.getResolvedProps());

    }
}
