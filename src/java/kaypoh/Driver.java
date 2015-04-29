/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaypoh;

import java.util.*;
import kaypoh.Kaypoh;

/**
 * Driver class
 * only for debugging; not to submitted
 * @author ical
 */
public class Driver {
    /**
     * Driver
     * arguments : api_used matching_method topic tags keywords
     * @param args String[]
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String [] argss= new String[10];
        //api
        argss[0]="tw";//request.getParameter("mode") ;
        argss[1]="kmp";
        argss[2]="Beauty";
        //tags
        argss[3]="#Salon";//request.getParameter("keyword") ;
        argss[4]="sex";
        argss[5]="bedak,kalung";
        argss[6]="job";
        Kaypoh Kepo = new Kaypoh(argss);
        List<List> allresult = Kepo.getResult();
        Kaypoh k = new Kaypoh(argss);
        
        /* Print result */
        for (List<String> results : allresult) {
            int N;
            try {
                N = results.size();
            } catch (NullPointerException e) {
                results = new ArrayList();
                N = results.size();
            }
            System.out.println("Banyak post : " + N);
            for (String result : results) {
                System.out.println(result);
            }
            System.out.println();
        }
    }
    
}
