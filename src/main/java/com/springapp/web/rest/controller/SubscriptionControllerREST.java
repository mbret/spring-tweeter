package com.springapp.web.rest.controller;

import com.springapp.domain.ScopedValue;
import com.springapp.domain.model.User;
import com.springapp.service.TweetService;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * http://www.javacodegeeks.com/2010/06/spring-3-restful-web-services.html.
 */
@Qualifier("rest-subscription-controller")
@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionControllerREST {

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

    /**
     * Return all the tweets for all subscriptions.
     * @return
     */
    @RequestMapping( value = "/tweets", method = RequestMethod.GET)
    @ResponseStatus( HttpStatus.OK )
    @ResponseBody
    public HashMap findAllTweets(){

//        HashMap<String, Object> a = new HashMap<>();
//        a.put("user", this.apiUser.getValue());
//        a.put("tweets", this.tweetService.findAllByUser(this.apiUser.getValue().getId()));
//
//        HashMap<String, Object> b = new HashMap<>();
//        b.put("user", this.apiUser.getValue());
//        b.put("tweets", this.tweetService.findAllByUser(this.apiUser.getValue().getId()));
//
//        List<HashMap> subscriptions = new ArrayList<>();
//        subscriptions.add(a);
//        subscriptions.add(b);

        return this.tweetService.findAllByUser(this.apiUser.getValue().getId(), true); // withFollower = true
//        return subscriptions;

    }


}
