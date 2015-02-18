package com.springapp.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.domain.ScopedValue;
import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.model.User;
import com.springapp.service.UserService;
import com.springapp.web.Route;

@Controller
public class RegisterController {

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
    
    
    /**
     * controller for user registration
     * @return
     */
    @RequestMapping(value = Route.register)
    public ModelAndView register(){
        ModelAndView model = new ModelAndView();
    	if(currentUser.isDefined()){
	        model.setViewName("error");
	        model.addObject("currentUser", currentUser.getValue());
        	model.addObject("message", "Vous ne pouvez pas acceder à cette page.");
    	}else{
	        model.setViewName("register");
	        
	        model.addObject("command", new User());
	        model.addObject("route", Route.getRoutes());
    	}
        return model;
    }
    
    
    /**
     * Display new tweet form
     * @return
     */
    @RequestMapping( value = Route.addUser, method = RequestMethod.POST)
    public ModelAndView addUser(
            @ModelAttribute User user, Model model
    ){

        try {
			this.userService.registerAccount(user);
		} catch (UserExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return new ModelAndView("redirect:" + Route.loginForm);

    }
}
