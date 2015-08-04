package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/9/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
@XmlRootElement(name = "stateInfo")
public class StateInfo implements Serializable {
    private int id;
    private String state;
    private String city;
    private String zip;

    public StateInfo() {
    }

    /**
     *
     * @param id
     * @param state
     * @param city
     * @param zip
     */
    public StateInfo(int id, String state, String city, String zip) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @XmlElement
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @XmlElement
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateInfo stateInfo = (StateInfo) o;

        if (id != stateInfo.id) return false;
        if (city != null ? !city.equals(stateInfo.city) : stateInfo.city != null) return false;
        if (state != null ? !state.equals(stateInfo.state) : stateInfo.state != null) return false;
        if (zip != null ? !zip.equals(stateInfo.zip) : stateInfo.zip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        return result;
    }
}
