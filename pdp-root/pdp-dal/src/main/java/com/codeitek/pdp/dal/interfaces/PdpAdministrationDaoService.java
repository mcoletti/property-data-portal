package com.codeitek.pdp.dal.interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 3:26 AM
 * To change this template use File | Settings | File Templates.
 */
public interface PdpAdministrationDaoService {

    public UserDao getUserDao();
    public UserAttributesDao getUserAttributesDao();
    public UserActivityLogDao getUserActivityLogDao();
    public AccountLevelDao getAccountLevelDao();
    public SystemGroupMembersDao getSystemGroupMembersDao();
    public SystemRolesDao getSystemRolesDao();
    public GroupsDao getGroupsDao();
    public GroupMembersDao getGroupMembersDao();
    public RoleDataDao getRoleDataDao();
    public CustomerDao getCustomerDao();

}
