/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypoh;

import java.util.List;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		facebook4j.conf.ConfigurationBuilder config = new facebook4j.conf.ConfigurationBuilder();
        config
            .setDebugEnabled(true)
//            .setHttpProxyHost("cache2.itb.ac.id")
//            .setHttpProxyUser("afrizal_f")
//            .setHttpProxyPassword("R1zal96@itb")
//            .setHttpProxyPort(8080)
            ;
        
        try {
            List<String> query = new FacebookCrawler(config).getTimeline();
            
            query.stream().forEach((tweet) -> {
                System.out.println(tweet);
            });
        } catch (Exception ex) {
            Logger.getLogger(Keypoh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<String> parse(String s) {
		List<String> l = new LinkedList<>();
		for (String p : s.split("\\+")) {
			l.add(p);
		}
		return l;
	}
}
