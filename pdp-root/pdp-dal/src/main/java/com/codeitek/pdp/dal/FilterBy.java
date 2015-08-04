package com.codeitek.pdp.dal;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/16/13
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public enum FilterBy {
    Customer ("customer"),
    Property ("property"),
    StatusAll ("statusAll"),
    None ("none"), CustomerUid("uniqueId"), CustomerName("customerName");


    private final String value;

    FilterBy(String xName) {
        this.value = xName;
    }

    public String getValue(){
        return value;
    }
}
