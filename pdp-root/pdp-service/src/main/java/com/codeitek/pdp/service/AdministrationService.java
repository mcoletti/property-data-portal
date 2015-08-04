package com.codeitek.pdp.service;

import com.codeitek.pdp.dal.exceptions.CustomerDaoException;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.exceptions.StateDaoException;
import com.codeitek.pdp.model.*;
import com.codeitek.pdp.service.utils.TokenUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/27/13
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AdministrationService {


    public User addUpdateUserAccount(User dto,boolean update) throws DataBaseJdbcException;
    public UserDetailView addUpdateUserDetail(UserDetail dto,boolean update);
    public UserActivityLog addUpdateUserActivity(UserActivityLog dto,boolean update);
    public List<UserDetailView> getUserDetailViewList() throws Exception;
    public List<UserDetailView> getUserDetailViewList(int userId);
    public List<UserDetailView> getUserDetailViewList(String customerUuid);
    public Attributes addUpdateAttributes(Attributes dto,boolean update) throws DataBaseJdbcException;
    public Customer addUpdateCustomerAccount(Customer dto,boolean update) throws CustomerDaoException;
    public CustomerAttributes addUpdateCustomerAttributes(CustomerAttributes dto,boolean update) throws DataBaseJdbcException;
    public CustomerList getCustomerList() throws CustomerDaoException;
    public Customer getCustomer(String customerUuid) throws CustomerDaoException;
    public Customer getCustomerByName(String name) throws CustomerDaoException;
    public Authority getAuthorizedAuthority() throws DataBaseJdbcException;
    public List<AuthorityUserView> getAuthorityUsers(String authorityUuid) throws DataBaseJdbcException;
    public TokenUtils getTokenUtils();


    public City addUpdateCity(City city, boolean b) throws DataBaseJdbcException;

    public State addUpdateState(State state, boolean update) throws StateDaoException;
}
