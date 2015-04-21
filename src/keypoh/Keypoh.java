/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypoh;

import java.util.List;
import java.util.LinkedList;

/**
 * Kaypoh
 * @author ical
 */
public class Keypoh {
    /**
     * Driver
     * @param args String[]
     */
    public static void main(String[] args) {
        if ("tw".equals(args[0])) {
            CallTwitter(args);
        } else {
            CallFacebook(args);
        }
    }
    
    /**
     * Function parse
     * Parsing string to string list
     * 
     * @param s
     * @param regex
     * @return List<String>
     */
    private static List<String> parse(String s, String regex) {
        List<String> l = new LinkedList<>();
        for (String ss : s.split(regex)) {
            if (ss != null) {
                l.add(ss);
            }
        }
        return l;
    }
    
    /**
     * Procedure CallTwitter
     * Call Twitter API
     * 
     * @param args 
     */
    private static void CallTwitter(String[] args) {
        twitter4j.conf.ConfigurationBuilder config = new twitter4j.conf.ConfigurationBuilder();
        ConfigTwitter(config);
        
        try {
            List<String> query = new TwitterCrawler(config).getTimeline(args[1]);
            
            query.stream().forEach((tweet) -> {
                System.out.println(tweet);
            });
        } catch (Exception ex) {}
    }
    
    /**
     * Procedure ConfigTwitter
     * Configure Twitter API
     * 
     * @param config 
     */
    private static void ConfigTwitter(
        twitter4j.conf.ConfigurationBuilder config) {
        config
            .setDebugEnabled(true)
            .setApplicationOnlyAuthEnabled(true)
//            .setHttpProxyHost("cache2.itb.ac.id")
//            .setHttpProxyUser("afrizal_f")
//            .setHttpProxyPassword("R1zal96@itb")
//            .setHttpProxyPort(8080)
            ;
    }
    
    /**
     * Procedure CallFacebook
     * Call Facebook API
     * 
     * @param args 
     */
    private static void CallFacebook(String[] args) {
        facebook4j.conf.ConfigurationBuilder config = new facebook4j.conf.ConfigurationBuilder();
        ConfigFacebook(config);
        
        try {
            List<String> query = new FacebookCrawler(config).getTimeline(args[1]);
            
            query.stream().forEach((tweet) -> {
                System.out.println(tweet);
            });
        } catch (Exception ex) {}
    }
    
    /**
     * Procedure ConfigFacebook
     * Configure Facebook API
     * 
     * @param config 
     */
    private static void ConfigFacebook(
        facebook4j.conf.ConfigurationBuilder config) {
        config
            .setDebugEnabled(true)
//            .setHttpProxyHost("cache2.itb.ac.id")
//            .setHttpProxyUser("afrizal_f")
//            .setHttpProxyPassword("R1zal96@itb")
//            .setHttpProxyPort(8080)
            ;
    }
}
