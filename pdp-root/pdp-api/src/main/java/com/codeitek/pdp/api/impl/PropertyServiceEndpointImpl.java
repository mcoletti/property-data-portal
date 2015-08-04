package com.codeitek.pdp.api.impl;

import com.codeitek.pdp.api.PropertyServiceEndpoint;
import com.codeitek.pdp.model.PropertyData;
import com.codeitek.pdp.model.PropertyDataDetail;
import com.codeitek.pdp.model.PropertyDataDetailList;
import com.codeitek.pdp.service.PropertyService;
import org.apache.log4j.Logger;
import org.codehaus.enunciate.modules.jersey.ExternallyManagedLifecycle;
import com.codeitek.pdp.api.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Property feed endpoint.
 *
 * @author mcoletti@gmail.com
 */
@ExternallyManagedLifecycle
@Path(ApiConstants.PROPERTY_SERVICE_PATH)
public class PropertyServiceEndpointImpl implements PropertyServiceEndpoint {

    private static final Logger LOG = Logger.getLogger(PropertyServiceEndpointImpl.class);
    private final PropertyService ps;
    private PropertyDataDetailList pdfl;

    @Autowired
    public PropertyServiceEndpointImpl(PropertyService propertyService) {
        this.ps = propertyService;
    }

    @Override
    public Response getPropertyByCustomer(String customerUUId) {

        try {
            LOG.debug("Loading Property Feed for CustomerUUId:" + customerUUId);
            return Response.status(Response.Status.ACCEPTED).entity(ps.getPropertyDataFeedList(customerUUId)).build();

        } catch (Exception e) {
            LOG.error("Error Loading data from Endpoint /propertyFeed - " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @Override
    public Response getPropertyByUuid(String propertyDataUuid) {

        try {
            LOG.debug("Loading Property Feed for PropertyDataUuid:" + propertyDataUuid);
            pdfl = ps.getPropertyDataFeedListByProperty(propertyDataUuid);
            PropertyDataDetail propertyFeed = pdfl.getList().size() == 0 ? null : pdfl.getList().get(0);

            return Response.status(Response.Status.ACCEPTED).entity(propertyFeed).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @Override
    public Response getPropertyByCityName(String city) {

        try {
            LOG.debug("Loading Property Feed for City:" + city);
            return Response.status(Response.Status.ACCEPTED).entity(ps.getPropertyDataFeedListByCity(city)).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @Override
    public Response getPropertyByCityId(int cityId) {
        try {
            LOG.debug("Loading Property Feed for CityId:" + cityId);
            return Response.status(Response.Status.ACCEPTED).entity(ps.getPropertyDataFeedListByCity(cityId)).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @Override
    public Response insert(PropertyData pd) {
        try {
            LOG.debug("Inserting New Property Data");
            pd = ps.addUpdatePropertyData(pd,false);
            return Response.status(Response.Status.ACCEPTED).entity(pd).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @Override
    public Response update(PropertyData pd) {
        try {
            LOG.debug("Updating New Property Data");
            pd = ps.addUpdatePropertyData(pd,true);
            return Response.status(Response.Status.ACCEPTED).entity(pd).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }


}
