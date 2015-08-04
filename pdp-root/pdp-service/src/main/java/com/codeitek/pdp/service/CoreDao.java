package com.codeitek.pdp.service;

import com.codeitek.pdp.dal.interfaces.*;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/29/13
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CoreDao {

    public CustomerDao getCustomerDao();
    public CustomerAttributesDao getCustomerAttributesDao();
    public UserDao getUserDao();
    public AttributesDao getAttributesDao();
    public UserAttributesDao getUserAttributesDao();
    public RoleDataDao getRoleDataDao();
    public AccountLevelDao getAccountLevelDao();
    public GroupsDao getGroupsDao();
    public GroupMembersDao getGroupMembersDao();
    public SystemGroupMembersDao getSystemGroupMembersDao();
    public SystemRolesDao getSystemRolesDao();
    public UserActivityLogDao getUserActivityLogDao();
    public AuthorityDao getAuthorityDao();
    public AuthorityUserMapDao getAuthorityUserMapDao();
    public CityDao getCityDao();
    public StateDao getStateDao();
    public ZipCodesDao getZipCodesDao();

}
