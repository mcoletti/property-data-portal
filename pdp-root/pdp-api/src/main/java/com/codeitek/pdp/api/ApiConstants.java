package com.codeitek.pdp.api;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/13/13
 * Time: 3:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class  ApiConstants {
    public static final String AUTH_SERVICE_PATH = "/v1/authorise";
    public static final String PROPERTY_SERVICE_PATH = "/v1/propertyService";
    public static final String API_MP = "/v1/api";
    public static final String FEEDS_MP = "/feeds";
    public static final String CUSTOMER_MP = "/customer";
    public static final String STATE_CITY_VIEW_MP = "/stateCity";
    public static final String GET_SCV_BY_CUSTOMER = "/stateCity/customer";
    public static final String CITY_MP = "/city";
    public static final String CITY_BY_NAME_MP = "/city/{customerName}";
    public static final String CITY_LIST_MP = "/city/list";
    public static final String STATE_MP = "/state";
    public static final String STATE_BY_NAME_MP = "/state/{name}";
    public static final String STATE_LIST_MP = "/state/list";

    public static final String GET_CUSTOMERS_PATH = "/customers";
    public static final String CUSTOMER_PATH = "/customer";
    public static final String GET_CUSTOMER_BY_UUID_PATH = "/customer/customerUuid/{customerUuid}";
    public static final String GET_CUSTOMER_BY_NAME_PATH = "/customer/customerName/{customerName}";
    public static final String UPDATE_CUSTOMER_PATH = "/customer";
    public static final String GET_USER_LIST = "/customer/{customerUUId}/user/list";
    public static final String GET_USER = "/user/{userUuid}";
    public static final String USER_PATH = "/user";
    public static final String ADMIN_MP = "/v1/admin";
    public static final String GET_PAGE_LAYOUT_BY_PAGE = "/pageLayout/page/{page}";

}
