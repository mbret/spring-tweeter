package com.springapp.dao.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Maxime on 2/16/2015.
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html
 * http://www.tutorialspoint.com/spring/spring_jdbc_example.htm
 */
public abstract class BaseDaoJDBC {

    protected JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
