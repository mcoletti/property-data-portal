package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

/**
 * Validate {@link com.codeitek.pdp.dal.impl.CustomerJdbcDao}.
 *
 * @author wchoules@gmail.com
 */
@ContextConfiguration("classpath:spring/test-spring-config.xml")
public class CustomerJdbcDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private CustomerJdbcDao sut;
    private Customer customer;

    private final String TEST_USER_BY_UUID = "e0faeca6-01db-4814-841b-bea0de1e6a6c";
    private final String TEST_USER_UPDATE = "5d788783-fa27-4c2c-83c9-140ae87c824f";
    private final String TEST_USER_DELETE = "76f63219-4901-4480-b883-0d792aac26e6";
    private final String TEST_USER_IS_DELETED = "18e362db-03e4-4d18-9132-de57aeaad4cb";

    @BeforeTransaction
    public void beforeTransaction() {
        executeSqlScript("classpath:sql/customer-test.sql", false);


    }

    @AfterTransaction
    public void afterTransaction() {
        deleteFromTables("PDPDB.CUSTOMER");
    }
    @AfterClass
    public void tearDown(){

    }

    @Test
    public void testInsert() throws Exception {

        customer = new Customer();
        customer.setCustomerDeleteInd(false);
        customer.setCustomerName("TEST_CUSTOMER");
        String pk = sut.insert(customer);
        assertNotNull(pk);
    }

    @Test(dependsOnMethods = {"testFindByPrimaryKey"})
    public void testUpdate() throws Exception {

        customer = sut.findByPrimaryKey(TEST_USER_UPDATE);
        assertFalse(customer.getCustomerDeleteInd());

        customer.setCustomerDeleteInd(true);
        sut.update(customer.getCustomerUuid(),customer);

        customer = sut.findByPrimaryKey(TEST_USER_UPDATE);
        assertNotNull(customer);
        assertTrue(customer.getCustomerDeleteInd(), "Failed on update Customer");

    }

    @Test(dependsOnMethods = {"testFindWhereDeleteIndEquals"})
    public void testDelete() throws Exception {

        sut.delete(TEST_USER_DELETE);
        assertNull(sut.findByPrimaryKey(TEST_USER_DELETE));
    }

    @Test(dependsOnMethods = {"testInsert"})
    public void testFindByPrimaryKey() throws Exception {

        customer = sut.findByPrimaryKey(TEST_USER_BY_UUID);
        assertEquals(customer.getCustomerUuid(), TEST_USER_BY_UUID);
    }

    @Test(dependsOnMethods = {"testUpdate"})
    public void testFindAll() throws Exception {
        List<Customer> chkCust = sut.findAll();
        assertNotNull(chkCust);
        assertEquals(chkCust.size(), 6);
    }

    @Test(dependsOnMethods = {"testFindAll"})
    public void testFindWhereUuidEquals() throws Exception {
        List<Customer> chkCustomer =  sut.findWhereUuidEquals(TEST_USER_BY_UUID);
        assertNotNull(chkCustomer);
        assertEquals(chkCustomer.get(0).getCustomerUuid(),TEST_USER_BY_UUID,"Failed Findby UUID Test");
    }

    @Test(dependsOnMethods = {"testFindWhereUuidEquals"})
    public void testFindWhereNameEquals() throws Exception {
        List<Customer> chkCustomer =  sut.findWhereNameEquals("TEST_USER_BY_NAME");
        assertNotNull(chkCustomer);
        assertEquals(chkCustomer.get(0).getCustomerName(),"TEST_USER_BY_NAME","Failed Findby Name Test");
    }

    @Test(dependsOnMethods = {"testFindWhereNameEquals"})
    public void testFindWhereDeleteIndEquals() throws Exception {

        List<Customer> chkCust = sut.findWhereDeleteIndEquals(true);
        assertNotNull(chkCust);
        assertTrue(chkCust.get(0).getCustomerDeleteInd(), "Failed on Test Delete Indicator");
        assertEquals(chkCust.get(0).getCustomerUuid(),TEST_USER_IS_DELETED);
    }
}
