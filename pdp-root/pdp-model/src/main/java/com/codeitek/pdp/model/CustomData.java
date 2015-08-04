package com.codeitek.pdp.model;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/20/13
 * Time: 5:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomData {
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

    private int dataTypeId;

    public int getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(int dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    private String propertyDataUuid;

    public String getPropertyDataUuid() {
        return propertyDataUuid;
    }

    public void setPropertyDataUuid(String propertyDataUuid) {
        this.propertyDataUuid = propertyDataUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomData that = (CustomData) o;

        if (dataTypeId != that.dataTypeId) return false;
        if (id != that.id) return false;
        if (rawDataId != that.rawDataId) return false;
        if (sortOrder != that.sortOrder) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (propertyDataUuid != null ? !propertyDataUuid.equals(that.propertyDataUuid) : that.propertyDataUuid != null)
            return false;
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
        result = 31 * result + dataTypeId;
        result = 31 * result + (propertyDataUuid != null ? propertyDataUuid.hashCode() : 0);
        return result;
    }
}
