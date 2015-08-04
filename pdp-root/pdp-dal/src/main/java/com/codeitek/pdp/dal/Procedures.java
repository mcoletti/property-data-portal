package com.codeitek.pdp.dal;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/12/13
 * Time: 7:36 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class Procedures {
    public static final String GET_PROPERTY_DATA = "{call pr_GetPropertyData(?,?,?)}";
    public static final String GET_PROPERTY_FINANCIAL_DATA = "{call pr_GetPropertyFinancialData(?)}";
    public static final String GET_PROPERTY_IMAGE_DATA = "{call pr_GetPropertyImageData(?)}";
    public static final String GET_CUSTOMER_DATA = "{call pr_GetCustomers(?,?)}";
}
