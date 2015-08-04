package com.codeitek.pdp.model;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/9/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class EtlJobQueue {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Timestamp runDtm;

    public Timestamp getRunDtm() {
        return runDtm;
    }

    public void setRunDtm(Timestamp runDtm) {
        this.runDtm = runDtm;
    }

    private Timestamp endDtm;

    public Timestamp getEndDtm() {
        return endDtm;
    }

    public void setEndDtm(Timestamp endDtm) {
        this.endDtm = endDtm;
    }

    private byte running;

    public byte getRunning() {
        return running;
    }

    public void setRunning(byte running) {
        this.running = running;
    }

    private byte assigned;

    public byte getAssigned() {
        return assigned;
    }

    public void setAssigned(byte assigned) {
        this.assigned = assigned;
    }

    private byte complete;

    public byte getComplete() {
        return complete;
    }

    public void setComplete(byte complete) {
        this.complete = complete;
    }

    private int jobServerId;

    public int getJobServerId() {
        return jobServerId;
    }

    public void setJobServerId(int jobServerId) {
        this.jobServerId = jobServerId;
    }

    private int etlJobId;

    public int getEtlJobId() {
        return etlJobId;
    }

    public void setEtlJobId(int etlJobId) {
        this.etlJobId = etlJobId;
    }

    private int jobStatusId;

    public int getJobStatusId() {
        return jobStatusId;
    }

    public void setJobStatusId(int jobStatusId) {
        this.jobStatusId = jobStatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtlJobQueue that = (EtlJobQueue) o;

        if (assigned != that.assigned) return false;
        if (complete != that.complete) return false;
        if (etlJobId != that.etlJobId) return false;
        if (id != that.id) return false;
        if (jobServerId != that.jobServerId) return false;
        if (jobStatusId != that.jobStatusId) return false;
        if (running != that.running) return false;
        if (endDtm != null ? !endDtm.equals(that.endDtm) : that.endDtm != null) return false;
        if (runDtm != null ? !runDtm.equals(that.runDtm) : that.runDtm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (runDtm != null ? runDtm.hashCode() : 0);
        result = 31 * result + (endDtm != null ? endDtm.hashCode() : 0);
        result = 31 * result + (int) running;
        result = 31 * result + (int) assigned;
        result = 31 * result + (int) complete;
        result = 31 * result + jobServerId;
        result = 31 * result + etlJobId;
        result = 31 * result + jobStatusId;
        return result;
    }
}
