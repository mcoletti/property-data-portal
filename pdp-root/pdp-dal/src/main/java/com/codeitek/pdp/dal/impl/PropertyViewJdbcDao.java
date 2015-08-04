package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.*;
import com.codeitek.pdp.dal.interfaces.PropertyImageDao;
import com.codeitek.pdp.dal.interfaces.PropertyViewDao;
import com.codeitek.pdp.dal.mapper.PropertyViewRowMapper;
import com.codeitek.pdp.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Property view data access object.
 *
 * @author mcoletti@gmail.com
 */
@Deprecated
public class PropertyViewJdbcDao extends SpringJdbcSupport implements PropertyViewDao {

    private static final PropertyViewRowMapper PROPERTY_VIEW_MAPPER = new PropertyViewRowMapper();
    private final PropertyImageDao propertyImageDao;
    private final Utils utils;
//    private final PropertyFinancialViewDao propertyFinancialViewDao;
//    private final PropertyFinancialDao propertyFinancialDao;
//    private final FinancialKeyDao financialKeyDao;
//    private final StateCityViewDao stateCityDao;

//    @Autowired
//    public PropertyViewJdbcDao(final PropertyImageDao propertyImageDao, PropertyFinancialDao propertyFinancialDao, FinancialKeyDao financialKeyDao, final StateCityViewDao stateCityViewDao) {
//        this.propertyImageDao = propertyImageDao;
//        this.propertyFinancialDao = propertyFinancialDao;
//        this.financialKeyDao = financialKeyDao;
//        this.stateCityDao = stateCityViewDao;
//    }


    @Autowired
    public PropertyViewJdbcDao(PropertyImageDao propertyImageDao, Utils utils) {
        this.propertyImageDao = propertyImageDao;
        this.utils = utils;
    }

    @Override
    public List<PropertyFeedView> selectByCustomer(String customerUUId) {
        return getJdbcTemplate().query(DAOQueries.Q_PROPERTY_VIEW_BY_CUSTOMER, PROPERTY_VIEW_MAPPER, customerUUId);
    }

    @Override
    public List<PropertyFeedView> selectByUid(String customerUUId, String propertyDataUUId) {
        return getJdbcTemplate().query(DAOQueries.Q_PROPERTY_VIEW_BY_PROPERTY, PROPERTY_VIEW_MAPPER, customerUUId, propertyDataUUId);
    }

    @Override
    public List<PropertyFeedView> selectByCity(String customerUUId, String city) {
        return getJdbcTemplate().query(DAOQueries.Q_PROPERTY_VIEW_BY_CITY, PROPERTY_VIEW_MAPPER, customerUUId, city);
    }

    @Override
    public List<PropertyDataDetail> loadFullPropertyView(String customerUUId) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyDataDetail loadFullPropertyViewByProperty(String customerUUId, String propertyDataUUId) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PropertyDataDetail> loadFullPropertyViewByCity(String customerUUId, String city) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

//    @Override
//    public List<PropertyFeed> loadFullPropertyView(String customerUUId) throws Exception{
//        List<PropertyFeedView> propertyFeedViewList = selectByCustomer(customerUUId);
//        List<PropertyFeed> propertyFeedList = new ArrayList<PropertyFeed>();
//        PropertyFeedBuilder pfBuilder;
//
//        for (PropertyFeedView pfv : propertyFeedViewList) {
//
//            pfBuilder = new PropertyFeedBuilder(pfv.getId(), pfv.getCustomerUuid(), pfv.getPropName(), pfv.getSqft(), pfv.getDescription(),
//                     pfv.getPrice(), pfv.getNumBeds(), pfv.getType(), pfv.getStatus(), pfv.getNumBaths(), pfv.getDataSourceId(),pfv.getZip());
//
//            pfBuilder.setDataSource(pfv.getDataSource());
//            pfBuilder.setCityName(pfv.getCityName());
//            pfBuilder.setStateName(pfv.getStateName());
//            pfBuilder.setCustomerUUId(customerUUId);
//
//            utils.setStateCityData(pfBuilder,pfv);
//            utils.setFinancialData(pfBuilder,pfv);
//            pfBuilder.setImageData(propertyImageDao.selectByProperty(pfv.getId()));
//            propertyFeedList.add(pfBuilder.build());
//        }
//
//        return propertyFeedList;
//    }

//    @Override
//    public PropertyFeed loadFullPropertyViewByProperty(String customerUUId, String propertyDataUUId) throws Exception{
//        PropertyFeedView pfv = selectByUid(customerUUId, propertyDataUUId).get(0);
//        PropertyFeedBuilder pfBuilder = new PropertyFeedBuilder(pfv.getId(), pfv.getCustomerUuid(), pfv.getPropName(), pfv.getSqft(), pfv.getDescription(),
//                 pfv.getPrice(), pfv.getNumBeds(), pfv.getType(), pfv.getStatus(), pfv.getNumBaths(), pfv.getDataSourceId(),pfv.getZip());
//
//        pfBuilder.setDataSource(pfv.getDataSource());
//
//        pfBuilder.setCityName(pfv.getCityName());
//        pfBuilder.setStateName(pfv.getStateName());
//        pfBuilder.setCustomerUUId(customerUUId);
//        utils.setStateCityData(pfBuilder,pfv);
//        utils.setFinancialData(pfBuilder,pfv);
//        pfBuilder.setImageData(propertyImageDao.selectByProperty(pfv.getId()));
//
//        return pfBuilder.build();
//    }

//    @Override
//    public List<PropertyFeed> loadFullPropertyViewByCity(String customerUUId, String cityName) throws Exception {
//
//
//
//
//        List<PropertyFeedView> propertyFeedViewList = selectByCity(customerUUId, cityName);
//        List<PropertyFeed> propertyFeedList = new ArrayList<PropertyFeed>();
//        PropertyFeedBuilder pfBuilder;
//        for (PropertyFeedView pfv : propertyFeedViewList) {
//
//            pfBuilder = new PropertyFeedBuilder(pfv.getId(), pfv.getCustomerUuid(), pfv.getPropName(), pfv.getSqft(), pfv.getDescription(),
//                     pfv.getPrice(), pfv.getNumBeds(), pfv.getType(), pfv.getStatus(), pfv.getNumBaths(), pfv.getDataSourceId(),pfv.getZip());
//
//            pfBuilder.setDataSource(pfv.getDataSource());
//            pfBuilder.setCityName(pfv.getCityName());
//            pfBuilder.setStateName(pfv.getStateName());
//            pfBuilder.setCustomerUUId(customerUUId);
//            utils.setStateCityData(pfBuilder, pfv);
//            utils.setFinancialData(pfBuilder,pfv);
//            pfBuilder.setImageData(propertyImageDao.selectByProperty(pfv.getId()));
//            propertyFeedList.add(pfBuilder.build());
//        }
//
//        return propertyFeedList;
//    }

    @Override
    public List<PropertyDataDetail> loadFullPropertyViewByCity(String customerUUId, int cityId)throws Exception{


//        List<StateCityView> scl = utils.getStateCityDao().selectById(cityId);
//        StateCity sc = scl.get(0);
//        return loadFullPropertyViewByCity(customerUUId,sc.getCity().getCityName());
        return null;
    }

//    private void setStateCityData(PropertyFeedBuilder builder,PropertyFeedView pfv){
//        List<StateCityView> scvl;
//        StateCityView scv;
//        scvl = stateCityDao.selectViewByZip(pfv.getZip());
//        if(scvl.size()!=0){
//            scv = scvl.get(0);
//            builder.setCityName(scv.getCityName());
//            builder.setStateName(scv.getStateName());
//            builder.setStateCity(new StateCity(scv.getCityId(),scv.getCityName(),scv.getSummary(),scv.getImageUrl(),scv.getStateId(),scv.getStateName()));
//        }
//    }
//
//    /**
//     * Load up the PropertyFinancial Object and set the FinancialKey object
//     * @param builder
//     * @param pfv
//     * @throws Exception
//     */
//    private void setFinancialData(PropertyFeedBuilder builder,PropertyFeedView pfv) throws Exception {
//
//        List<PropertyFinancial> financialList = new ArrayList<PropertyFinancial>();
//
//        for(PropertyFinancial pf:propertyFinancialDao.findWherePropertyDataUuidEquals(pfv.getCustomerUuid())){
//
//              pf.setFinancialKey(financialKeyDao.findByPrimaryKey(pf.getFinancialKeyId()));
//              financialList.add(pf);
//        }
//        builder.setFinancialList(financialList);
//    }


}
