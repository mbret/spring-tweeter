package com.springapp.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;
import com.springapp.service.TweetService;
import com.springapp.service.UserService;

@Controller
public class RegisterController {

    private UserService userService;
    private TweetService tweetService;
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTweetService(TweetService tweetService) {
        this.tweetService = tweetService;
    }
    
    
    /**
     * controller for user registration
     * @return
     */
    @RequestMapping("/register.html")
    public ModelAndView register(){
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        /*
        // Add a user
        User user = new User("Maxime", "Bret", "email.gmail.com");
        try {
            this.userService.registerAccount( user );
        } catch (UserExistException e) {
            e.printStackTrace();
        }

        // Retrieve this user
        User retrievedUser = this.userService.findOne( user.getId() );
        model.addObject("user", retrievedUser); // pass user to the view
        
        // Add a tweet
        Tweet tweet = new Tweet(retrievedUser, "My first tweet");
        this.tweetService.create(tweet);
        Tweet tweet2 = new Tweet(retrievedUser, "My second tweet");
        this.tweetService.create(tweet2);

        // Retrieve all the user tweets
        List<Tweet> tweets = this.tweetService.findAllByUser( user.getId() );
        model.addObject("tweets", tweets); // pass user to the view
        */
        return model;
    }
}
