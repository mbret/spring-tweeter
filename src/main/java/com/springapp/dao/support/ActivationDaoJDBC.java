package com.springapp.dao.support;

import com.springapp.dao.ActivationDao;
import com.springapp.domain.model.Activation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ActivationDaoJDBC extends BaseDaoJDBC implements ActivationDao {

	private static final String GET_ACTIVATION = "SELECT userid FROM activation WHERE id = ?";
	private static final String ADD_ACTIVATION = "INSERT INTO activation(id, userid) VALUES(?, ?)";
	private static final String DEL_ACTIVATION = "DELETE FROM activation WHERE id = ?";

	public String getActivation(String activationId) {
		return jdbcTemplate.queryForObject(GET_ACTIVATION, String.class, activationId);
	}

	public void addActivation(Activation a) {
		jdbcTemplate.update(ADD_ACTIVATION, a.getActivationKey(), a.getUserId());
	}

	public void deleteActivation(String activationId) {
		jdbcTemplate.update(DEL_ACTIVATION, activationId);
	}

}
