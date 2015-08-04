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
 * Date: 7/31/13
 * Time: 6:18 AM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring/test-spring-config.xml")
public class AuthoritiesJdbcDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private AuthorityJdbcDao sut;

    @BeforeTransaction
    public void beforeTransaction() {
        executeSqlScript("classpath:sql/authroity-test.sql", false);

    }

    @AfterTransaction
    public void afterTransaction() {
        deleteFromTables(DAOTableRef.AUTHORITY);
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
    public void testFindByPrimaryKey() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testFindWhereIdEquals() throws Exception {

    }

    @Test
    public void testFindWhereAuthorityEquals() throws Exception {

    }

    @Test
    public void testFindWhereEnabledEquals() throws Exception {

    }

    @Test
    public void testFindWhereApiUrlEquals() throws Exception {

    }

    @Test
    public void testFindWhereApiAuthTokenEquals() throws Exception {

    }
}
