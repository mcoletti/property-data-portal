package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.model.StateCityView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/16/13
 * Time: 6:03 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StateCityViewDao {

    public List<StateCityView> selectAll();
    public List<StateCityView> selectById(int id);
    public List<StateCityView> selectByCity(String city);
    public List<StateCityView> selectByState(String state);
    public List<StateCityView> selectViewByZip(int zip);
}
