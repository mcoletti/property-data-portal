package com.codeitek.pdp.service.utils;

import com.codeitek.pdp.model.RoleData;
import com.codeitek.pdp.model.UserGroups;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/31/13
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AuthUtils {

    public boolean AuthorizeUserAccount(String userUuid,String authorityUuid);
    public UserGroups getUserGroups(String userUuid);
    public boolean userIsInGroup(String userUuid,int groupId);
    public boolean userIsInGroup(String userUuid,String group);
    public boolean userIsInSysRole(String userUuid,int sysRoleId);
    public boolean userIsInSysRole(String userUuid,String sysRole);
    public List<RoleData> getUserRoles(String userUuid);
    public boolean userIsInRole(String userUuid,int roleDataId);
    public boolean userIsInRole(String userUuid,String role);


}
