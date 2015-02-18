package com.springapp.web.mvc.controller;

import com.springapp.web.Route;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
 /*
    @RequestMapping("/signup.html")
    public String signup() {
        return "hello";
    }
    
    @RequestMapping("/signin.html")
    public String signin(){
        return "test";
    }

    @RequestMapping("/logout.html")
    public String logout(){
        return "test";

    }

    @RequestMapping(value = { Route.login, "/login.html" }, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }

        return error;
    }

//    @RequestMapping(value = "/signin", method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("adduser") User user, BindingResult result, RedirectAttributes redirectAttributes) {
//
//        // Validation
//        userValidator.validate(user, result);
//        if(result.hasErrors())
//            return "add-user";
//
//        // Ajout de l'utilisateur
//        try {
//            userService.addUser(user);
//            return "add-user-success";
//        }
//        catch(UserExistException e) {
//            result.rejectValue("mail", "user.mail.exist", "L'adresse est déjà utilisée");
//            return "add-user";
//        }
//    }

    @RequestMapping(value="/signinError", method = RequestMethod.GET)
    public String signinError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login_page";

    } */
}
