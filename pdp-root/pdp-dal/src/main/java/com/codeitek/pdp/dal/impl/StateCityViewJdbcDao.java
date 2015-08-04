package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.DAOQueries;
import com.codeitek.pdp.dal.SpringJdbcSupport;
import com.codeitek.pdp.dal.interfaces.StateCityViewDao;
import com.codeitek.pdp.dal.mapper.StateCityViewRowMapper;
import com.codeitek.pdp.model.StateCityView;

import java.util.List;

/**
 * State-cityName data access object.
 *
 * @author mcoletti@gmail.com
 */
@Deprecated
public class StateCityViewJdbcDao extends SpringJdbcSupport implements StateCityViewDao {

    private static final StateCityViewRowMapper STATE_CITY_MAPPER = new StateCityViewRowMapper();

    @Override
    public List<StateCityView> selectAll() {
        return getJdbcTemplate().query(DAOQueries.S_STATE_CITY_VIEW, STATE_CITY_MAPPER);
    }

    @Override
    public List<StateCityView> selectById(int id) {
        return getJdbcTemplate().query(DAOQueries.S_STATE_CITY_VIEW_BY_CITY_ID, STATE_CITY_MAPPER, id);
    }

    @Override
    public List<StateCityView> selectByCity(String city) {
        return getJdbcTemplate().query(DAOQueries.S_STATE_CITY_VIEW_BY_CITY, STATE_CITY_MAPPER, city);
    }

    @Override
    public List<StateCityView> selectByState(String state) {
        return getJdbcTemplate().query(DAOQueries.S_STATE_CITY_VIEW_BY_STATE, STATE_CITY_MAPPER, state);
    }

    @Override
    public List<StateCityView> selectViewByZip(int zip) {
        return getJdbcTemplate().query(DAOQueries.S_STATE_CITY_VIEW_BY_ZIP, STATE_CITY_MAPPER, zip);
    }
}
