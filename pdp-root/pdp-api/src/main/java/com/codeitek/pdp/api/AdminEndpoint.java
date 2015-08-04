package com.codeitek.pdp.api;

import com.codeitek.pdp.model.City;
import com.codeitek.pdp.model.Customer;
import com.codeitek.pdp.model.State;
import com.codeitek.pdp.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.codeitek.pdp.api.ApiConstants.*;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/13/13
 * Time: 6:08 AM
 * To change this template use File | Settings | File Templates.
 */
public interface AdminEndpoint {



    @GET
    @Path(GET_CUSTOMERS_PATH)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getCustomerList();

    @GET
    @Path(GET_CUSTOMER_BY_NAME_PATH)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getCustomerByName(@PathParam("customerName") String customerName);

    @GET
    @Path(GET_CUSTOMER_BY_UUID_PATH)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getCustomerByUUid(@PathParam("customerUuid") String customerUUId);

    @GET
    @Path(GET_SCV_BY_CUSTOMER)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getStateCityListByCustomer(@QueryParam("customerUUId") String customerUUId);

    @POST
    @Path(CITY_MP)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response addNewCity(City city);

    @PUT
    @Path(CITY_MP)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response updateCity(City city);

    @GET
    @Path(CITY_BY_NAME_MP)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getCity(@PathParam("customerName") String name);

    @GET
    @Path(CITY_LIST_MP)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getCityList();

    @GET
    @Path(STATE_LIST_MP)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getStateList();

    @GET
    @Path(STATE_BY_NAME_MP)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getState(@PathParam("name") String name);

    @POST
    @Path(STATE_MP)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response addState(State state);

    @POST
    @Path(CUSTOMER_PATH)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response addNewCustomer(Customer customer);

    @PUT
    @Path(CUSTOMER_PATH)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response updateCustomer(Customer customer);

    @GET
    @Path(GET_USER_LIST)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getUserList(@PathParam("customerUUId") String customerUUId);

    @GET
    @Path(GET_USER)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getUser(@PathParam("userUuid") String userUuid);

    @POST
    @Path(USER_PATH)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response addUser(User user);

    @PUT
    @Path(USER_PATH)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response updateUser(User user);

    @GET
    @Path(GET_PAGE_LAYOUT_BY_PAGE)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getPageLayout(@PathParam("page") String page);


}
