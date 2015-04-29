/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaypoh;

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
    private final AccessToken token = new AccessToken("CAALtrpw2Xm4BAO8GWZBlBuzfTDr4NuGCgtinUSLypGDkT7jiHhffUZBNAIirEyQ6IUemQGRGaZAKFZBDeFHRSVcglqWA7S715rPDhl9TjVGqKFQ7w4FZCWAVq0u0L0LP47RbosOhARNE01HB1gR2OZCk3XdnCAwoudDTYrARYFUPk3FkrhSNH6E5GFh8OlKZCcz1T8n4EPh0yOqtS6qKxH1");
    
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
    
    public void Call(String keys, List<String> res, List<String> uid) throws Exception {
        List<Post> query = null;
        try {
            query = 
                getTimeline(keys);
        } finally {
            for (int i = 0; i < query.size(); i++) {
                res.add(query.get(i).getMessage());
                uid.add(query.get(i).getName());
            }
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
