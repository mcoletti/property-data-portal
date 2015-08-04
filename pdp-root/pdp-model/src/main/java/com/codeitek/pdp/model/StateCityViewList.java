package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/3/13
 * Time: 7:07 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "stateCityViewList")
public class StateCityViewList extends GenericList<StateCityView> {
    @XmlElement(name = "statCityView")
    @Override
    public List<StateCityView> getList() {
        return this.list;
    }
}
