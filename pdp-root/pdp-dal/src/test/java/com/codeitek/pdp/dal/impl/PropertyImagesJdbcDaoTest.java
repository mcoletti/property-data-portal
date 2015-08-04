package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOTableRef;
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
 * Time: 3:22 AM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring/test-spring-config.xml")
public class PropertyImagesJdbcDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private PropertyImagesJdbcDao sut;

    @BeforeTransaction
    public void beforeTransaction() {
        executeSqlScript("classpath:sql/propImgs-test.sql", false);

    }

    @AfterTransaction
    public void afterTransaction() {
        deleteFromTables(DAOTableRef.PROP_IMGS);
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
    public void testFindByPropertyData() throws Exception {

    }

    @Test
    public void testFindWhereIdEquals() throws Exception {

    }

    @Test
    public void testFindWhereTitleEquals() throws Exception {

    }

    @Test
    public void testFindWhereTypeEquals() throws Exception {

    }

    @Test
    public void testFindWhereSizeEquals() throws Exception {

    }

    @Test
    public void testFindWhereSrcUrlEquals() throws Exception {

    }

    @Test
    public void testFindWherePropertyDataUuidEquals() throws Exception {

    }
}
