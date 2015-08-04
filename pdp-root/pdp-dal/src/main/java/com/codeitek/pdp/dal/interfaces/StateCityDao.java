package com.codeitek.pdp.dal.interfaces;

import com.codeitek.pdp.model.StateCity;
import com.codeitek.pdp.model.StateCityView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/16/13
 * Time: 6:03 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StateCityDao {

    public List<StateCity> selectAll();
    public List<StateCity> selectById(int id);
    public List<StateCity> selectByCity(String city);
    public List<StateCity> selectByState(String state);
    public List<StateCity> selectViewByCustomerUUid(String customerUUId);
}
