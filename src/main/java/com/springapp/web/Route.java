package com.springapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.HashMap;

public class Route {
    
    private static HashMap<String, String> routes;

    public static final String context = "";
    public static final String host = context + "/";
    public static final String home = context + "/index";
    public static final String login = context + "/login";
    public static final String logout = context + "/logout";
    public static final String tweet = context + "/users/tweets/detail";
    public static final String tweets = context + "/users/tweets";
    public static final String searchUser = context + "/users/searchUser";
    public static final String postTweet = context + "/tweets/post";
    public static final String subscriptions = context + "/subscriptions";
    public static final String register = context + "/register";
    public static final String addUser = context + "/register/addUser";
    public static final String subscribe = context + "/subscriptions/subscribe";
    public static final String unsubscribe = context + "/subscriptions/unsubscribe";
    public static final String users = context + "/users";
    public static final String profile = context + "/profile";

    // Used in views
    // substring remove the first /
    static {
        routes = new HashMap<String, String>();
        routes.put("postTweet", postTweet.substring(1));
        routes.put("addUser", addUser.substring(1));
        routes.put("login", login.substring(1));
        routes.put("logout", logout.substring(1));
        routes.put("register", register.substring(1));
        routes.put("searchUser", searchUser.substring(1));
        routes.put("profile", profile.substring(1));
        routes.put("tweets", tweets.substring(1));
        routes.put("subscribe", subscribe.substring(1));
        routes.put("unsubscribe", unsubscribe.substring(1));
    }

    public static HashMap<String, String> getRoutes()
    {
        return routes;
    }

    public static String getRoute(String destin)
    {
        return routes.get(destin);
    }

}