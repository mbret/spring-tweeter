package com.springapp.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

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
    
    @RequestMapping("/test.html")
    public String showTest(){
        return "test";
        
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
