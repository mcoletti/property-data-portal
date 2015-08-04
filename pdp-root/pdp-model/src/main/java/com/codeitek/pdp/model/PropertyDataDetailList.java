package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/13/13
 * Time: 3:32 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "propertyDataDetailList")
public class PropertyDataDetailList extends GenericList<PropertyDataDetail> {

    @XmlElement(name = "propertyDataDetail")
    @Override
    public List<PropertyDataDetail> getList() {
        return this.list;
    }
}
