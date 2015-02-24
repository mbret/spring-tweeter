package com.springapp.web.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springapp.domain.ScopedValue;
import com.springapp.domain.exception.ForbiddenException;
import com.springapp.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PrivateInterceptor extends HandlerInterceptorAdapter {

    private ScopedValue<User> currentUser;

    @Autowired
    @Qualifier("current-user")
    public void setCurrentUser(ScopedValue<User> currentUser) {
        this.currentUser = currentUser;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!currentUser.isDefined() || !currentUser.getValue().isValid()) {
            throw new ForbiddenException("No current user available");
        }

        // Expose user
        request.setAttribute("USER", currentUser.getValue());
        return true;
    }

}
