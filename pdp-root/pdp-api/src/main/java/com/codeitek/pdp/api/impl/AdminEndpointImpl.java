package com.codeitek.pdp.api.impl;

import com.codeitek.pdp.api.AdminEndpoint;
import com.codeitek.pdp.api.ApiConstants;
import com.codeitek.pdp.dal.interfaces.PdpDaoService;
import com.codeitek.pdp.model.*;
import com.codeitek.pdp.service.AdministrationService;
import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Logger;
import org.codehaus.enunciate.modules.jersey.ExternallyManagedLifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import javax.servlet.ServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Admin endpoint.
 *
 * @author mcoletti@gmail.com
 */
@ExternallyManagedLifecycle
@Path(ApiConstants.ADMIN_MP)
public class AdminEndpointImpl implements AdminEndpoint {

    private static final Logger LOG = Logger.getLogger(AdminEndpointImpl.class);
    private final AdministrationService adminService;

    @Autowired
    public AdminEndpointImpl(AdministrationService adminService) {
        this.adminService = adminService;
    }

    @Override
    public Response getCustomerList() {

        try {
            LOG.debug(String.format("Loading Customer List - API Call:%s", "test"));
            CustomerList customerList = adminService.getCustomerList();
            return Response.status(Response.Status.ACCEPTED).entity(customerList).build();

        } catch (Exception e) {
            LOG.error("Error Loading data  - " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @Override
    public Response getCustomerByName(String customerName) {

        try {
            LOG.debug(String.format("Loading Customer by Name:%s",customerName));
            Customer customer = adminService.getCustomerByName(customerName);
            return Response.status(Response.Status.ACCEPTED).entity(customer).build();

        } catch (Exception e) {
            LOG.error("Error Loading data  - " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @Override
    public Response getCustomerByUUid(String uuid) {
        try {
            LOG.debug(String.format("Loading Customer by UUId:%s",uuid));
            Customer customer = adminService.getCustomer(uuid);
            return Response.status(Response.Status.ACCEPTED).entity(customer).build();

        } catch (Exception e) {
            LOG.error("Error Loading data  - " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @Override
    public Response getStateCityListByCustomer(String customerUUId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response addNewCity(City city) {
        try {
            LOG.debug(String.format("Adding New City:%s",city.getCityName()));
            city  = adminService.addUpdateCity(city,false);
            return Response.status(Response.Status.ACCEPTED).entity(city).build();

        } catch (Exception e) {
            LOG.error("Error Adding New City  - " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @Override
    public Response updateCity(City city) {
        throw new NotImplementedException();
    }

    @Override
    public Response getCity(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response getCityList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response getStateList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public Response getState(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response addState(State state) {
        try {
            LOG.debug(String.format("Adding New State:%s",state.getStateName()));
            state  = adminService.addUpdateState(state,false);
            return Response.status(Response.Status.ACCEPTED).entity(state).build();

        } catch (Exception e) {
            LOG.error("Error Adding New City  - " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @Override
    public Response addNewCustomer(Customer customer) {
        try {
            LOG.debug(String.format("Adding new Customer:%s",customer.getCustomerName()));
            customer = adminService.addUpdateCustomerAccount(customer,false);
            return Response.status(Response.Status.ACCEPTED).entity(customer).build();

        } catch (Exception e) {
            LOG.error("Error Adding new Customer data  - " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @Override
    public Response updateCustomer(Customer customer) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response getUserList(String customerUUId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response getUser(String userUuid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response addUser(User user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response updateUser(User user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response getPageLayout(String page) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
