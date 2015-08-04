package com.codeitek.pdp.service;

import com.codeitek.pdp.dal.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/29/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoreDaoImpl implements CoreDao {

    private final CustomerDao customerDao;
    private final CustomerAttributesDao customerAttributesDao;
    private final UserDao userDao;
    private final AttributesDao attributesDao;
    private final UserAttributesDao userAttributesDao;
    private final RoleDataDao roleDataDao;
    private final AccountLevelDao accountLevelDao;
    public final GroupMembersDao groupMembersDao;
    public final GroupsDao groupsDao;
    public final SystemGroupMembersDao systemGroupMembersDao;
    public final SystemRolesDao systemRolesDao;
    private final UserActivityLogDao userActivityLogDao;
    private final AuthorityDao authorityDao;
    private final AuthorityUserMapDao authorityUserMapDao;
    private final CityDao cityDao;
    private final StateDao stateDao;
    private final ZipCodesDao zipCodesDao;

    @Autowired
    public CoreDaoImpl(CustomerDao customerDao, CustomerAttributesDao customerAttributesDao, UserDao userDao, AttributesDao attributesDao, UserAttributesDao userAttributesDao, RoleDataDao roleDataDao, AccountLevelDao accountLevelDao, GroupMembersDao groupMembersDao, GroupsDao groupsDao, SystemGroupMembersDao systemGroupMembersDao, SystemRolesDao systemRolesDao, UserActivityLogDao userActivityLogDao, AuthorityDao authorityDao, AuthorityUserMapDao authorityUserMapDao, CityDao cityDao, StateDao stateDao, ZipCodesDao zipCodesDao) {
        this.customerDao = customerDao;
        this.customerAttributesDao = customerAttributesDao;
        this.userDao = userDao;
        this.attributesDao = attributesDao;
        this.userAttributesDao = userAttributesDao;
        this.roleDataDao = roleDataDao;
        this.accountLevelDao = accountLevelDao;
        this.groupMembersDao = groupMembersDao;
        this.groupsDao = groupsDao;
        this.systemGroupMembersDao = systemGroupMembersDao;
        this.systemRolesDao = systemRolesDao;
        this.userActivityLogDao = userActivityLogDao;
        this.authorityDao = authorityDao;
        this.authorityUserMapDao = authorityUserMapDao;
        this.cityDao = cityDao;
        this.stateDao = stateDao;
        this.zipCodesDao = zipCodesDao;
    }


    @Override
    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    @Override
    public CustomerAttributesDao getCustomerAttributesDao() {
        return customerAttributesDao;
    }

    @Override
    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public AttributesDao getAttributesDao() {
        return attributesDao;
    }

    @Override
    public UserAttributesDao getUserAttributesDao() {
        return userAttributesDao;
    }

    @Override
    public RoleDataDao getRoleDataDao() {
        return roleDataDao;
    }

    @Override
    public AccountLevelDao getAccountLevelDao() {
        return accountLevelDao;
    }

    @Override
    public GroupsDao getGroupsDao() {
        return groupsDao;
    }

    @Override
    public GroupMembersDao getGroupMembersDao() {
        return groupMembersDao;
    }

    @Override
    public SystemGroupMembersDao getSystemGroupMembersDao() {
        return systemGroupMembersDao;
    }

    @Override
    public SystemRolesDao getSystemRolesDao() {
        return systemRolesDao;
    }

    @Override
    public UserActivityLogDao getUserActivityLogDao() {
        return userActivityLogDao;
    }

    @Override
    public AuthorityDao getAuthorityDao() {
        return authorityDao;
    }

    @Override
    public AuthorityUserMapDao getAuthorityUserMapDao() {
        return authorityUserMapDao;
    }

    @Override
    public CityDao getCityDao() {
        return cityDao;
    }

    @Override
    public StateDao getStateDao() {
        return stateDao;
    }

    @Override
    public ZipCodesDao getZipCodesDao() {
        return zipCodesDao;
    }


}
