package com.springapp.web.mvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.domain.ScopedValue;
import com.springapp.domain.exception.UserNotFoundException;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;
import com.springapp.service.TweetService;
import com.springapp.service.UserService;
import com.springapp.web.Route;

@Controller
public class TweetController {

    private TweetService tweetService;
    private UserService userService;    
    private ScopedValue<User> currentUser;
    
    @Autowired
    @Qualifier("current-user")
    public void setCurrentUser(ScopedValue<User> currentUser) {
        this.currentUser = currentUser;
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
     * Display tweet timeline.
     * Require user id as parameter.
     * @return
     */
    
    @RequestMapping( value = Route.tweets, method = RequestMethod.GET)
    public ModelAndView tweets(
            @RequestParam( value = "user", required = false ) String uid
    ){
        ModelAndView model = new ModelAndView();
        
        // Want specific user tweets
        if( uid != null ){
            List<Tweet> tweets;
            model.setViewName("tweets");
            User user = this.userService.findOne(uid);
            model.addObject("currentUser", currentUser.getValue());
            model.addObject("userTarget", user);
            tweets = this.tweetService.findAllByUser(uid);
            model.addObject("tweets", tweets);
        }
        // Want our tweets with subscriptions
        else{ 
            model.setViewName("monFil");
            final boolean withSubscription = true;
            model.addObject("currentUser", currentUser.getValue());
            HashMap<String, List<Tweet>> tweets = this.tweetService.findAllByUser(this.currentUser.getValue().getId(), withSubscription);
            model.addObject("tweets", tweets);
        }

        return model;
    }
    
    @RequestMapping( value = Route.searchUser, method = RequestMethod.GET)
    public ModelAndView searchUser(
            @RequestParam("userName") String userName
    ){
    	try{
    		User u = this.userService.getUserByName(userName);
            ModelAndView model = new ModelAndView();
            model.setViewName("tweets");
            User user = this.userService.findOne(u.getId());
            List<Tweet> tweets = this.tweetService.findAllByUser(u.getId());
            model.addObject("userTarget", user);
            model.addObject("tweets", tweets);
            model.addObject("isFollowing", userService.isFollowing(user.getId(), currentUser.getValue().getId()));
            return model;
    	}catch(UserNotFoundException une){
            ModelAndView model = new ModelAndView();
    		model.setViewName("error");
	        model.addObject("currentUser", currentUser.getValue());
        	model.addObject("message", "Utilisateur non trouvé");
        	return model;
    	}
        
    }
    
    /**
     * Display a tweet detail.
     * @param id
     * @return
     */
    @RequestMapping( value = Route.tweet, method = RequestMethod.GET)
    public ModelAndView tweet(
            @RequestParam("id") String id
    ){
        ModelAndView model = new ModelAndView();
        model.setViewName("tweet-detail");
        model.addObject("currentUser", currentUser.getValue());
        Tweet tweet = this.tweetService.findOne(id);
        model.addObject("tweet", tweet);
        return model;
    }

    /**
     * Display new tweet form
     * @return
     */
    @RequestMapping( value = Route.postTweet, method = RequestMethod.GET)
    public ModelAndView postTweet(){
        ModelAndView model = new ModelAndView();
        model.addObject("currentUser", currentUser.getValue());
        model.setViewName("tweet-post");
        model.addObject("command", new Tweet());
        return model;
    }
    
    /**
     * Display new tweet form
     * @return
     */
    @RequestMapping( value = Route.postTweet, method = RequestMethod.POST)
    public ModelAndView  postTweetProcess(
            @ModelAttribute Tweet tweet, Model model
    ){
    	tweet.setUserID(currentUser.getValue().getId());
    	tweet.setUser(currentUser.getValue());
        this.tweetService.create(tweet);

        return new ModelAndView("redirect:" + Route.tweet + "?id=" + tweet.getId().toString());

    }

}
