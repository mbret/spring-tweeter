package com.springapp.web.mvc.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;
import com.springapp.service.TweetService;
import com.springapp.service.UserService;
import com.springapp.web.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Response;
import java.util.List;

/**
 * http://www.javacodegeeks.com/2010/06/spring-3-restful-web-services.html.
 */
@Controller
@RequestMapping("/api/subscriptions")
public class APISubscriptionController {

    private TweetService tweetService;
    private UserService userService;

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
    @RequestMapping( value = "/tweets", method = RequestMethod.GET, headers="Accept=application/json")
    @ResponseStatus( HttpStatus.OK )
    @ResponseBody
    public Tweet findAllTweets(){
        
        return new Tweet( new User(), "sdf");

    }


}
