package com.codeitek.pdp.service.utils;

import com.codeitek.pdp.model.RoleData;
import com.codeitek.pdp.model.UserGroups;
import com.codeitek.pdp.service.CoreDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/31/13
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class AuthUtilsImpl implements AuthUtils {


    private final CoreDao coreDao;

    public AuthUtilsImpl(CoreDao coreDao) {
        this.coreDao = coreDao;
    }


    @Override
    public boolean AuthorizeUserAccount(String userUuid, String authorityUuid) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UserGroups getUserGroups(String userUuid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean userIsInGroup(String userUuid, int groupId) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean userIsInGroup(String userUuid, String group) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean userIsInSysRole(String userUuid, int sysRoleId) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean userIsInSysRole(String userUuid, String sysRole) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<RoleData> getUserRoles(String userUuid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean userIsInRole(String userUuid, int roleDataId) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean userIsInRole(String userUuid, String role) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
