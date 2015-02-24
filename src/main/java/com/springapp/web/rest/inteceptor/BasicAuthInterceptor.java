package com.springapp.web.rest.inteceptor;

import com.springapp.domain.ScopedValue;
import com.springapp.domain.exception.AuthenticationException;
import com.springapp.domain.model.User;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

/**
 * Created by Maxime on 2/24/2015.
 */
public class BasicAuthInterceptor implements HandlerInterceptor {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private ScopedValue<User> apiUser;

    @Autowired
    @Qualifier("api-user")
    public void setCurrentUser(ScopedValue<User> currentUser) {
        this.apiUser = currentUser;
    }
    
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String header = httpServletRequest.getHeader("Authorization");
        
        if( header == null || ! header.contains("Basic ")){
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return false;
        }
        
        String credentials = header.replace("Basic ", "");
        credentials = new String(Base64.getDecoder().decode(credentials));
        String[] credentialAr = credentials.split("\\:");
        String email = credentials.length() > 0 ? credentialAr[0] : "";
        String password = credentials.length() > 1 ? credentialAr[1] : "";
        System.out.println(email + " : " + password);
        
        try {
            User u =  this.userService.authenticate(email, password);
            this.apiUser.setValue(u);
        } catch (AuthenticationException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials");
            return false;
        }
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
