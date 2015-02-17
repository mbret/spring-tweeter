package com.springapp.service.support;

import com.springapp.dao.ActivationDao;
import com.springapp.dao.PasswordDao;
import com.springapp.dao.TweetDao;
import com.springapp.dao.UserDao;
import com.springapp.domain.exception.ActivationNotFoundException;
import com.springapp.domain.exception.AuthenticationException;
import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.exception.UserNotFoundException;
import com.springapp.domain.model.Activation;
import com.springapp.domain.model.Password;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;
import com.springapp.service.TweetService;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class TweetServiceDao implements TweetService {

    private TweetDao tweetDao;

    @Autowired
    public void setTweetDao(TweetDao tweetDao) {
        this.tweetDao = tweetDao;
    }

    @Override
    public List<Tweet> findAllByUser(Object id) {
        return this.tweetDao.findAllByUser( id );
    }

    @Override
    public Tweet findOne(Object id) {
        return this.tweetDao.findOne(id);
    }

    @Override
    public void create(Tweet tweet) {
        this.tweetDao.create(tweet);
    }

    @Override
    public List<Tweet> findAll() {
        List<Tweet> tweets = this.tweetDao.findAll();
        return tweets;
    }
}
