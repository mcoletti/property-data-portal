package com.codeitek.pdp.service.helpers;

import com.codeitek.pdp.dal.interfaces.PdpAdministrationDaoService;
import com.codeitek.pdp.model.*;
import com.codeitek.pdp.service.AdministrationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdminServiceHelper {

    private AdministrationService adminService;
    private List<GroupMembers> groupMembers;
    private List<SystemGroupMembers> systemGroupMembers;
    private List<GroupView> groupViews;
    private List<Groups> groupsList;
    private GroupView groupView;

    public AdminServiceHelper(AdministrationService administrationDaoService) {
        this.adminService = administrationDaoService;
    }

    public void getGroupViewList(User user,List<GroupView> groupViews)throws Exception{

//        groupViews = new ArrayList<GroupView>();
//
//        groupMembers = adminService. .getGroupMembersDao().findWhereUserUuidEquals(user.getCustomerUuid());
//        groupsList = new ArrayList<Groups>();
//        Groups groups;
//        for (GroupMembers gm:groupMembers){
//            groups = adminService.getGroupsDao().findByPrimaryKey(gm.getGroupsId());
//            groupsList.add(groups);
//        }
//
//
//
//
//        systemGroupMembers = adminService.getSystemGroupMembersDao().findByUser(user.getCustomerUuid());



    }

}
