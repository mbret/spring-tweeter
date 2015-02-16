package com.springapp.web.mvc.controller;

import com.springapp.web.Route;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SubscriptionController {

    /**
     * Display list of subscriptions.
     * @return
     */
    @RequestMapping( value = Route.subscriptions, method = RequestMethod.GET)
    public String subscriptions() {
        return "hello";
    }
    
    /**
     * Display subscription form.
     * @return
     */
    @RequestMapping( value = Route.subscribe, method = RequestMethod.GET)
    public String subscribe() {
        return "hello";
    }

    /**
     * Process the subscribtion.
     * @return
     */
    @RequestMapping( value = Route.subscribe, method = RequestMethod.POST)
    public String subscribeProcess() {
        return "hello";
    }

    /**
     * Unsubscribe a user.
     * @return
     */
    @RequestMapping( value = Route.unsubscribe, method = RequestMethod.GET)
    public String unsubscribeProcess(){
        return "test";

    }
}
