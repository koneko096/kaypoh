/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaypoh;

import java.util.List;

/**
 *
 * @author FiqieUlya
 */
public class Kaypoh {
    public List<String> query;
    public Kaypoh(String keyword){
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
            query = new TwitterCrawler(config).getTimeline(keyword);
            
            /*query.stream().forEach((tweet) -> {
                System.out.println(tweet);
            });*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
