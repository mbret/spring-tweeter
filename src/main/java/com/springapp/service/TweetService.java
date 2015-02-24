package com.springapp.service;

import com.springapp.domain.exception.ActivationNotFoundException;
import com.springapp.domain.exception.AuthenticationException;
import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.exception.UserNotFoundException;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;

import java.util.List;

public interface TweetService extends Service<Tweet>{

    public abstract List<Tweet> findAllByUser(Object id);
    
//    public abstract  List<>
}