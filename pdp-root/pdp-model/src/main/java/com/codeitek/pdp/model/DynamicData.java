package com.codeitek.pdp.model;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/9/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class DynamicData {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String valuePrefix;

    public String getValuePrefix() {
        return valuePrefix;
    }

    public void setValuePrefix(String valuePrefix) {
        this.valuePrefix = valuePrefix;
    }

    private int sortOrder;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    private int rawDataId;

    public int getRawDataId() {
        return rawDataId;
    }

    public void setRawDataId(int rawDataId) {
        this.rawDataId = rawDataId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DynamicData that = (DynamicData) o;

        if (id != that.id) return false;
        if (rawDataId != that.rawDataId) return false;
        if (sortOrder != that.sortOrder) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (valuePrefix != null ? !valuePrefix.equals(that.valuePrefix) : that.valuePrefix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (valuePrefix != null ? valuePrefix.hashCode() : 0);
        result = 31 * result + sortOrder;
        result = 31 * result + rawDataId;
        return result;
    }
}
