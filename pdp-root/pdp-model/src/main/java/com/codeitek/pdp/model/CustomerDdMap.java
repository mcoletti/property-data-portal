package com.codeitek.pdp.model;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/9/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDdMap {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int dynamicDataId;

    public int getDynamicDataId() {
        return dynamicDataId;
    }

    public void setDynamicDataId(int dynamicDataId) {
        this.dynamicDataId = dynamicDataId;
    }

    private String dynamicDataName;

    public String getDynamicDataName() {
        return dynamicDataName;
    }

    public void setDynamicDataName(String dynamicDataName) {
        this.dynamicDataName = dynamicDataName;
    }

    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDdMap that = (CustomerDdMap) o;

        if (customerId != that.customerId) return false;
        if (dynamicDataId != that.dynamicDataId) return false;
        if (id != that.id) return false;
        if (dynamicDataName != null ? !dynamicDataName.equals(that.dynamicDataName) : that.dynamicDataName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + dynamicDataId;
        result = 31 * result + (dynamicDataName != null ? dynamicDataName.hashCode() : 0);
        result = 31 * result + customerId;
        return result;
    }
}
