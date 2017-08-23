/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaypoh.crawler;

import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.Optional;

/**
 * TwitterCrawler
 * 
 * @author Afrizal Fikri
 */
public class TwitterCrawler extends WebCrawler<Configuration, Twitter, Status> {
    private Twitter tw;
    private final int limit = 100;    
    /*
    private final AccessToken token = new AccessToken(
        "94018147-mpvS450PWyQ9lB23gWFG4qxHcfeAQhGWEXAQnKgYa",
        "b7hWuibWoSNjEjZ0T7jBoFF0OxUVxOFBy4IynmuL0iI69"
    );
    */

    @Override
    protected Twitter generateClient(Configuration config) {
        return new TwitterFactory(config).getInstance();
    }

    @Override
    protected Configuration generateConfig() {
        return new ConfigurationBuilder()
                .setDebugEnabled(true)
                .setApplicationOnlyAuthEnabled(true)
                .setOAuthConsumerKey("4Fe696sYfk2pZjmmncAaZJQUR")
                .setOAuthConsumerSecret("F25etIib277GtJDK5qIXzC8N4YdZ3Fh8w7Bg2otwqt2EDHQabj")
                .build();
    }

    @Override
    protected boolean contentNotEmpty(Status status) {
        return !status.getText().isEmpty();
    }

    @Override
    protected Optional<List<Status>> getContents(String key) {
        Query query = new Query(key);
        query.setCount(limit);

        List<Status> statuses = null;
        try {
            QueryResult qres = tw.search(query);
            statuses = qres.getTweets();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(statuses);
    }

    public void Call(String keys, List<String> res, List<String> uid, List<String> pic) throws Exception {
        List<Status> query = null;
        try {
            query = getTimeline(keys);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (query != null) {
                for (Status aQuery : query) {
                    res.add(aQuery.getText());
                    uid.add(aQuery.getUser().getScreenName());
                    pic.add(aQuery.getUser().getProfileImageURL());
                }
            }
        }
    }
}
