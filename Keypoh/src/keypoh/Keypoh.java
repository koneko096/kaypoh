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
import twitter4j.*;
import twitter4j.conf.*;

import java.util.List;

public class Keypoh {
    /**
     * Constants
     */
    static final int tweetNumbers = 100;

    /**
     * Usage: java twitter4j.examples.timeline.GetHomeTimeline
     *
     * @param args String[]
     */
    public static void main(String[] args) {        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey("4Fe696sYfk2pZjmmncAaZJQUR")
            .setOAuthConsumerSecret("F25etIib277GtJDK5qIXzC8N4YdZ3Fh8w7Bg2otwqt2EDHQabj")
            .setOAuthAccessToken("94018147-mpvS450PWyQ9lB23gWFG4qxHcfeAQhGWEXAQnKgYa")
            .setOAuthAccessTokenSecret("b7hWuibWoSNjEjZ0T7jBoFF0OxUVxOFBy4IynmuL0iI69")
            .setHttpProxyHost("cache2.itb.ac.id")
            .setHttpProxyUser("afrizal_f")
            .setHttpProxyPassword("R1zal96@itb")
            .setHttpProxyPort(8080);
        
        try {
            // gets Twitter instance with default credentials
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            User user = twitter.verifyCredentials();
            Paging pages = new Paging (1, tweetNumbers);
            List<Status> statuses = twitter.getHomeTimeline(pages);
//            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            System.out.println(statuses.size());
//            for (Status status : statuses) {
//                System.out.println("@" + status.getUser().getScreenName() + " : " + status.getText());
//            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
    }
}