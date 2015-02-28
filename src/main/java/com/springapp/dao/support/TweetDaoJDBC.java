package com.springapp.dao.support;

import com.springapp.dao.TweetDao;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
@Qualifier("tweetdao-jdbc")
@Lazy
public class TweetDaoJDBC extends BaseDaoJDBC implements TweetDao {

    private static final String GET_TWEETS          = "SELECT * FROM tweet";
    private static final String GET_TWEETS_BY_USER  = "SELECT * FROM tweet WHERE user = ?";
    private static final String GET_TWEET           = "SELECT * FROM tweet WHERE id = ?";
    private static final String CREATE              = "INSERT INTO tweet(content, user) VALUES(?, ?)";
	private UserService userService;

    @Override
    @Autowired
    public void setSimpleJdbcInsert(DataSource dataSource) {
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("tweet")
                // mandatory to use default value (for date)
                .usingColumns("user", "content")
                .usingGeneratedKeyColumns("id");
    }
    

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public List<Tweet> findAll() {
        List list = this.jdbcTemplate.query(GET_TWEETS, new TweetMapper());
        return list;
    }

    @Override
    public Tweet findOne(Object id) {
        try{
            return this.jdbcTemplate.queryForObject(GET_TWEET, new TweetMapper(), id);
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void create(Tweet tweet) {

        
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("user", tweet.getUserID())
                .addValue("content", tweet.getContent());
        
        // create insert and get generated key
        Number newId = this.simpleJdbcInsert.executeAndReturnKey(parameters);
        tweet.setId(newId.doubleValue());
    }

    @Override
    public List<Tweet> findAllByUser(Object id) {
    	
        List list = this.jdbcTemplate.query(GET_TWEETS_BY_USER, new TweetMapper(), id);
        return list;
    }

    @Override
    public HashMap<String, List<Tweet>> findAllByUser(Object id, boolean withSubscriptions) {
    	List<User> users = userService.getFollowers((String)id);
    	HashMap<String, List<Tweet>> tweets = new HashMap<String, List<Tweet>>();
    	for(User u : users){
    		List<Tweet> tw = this.jdbcTemplate.query(GET_TWEETS_BY_USER, new TweetMapper(), u.getId());
        	tweets.put(u.getName(), tw);
    	}
        return tweets;
    }

    private class TweetMapper implements RowMapper<Tweet> {
        
        @Override
        public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tweet tweet = new Tweet();
            tweet.setContent(rs.getString("content"));
            tweet.setId(rs.getDouble("id"));
            tweet.setUserID(rs.getString("user"));
            return tweet;
        }

    }
	
}

	
