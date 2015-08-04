package com.codeitek.pdp.dal;

import com.codeitek.pdp.dal.interfaces.PdpDaoService;
import com.codeitek.pdp.model.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 4:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyServiceHelper {


    private final PdpDaoService pds;

    public PropertyServiceHelper(PdpDaoService pds) {
        this.pds = pds;
    }

    public void getPropertyDataFeedList(PropertyDataDetailList pdfl ,List<PropertyData> pdl,String dsName) throws Exception{
        PropertyDataDetailBuilder pfb;
        ZipCodes zc;
        City city;
        State state;
        for(PropertyData pd: pdl){

            pfb = new PropertyDataDetailBuilder(pd);
            zc = pds.getZipCodesDao().findByPrimaryKey(pd.getZipCode());
            city =  pds.getCityDao().findByPrimaryKey(zc.getCityId());
            state =  pds.getStateDao().findByPrimaryKey(city.getStateId());
            pfb.setCity(city.getCityName());
            pfb.setState(state.getStateName());
            pfb.setStateCity(new StateCity(state, city));
            pfb.setDataSource(dsName);
            pfb.setFinancialList(pds.getPropertyFinancialDao().findWherePropertyDataUuidEquals(pd.getUuid()));
            pfb.setImageList(pds.getPropertyImagesDao().findByPropertyData(pd.getUuid()));
            pdfl.addToList(pfb.build());
        }
    }


}
