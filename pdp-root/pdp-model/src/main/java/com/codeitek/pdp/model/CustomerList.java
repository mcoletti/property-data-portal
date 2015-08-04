package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/13/13
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "customerList")
public class CustomerList extends GenericList<Customer> {

    @XmlElement(name = "customer")
    @Override
    public List<Customer> getList() {
        return this.list;
    }
}
