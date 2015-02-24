package com.springapp.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springapp.dao.TweetDao;
import com.springapp.domain.model.Tweet;
import com.springapp.service.TweetService;

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
    public List<Tweet> findAllByUser(Object id, boolean withSubscription) {
        return this.tweetDao.findAllByUser( id, withSubscription );
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
