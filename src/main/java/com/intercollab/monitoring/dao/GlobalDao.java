package com.intercollab.monitoring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by andrii on 07.10.16.
 */
public class GlobalDao {

    protected JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected Integer getId(String sequence) {

        return jdbcTemplate.queryForObject("SELECT nextval('" + sequence + "')", Integer.class);

    }

}
