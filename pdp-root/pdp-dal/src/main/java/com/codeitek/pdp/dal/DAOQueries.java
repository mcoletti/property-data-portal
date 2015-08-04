package com.codeitek.pdp.dal;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/7/13
 * Time: 3:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class DAOQueries {

    // Property DB Queries
    public static final String Q_PROPERTY_VIEW = "SELECT * FROM PDPDB.vw_PropertyFeed";
    public static final String Q_PROPERTY_VIEW_BY_CUSTOMER = String.format("%s WHERE CUST_UUID = ?", Q_PROPERTY_VIEW);
    public static final String Q_PROPERTY_VIEW_BY_PROPERTY = String.format("%s WHERE CUST_UUID = ? AND UUID = ?", Q_PROPERTY_VIEW);;
    public static final String Q_PROPERTY_VIEW_BY_CITY = String.format("%s WHERE CUST_UUID = ? AND CITY = ?", Q_PROPERTY_VIEW);
    public static final String Q_PROPERTY_IMAGE_DATA = "SELECT * FROM PDPDB.PROPERTY_IMAGES";
    public static final String Q_PROPERTY_IMAGE_DATA_BY_PROPERTY = String.format("%s WHERE PROPERTY_DATA_ID = ?", Q_PROPERTY_IMAGE_DATA);
    public static final String S_PROPERTY_FINANCIAL_VIEW = "SELECT * FROM PDPDB.vw_PropertyFinacials";
    public static final String S_PROPERTY_FINANCIAL_VIEW_BY_PROPERTY = String.format("%s WHERE PROPERTY_DATA_UUID = ?",S_PROPERTY_FINANCIAL_VIEW);
    // Customer DB QUeries
    public static final String S_CUSTOMER = "SELECT * FROM PDPDB.CUSTOMER";
    public static final String S_CUSTOMER_BY_UUID = String.format("%s WHERE UUID = ?", S_CUSTOMER);
    public static final String S_CUSTOMER_BY_NAME = String.format("%s WHERE CUST_NAME = ?", S_CUSTOMER);
    // State City DB Queries
    public static final String S_CITY = "SELECT * FROM PDPDB.CITY";
    public static final String S_CITY_BY_ID = String.format("%s WHERE ID = ?", S_CITY);
    public static final String S_CITY_BY_CITY = String.format("%s WHERE CITY = ?", S_CITY);
    public static final String S_STATE = "SELECT * FROM TALONDB.STATE";
    public static final String S_STATE_BY_STATE = String.format("%s WHERE STATE = ?", S_STATE);

    public static final String S_STATE_CITY_VIEW = "SELECT @rownum:=@rownum+1,PDPDB.vw_stateCityInfo.* FROM (SELECT @rownum:=0) r, TALONDB.vw_stateCityInfo";
    public static final String S_STATE_CITY_VIEW_BY_CITY_ID = String.format("%s WHERE CITY_ID = ?", S_STATE_CITY_VIEW);
    public static final String S_STATE_CITY_VIEW_BY_ZIP = String.format("%s WHERE ZIP_CODE = ?", S_STATE_CITY_VIEW);
    public static final String S_STATE_CITY_VIEW_BY_CITY = String.format("%s WHERE CITY = ?", S_STATE_CITY_VIEW);
    public static final String S_STATE_CITY_VIEW_BY_STATE = String.format("%s WHERE STATE = ?", S_STATE_CITY_VIEW);

    public static final String S_STATE_CITY = "SELECT * FROM PDPDB.vw_StateCityDistinct";
    public static final String S_STATE_CITY_BY_CUST_UUID = String.format("%s WHERE CUST_UUID = ?", S_STATE_CITY);
    public static final String S_STATE_CITY_BY_CITY_ID = String.format("%s WHERE CITY_ID = ?", S_STATE_CITY);
    public static final String S_STATE_CITY_BY_CITY = String.format("%s WHERE CITY = ?", S_STATE_CITY);
    public static final String S_STATE_CITY_BY_STATE = String.format("%s WHERE STATE = ?", S_STATE_CITY);



    public static final String Q_FINANCIAL_KEY = "SELECT * FROM PDPDB.FINACIAL_KEY";
    public static final String Q_FINANCIAL_KEY_BY_ID =String.format("%s WHERE ID = ?",Q_FINANCIAL_KEY);

    public static final String S_PAGE_LAYOUT_VIEW = "SELECT * FROM PDPDB.vw_PageLayout";
    public static final String Q_PAGE_LAYOUT_VIEW_BY_ID = String.format("%s WHERE PAGE_ID = ? ORDER BY PAGE_ID", S_PAGE_LAYOUT_VIEW);
    public static final String Q_PAGE_LAYOUT_VIEW_BY_PAGE = String.format("%s WHERE PAGE = ? ORDER BY PAGE", S_PAGE_LAYOUT_VIEW);
    public static final String Q_PAGE_LAYOUT_VIEW_BY_SEC_ID = String.format("%s WHERE PAGE_SEC_ID = ? ORDER BY PAGE_SEC_ID", S_PAGE_LAYOUT_VIEW);
    public static final String Q_PAGE_LAYOUT_VIEW_BY_SEC_KEY = String.format("%s WHERE PAGE_SEC_KEY = ? ORDER BY PAGE_SEC_KEY", S_PAGE_LAYOUT_VIEW);
    public static final String Q_PAGE_LAYOUT_VIEW_BY_SEC_GRP_KEY = String.format("%s WHERE SEC_GRP_KEY = ? ORDER BY SEC_GRP_KEY", S_PAGE_LAYOUT_VIEW);
    public static final String Q_PAGE_LAYOUT_VIEW_BY_SEC_GRP_DEFAULT_IND = String.format("%s WHERE SEC_GRP_DEFAULT_IND = ? ORDER BY SEC_GRP_DEFAULT_IND", S_PAGE_LAYOUT_VIEW);
    public static final String Q_PAGE_LAYOUT_VIEW_BY_SEC_GRP_ELEMENT_ID = String.format("%s WHERE GRP_ELEMENT_ID = ? ORDER BY GRP_ELEMENT_ID", S_PAGE_LAYOUT_VIEW);

    public static final String I_PROP_FINANCIAL = "INSERT INTO PDPDB.PROPERTY_FINANCIAL ( VALUE, FINANCIAL_KEY_ID, PROPERTY_DATA_UUID ) VALUES ( ?, ?, ? )";
    public static final String U_PROP_FINANCIAL ="UPDATE PDPDB.PROPERTY_FINANCIAL SET ID = ?, VALUE = ?, FINANCIAL_KEY_ID = ?, PROPERTY_DATA_UUID = ? WHERE ID = ?";
    public static final String D_PROP_FINANCIAL = "DELETE FROM PDPDB.PROPERTY_FINANCIAL WHERE ID = ?";
    public static final String S_PROPERTY_FINANCIAL = "SELECT ID, VALUE, FINANCIAL_KEY_ID, PROPERTY_DATA_UUID FROM PDPDB.PROPERTY_FINANCIAL";
    public static final String Q_PROPERTY_FINANCIAL_BY_VALUE =String.format("%s WHERE VALUE = ? ORDER BY VALUE", S_PROPERTY_FINANCIAL);
    public static final String Q_PROPERTY_FINANCIAL_BY_ID =String.format("%s WHERE ID = ?", S_PROPERTY_FINANCIAL);
    public static final String Q_PROPERTY_FINANCIAL_BY_PROPERTY =String.format("%s WHERE PROPERTY_DATA_UUID = ?", S_PROPERTY_FINANCIAL);
    public static final String Q_PROPERTY_FINANCIAL_BY_FINANCIAL_KEY_ID = String.format("%s WHERE FINANCIAL_KEY_ID = ?", S_PROPERTY_FINANCIAL);


    public static final String S_USER_AUTH_MAP = String.format("SELECT TOKEN, USER_UUID, AUTHORITIES_ID, EXPIRATION_DTM FROM %s",DAOTableRef.USR_AUTH_TOKEN_MAP);
    public static final String I_USER_AUTH_MAP = String.format("INSERT INTO %s ( TOKEN, USER_UUID, AUTHORITIES_ID , EXPIRATION_DTM ) VALUES ( ?, ?, ? , ? )",DAOTableRef.USR_AUTH_TOKEN_MAP);
    public static final String D_USER_AUTH_MAP = String.format("DELETE FROM %s WHERE TOKEN = ?",DAOTableRef.USR_AUTH_TOKEN_MAP);
    public static final String U_USER_AUTH_MAP = String.format("UPDATE $s SET TOKEN = ?, USER_UUID = ?, AUTHORITIES_ID = ?,EXPIRATION_DTM = ? WHERE TOKEN = ?",DAOTableRef.USR_AUTH_TOKEN_MAP);


    public static final String S_AUTHORITY = String.format("SELECT * %s",DAOTableRef.AUTHORITY);
    public static final String I_AUTHORITY = String.format("INSERT INTO %s ( AUTHORITY, ENABLED, API_URL, API__AUTH_TOKEN , DELETE_IND ) VALUES ( ?, ?, ?, ? , ? )",DAOTableRef.AUTHORITY);
    public static final String U_AUTHORITY = String.format("UPDATE %s SET AUTHORITY = ? , ENABLED = ?, API_URL = ?, API__AUTH_TOKEN = ?, DELETE_IND = ? WHERE UUID = ?",DAOTableRef.AUTHORITY);
    public static final String D_AUTHORITY = String.format("UPDATE %s SET DELETE_IND = 1 WHERE UUID = ?",DAOTableRef.AUTHORITY);


    public static final String S_USER = String.format("SELECT UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, ROLE_DATA_ID, LAST_LOGIN_DTM, LOCK_IND, AUTH_TOKEN, AUTH_TOKEN_EXPIRATION_DTM FROM %s",DAOTableRef.USER);
    public static final String I_USER = String.format("INSERT INTO %s ( UUID, USER_NAME, FIRST_NAME, LAST_NAME, PRIMARY_EMAIL, REFERRED_BY, GENDER, DELETE_IND, CUSTOMER_UUID, LAST_LOGIN_DTM, LOCK_IND, AUTH_TOKEN, AUTH_TOKEN_EXPIRATION_DTM ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ? )",DAOTableRef.USER);
    public static final String U_USER = String.format("UPDATE %s SET UUID = ?, USER_NAME = ?, FIRST_NAME = ?, LAST_NAME = ?, PRIMARY_EMAIL = ?, REFERRED_BY = ?, GENDER = ?, DELETE_IND = ?, CUSTOMER_UUID = ?,  LAST_LOGIN_DTM = ?, LOCK_IND = ?, AUTH_TOKEN = ?, AUTH_TOKEN_EXPIRATION_DTM = ? WHERE UUID = ?",DAOTableRef.USER);


    private static final String PROP_DATA_FIELDS = "UUID, PROP_NAME, PRICE, SQFT, DESCRIPTION, NUM_BEDS, NUM_BATHS,YEAR_BUILT,LOT_SIZE,DATA_SOURCE_ID, ZIP_CODE, PROPERTY_TYPE_ID , LOT_SIZE, MARKET_ID";
    public static final String S_PROP_DATA = String.format("SELECT %s FROM %s",PROP_DATA_FIELDS,DAOTableRef.PROP_DATA);
    public static final String I_PROP_DATA = String.format("INSERT INTO %s (%s) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )",PROP_DATA_FIELDS,DAOTableRef.PROP_DATA);
    public static final String U_PROP_DATA = String.format("UPDATE %s SET UUID = ?, PROP_NAME = ?, PRICE = ?, SQFT = ?, DESCRIPTION = ?, NUM_BEDS = ?, NUM_BATHS = ?, DATA_SOURCE_ID = ?, ZIP_CODE = ?, PROPERTY_TYPE_ID = ?, LOT_SIZE = ?, YEAR_BUILT = ?, MARKET_ID = ? WHERE UUID = ?",DAOTableRef.PROP_DATA);
}
