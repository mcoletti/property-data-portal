package com.codeitek.pdp.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 8/1/13
 * Time: 4:38 AM
 * To change this template use File | Settings | File Templates.
 */
public interface AuthManagerEndpoint {

    @POST
    @Path(ApiConstants.AUTH_SERVICE_PATH)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response authorise(@QueryParam("userName") String userName, @QueryParam("apiToken") String apiToken);

    @POST
    @Path(ApiConstants.AUTH_SERVICE_PATH + "/touch")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response touch(@QueryParam("userName") String userName, @QueryParam("authToken") String apiToken);
}
