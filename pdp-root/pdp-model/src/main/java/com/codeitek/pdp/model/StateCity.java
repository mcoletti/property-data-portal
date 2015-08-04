package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/10/13
 * Time: 7:52 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "stateCity")
public class StateCity implements Serializable {


    private State state;
    private City city;

    public StateCity() {
    }

    public StateCity(State state,City city) {

        this.state = state;
        this.city = city;
    }

    public StateCity(int cityId, String city, String summary, String imageUrl, int stateId, String state) {

        this.state = new State(stateId,state);
        this.city = new City(cityId,city,summary,imageUrl,stateId);
    }

    public void setState(State state) {
        this.state = state;
    }
    @XmlElement
    public State getState() {
        return state;
    }
    @XmlElement
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


}

