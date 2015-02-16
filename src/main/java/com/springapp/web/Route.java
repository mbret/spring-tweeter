package com.springapp.web;

import java.util.HashMap;

public class Route {

    private static HashMap<String, String> routes;

    public static final String host = "/";
    public static final String home = "/index.html";
    public static final String login = "/login.html";
    public static final String logout = "/login.html?logout";
    public static final String tweet = "/tweets.html";
    public static final String tweets = "/tweets.html";
    public static final String postTweet = "/tweets.html";
    public static final String subscriptions = "/tweets/subscriptions.html";
    public static final String subscribe = "/tweets/subscribe.html";
    public static final String unsubscribe = "/tweets/unsubscribe.html";

    {
        if(routes == null)
        {
            routes = new HashMap<String, String>();

            routes.put("host", host);
            routes.put("home", host + home);
        }
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