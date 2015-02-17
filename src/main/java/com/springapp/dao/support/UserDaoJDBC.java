package com.springapp.dao.support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springapp.dao.UserDao;
import com.springapp.domain.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Qualifier("userdao-jdbc")
@Lazy
public class UserDaoJDBC extends BaseDaoJDBC implements UserDao {
	
	private static final Logger log = LoggerFactory.getLogger(UserDao.class);

	private static final String GET_USERS = "SELECT * FROM user";
	private static final String GET_USER  = "SELECT * FROM user WHERE id = ?";
	private static final String GET_USERM = "SELECT * FROM user WHERE mail = ?";
	private static final String ADD_USER  = "INSERT INTO user(id, mail, name, firstName) VALUES(?, ?, ?, ?)";
	private static final String UPD_USER  = "UPDATE user SET mail = ?, name = ?, firstname = ? WHERE id = ?";
	private static final String DEL_USER  = "DELETE FROM user WHERE id = ?";

    @Override
    public void setSimpleJdbcInsert(DataSource dataSource) {
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("user")
                .usingGeneratedKeyColumns("id");
    }
    
	public List<User> getUsers() {
		return jdbcTemplate.query(GET_USERS, new UserMapper());
	}

	public User getUser(String id) {
		log.info("UserDao::getUser({})", new Object [] {id});
		return jdbcTemplate.queryForObject(GET_USER, new UserMapper(), id);
	}
	
	public User getUserByMail(String mail) {
		return jdbcTemplate.queryForObject(GET_USERM, new UserMapper(), mail);
	}
    

	public void updateUser(User user) {
		jdbcTemplate.update(UPD_USER, user.getMail(), user.getName(), user.getFirstName(), user.getId());
	}

	public void deleteUser(String id) {
		jdbcTemplate.update(DEL_USER, id);
	}

    @Override
    public List<User> findAll() {
        List list = this.jdbcTemplate.query(GET_USERS, new UserMapper());
        return list;
    }

    @Override
    public User findOne(Object id) {
        return this.jdbcTemplate.queryForObject(GET_USER, new UserMapper(), id);
    }

    /**
     * Create a user.
     * @param user
     */
    @Override
    public void create(User user) {
        this.jdbcTemplate.update(ADD_USER, user.getId(), user.getMail(), user.getName(), user.getFirstName());
    }


    private class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			
			user.setId(rs.getString("id"));
			user.setMail(rs.getString("mail"));
			user.setName(rs.getString("name"));
			user.setFirstName(rs.getString("firstname"));
			
			return user;
		}
		
	}

}
