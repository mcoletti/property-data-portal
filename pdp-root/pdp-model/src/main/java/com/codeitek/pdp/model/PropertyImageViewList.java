package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/1/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "propertyImageViewList")
public class PropertyImageViewList extends GenericList<PropertyImageView> {

    @XmlElement(name = "propertyImageView")
    @Override
    public List<PropertyImageView> getList() {
        return this.list;
    }
}
