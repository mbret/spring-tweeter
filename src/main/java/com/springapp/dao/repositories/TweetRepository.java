package com.springapp.dao.repositories;

import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TweetRepository extends JpaRepository<Tweet, String> {}
