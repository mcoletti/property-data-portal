package com.codeitek.pdp.dal;

import com.codeitek.pdp.dal.interfaces.*;
import com.codeitek.pdp.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/18/13
 * Time: 7:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {



    private final StateDao stateDao;
    private final CityDao cityDao;
    private final PropertyFinancialDao propertyFinancialDao;
    private final FinancialKeyDao financialKeyDao;

    @Autowired
    public Utils(StateDao stateDao, CityDao cityDao, PropertyFinancialDao propertyFinancialDao, FinancialKeyDao financialKeyDao) {
        this.stateDao = stateDao;
        this.cityDao = cityDao;
        this.propertyFinancialDao = propertyFinancialDao;
        this.financialKeyDao = financialKeyDao;
    }






    /**
     * Load up the PropertyFinancial Object and set the FinancialKey object
     * @param builder
     * @param pfv
     * @throws Exception
     */
    public void setFinancialData(PropertyDataDetailBuilder builder,PropertyFeedView pfv) throws Exception {

        List<PropertyFinancial> financialList = new ArrayList<PropertyFinancial>();

        for(PropertyFinancial pf:propertyFinancialDao.findWherePropertyDataUuidEquals(pfv.getUuid())){

            pf.setFinancialKey(financialKeyDao.findByPrimaryKey(pf.getFinancialKeyId()));
            financialList.add(pf);
        }
        builder.setFinancialList(financialList);
    }



}
