package com.codeitek.pdp.dal.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:25 AM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring/test-spring-config.xml")
public class PropertyDataJdbcDaoTest extends AbstractTransactionalTestNGSpringContextTests {


    @Autowired
    private PropertyDataJdbcDao sut;



    @BeforeTransaction
    public void beforeTransaction() {
        executeSqlScript("classpath:sql/propertyData-test.sql", false);

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
    public void testFindByPrimaryKey() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testFindByDataSource() throws Exception {

    }

    @Test
    public void testFindByZipCodes() throws Exception {

    }

    @Test
    public void testFindByPropertyStatus() throws Exception {

    }

    @Test
    public void testFindByPropertyType() throws Exception {

    }

    @Test
    public void testFindWhereUuidEquals() throws Exception {

    }

    @Test
    public void testFindWherePropNameEquals() throws Exception {

    }

    @Test
    public void testFindWherePriceEquals() throws Exception {

    }

    @Test
    public void testFindWhereSqftEquals() throws Exception {

    }

    @Test
    public void testFindWhereDescriptionEquals() throws Exception {

    }

    @Test
    public void testFindWhereNumBedsEquals() throws Exception {

    }

    @Test
    public void testFindWhereNumBathsEquals() throws Exception {

    }

    @Test
    public void testFindWhereDataSourceIdEquals() throws Exception {

    }

    @Test
    public void testFindWhereZipCodeEquals() throws Exception {

    }

    @Test
    public void testFindWherePropertyStatusIdEquals() throws Exception {

    }

    @Test
    public void testFindWherePropertyTypeIdEquals() throws Exception {

    }


}
