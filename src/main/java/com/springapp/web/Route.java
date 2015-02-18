package com.springapp.web;

import java.util.HashMap;

public class Route {

    private static HashMap<String, String> routes;

    public static final String host = "/";
    public static final String home = "/index";
    public static final String loginForm = "/loginForm";
    public static final String login = "/loginController/login";
    public static final String logout = "/loginController/logout";
    public static final String tweet = "/users/tweets/detail";
    public static final String tweets = "/users/tweets";
    public static final String postTweet = "/tweets/post";
    public static final String subscriptions = "/subscriptions";
    public static final String register = "/register";
    public static final String addUser = "/register/addUser";
    public static final String subscribe = "/subscriptions/subscribe";
    public static final String unsubscribe = "/subscriptions/unsubscribe";
    public static final String users = "/users";

    // Used in views
    // substring remove the first /
    static {
        routes = new HashMap<String, String>();
        routes.put("postTweet", postTweet.substring(1));
        routes.put("addUser", addUser.substring(1));
        routes.put("login", login.substring(1));
        routes.put("logout", logout.substring(1));
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