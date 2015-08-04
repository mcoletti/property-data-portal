package com.codeitek.pdp.dal.interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public interface AdminDao {

    public AccountLevelDao getAccountLevelDao();
    public SystemGroupMembersDao getSystemGroupMembersDao();
    public SystemRolesDao getSystemRolesDao();
    public GroupsDao getGroupsDao();
    public GroupMembersDao getGroupMembersDao();
    public RoleDataDao getRoleDataDao();

}
