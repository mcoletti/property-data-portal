package com.codeitek.pdp.api;

import com.codeitek.pdp.model.PropertyData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/12/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PropertyServiceEndpoint {



    @GET
    @Path("/customer/{customerUUId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getPropertyByCustomer(@PathParam("customerUUId") String uuid);

    @GET
    @Path("/{propertyDataUuid}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getPropertyByUuid(@PathParam("propertyDataUuid") String propertyDataUuid);

    @GET
    @Path("/city/name/{cityName}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getPropertyByCityName(@PathParam("cityName") String cityName);

    @GET
    @Path("/city/id/{cityId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getPropertyByCityId(@PathParam("cityId") int cityId);

    @PUT
    @Path("/")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response insert(PropertyData pd);

    @POST
    @Path("/")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response update(PropertyData pd);


}
