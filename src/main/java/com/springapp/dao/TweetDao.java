package com.springapp.dao;

import com.springapp.domain.model.Tweet;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

@CacheConfig(cacheNames={"tweets"})
public interface TweetDao {
	public List<Tweet> findAll(Integer userId);
    
    public void create(Tweet tweet);
}
