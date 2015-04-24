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
    private Facebook fb;
    private final Reading page = new Reading().limit(200);
    private final AccessToken token = new AccessToken("CAALtrpw2Xm4BAJkhesljqt8ywJAkZCzZBvohvZCexHMxYFf1RucExRV1oVAAW1LY90ij3yMYMA546whEZCbXgc7RvS4LzXOHPCbI18aXbKhd5RDoMMRpOjt0HqPdOsHl2roThLuOkh4ZBjrcHRwZBnBibdZA0fIjo2RSnX9QzAoFB8arOXPNOuukZB3i7R54SfgCPByIettZAEc54ZAlcddNPQ");
    
    FacebookCrawler(ConfigurationBuilder config) {
        fb = new FacebookFactory(config.build()).getInstance();
        fb.setOAuthAppId("824284154322542", "a3fcb10ae1498c7872cd441fbb6b6220");
        fb.setOAuthAccessToken(token);
    }
    
    public List getTimeline() throws FacebookException {
        List<String> ans = new LinkedList();
        List<Post> statuses = fb.getHome(page);
        
        statuses.stream().filter((status) -> (status.getMessage() != null)).forEach((status) -> {
            ans.add(status.getMessage());
        });
            
        return ans;
    }
}
