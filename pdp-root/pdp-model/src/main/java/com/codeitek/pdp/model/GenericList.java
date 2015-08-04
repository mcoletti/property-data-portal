package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/13/13
 * Time: 3:24 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class GenericList<T> implements IGenericList<T> {

    protected List<T> list = new ArrayList<T>();

    @XmlTransient
    public abstract List<T> getList();

    @Override
    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public void addToList(T item) {
        this.list.add(item);
    }
}
