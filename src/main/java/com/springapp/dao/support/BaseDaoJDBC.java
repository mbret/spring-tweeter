package com.springapp.dao.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.sql.DataSource;

/**
 * Created by Maxime on 2/16/2015.
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html
 * http://www.tutorialspoint.com/spring/spring_jdbc_example.htm
 */
public abstract class BaseDaoJDBC {

    protected JdbcTemplate jdbcTemplate;
    protected SimpleJdbcInsert simpleJdbcInsert;
    
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Autowired
    public abstract void setSimpleJdbcInsert(DataSource dataSource);
}
