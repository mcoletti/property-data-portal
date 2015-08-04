package com.codeitek.pdp.core.client;

import com.codeitek.pdp.core.impl.TalonClientException;
import com.codeitek.pdp.model.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/22/13
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
public interface TalonClient {

    public PropertyDataDetailList getPropertyFeed(String customerUUid);

    public PropertyDataDetail getPropertyFeedByProperty(String customerUUid, String propertyUId);

    public PropertyDataDetailList getPropertyFeedByCity(String customerUUid, int cityId);

    public PropertyDataDetailList getPropertyFeedByCity(String customerUUid, String city);

    public CustomerList getCustomerList();

    public Customer getCustomer(String customerName);

    public Customer getCustomerByUUId(String customerUUId);

    public List<StateCity> getStateCityList(String customerUUId);

    public City getCity(int cityId);

    public List<StateCity> getStateCity(String city);
    public List<StateCityView> getStateCity(int zip);
    public List<Pagelayout> getPageLayout(String pageName) throws TalonClientException;
}
