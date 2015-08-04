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
 * Time: 2:07 AM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring/test-spring-config.xml")
public class SystemGroupMembersJdbcDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private SystemGroupMembersJdbcDao sut;

    @BeforeTransaction
    public void beforeTransaction() {
        executeSqlScript("classpath:sql/sysGrpMems-test.sql", false);

    }

    @AfterTransaction
    public void afterTransaction() {
        deleteFromTables(DAOTableRef.SYS_GRP_MEMS);
    }

    @Test
    public void testInsert() throws Exception {

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
    public void testFindBySystemRoles() throws Exception {

    }

    @Test
    public void testFindByGroups() throws Exception {

    }

    @Test
    public void testFindByUser() throws Exception {

    }

    @Test
    public void testFindWhereSystemRolesIdEquals() throws Exception {

    }

    @Test
    public void testFindWhereGroupsIdEquals() throws Exception {

    }

    @Test
    public void testFindWhereUserUuidEquals() throws Exception {

    }
}
