/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaypoh.crawler;

import facebook4j.*;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.Optional;

/**
 * FacebookCrawler
 * 
 * @author Afrizal Fikri
 */
public class FacebookCrawler extends WebCrawler<Configuration, Facebook, Post> {
    private final Reading page = new Reading().limit(100);

    @Override
    protected Facebook generateClient(Configuration config) {
        return new FacebookFactory(config).getInstance();
    }

    @Override
    protected Configuration generateConfig() {
        return new ConfigurationBuilder()
                    .setDebugEnabled(true)
                    .setOAuthAppId("824284154322542")
                    .setOAuthAppSecret("a3fcb10ae1498c7872cd441fbb6b6220")
                    .setOAuthAccessToken("CAALtrpw2Xm4BAO8GWZBlBuzfTDr4NuGCgtinUSLypGDkT7jiHhffUZBNAIirEyQ6IUemQGRGaZAKFZBDeFHRSVcglqWA7S715rPDhl9TjVGqKFQ7w4FZCWAVq0u0L0LP47RbosOhARNE01HB1gR2OZCk3XdnCAwoudDTYrARYFUPk3FkrhSNH6E5GFh8OlKZCcz1T8n4EPh0yOqtS6qKxH1")
                    .build();
    }

    @Override
    protected boolean contentNotEmpty(Post post) {
        return !post.getMessage().isEmpty();
    }

    @Override
    protected Optional<List<Post>> getContents(String key) {
        List<Post> fbStatuses = null;
        try {
            fbStatuses = client.searchPosts(key, page);
        } catch (FacebookException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(fbStatuses);
    }

    public void Call(String keys, List<String> res, List<String> uid) throws Exception {
        List<Post> query = null;
        try {
            query = getTimeline(keys);
        } finally {
            if (query != null) {
                for (Post aQuery : query) {
                    res.add(aQuery.getMessage());
                    uid.add(aQuery.getName());
                }
            }
        }
    }
}
