package com.springapp.web;

import java.util.HashMap;

public class Route {

    private static HashMap<String, String> routes;

    public static final String host = "/";
    public static final String home = "/index.html";
    public static final String login = "/login.html";
    public static final String logout = "/login.html?logout";
    public static final String tweet = "/users/tweets/detail.html";
    public static final String tweets = "/users/tweets.html";
    public static final String postTweet = "/tweets/post.html";
    public static final String subscriptions = "/subscriptions.html";
    public static final String subscribe = "/subscriptions/subscribe.html";
    public static final String unsubscribe = "/subscriptions/unsubscribe.html";
    public static final String users = "/users.html";

    // Used in views
    // substring remove the first /
    static {
        routes = new HashMap<String, String>();
        routes.put("postTweet", postTweet.substring(1));
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