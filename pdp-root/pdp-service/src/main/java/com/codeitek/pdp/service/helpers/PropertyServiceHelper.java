package com.codeitek.pdp.service.helpers;

import com.codeitek.pdp.dal.exceptions.DataBaseJdbcException;
import com.codeitek.pdp.model.*;
import com.codeitek.pdp.service.PropertyCoreDao;
import com.codeitek.pdp.service.PropertyService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/27/13
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyServiceHelper {

    private final PropertyService propertyService;
    private final PropertyCoreDao coreDaoService;

    public PropertyServiceHelper(PropertyService pds, PropertyCoreDao coreDaoService) {
        this.propertyService = pds;
        this.coreDaoService = coreDaoService;
    }

    public void getPropertyDataFeedList(PropertyDataDetailList pdfl ,List<PropertyData> pdl,String dsName) throws Exception{
        PropertyDataDetailBuilder pfb;
        ZipCodes zc;
        City city;
        State state;
        for(PropertyData pd: pdl){

            pfb = new PropertyDataDetailBuilder(pd);
            zc = coreDaoService.getZipCodesDao().findByPrimaryKey(pd.getZipCode());
            city =  coreDaoService.getCityDao().findByPrimaryKey(zc.getCityId());
            state =  coreDaoService.getStateDao().findByPrimaryKey(city.getStateId());
            pfb.setCity(city.getCityName());
            pfb.setState(state.getStateName());
            pfb.setStateCity(new StateCity(state, city));
            pfb.setDataSource(dsName);
            pfb.setFinancialList(coreDaoService.getPropertyFinancialDao().findWherePropertyDataUuidEquals(pd.getUuid()));
            pfb.setImageList(coreDaoService.getPropertyImagesDao().findByPropertyData(pd.getUuid()));
            pdfl.addToList(pfb.build());
        }
    }

    public PropertyFinancialPk addUpdateFinacial(PropertyFinancial pf,boolean update) throws DataBaseJdbcException {

        PropertyFinancialPk pk = (update == true) ? coreDaoService.getPropertyFinancialDao().update(pf.createPk(),pf) : coreDaoService.getPropertyFinancialDao().insert(pf);
        return pk;
    }

}
