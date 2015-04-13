/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypoh;

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
    private final Paging page = new Paging(1, 200);
    private final AccessToken token = new AccessToken(
        "94018147-mpvS450PWyQ9lB23gWFG4qxHcfeAQhGWEXAQnKgYa",
        "b7hWuibWoSNjEjZ0T7jBoFF0OxUVxOFBy4IynmuL0iI69"
    );
    
    TwitterCrawler(ConfigurationBuilder config) {
        tw = new TwitterFactory(config.build()).getInstance();
        tw.setOAuthConsumer("4Fe696sYfk2pZjmmncAaZJQUR", "F25etIib277GtJDK5qIXzC8N4YdZ3Fh8w7Bg2otwqt2EDHQabj");
        tw.setOAuthAccessToken(token);
    }
    
    public List getTimeline() throws TwitterException {
        List<String> ans = new LinkedList();
        List<Status> tweets = tw.getHomeTimeline(page);
        
        tweets.stream().filter((tweet) -> (tweet.getText() != null)).forEach((tweet) -> {
            ans.add(tweet.getText());
        });
            
        return ans;
    }
}
