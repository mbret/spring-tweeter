package com.springapp.dao.support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.springapp.dao.TweetDao;
import com.springapp.domain.model.Tweet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Qualifier("tweetdao-jdbc")
@Lazy
public class TweetDaoJDBC extends BaseDaoJDBC implements TweetDao {

    private static final String GET_TWEETS          = "SELECT * FROM tweet";
    private static final String GET_TWEETS_BY_USER  = "SELECT * FROM tweet WHERE user = ?";
    private static final String CREATE              = "INSERT INTO tweet(content) VALUES(?)";

    @Override
    public List<Tweet> findAll() {
        List list = this.jdbcTemplate.query(GET_TWEETS, new TweetMapper());
        return list;
    }

    @Override
    public Tweet findOne(Object id) {
        return null;
    }

    @Override
    public void create(Tweet tweet) {
        this.jdbcTemplate.update(CREATE, tweet.getContent());
    }

    @Override
    public List<Tweet> findAllByUser(Integer userID) {
        List list = this.jdbcTemplate.queryForList( GET_TWEETS_BY_USER, new TweetMapper(), userID);
        return list;
    }

    @Override
    public void setSimpleJdbcInsert(DataSource dataSource) {

    }

    private class TweetMapper implements RowMapper<Tweet> {
        
        @Override
        public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tweet tweet = new Tweet();
            return tweet;
        }

    }
	
}

	
