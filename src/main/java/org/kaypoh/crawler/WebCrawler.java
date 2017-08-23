package org.kaypoh.crawler;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class WebCrawler<Config, Client, Content> {
    final Client client;

    WebCrawler() {
        Config config = generateConfig();
        client = generateClient(config);
    }

    protected abstract Client generateClient(Config config);

    protected abstract Config generateConfig();

    List<Content> getTimeline(String key) {
        List<Content> apiContents = getContents(key).orElse(Collections.emptyList());
        return apiContents.stream().filter(this::contentNotEmpty)
                                   .collect(Collectors.toList());
    }

    protected abstract boolean contentNotEmpty(Content content);

    protected abstract Optional<List<Content>> getContents(String key);
}
