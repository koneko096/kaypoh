/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypoh;

import java.util.List;
import java.util.LinkedList;

import facebook4j.*;
import facebook4j.auth.*;
import facebook4j.conf.*;

/**
 * FacebookCrawler
 * 
 * @author Afrizal Fikri
 */
public class FacebookCrawler {
    private final Facebook fb;
    private final Reading page = new Reading().limit(100);
    private final AccessToken token = new AccessToken("CAALtrpw2Xm4BAHlOPNQrPSNvZBVZBwOsPceRMflZAWOXS951g1ZCdQXl9qI84PhptJf14HOH3LBvESGc0zA5yyZCZATymNUN15IZCSMc3NRu9JqRP7IjiTVFbtpkLLuFvqD30CBSIcpCSut8wYj2NTvpspXun8v6ZBPOm2c9y4EODZBZBJkrIxhKHj3JG6y224fSXEjWdqE52ZA8dsuzVZCt0Xcg");
    
    /**
     * Constructor
     * @param config
     * @throws Exception 
     */
    FacebookCrawler(ConfigurationBuilder config) throws Exception {
        Configure(config);
        fb = new FacebookFactory(config.build()).getInstance();
        fb.setOAuthAppId("824284154322542", "a3fcb10ae1498c7872cd441fbb6b6220");
        fb.setOAuthAccessToken(token);
    }
    
    /**
     * Function getTimeline
     * @param key
     * @return List
     * @throws Exception 
     */
    private List getTimeline(String key) throws Exception {
        List<String> ans = new LinkedList();
        List<Post> statuses = null;
        try {
            statuses = fb.searchPosts(key, page);
        } catch (Exception e) { e.printStackTrace(); }
        
        for (Post status : statuses) {
            if (status.getMessage() != null) {
                ans.add(status.getMessage());
            }
        }
            
        return ans;
    }
    
    /**
     * Procedure Call
     * Call Facebook API
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
     * Configure Facebook API
     * 
     * @param config 
     */
    private void Configure(
        facebook4j.conf.ConfigurationBuilder config) {
        config
            .setDebugEnabled(true)
            .setHttpProxyHost("167.205.22.104")
            .setHttpProxyPort(8082)
            ;
    }
}
