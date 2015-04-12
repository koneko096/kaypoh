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
    private Facebook fb;
    private final Reading page = new Reading().limit(200);
    private final AccessToken token = new AccessToken("CAALtrpw2Xm4BAHqvInx5BWX9etcALMu4tPo97VriZC6etBYhZBGoRbpTigS77OZCZANfmpYZAEggMxmpZBSAiOrR8iqenA9FZCctGZBJn4OTZBoJc2ZAlhqNIpQZCTKhYdABujZAr8bGAxrWRmZCFLBEEqR8CBCZBfy0Q6B5wFZC9KZCrRHZBgd0OZAZCmPfluaMCyEBOeAGmD9fGTZBOBYbFbjYnzjDntpN");
    
    FacebookCrawler(ConfigurationBuilder config) {
        fb = new FacebookFactory(config.build()).getInstance();
        fb.setOAuthAppId("824284154322542", "a3fcb10ae1498c7872cd441fbb6b6220");
        fb.setOAuthAccessToken(token);
        System.out.println(token);
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
