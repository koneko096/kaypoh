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
    private final AccessToken token = new AccessToken("CAALtrpw2Xm4BAJkhesljqt8ywJAkZCzZBvohvZCexHMxYFf1RucExRV1oVAAW1LY90ij3yMYMA546whEZCbXgc7RvS4LzXOHPCbI18aXbKhd5RDoMMRpOjt0HqPdOsHl2roThLuOkh4ZBjrcHRwZBnBibdZA0fIjo2RSnX9QzAoFB8arOXPNOuukZB3i7R54SfgCPByIettZAEc54ZAlcddNPQ");
    
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
        List<Post> statuses = fb.searchPosts(key, page);
        
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
    public List Call(String[] args) throws Exception {        
        List<String> query = null;
        try {
            query = 
                getTimeline(
                    Keypoh.QueryGenerator(args[3],1)
                );
            
            query.stream().forEach((tweet) -> {
                System.out.println(tweet);
            });
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
//            .setHttpProxyHost("cache2.itb.ac.id")
//            .setHttpProxyUser("afrizal_f")
//            .setHttpProxyPassword("R1zal96@itb")
//            .setHttpProxyPort(8080)
            ;
    }
}
