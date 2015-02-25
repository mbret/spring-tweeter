package com.springapp.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.service.UserService;
import com.springapp.web.Route;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = Route.subscribe, method = RequestMethod.GET)
    public ModelAndView subscribe(
    		 @RequestParam( value = "followed", required = false ) String followed,
    		 @RequestParam( value = "follower", required = false ) String follower
    		) {
    	userService.follow(followed, follower);
        return new ModelAndView("redirect:" + Route.host);
    }
    

    @RequestMapping(value = Route.unsubscribe, method = RequestMethod.GET)
    public ModelAndView unsubscribe(
    		 @RequestParam( value = "followed", required = false ) String followed,
    		 @RequestParam( value = "follower", required = false ) String follower
    		) {
    	userService.unfollow(followed, follower);
        return new ModelAndView("redirect:" + Route.host);
    }


}