package com.springapp.web.mvc.controller;

import com.springapp.domain.bean.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.domain.ScopedValue;
import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.model.User;
import com.springapp.service.UserService;
import com.springapp.web.Route;

import javax.validation.Valid;

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
    @RequestMapping(value = Route.register, method = RequestMethod.GET)
    public ModelAndView register(
            Register register
    ){
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        return model;
    }

    /**
     * Display new tweet form
     * @return
     */
    @RequestMapping( value = Route.register, method = RequestMethod.POST)
    public ModelAndView addUser(
            @Valid Register register,
            BindingResult bindingResult,
            Model m
    ){

        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        
        if(bindingResult.hasErrors()){
            
        }
        else{
            try {
                User user = new User(register.getFirstName(), register.getLastName(), register.getEmail(), register.getPassword());
                user = this.userService.registerAccount(user);
                this.currentUser.setValue(user);
                return new ModelAndView("redirect:" + Route.tweet);
                
            } catch (UserExistException e) {
//                e.printStackTrace();
                model.addObject("registerError", "This email is already taken!");
            }
        }

        return model;
        
    }
}
