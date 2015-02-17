package com.springapp.web.mvc.controller;

import com.springapp.domain.exception.ExistException;
import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.model.User;
import com.springapp.service.UserService;
import com.springapp.web.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @ModelAttribute("adduser")
    public User getAddUser() {
        return new User();
    }

    @RequestMapping(value = "/add-user.html", method = RequestMethod.GET)
    public String showAddUser() {
        return "add-user";
    }

    @RequestMapping(value = "/add-user.html", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("adduser") User user, BindingResult result, RedirectAttributes redirectAttributes) {

        // Validation
        userValidator.validate(user, result);
        if(result.hasErrors())
            return "add-user";

        // Ajout de l'utilisateur
//        try {
            userService.create(user);
            return "add-user-success";
//        }
//        catch(ExistException e) {
//            result.rejectValue("mail", "user.mail.exist", "L'adresse est déjà utilisée");
//            return "add-user";
//        }
    }

}