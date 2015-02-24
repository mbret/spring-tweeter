package com.springapp.dao;

import com.springapp.domain.model.Tweet;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

@CacheConfig(cacheNames={"tweets"})
public interface TweetDao extends Dao<Tweet> {
    
    public List<Tweet> findAllByUser(Object id);
    
    public List<Tweet> findAllByUser(Object id, boolean withSubscriptions);

}
