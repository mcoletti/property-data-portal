package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.interfaces.PdpPropertyDaoService;
import com.codeitek.pdp.dal.interfaces.PropertyFinancialDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/6/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class PdpPropertyJdbcDaoService implements PdpPropertyDaoService {
    private final PropertyFinancialDao propertyFinancialDao;

    @Autowired
    public PdpPropertyJdbcDaoService(PropertyFinancialDao propertyFinancialDao) {
        this.propertyFinancialDao = propertyFinancialDao;
    }

    @Override
    public PropertyFinancialDao getPropertyFinancialDao() {
        return propertyFinancialDao;
    }
}
