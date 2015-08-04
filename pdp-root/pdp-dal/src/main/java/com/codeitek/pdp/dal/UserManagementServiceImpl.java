package com.codeitek.pdp.dal;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.impl.UserJdbcDao;
import com.codeitek.pdp.dal.interfaces.PdpAdministrationDaoService;
import com.codeitek.pdp.dal.interfaces.PdpDaoService;
import com.codeitek.pdp.dal.interfaces.UserManagementService;
import com.codeitek.pdp.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 8:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserManagementServiceImpl extends UserJdbcDao implements UserManagementService {

    private final PdpAdministrationDaoService administrationDaoService;

    public UserManagementServiceImpl(PdpAdministrationDaoService administrationDaoService) {
        this.administrationDaoService = administrationDaoService;
    }


    @Override
    public List<UserDetailView> getUserDetailViewList() throws Exception {

        List<User> userList = administrationDaoService.getUserDao().findAll();
        List<UserDetailView> detailViewList = new ArrayList<UserDetailView>();
        UserDetailView detailView;
        List<GroupMembers> groupMembers;
        List<SystemGroupMembers> systemGroupMembers;
        for (User user : userList) {

            List<GroupView> groupViews = new ArrayList<GroupView>();




            detailView = new UserDetailView(user);
            detailView.setCustomer(administrationDaoService.getCustomerDao().findByPrimaryKey(user.getCustomerUuid()));
            detailView.setUserAttributes(administrationDaoService.getUserAttributesDao().findWhereUserUuidEquals(user.getUuid()));


        }
        List<UserAttributes> userAttributes = administrationDaoService.getUserAttributesDao().findAll();


        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<UserDetailView> getUserDetailViewList(int userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<UserDetailView> getUserDetailViewList(String customerUuid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
