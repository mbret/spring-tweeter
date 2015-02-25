package com.springapp.web.mvc.controller;

import com.springapp.domain.model.User;
import com.springapp.service.UserService;
import com.springapp.web.Route;
import com.springapp.web.validation.support.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private UserValidator userValidator;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

//    
//    @ModelAttribute("adduser")
//    public User getAddUser() {
//        return new User();
//    }
//
//    @RequestMapping(value = "/add-user.html", method = RequestMethod.GET)
//    public String showAddUser() {
//        return "add-user";
//    }
//
//    @RequestMapping(value = "/add-user.html", method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("adduser") User user, BindingResult result, RedirectAttributes redirectAttributes) {
//
//        // Validation
//        userValidator.validate(user, result);
//        if(result.hasErrors())
//            return "add-user";
//
//        // Ajout de l'utilisateur
////        try {
//            userService.create(user);
//            return "add-user-success";
////        }
////        catch(ExistException e) {
////            result.rejectValue("mail", "user.mail.exist", "L'adresse est déjà utilisée");
////            return "add-user";
////        }
//    }

    /**
     * Display all users 
     * @return
     */
    @RequestMapping(value = Route.users, method = RequestMethod.GET)
    public ModelAndView users(){
        ModelAndView model = new ModelAndView();
        model.setViewName("users");
        
        List<User> users = this.userService.findAll();
        
        
        model.addObject("users", users);
        return model;
    }

}