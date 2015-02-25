package com.springapp.dao.support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.springapp.dao.UserDao;
import com.springapp.domain.model.User;

@Repository
@Qualifier("userdao-jdbc")
@Lazy
public class UserDaoJDBC extends BaseDaoJDBC implements UserDao {
	
	private static final Logger log = LoggerFactory.getLogger(UserDao.class);

	private static final String GET_USERS = "SELECT * FROM user";
	private static final String GET_USER  = "SELECT * FROM user WHERE id = ?";
	private static final String GET_USERM = "SELECT * FROM user WHERE mail = ?";
	private static final String GET_USERN = "SELECT * FROM user WHERE name = ?";
	private static final String ADD_USER  = "INSERT INTO user(id, mail, name, firstName, password) VALUES(?, ?, ?, ?, ?)";
	private static final String UPD_USER  = "UPDATE user SET mail = ?, name = ?, firstname = ? WHERE id = ?";
	private static final String DEL_USER  = "DELETE FROM user WHERE id = ?";

	private static final String FOLLOW  = "INSERT INTO follow(followed, follower) VALUES (?, ?)";
	private static final String UNFOLLOW  = "DELETE FROM follow WHERE followed = ? AND follower = ?";
	private static final String GET_FOLLOWERS  = "SELECT u.* FROM user u, follow f WHERE f.follower = ? AND f.followed = u.id";
	private static final String IS_FOLLOWING  = "SELECT u.* FROM user u, follow f WHERE f.followed = ? AND f.follower = u.id AND f.follower = ?";
	

    @Override
    public void setSimpleJdbcInsert(DataSource dataSource) {
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("user")
                .usingGeneratedKeyColumns("id");
    }
    
	public List<User> getUsers() {
		return jdbcTemplate.query(GET_USERS, new UserMapper());
	}

	public List<User> getFollowers(String followed) {
		return jdbcTemplate.query(GET_FOLLOWERS, new UserMapper(), followed);
	}

	public User getUser(String id) {
		log.info("UserDao::getUser({})", new Object [] {id});
		return jdbcTemplate.queryForObject(GET_USER, new UserMapper(), id);
	}
	
	public User getUserByMail(String mail) {
		return jdbcTemplate.queryForObject(GET_USERM, new UserMapper(), mail);
	}

	public User getUserByName(String name) {
		return jdbcTemplate.queryForObject(GET_USERN, new UserMapper(), name);
	}
    

	public void updateUser(User user) {
		jdbcTemplate.update(UPD_USER, user.getMail(), user.getName(), user.getFirstName(), user.getId(), user.getPassword());
	}

	public void deleteUser(String id) {
		jdbcTemplate.update(DEL_USER, id);
	}
	
	public void unfollow(String followed, String follower) {
		jdbcTemplate.update(UNFOLLOW, followed, follower);
	}
	
	public void follow(String followed, String follower) {
		jdbcTemplate.update(FOLLOW, followed, follower);
	}

	public List<User> findAllFollowers() {
        List<User> list = this.jdbcTemplate.query(GET_FOLLOWERS, new UserMapper());
        return list;
    }

    @Override
    public List<User> findAll() {
        List<User> list = this.jdbcTemplate.query(GET_USERS, new UserMapper());
        return list;
    }

    @Override
    public User findOne(Object id) {
        try{
            return this.jdbcTemplate.queryForObject(GET_USER, new UserMapper(), id);
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    /**
     * Create a user.
     * @param user
     */
    @Override
    public void create(User user) {
        this.jdbcTemplate.update(ADD_USER, user.getId(), user.getMail(), user.getName(), user.getFirstName(), user.getPassword());
    }


    private class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			
			user.setId(rs.getString("id"));
			user.setMail(rs.getString("mail"));
			user.setName(rs.getString("name"));
			user.setFirstName(rs.getString("firstname"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		
	}


	@Override
	public boolean isFollowing(String followed, String follower) {
		try{
			User user = jdbcTemplate.queryForObject(IS_FOLLOWING, new UserMapper(), followed, follower);
			if (user == null)
				return false;
			else return true;
		}catch(EmptyResultDataAccessException a){
			return false;
		}
	}
}
