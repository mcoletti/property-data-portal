package com.codeitek.pdp.dal.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:21 AM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring/test-spring-config.xml")
public class CityJdbcDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private CityJdbcDao sut;


    @BeforeTransaction
    public void beforeTransaction() {
        executeSqlScript("classpath:sql/city-test.sql", false);

    }

    @AfterTransaction
    public void afterTransaction() {
        deleteFromTables("PDPDB.CITY");
    }


    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testMapRow() throws Exception {

    }

    @Test
    public void testGetTableName() throws Exception {

    }
    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testFindByState() throws Exception {

    }

    @Test
    public void testFindWhereIdEquals() throws Exception {

    }

    @Test
    public void testFindWhereCityEquals() throws Exception {

    }

    @Test
    public void testFindWhereSummaryEquals() throws Exception {

    }

    @Test
    public void testFindWhereImageUrlEquals() throws Exception {

    }

    @Test
    public void testFindWhereStateIdEquals() throws Exception {

    }

    @Test
    public void testFindByPrimaryKey() throws Exception {

    }
}
