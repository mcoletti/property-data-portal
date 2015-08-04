package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/16/13
 * Time: 6:31 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "statCityView")
public class StateCityView extends StateCity implements Serializable {


    private int id;
    private int zip;

    public StateCityView() {
    }

    public StateCityView(int cityId, String city, String summary, String imageUrl, int stateId, String state, int id, int zip) {
        super(cityId, city, summary, imageUrl, stateId, state);
        this.id = id;
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
    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }


}
