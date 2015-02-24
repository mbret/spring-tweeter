package com.springapp.web.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springapp.domain.ScopedValue;
import com.springapp.domain.exception.ForbiddenException;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;
import com.springapp.web.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ShouldBeLoggedInterceptor extends HandlerInterceptorAdapter {

    private ScopedValue<User> currentUser;

    @Autowired
    @Qualifier("current-user")
    public void setCurrentUser(ScopedValue<User> currentUser) {
        this.currentUser = currentUser;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        if(!currentUser.isDefined() || !currentUser.getValue().isValid()) {
            response.sendRedirect( Route.login );
//            model.addObject("currentUser", currentUser.getValue());
//            model.setViewName("tweet-post");
//            model.addObject("command", new Tweet());
//            model.addObject("route", Route.getRoutes());
        }

        // Expose user
        request.setAttribute("USER", currentUser.getValue());
        return true;
    }

}
