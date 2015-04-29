/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaypoh;

import java.util.*;
import static java.util.Arrays.asList;
import StringMatching.*;

/**
 * Kaypoh
 * @author ical
 */
public class Kaypoh {
    private List<String> topics = asList("Health & Beauty", "Entertainment", "Sport", "Tech");
    public List< List<String> > topicCategories = asList(
        asList("Obat", "Perawatan Tubuh", "Perawatan Wajah","Fashion"),
        asList("Musik", "Movies", "TV","Celebrity"),
        asList("Bola", "Raket", "Atlet", "Turnamen"),
        asList("Internet","Gadget","Science", "Space")
    );
    public List<List<String> > username = null;
    private List<List<String> > searchResult = null;
    public List<List<String>> profpic=null;
    /**
     * Constructor
     * input arguments as params : 
     * api_used matching_method topic tags keywords
     * 
     * @param args
     * @throws java.lang.Exception
     */
    public Kaypoh(String[] args) throws Exception {
        List<String> contents = new ArrayList<>();
        List<String> users = new ArrayList<>();
        List<String> picture = new ArrayList<>();
        StringProcessor st;

        /* Set matching method */
        if (args[1].equalsIgnoreCase("bm")) {
            st = new BoyerMoore();
        } else {
            st = new KnuthMorrisPratt();
        }
        
        /* Set categories from given topic */
        for (int i = 0; i < topics.size(); ++i) {
            if (topics.get(i).equals(args[2])) {
                int N = topicCategories.get(i).size();
                searchResult = new ArrayList(N + 1);
                username = new ArrayList(N + 1);
                profpic= new ArrayList(N+1);
                for (int j = 0; j <= N; j++) {
                    searchResult.add(null);
                    username.add(null);
                    profpic.add(null);
                }
                break;
            }
        }
        
        /* Get contents from API request */
        if (args[0].equalsIgnoreCase("tw")) {
            twitter4j.conf.ConfigurationBuilder config;
            config = new twitter4j.conf.ConfigurationBuilder();
            TwitterCrawler x = new TwitterCrawler(config);
            x.Call(QueryGenerator(args[3], 0), contents, users, picture);
        } else {
            facebook4j.conf.ConfigurationBuilder config;
            config = new facebook4j.conf.ConfigurationBuilder();
            FacebookCrawler x = new FacebookCrawler(config);
            x.Call(QueryGenerator(args[3], 1), contents, users);
        }

        /* Categorize each content */
        for (int j = 0; j < contents.size(); j++) {
            boolean categorized = false;
            String content = contents.get(j);
            String user = users.get(j);
            String pic =picture.get(j);
            for (int i = 4; !categorized && args[i] != null; ++i) {
                List<String> keywords = parse(args[i], ",");

                for (String keyword : keywords) {
                    st.setPattern(keyword);
                    if (st.search(content)) {
                        List<String> list = searchResult.get(i - 4);
                        List<String> list2 = username.get(i - 4);
                        List<String> list3 = profpic.get(i - 4);
                        if (list == null) {
                            list = new ArrayList<>();
                            list2 = new ArrayList<>();
                            list3 = new ArrayList<>();
                        }
                        list.add(content);
                        list2.add(user);
                        list3.add(pic);
                        searchResult.set(i - 4, list);
                        username.set(i - 4, list2);
                        profpic.set(i-4,list3);

                        categorized = true;
                        break;
                    }
                }
            }

            /* unknown category */
            if (!categorized) {
                int N = searchResult.size();
                List<String> list = searchResult.get(N - 1);
                List<String> list2 = username.get(N - 1);
                List<String> list3 = profpic.get(N - 1);
                if (list == null) {
                    list = new ArrayList<>();
                    list2 = new ArrayList<>();
                    list3 = new ArrayList<>();
                }
                list.add(content);
                list2.add(user);
                list3.add(pic);
                searchResult.set(N - 1, list);
                username.set(N - 1, list2);
                profpic.set(N - 1, list3);
            }
        }
    }
    
    public List getResult() {        
        return searchResult;
    }
    
    public String getLocation(String s, int k) {
        int pos;
        String ans = "";
        pos = s.indexOf("Di ");
        if (pos >= 0) 
            pos += 3;
        else {
            pos = s.indexOf(" di ");
            if (pos < 0) return ans;
            pos += 4;
        }
        String[] l = s.substring(pos).split(" ");
        try {
            for (int i = 0; i < k; i++) {
                if (i > 0) ans += " ";
                ans += l[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
        return ans;
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

