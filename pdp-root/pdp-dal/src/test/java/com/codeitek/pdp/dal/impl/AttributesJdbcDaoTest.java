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
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring/test-spring-config.xml")
public class AttributesJdbcDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private AttributesJdbcDao sut;


    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @BeforeTransaction
    public void beforeTransaction() {
        executeSqlScript("classpath:sql/attributes-test.sql", false);

    }

    @AfterTransaction
    public void afterTransaction() {
        deleteFromTables("PDPDB.ATTRIBUTES");
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
    public void testFindWhereIdEquals() throws Exception {

    }

    @Test
    public void testFindWhereKeyEquals() throws Exception {

    }

    @Test
    public void testFindByPrimaryKey() throws Exception {

    }
}
