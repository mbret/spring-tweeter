package com.springapp.web.mvc.controller;

import com.springapp.domain.ScopedValue;
import com.springapp.domain.exception.AuthenticationException;
import com.springapp.domain.bean.Login;
import com.springapp.domain.model.User;
import com.springapp.service.UserService;
import com.springapp.web.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
    @RequestMapping(value = Route.login)
    public ModelAndView loginForm(
            Login login
    ){
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    /**
     * user login
     * @return
     */
    @RequestMapping( value = Route.login, method = RequestMethod.POST)
    public ModelAndView login(
            @Valid Login login,
            BindingResult bindingResult,
            Model m
    ){
        ModelAndView mod = new ModelAndView();
        mod.setViewName("login");
        
        if(bindingResult.hasErrors()){
            
        }
        else{
            try {
                User u = this.userService.authenticate( login.getEmail(), login.getPassword() );
                currentUser.setValue(u);
                return new ModelAndView("redirect:" + Route.host);
            } catch (AuthenticationException e) {
//                e.printStackTrace();
//                bindingResult.addError(new ObjectError("credential", "Invalid credentials"));
                mod.addObject("credentialError", "Invalid credentials");
            }
        }

        return mod;
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
        currentUser.setValue(null);
        return new ModelAndView("redirect:" + Route.host);
    }

}
