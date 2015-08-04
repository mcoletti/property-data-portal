package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.model.UserDetailView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserManagementService extends UserDao {

    public List<UserDetailView> getUserDetailViewList() throws Exception;
    public List<UserDetailView> getUserDetailViewList(int userId);
    public List<UserDetailView> getUserDetailViewList(String customerUuid);

}
