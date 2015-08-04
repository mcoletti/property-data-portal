package com.codeitek.pdp.model;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/29/13
 * Time: 6:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyFinancialDetail extends PropertyFinancial {


    private FinancialKey financialKey;

    public PropertyFinancialDetail() {
    }

    public PropertyFinancialDetail(int id, BigDecimal value, int financialKeyId, String propertyDataUuid, FinancialKey financialKey, FinancialKey financialKey1) {
        super(id, value, financialKeyId, propertyDataUuid, financialKey);
        financialKey = financialKey1;
    }


    public FinancialKey getFinancialKey() {
        return financialKey;
    }

    public void setFinancialKey(FinancialKey financialKey) {
        this.financialKey = financialKey;
    }
}
