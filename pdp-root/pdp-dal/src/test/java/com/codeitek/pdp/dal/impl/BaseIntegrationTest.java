package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.SpringJdbcSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.testng.annotations.BeforeClass;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/26/13
 * Time: 5:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseIntegrationTest {

    public SpringJdbcSupport springJdbcSupport;
    public ApplicationContext context;

    @BeforeClass
    public void init(){
        context = new ClassPathXmlApplicationContext(new String[]{"spring/int-test-beans.xml"});
        JdbcTemplate jdbcTemplate =   (JdbcTemplate)context.getBean("jdbcTemplate");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        springJdbcSupport = new SpringJdbcSupport();
        springJdbcSupport.setJdbcTemplate(jdbcTemplate);
        springJdbcSupport.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);
    }


}
