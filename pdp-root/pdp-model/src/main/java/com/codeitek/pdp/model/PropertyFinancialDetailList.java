package com.codeitek.pdp.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/29/13
 * Time: 6:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyFinancialDetailList extends GenericList<PropertyFinancialDetail> {


    @Override
    public List<PropertyFinancialDetail> getList() {
        return this.list;
    }
}
