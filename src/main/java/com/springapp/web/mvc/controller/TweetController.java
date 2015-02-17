package com.springapp.web.mvc.controller;

import com.springapp.domain.model.Tweet;
import com.springapp.service.TweetService;
import com.springapp.service.UserService;
import com.springapp.web.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TweetController {

    private TweetService tweetService;

    @Autowired
    public void setTweetService(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    /**
     * Display tweet timeline.
     * @return
     */
    @RequestMapping( value = Route.tweets, method = RequestMethod.GET)
    public ModelAndView tweets() {
        ModelAndView model = new ModelAndView();
        model.setViewName("tweets");
        
        List<Tweet> tweets = this.tweetService.findAll();
        this.tweetService.create( new Tweet("sdfsdf") );

        model.addObject("tweets", tweets);
        return model;
    }

    /**
     * Display new tweet form
     * @return
     */
    @RequestMapping( value = Route.postTweet, method = RequestMethod.POST)
    public String postTweetProcess(){
        return "test";

    }

}
