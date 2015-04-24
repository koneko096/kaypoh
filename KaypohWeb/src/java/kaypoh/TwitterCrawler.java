/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaypoh;

import java.util.List;
import java.util.LinkedList;

import twitter4j.*;
import twitter4j.auth.*;
import twitter4j.conf.*;

/**
 * TwitterCrawler
 * 
 * @author Afrizal Fikri
 */
public class TwitterCrawler {
    private Twitter tw;
    private final int limit = 100;    
    /*
    private final AccessToken token = new AccessToken(
        "94018147-mpvS450PWyQ9lB23gWFG4qxHcfeAQhGWEXAQnKgYa",
        "b7hWuibWoSNjEjZ0T7jBoFF0OxUVxOFBy4IynmuL0iI69"
    );
    */
    
    /**
     * Constructor
     * @param config
     * @throws Exception 
     */
    TwitterCrawler(ConfigurationBuilder config) throws Exception {
        Configure(config);
        tw = new TwitterFactory(config.build()).getInstance();
        tw.setOAuthConsumer("4Fe696sYfk2pZjmmncAaZJQUR", "F25etIib277GtJDK5qIXzC8N4YdZ3Fh8w7Bg2otwqt2EDHQabj");
//        tw.setOAuthAccessToken(token);
        OAuth2Token tok = tw.getOAuth2Token();
    }
    
    /**
     * Function getTimeline
     * @param key
     * @return List
     * @throws Exception 
     */
    private List getTimeline(String key) throws Exception {
        List<String> ans = new LinkedList();
        Query query = new Query(key);
        query.setCount(limit);
        QueryResult res = tw.search(query);
        
        List<Status> tweets = res.getTweets();
        for (Status tweet : tweets) {
            if (tweet.getText() != null) {
                ans.add(tweet.getText());
            }
        }
            
        return ans;
    }
    
    /**
     * Procedure Call
     * Call Twitter API
     * 
     * @param args
     * @return List
     * @throws Exception 
     */
    public List Call(String keys) throws Exception {
        List<String> query = null;
        try {
            query = 
                getTimeline(keys);
        } finally {
            return query;
        }
    }
    
    /**
     * Procedure Configure
     * Configure Twitter API
     * 
     * @param config 
     */
    private void Configure(
        twitter4j.conf.ConfigurationBuilder config) {
        config
            .setDebugEnabled(true)
            .setApplicationOnlyAuthEnabled(true)
//            .setHttpProxyHost("167.205.22.104")
//            .setHttpProxyPort(8082)
            ;
    }
}
