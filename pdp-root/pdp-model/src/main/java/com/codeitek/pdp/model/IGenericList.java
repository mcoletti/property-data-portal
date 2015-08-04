package com.codeitek.pdp.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/13/13
 * Time: 3:23 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IGenericList<T> {
    public void setList(List<T> list);
    public void addToList(T item);
}
