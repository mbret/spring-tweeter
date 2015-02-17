package com.springapp.web.mvc.controller;

import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;
import com.springapp.service.TweetService;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

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
    
    @ModelAttribute("name")
    public String getName(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return name;
    }

    @RequestMapping(value = { "/", "/index", "/index.html" }, method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    /**
     * This controller show different example how to use spring 
     * @return
     */
    @RequestMapping("/example.html")
    public ModelAndView showTest(){
        ModelAndView model = new ModelAndView();
        model.setViewName("example");
        
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
        
        return model;
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        // check if user is login
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (!(auth instanceof AnonymousAuthenticationToken)) {
//            UserDetails userDetail = (UserDetails) auth.getPrincipal();
//            System.out.println(userDetail);
//
//            model.addObject("username", userDetail.getUsername());
//
//        }

        model.setViewName("403");
        return model;

    }

}
