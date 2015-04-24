/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypoh;

import java.util.*;
import static java.util.Arrays.asList;
import StringMatching.*;

/**
 * Kaypoh
 * @author ical
 */
public class Keypoh {
    private List<String> topics = asList("topic1", "topic2", "topic3");
    private List< List<String> > topicCategories = asList(
        asList("categ11", "categ12", "categ13"),
        asList("categ21", "categ22", "categ23"),
        asList("categ31", "categ32", "categ33")
    );
    private List<String> categories;
    private Map<String, List<String> > searchResult = new HashMap();
        
    /**
     * Constructor
     * input arguments as params : 
     * api_used matching_method topic tags keywords
     * 
     * @param args
     * @throws java.lang.Exception
     */
    public Keypoh(String[] args) throws Exception {
        List<String> contents;
        StringProcessor st;

        /* Get contents from API request */
        if (args[0].equals("tw")) {
            twitter4j.conf.ConfigurationBuilder config;
            config = new twitter4j.conf.ConfigurationBuilder();
            contents = new TwitterCrawler(config).Call(QueryGenerator(args[3], 0));
        } else {
            facebook4j.conf.ConfigurationBuilder config;
            config = new facebook4j.conf.ConfigurationBuilder();
            contents = new FacebookCrawler(config).Call(QueryGenerator(args[3], 1));
        }

        /* Set matching method */
        if (args[1].equals("bm")) {
            st = new BoyerMoore();
        } else {
            st = new KnuthMorrisPratt();
        }

        /* Set categories from given topic */
        for (int i = 0; i < topics.size(); ++i) {
            if (topics.get(i).equals(args[2])) {
                categories = topicCategories.get(i);
                break;
            }
        }

        /* Categorize each content */
        for (String content : contents) {
            boolean categorized = false;

            for (int i = 4; i < args.length && !categorized; ++i) {
                List<String> keywords = parse(args[i], ",");

                for (String keyword : keywords) {
                    st.setPattern(keyword);
                    if (st.search(content)) {
                        List<String> list = searchResult.get(categories.get(i - 4));
                        if (list == null) {
                            list = new LinkedList<>();
                        }
                        list.add(content);
                        searchResult.put(categories.get(i - 4), list);

                        categorized = true;
                        break;
                    }
                }
            }

            /* unknown category */
            if (!categorized) {
                List<String> list = searchResult.get("unknown");
                if (list == null) {
                    list = new LinkedList<>();
                }
                list.add(content);
                searchResult.put("unknown", list);
            }
        }
    }
    
    public List getResult() {
        List<List<String>> allresult = new ArrayList<>();
        
        /* Add result */
        for (String category : categories) {
            List<String> results = searchResult.get(category);
            if (results == null) results = new ArrayList<>();
            allresult.add(results);
        }

        /* Khusus untuk kategori unknown */
        List<String> results = searchResult.get("unknown");
        if (results == null) results = new ArrayList<>();
        allresult.add(results);
        
        return allresult;
    }

    
    /**
     * Function parse
     * Parsing string to string list
     * 
     * @param s
     * @param delim
     * @return List<String>
     */
    private List<String> parse(String s, String delim) {
        List<String> l = new LinkedList<>();
        for (String ss : s.split(delim)) {
            if (ss != null) {
                l.add(ss);
            }
        }
        return l;
    }
    
    /**
     * String QueryGenerator
     * Adjust multi queries to API call argument
     * 
     * @param key
     * @param param
     * @return String
     */
    public String QueryGenerator(String key, int param) {
        String q = "";
        for (String s : parse(key, ",")) {
            if (s != null) {
                if (!q.equals("")) {
                    switch (param) {
                        case 0 : q += " OR "; break;
                        case 1 : q += "+"; break;
                    }
                }
                q += s;
            }
        }
        return q;        
    }
}
