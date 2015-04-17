/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypoh;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Kaypoh
 * 
 * @author ical
 */
public class Keypoh {
    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        twitter4j.conf.ConfigurationBuilder config = new twitter4j.conf.ConfigurationBuilder();
        config
            .setDebugEnabled(true)
            .setApplicationOnlyAuthEnabled(true)
//            .setHttpProxyHost("cache2.itb.ac.id")
//            .setHttpProxyUser("afrizal_f")
//            .setHttpProxyPassword("R1zal96@itb")
//            .setHttpProxyPort(8080)
            ;
        
        try {
            List<String> query = new TwitterCrawler(config).getTimeline("hobiku");
            
            query.stream().forEach((tweet) -> {
                System.out.println(tweet);
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static List<String> parse(String s, String regex) {
		List<String> l = new LinkedList<>();
                l.addAll(Arrays.asList(s.split(regex)));
		return l;
	}
}
