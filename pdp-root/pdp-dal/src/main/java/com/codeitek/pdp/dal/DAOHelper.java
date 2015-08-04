package com.codeitek.pdp.dal;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 5/7/13
 * Time: 3:18 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class DAOHelper {

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(DAOHelper.class);


    private DataSource dataSource;

    protected DAOHelper(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }
}
