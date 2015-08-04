package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOQueries;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.interfaces.StateCityDao;
import com.codeitek.pdp.dal.mapper.StateCityRowMapper;
import com.codeitek.pdp.model.StateCity;

import java.util.List;

/**
 * State-cityName data access object.
 *
 * @author mcoletti@gmail.com
 */
@Deprecated
public class StateCityJdbcDao extends SpringJdbcSupport implements StateCityDao {

    private static final StateCityRowMapper STATE_CITY_MAPPER = new StateCityRowMapper();

    @Override
    public List<StateCity> selectAll() {
        return getJdbcTemplate().query(DAOQueries.S_STATE_CITY, STATE_CITY_MAPPER);
    }

    @Override
    public List<StateCity> selectById(int id) {
        return getJdbcTemplate().query(DAOQueries.S_STATE_CITY_BY_CITY_ID, STATE_CITY_MAPPER, id);
    }

    @Override
    public List<StateCity> selectByCity(String city) {
        return getJdbcTemplate().query(DAOQueries.S_STATE_CITY_BY_CITY, STATE_CITY_MAPPER, city);
    }

    @Override
    public List<StateCity> selectByState(String state) {
        return getJdbcTemplate().query(DAOQueries.S_STATE_CITY_BY_STATE, STATE_CITY_MAPPER, state);
    }

    @Override
    public List<StateCity> selectViewByCustomerUUid(String customerUUId) {
        return getJdbcTemplate().query(DAOQueries.S_STATE_CITY_BY_CUST_UUID, STATE_CITY_MAPPER, customerUUId);
    }


}
