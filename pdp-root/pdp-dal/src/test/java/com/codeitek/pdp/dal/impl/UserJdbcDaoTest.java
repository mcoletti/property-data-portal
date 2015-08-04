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
 * Time: 2:14 AM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring/test-spring-config.xml")
public class UserJdbcDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserJdbcDao sut;

    @BeforeTransaction
    public void beforeTransaction() {
        executeSqlScript("classpath:sql/user-test.sql", false);

    }

    @AfterTransaction
    public void afterTransaction() {
        deleteFromTables(DAOTableRef.USER);
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
    public void testFindWhereUuidEquals() throws Exception {

    }

    @Test
    public void testFindWhereUserNameEquals() throws Exception {

    }

    @Test
    public void testFindWhereFirstNameEquals() throws Exception {

    }

    @Test
    public void testFindWhereLastNameEquals() throws Exception {

    }

    @Test
    public void testFindWherePrimaryEmailEquals() throws Exception {

    }

    @Test
    public void testFindWhereReferredByEquals() throws Exception {

    }

    @Test
    public void testFindWhereGenderEquals() throws Exception {

    }

    @Test
    public void testFindWhereDeleteIndEquals() throws Exception {

    }

    @Test
    public void testFindWhereCustomerUuidEquals() throws Exception {

    }

    @Test
    public void testFindWhereRoleDataIdEquals() throws Exception {

    }

    @Test
    public void testFindWhereLastLoginDtmEquals() throws Exception {

    }

    @Test
    public void testFindWhereLockIndEquals() throws Exception {

    }
}
