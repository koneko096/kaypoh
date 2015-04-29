/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringMatching;

/**
 * Class KnuthMorrisPrath
 * @author FiqieUlya
 */
public class KnuthMorrisPratt implements StringProcessor {
    private int[] failure;      // failure position array
    private String pat;         // pattern to be found
    
    /** Constructor
     * @param pat **/
    public KnuthMorrisPratt() {}
    
    /**
     * Procedure preprocess
     * Failure construct for a pattern
     * 
     * @param pat 
     */
    private void preprocess(String pat)
    {
        int n = pat.length();
        failure[0] = -1;
        for (int j = 1; j < n; j++)
        {
            int i = failure[j - 1];
            while (i >= 0 &&
                Character.toLowerCase(pat.charAt(j)) != Character.toLowerCase(pat.charAt(i + 1))) 
            {
                i = failure[i];
            }
            if (Character.toLowerCase(pat.charAt(j)) != Character.toLowerCase(pat.charAt(i + 1))) {
                failure[j] = i + 1;
            } else {
                failure[j] = -1;
            }
        }
    }
    
    /**
     * Function search
     * Function to find match for a pattern
     * 
     * @param text
     * @return 
     */
    @Override
    public boolean search(String text)
    {
        int i = 0, j = 0;
        int lens = text.length();
        int lenp = pat.length();
        while (i < lens && j < lenp)
        {
            if (Character.toLowerCase(text.charAt(i)) == Character.toLowerCase(pat.charAt(j)))
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
        return (j == lenp);
    }    

    /**
     * Procedure setPattern
     * @param pat 
     */
    @Override
    public void setPattern(String pat) {
        this.pat = pat;
        /** pre construct failure array for a pattern **/
        failure = new int[pat.length()];
        preprocess(pat);
    }
}
    

    

