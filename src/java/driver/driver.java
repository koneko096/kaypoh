/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.util.*;
import keypoh.Keypoh;

/**
 * Driver class
 * only for debugging; not to submitted
 * @author ical
 */
public class driver {
    /**
     * Driver
     * arguments : api_used matching_method topic tags keywords
     * @param args String[]
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Keypoh k = new Keypoh(args);
        List<List> allresult = k.getResult();
        
        /* Print result */
        for (List<String> results : allresult) {
            System.out.println("Banyak post : " + results.size());
            for (String result : results) {
                System.out.println(result);
            }
            System.out.println();
        }
    }
    
}
