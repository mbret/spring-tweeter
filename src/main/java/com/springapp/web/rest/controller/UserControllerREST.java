package com.springapp.web.rest.controller;

import com.springapp.domain.model.User;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Maxime on 2/24/2015.
 */
@RestController
@RequestMapping("/api/users")
public class UserControllerREST {

    private UserService userServ;

    @Autowired
    public void setUserService(UserService usrserv){
        this.userServ = usrserv;
    }

    @RequestMapping(value="/{uuid}", method= RequestMethod.GET)
    public User getUser(@PathVariable String uuid){
        return userServ.getUserById(uuid);
    }
    
}
