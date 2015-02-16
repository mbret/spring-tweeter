package com.springapp.service;

import com.springapp.domain.exception.ActivationNotFoundException;
import com.springapp.domain.exception.AuthenticationException;
import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.exception.UserNotFoundException;
import com.springapp.domain.model.Password;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;

public interface TweetService {

    public void getTweets(Integer userID);

    public void create(Tweet tweet);
}