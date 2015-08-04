package com.codeitek.pdp.dal;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/29/13
 * Time: 6:02 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public enum QueriesEnums {

    PropertyFeed("from PropertyFeedView"),
    Customers("from Customer"), PropertyImages("from PropertyImageView"), PropertyFinacial("from PropertyFinancialView");

    private final String query;

    QueriesEnums(String query) {
        this.query = query;
    }

    public String getQueryString(){
        return query;
    }
}
