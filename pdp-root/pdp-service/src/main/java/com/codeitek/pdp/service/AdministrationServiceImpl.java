package com.codeitek.pdp.service;

import com.codeitek.pdp.cache.CacheItemKeys;
import com.codeitek.pdp.cache.CacheManager;
import com.codeitek.pdp.cache.CacheStore;
import com.codeitek.pdp.dal.exceptions.CustomerDaoException;
import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.dal.exceptions.StateDaoException;
import com.codeitek.pdp.model.*;
import com.codeitek.pdp.service.helpers.AdminServiceHelper;
import com.codeitek.pdp.service.utils.AuthUtils;
import com.codeitek.pdp.service.utils.AuthUtilsImpl;
import com.codeitek.pdp.service.utils.TokenUtils;
import com.codeitek.pdp.service.utils.TokenUtilsImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/27/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdministrationServiceImpl extends BaseService implements AdministrationService {


    private final CoreDao coreDao;
    private AdminServiceHelper serviceHelper;
    private TokenUtils tokenUtils;
    private AuthUtils authUtils;



    @Autowired
    protected AdministrationServiceImpl(CacheManager cacheManager, CoreDao coreDao) {
        super(cacheManager);
        this.coreDao = coreDao;
        this.serviceHelper = new AdminServiceHelper(this);
        this.tokenUtils = new TokenUtilsImpl(coreDao);
        this.authUtils = new AuthUtilsImpl(coreDao);
    }


    @Override
    public User addUpdateUserAccount(User dto, boolean update) throws DataBaseJdbcException {

        String userUuid = (update == true) ? coreDao.getUserDao().update(dto.getUuid(), dto) : coreDao.getUserDao().insert(dto);
        if (getCacheManager().isCacheEnabled()) {
            //TODO Add Cache Implementation to Modify USer Cache Item
        } else {
            dto = coreDao.getUserDao().findByPrimaryKey(userUuid);
        }
        return dto;

    }

    @Override
    public UserDetailView addUpdateUserDetail(UserDetail userDetail, boolean update) {


        if (getCacheManager().isCacheEnabled()) {
            //TODO Add Cache Implementation to Modify User Detail Cache Item
        }


        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UserActivityLog addUpdateUserActivity(UserActivityLog activityLog, boolean update) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<UserDetailView> getUserDetailViewList() throws Exception {
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

    @Override
    public Attributes addUpdateAttributes(Attributes dto, boolean update) throws DataBaseJdbcException {

        AttributesPk pk = (update == true) ? coreDao.getAttributesDao().update(dto.createPk(), dto) : coreDao.getAttributesDao().insert(dto);
        if (getCacheManager().isCacheEnabled()) {
            //TODO Add Cache Implementation
        } else {
            dto = coreDao.getAttributesDao().findByPrimaryKey(pk);
        }
        return dto;
    }

    @Override
    public Customer addUpdateCustomerAccount(Customer dto, boolean update) throws CustomerDaoException {

        String customerUuid = (update == true) ? coreDao.getCustomerDao().update(dto.getCustomerUuid(), dto) : coreDao.getCustomerDao().insert(dto);
        if (getCacheManager().isCacheEnabled()) {
            //TODO Add Cache Implementation
        } else {
            dto = coreDao.getCustomerDao().findByPrimaryKey(customerUuid);
        }
        return dto;
    }

    @Override
    public CustomerAttributes addUpdateCustomerAttributes(CustomerAttributes dto, boolean update) throws DataBaseJdbcException {

        CustomerAttributesPk pk = (update == true) ? coreDao.getCustomerAttributesDao().update(dto.createPk(), dto) : coreDao.getCustomerAttributesDao().insert(dto);
        if (getCacheManager().isCacheEnabled()) {
            //TODO Add Cache Implementations
        } else {
            dto = coreDao.getCustomerAttributesDao().findByPrimaryKey(pk);
        }
        return dto;
    }

    @Override
    public CustomerList getCustomerList() throws CustomerDaoException {

        CustomerList customerList = new CustomerList();
        if (getCacheManager().isCacheEnabled()) {
            //TODO Add Cache Implementation
        } else {
            customerList.setList(coreDao.getCustomerDao().findAll());
        }
        return customerList;
    }

    @Override
    public Customer getCustomer(String customerUuid) throws CustomerDaoException {


        Customer customer;
        if (getCacheManager().isCacheEnabled()) {
            customer = getCacheManager().getCacheItem(customerUuid);
        } else {
            customer = coreDao.getCustomerDao().findByPrimaryKey(customerUuid);
        }
        return customer;
    }

    @Override
    public Customer getCustomerByName(String name) throws CustomerDaoException {
        List<Customer> customerList;
        Customer customer;
        if (getCacheManager().isCacheEnabled()) {
            customer = getCacheManager().getCacheItem(name);
        } else {
            customerList = coreDao.getCustomerDao().findWhereNameEquals(name);
            customer = (customerList.size()==0) ? null : customerList.get(0);
        }
        return customer;
    }

    @Override
    public Authority getAuthorizedAuthority() throws DataBaseJdbcException {

        List<Authority> authorities = coreDao.getAuthorityDao().findWhereEnabledEquals(true);
        Authority authority = (authorities.size()==0) ? null : authorities.get(0);
        return authority;
    }

    @Override
    public List<AuthorityUserView> getAuthorityUsers(String authorityUuid) throws DataBaseJdbcException {
        List<AuthorityUserView> authorityUserViewList = new ArrayList<AuthorityUserView>();

        Authority authority = coreDao.getAuthorityDao().findByPrimaryKey(authorityUuid);
        if (!getCacheManager().isCacheEnabled()) {
            List<AuthorityUserMap> userMap = coreDao.getAuthorityUserMapDao().findWhereAuthorityUuidEquals(authorityUuid);
            User user;
            AuthorityUserView auv;
            for(AuthorityUserMap m: userMap){

                user = coreDao.getUserDao().findByPrimaryKey(m.getUserUuid());
                auv = new AuthorityUserView(user,authority);
                authorityUserViewList.add(auv);
            }
        }else{
            authorityUserViewList = getCacheManager().getCacheItem(String.format("%s_%s", CacheItemKeys.AUTH_USER_VIEW, authorityUuid), CacheStore.USER_DATA);
        }


        return authorityUserViewList;
    }

    @Override
    public TokenUtils getTokenUtils() {
        return tokenUtils;
    }

    @Override
    public City addUpdateCity(City city, boolean update) throws DataBaseJdbcException {
        CityPk pk;
        pk = (update == true) ? coreDao.getCityDao().update(city.createPk(),city) : coreDao.getCityDao().insert(city);
        return coreDao.getCityDao().findByPrimaryKey(pk);
    }

    @Override
    public State addUpdateState(State state, boolean update) throws StateDaoException {
        StatePk pk;
        pk= (update == true) ? coreDao.getStateDao().update(state.createPk(),state) : coreDao.getStateDao().insert(state);
        return coreDao.getStateDao().findByPrimaryKey(pk);

    }


}
