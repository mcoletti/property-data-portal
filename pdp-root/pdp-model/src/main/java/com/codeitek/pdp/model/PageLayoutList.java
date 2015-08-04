package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/6/13
 * Time: 6:56 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "pageLayoutList")
public class PageLayoutList extends GenericList<Pagelayout> {

    @XmlElement(name = "pageLayout")
    @Override
    public List<Pagelayout> getList() {
        return this.list;
    }
}
