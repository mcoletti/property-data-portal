package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/9/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
@XmlRootElement(name = "users")
public class Users implements Serializable {


    public Users() {
    }

    /**
     *
     * @param id
     * @param userName
     * @param enabled
     * @param creUserId
     * @param creDtm
     */
    public Users(int id, String userName, byte enabled, int creUserId, Date creDtm) {
        this.id = id;
        this.userName = userName;
        this.enabled = enabled;
        this.creUserId = creUserId;
        this.creDtm = creDtm;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private byte enabled;

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    private int creUserId;

    public int getCreUserId() {
        return creUserId;
    }

    public void setCreUserId(int creUserId) {
        this.creUserId = creUserId;
    }

    private Date creDtm;

    public Date getCreDtm() {
        return creDtm;
    }

    public void setCreDtm(Date creDtm) {
        this.creDtm = creDtm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (creUserId != users.creUserId) return false;
        if (enabled != users.enabled) return false;
        if (id != users.id) return false;
        if (creDtm != null ? !creDtm.equals(users.creDtm) : users.creDtm != null) return false;
        if (userName != null ? !userName.equals(users.userName) : users.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (int) enabled;
        result = 31 * result + creUserId;
        result = 31 * result + (creDtm != null ? creDtm.hashCode() : 0);
        return result;
    }
}
