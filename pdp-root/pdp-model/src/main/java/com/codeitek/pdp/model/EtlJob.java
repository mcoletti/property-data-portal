package com.codeitek.pdp.model;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/9/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class EtlJob {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String jobName;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    private Timestamp creDtm;

    public Timestamp getCreDtm() {
        return creDtm;
    }

    public void setCreDtm(Timestamp creDtm) {
        this.creDtm = creDtm;
    }

    private byte enabled;

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtlJob etlJob = (EtlJob) o;

        if (enabled != etlJob.enabled) return false;
        if (id != etlJob.id) return false;
        if (creDtm != null ? !creDtm.equals(etlJob.creDtm) : etlJob.creDtm != null) return false;
        if (jobName != null ? !jobName.equals(etlJob.jobName) : etlJob.jobName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        result = 31 * result + (creDtm != null ? creDtm.hashCode() : 0);
        result = 31 * result + (int) enabled;
        return result;
    }
}
