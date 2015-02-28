package com.springapp.web.rest.controller;

import com.springapp.domain.ScopedValue;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;
import com.springapp.service.TweetService;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetControllerREST {

    private TweetService tweetService;
    private UserService userService;
    private ScopedValue<User> apiUser;

    @Autowired
    @Qualifier("api-user")
    public void setCurrentUser(ScopedValue<User> currentUser) {
        this.apiUser = currentUser;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @Autowired
    public void setTweetService(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @RequestMapping(value="/{uuid}", method= RequestMethod.GET)
    public Tweet getTweet(@PathVariable String uuid){
        return tweetService.findOne(uuid);
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public List getTweets(@PathVariable String uuid){
        return tweetService.findAllByUser(this.apiUser.getValue().getId());
    }


}
