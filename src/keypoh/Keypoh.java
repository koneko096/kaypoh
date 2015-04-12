/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypoh;

/**
 *
 * @author ical
 */
import java.net.*;

import facebook4j.*;
import facebook4j.auth.AccessToken;

//import twitter4j.*;
//import twitter4j.conf.*;

import java.util.List;

public class Keypoh {
    /**
     * Constants
     */
    static final int limit = 100;

    /**
     * Query processor
     *
     * @param args String[]
     */
    public static void main(String[] args) {
//        ConfigurationBuilder config = new ConfigurationBuilder();
//        config
//            .setDebugEnabled(true)
//            .setHttpProxyHost("cache2.itb.ac.id")
//            .setHttpProxyUser("afrizal_f")
//            .setHttpProxyPassword("R1zal96@itb")
//            .setHttpProxyPort(8080)
//            .setOAuthConsumerKey("4Fe696sYfk2pZjmmncAaZJQUR")
//            .setOAuthConsumerSecret("F25etIib277GtJDK5qIXzC8N4YdZ3Fh8w7Bg2otwqt2EDHQabj")
//            .setOAuthAccessToken("94018147-mpvS450PWyQ9lB23gWFG4qxHcfeAQhGWEXAQnKgYa")
//            .setOAuthAccessTokenSecret("b7hWuibWoSNjEjZ0T7jBoFF0OxUVxOFBy4IynmuL0iI69")
//            ;
        
        Facebook fb = new FacebookFactory().getInstance();
        fb.setOAuthAppId("824284154322542", "a3fcb10ae1498c7872cd441fbb6b6220");
        
        AccessToken at = new AccessToken("CAALtrpw2Xm4BAHqvInx5BWX9etcALMu4tPo97VriZC6etBYhZBGoRbpTigS77OZCZANfmpYZAEggMxmpZBSAiOrR8iqenA9FZCctGZBJn4OTZBoJc2ZAlhqNIpQZCTKhYdABujZAr8bGAxrWRmZCFLBEEqR8CBCZBfy0Q6B5wFZC9KZCrRHZBgd0OZAZCmPfluaMCyEBOeAGmD9fGTZBOBYbFbjYnzjDntpN");
        fb.setOAuthAccessToken(at);
        
        try {
            List<Post> feeds = fb.getHome();
            System.out.println(feeds.size());
            
            // For all feeds...
            for (Post post : feeds) {
                String content = post.getMessage();
                String type = post.getType();
                System.out.print(type + " --> ");
                
                if (type == "link") {
                    content = post.getLink()+ "\n" + content;
                }
                
                if (content != null)
                    System.out.println(content);
            }
        } catch (FacebookException fe) {
            fe.printStackTrace();
        }           
        
//        try {
//            // gets Twitter instance with default credentials
//            TwitterFactory tf = new TwitterFactory(config.build());
//            Twitter twitter = tf.getInstance();
//            User user = twitter.verifyCredentials();
//            Paging pages = new Paging (1, tweetNumbers);
//            List<Status> statuses = twitter.getHomeTimeline(pages);
////            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
//            System.out.println(statuses.size());
////            for (Status status : statuses) {
////                System.out.println("@" + status.getUser().getScreenName() + " : " + status.getText());
////            }
//        } catch (TwitterException te) {
//            te.printStackTrace();
//            System.out.println("Failed to get timeline: " + te.getMessage());
//            System.exit(-1);
//        }
        
        
    }
}