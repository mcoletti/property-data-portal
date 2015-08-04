package com.codeitek.pdp.core;

import org.apache.commons.configuration.Configuration;
import com.codeitek.pdp.core.client.HttpClient;
import com.codeitek.pdp.core.client.TalonClient;
import com.codeitek.pdp.core.impl.HttpClientImpl;
import com.codeitek.pdp.core.impl.TalonClientImpl;
import com.codeitek.pdp.model.*;
import com.codeitek.pdp.utils.PropertyLoader;
import com.codeitek.pdp.utils.PropertyLoaderImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/30/13
 * Time: 4:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Test(groups = {"acc"})
public class TestHttpClient {

    private TalonClient sut;
    private String customerUUid;
    private String customerName;
    private String propertyUUid;

    @BeforeClass
    public void init() {
        PropertyLoader propertyLoader = new PropertyLoaderImpl(TestHttpClient.class.getClassLoader().getResource("api.properties"));
        Configuration config = propertyLoader.getConfigByPreFIx("dev");
        Configuration testConfig = propertyLoader.getConfigByPreFIx("test");
        customerName = testConfig.getString("customerName");
        customerUUid = testConfig.getString("customerUUid");
        propertyUUid = testConfig.getString("propertyUUid");
        HttpClient httpClient = new HttpClientImpl(config.getString("rootApiUri"));
        sut = new TalonClientImpl(httpClient);
    }

    @Test(enabled = false)
    public void testGetPropertyFeedByCustomer() throws Exception {
        PropertyDataDetailList actual = sut.getPropertyFeed(customerUUid);

        assertNotNull(actual);
        assertEquals(actual.getList().get(0).getCustomerUUId(), customerUUid);
    }

    @Test(enabled = false)
    public void testGetPropertyFeedByCustomerByCityName() throws Exception {
        PropertyDataDetailList actual = sut.getPropertyFeedByCity(customerUUid, "COLUMBUS");

        assertNotNull(actual);
        assertEquals(actual.getList().get(0).getCustomerUUId(), customerUUid);
        assertEquals(actual.getList().get(0).getCity(), "COLUMBUS");
    }

    @Test(enabled = false)
    public void testGetPropertyFeedByCustomerByCityId() throws Exception {
        PropertyDataDetailList actual = sut.getPropertyFeedByCity(customerUUid, 25);

        assertNotNull(actual);
        assertEquals(actual.getList().get(0).getCustomerUUId(), customerUUid);
        assertEquals(actual.getList().get(0).getCity(), "COLUMBUS");
    }

    @Test(enabled = false)
    public void testGetPropertyFeedByCustomerByProperty() throws Exception {
        PropertyDataDetail actual = sut.getPropertyFeedByProperty(customerUUid, propertyUUid);

        assertNotNull(actual);
        assertEquals(actual.getCustomerUUId(), customerUUid);
        assertEquals(actual.getUuid(), propertyUUid);
    }

    @Test(enabled = false)
    public void testGetAdminCustomerList() throws Exception {
        CustomerList actual = sut.getCustomerList();

        assertNotNull(actual);
        assertEquals(actual.getList().get(0).getCustomerUuid(), customerUUid);
    }

    @Test(enabled = false)
    public void testGetAdminCustomerByName() throws Exception {
        Customer actual = sut.getCustomer(customerName);

        assertNotNull(actual);
        assertEquals(actual.getCustomerName(), customerName);
    }

    @Test(enabled = false)
    public void testGetAdminCustomerByUUid() throws Exception {
        Customer actual = sut.getCustomerByUUId(customerUUid);

        assertNotNull(actual);
        assertEquals(actual.getCustomerUuid(), customerUUid);
    }


    @Test(enabled = false)
    public void testGetStateCityByCustUUid() throws Exception {
        List<StateCity> actual = sut.getStateCityList(customerUUid);
        assertNotNull(actual);
        assertNotEquals(actual.size(),0);
    }

    @Test(enabled = false)
    public void testGetStateCityByCity() throws Exception {
        List<StateCity> actual = sut.getStateCity("COLUMBUS");
        assertNotNull(actual);
        assertNotEquals(actual.size(),0);
    }

    @Test(enabled = false)
    public void testGetStateCityByZip() throws Exception {
        List<StateCityView> actual = sut.getStateCity(43205);
        assertNotNull(actual);
        assertNotEquals(actual.size(),0);
    }

    @Test(enabled = false)
    public void testGetPageLayout() throws Exception {
        List<Pagelayout> actual = sut.getPageLayout("propertylistings");
        assertNotNull(actual);
        assertEquals(actual.get(0).getPage(),"propertylistings");
    }
}
