package com.codeitek.pdp.model;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/9/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class EtlJobSchedule {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String runDay;

    public String getRunDay() {
        return runDay;
    }

    public void setRunDay(String runDay) {
        this.runDay = runDay;
    }

    private String runHour;

    public String getRunHour() {
        return runHour;
    }

    public void setRunHour(String runHour) {
        this.runHour = runHour;
    }

    private String runMin;

    public String getRunMin() {
        return runMin;
    }

    public void setRunMin(String runMin) {
        this.runMin = runMin;
    }

    private byte enabled;

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    private Timestamp creDtm;

    public Timestamp getCreDtm() {
        return creDtm;
    }

    public void setCreDtm(Timestamp creDtm) {
        this.creDtm = creDtm;
    }

    private int creUser;

    public int getCreUser() {
        return creUser;
    }

    public void setCreUser(int creUser) {
        this.creUser = creUser;
    }

    private int etlJobId;

    public int getEtlJobId() {
        return etlJobId;
    }

    public void setEtlJobId(int etlJobId) {
        this.etlJobId = etlJobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtlJobSchedule that = (EtlJobSchedule) o;

        if (creUser != that.creUser) return false;
        if (enabled != that.enabled) return false;
        if (etlJobId != that.etlJobId) return false;
        if (id != that.id) return false;
        if (creDtm != null ? !creDtm.equals(that.creDtm) : that.creDtm != null) return false;
        if (runDay != null ? !runDay.equals(that.runDay) : that.runDay != null) return false;
        if (runHour != null ? !runHour.equals(that.runHour) : that.runHour != null) return false;
        if (runMin != null ? !runMin.equals(that.runMin) : that.runMin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (runDay != null ? runDay.hashCode() : 0);
        result = 31 * result + (runHour != null ? runHour.hashCode() : 0);
        result = 31 * result + (runMin != null ? runMin.hashCode() : 0);
        result = 31 * result + (int) enabled;
        result = 31 * result + (creDtm != null ? creDtm.hashCode() : 0);
        result = 31 * result + creUser;
        result = 31 * result + etlJobId;
        return result;
    }
}
