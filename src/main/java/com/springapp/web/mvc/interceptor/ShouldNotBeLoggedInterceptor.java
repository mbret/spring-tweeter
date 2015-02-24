package com.springapp.web.mvc.interceptor;

import com.springapp.domain.ScopedValue;
import com.springapp.domain.model.User;
import com.springapp.web.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShouldNotBeLoggedInterceptor extends HandlerInterceptorAdapter {

    private ScopedValue<User> currentUser;

    @Autowired
    @Qualifier("current-user")
    public void setCurrentUser(ScopedValue<User> currentUser) {
        this.currentUser = currentUser;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        if( currentUser.isDefined() ) {
            response.sendRedirect( Route.home );
            return false;
        }

        return true;
    }

}
