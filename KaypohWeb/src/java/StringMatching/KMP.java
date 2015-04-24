/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringMatching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author FiqieUlya
 */
public class KMP {

    /**
     * @param args
     * @throws java.io.IOException
     * @args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Knuth Morris Pratt\n");
        System.out.print("Text :");
        String text = br.readLine();
        System.out.print("\nPattern :");
        String pattern = br.readLine();
        KMP kmp = new KMP(text, pattern);    
    }
   
        
 
/** Class KnuthMorrisPratt **/

    /** Failure array **/
    private int[] failure;
    
    /** Constructor
     * @param text
     * @param pat **/
    public KMP(String text, String pat)
    {
        /** pre construct failure array for a pattern **/
        failure = new int[pat.length()];
        fail(pat);
        /** find match **/
        int pos = posMatch(text, pat);
        if (pos == -1) {
            System.out.println("\nNo match found");
        } else {
            System.out.println("\nMatch found at index "+ pos);
        }
    }
    /** Failure function for a pattern **/
    private void fail(String pat)
    {
        int n = pat.length();
        failure[0] = -1;
        for (int j = 1; j < n; j++)
        {
            int i = failure[j - 1];
            while ((pat.charAt(j) != pat.charAt(i + 1)) && i >= 0) {
                i = failure[i];
            }
            if (pat.charAt(j) == pat.charAt(i + 1)) {
                failure[j] = i + 1;
            } else {
                failure[j] = -1;
            }
        }
    }
    /** Function to find match for a pattern **/
    private int posMatch(String text, String pat)
    {
        int i = 0, j = 0;
        int lens = text.length();
        int lenp = pat.length();
        while (i < lens && j < lenp)
        {
            if (text.charAt(i) == pat.charAt(j))
            {
                i++;
                j++;
            }
            else if (j == 0) {
                i++;
            } else {
                j = failure[j - 1] + 1;
            }
        }
        return ((j == lenp) ? (i - lenp) : -1);
    }
    
}
    