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
import com.springapp.domain.exception.AuthenticationException;
import com.springapp.domain.model.User;
import com.springapp.service.UserService;
import com.springapp.web.Route;

@Controller
public class loginController {
    
    private UserService userService;
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    private ScopedValue<User> currentUser;
    
    @Autowired
    @Qualifier("current-user")
    public void setCurrentUser(ScopedValue<User> currentUser) {
        this.currentUser = currentUser;
    }
    
    /**
     * form for user login
     * @return
     */
    @RequestMapping(value = Route.loginForm)
    public ModelAndView loginForm(){
        return loginForm(null);
    }
    
    private ModelAndView loginForm(String message){
        ModelAndView model = new ModelAndView();
        if(currentUser.isDefined()){
	        model.setViewName("error");
	        model.addObject("currentUser", currentUser.getValue());
        	model.addObject("message", "Vous ne pouvez pas acceder à cette page.");
        }else{
	        model.setViewName("login");
	        if(message!=null){
	        	model.addObject("message", message);
	        }
	        model.addObject("command", new User());
	        model.addObject("route", Route.getRoutes());
        }
        return model;
    }
    
    
    
    /**
     * user login
     * @return
     */
    @RequestMapping( value = Route.login, method = RequestMethod.POST)
    public ModelAndView login(
            @ModelAttribute User user, Model model
    ){
        ModelAndView mod = new ModelAndView();
        if(currentUser.isDefined()){
	        mod.setViewName("error");
	        mod.addObject("currentUser", currentUser.getValue());
        	mod.addObject("message", "Vous ne pouvez pas acceder à cette page.");
        	return mod;
        }else{
	        try {
				User u = this.userService.authenticate(user.getMail(), user.getPassword());	
				currentUser.setValue(u);
		        return new ModelAndView("redirect:" + Route.host);
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				String message = "Login ou mot de passe incorrect."; 
				return this.loginForm(message);
			}
        }
    }
    
    
    /**
     * user login
     * @return
     */
    @RequestMapping( value = Route.logout)
    public ModelAndView logout(
            @ModelAttribute User user, Model model
    ){
    	ModelAndView mod = new ModelAndView();
        if(!currentUser.isDefined()){
	        mod.setViewName("error");
	        mod.addObject("currentUser", currentUser.getValue());
        	mod.addObject("message", "Vous ne pouvez pas acceder à cette page.");
        	return mod;
        }else{
	    	currentUser.setValue(null);
	        return new ModelAndView("redirect:" + Route.host);
        }
    }

}
