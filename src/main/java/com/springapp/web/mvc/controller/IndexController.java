package com.springapp.web.mvc.controller;

import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.model.User;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
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
