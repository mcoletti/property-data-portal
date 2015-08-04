package com.codeitek.pdp.model;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/9/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class EtlJobPropMap {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int etlJobId;

    public int getEtlJobId() {
        return etlJobId;
    }

    public void setEtlJobId(int etlJobId) {
        this.etlJobId = etlJobId;
    }

    private int etlJobPropertiesId;

    public int getEtlJobPropertiesId() {
        return etlJobPropertiesId;
    }

    public void setEtlJobPropertiesId(int etlJobPropertiesId) {
        this.etlJobPropertiesId = etlJobPropertiesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtlJobPropMap that = (EtlJobPropMap) o;

        if (etlJobId != that.etlJobId) return false;
        if (etlJobPropertiesId != that.etlJobPropertiesId) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + etlJobId;
        result = 31 * result + etlJobPropertiesId;
        return result;
    }
}
