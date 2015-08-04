package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/23/13
 * Time: 7:09 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "stateCityList")
public class StateCityList extends GenericList<StateCity> {

    @XmlElement(name = "stateCity")
    @Override
    public List<StateCity> getList() {
      return this.list;
    }
}
