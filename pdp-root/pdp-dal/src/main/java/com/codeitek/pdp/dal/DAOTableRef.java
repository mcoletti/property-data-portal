package com.codeitek.pdp.dal;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 2:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class DAOTableRef {
    private static final String DB = "PDPDB";
    public static final String CUSTOMER = String.format("%s.CUSTOMER",DB);
    public static final String SYS_GRP_MEMS = String.format("%s.SYSTEM_GROUP_MEMBERS",DB);
    public static final String SYS_ROLES = String.format("%s.SYSTEM_ROLES", DB);
    public static final String USR_ACT_LOG = String.format("%s.USER_ACTIVITY_LOG", DB);
    public static final String USR_ATRIBS = String.format("%s.USER_ATTRIBUTES", DB);
    public static final String USER = String.format("%s.USER", DB);
    public static final String ROLE_DATA = String.format("%s.ROLE_DATA", DB);
    public static final String PROP_IMGS = String.format("%s.PROPERTY_IMAGES", DB);
    public static final String RAW_DATA = String.format("%s.RAW_DATA", DB);
    public static final String ACCT_LVL = String.format("%s.ACCOUNT_LEVEL", DB);
    public static final String PROP_FINANCIAL = String.format("%s.PROPERTY_FINANCIAL", DB);
    public static final String PAGE_REF_VIEW = String.format("$s.vw_PageLayout", DB);
    public static final String AUTHORITY = String.format("%s.AUTHORITY", DB);
    public static final String USR_AUTH_TOKEN_MAP = String.format("%s.USER_AUTH_TOKEN_MAP", DB);
    public static final String PROP_DATA = String.format("%s.PROPERTY_DATA", DB);
}
