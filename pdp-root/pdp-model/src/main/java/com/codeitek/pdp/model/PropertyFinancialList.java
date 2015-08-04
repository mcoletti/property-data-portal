package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/29/13
 * Time: 6:04 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "propertyFinancialList")
public class PropertyFinancialList extends GenericList<PropertyFinancial> {

    @XmlElement(name = "propertyFinancial")
    @Override
    public List<PropertyFinancial> getList() {
        return this.list;
    }
}
