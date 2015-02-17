package com.springapp.dao.support;

import com.springapp.dao.PasswordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springapp.domain.model.Password;

import javax.sql.DataSource;

@Repository
public class PasswordDaoJDBC extends BaseDaoJDBC implements PasswordDao {

	private static final String GET_PASSWORD = "SELECT password FROM password WHERE id = ?";
	private static final String SET_PASSWORD = "INSERT INTO password(id, password) VALUES(?, ?) ON DUPLICATE KEY UPDATE password = ?";

	public String getPassword(String userId) {
		return jdbcTemplate.queryForObject(GET_PASSWORD, String.class, userId);
	}
	
	public void setPassword(Password p) {
		jdbcTemplate.update(SET_PASSWORD, p.getUserId(), p.getPassword(), p.getPassword());
	}

    @Override
    public void setSimpleJdbcInsert(DataSource dataSource) {

    }
}
