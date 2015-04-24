/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringMatching;

/**
 * Class BoyerMoore
 * @author FiqieUlya
 */
public class BoyerMoore implements StringProcessor {
    private final int R;     // the radix
    private int[] right;     // the bad-character skip array
    private String pat;      // pattern to be found

    /** 
     * Constructor
     * @param pat 
     */
    public BoyerMoore() { this.R = 256; }

    /**
     * Function search
     * Function search pattern
     * 
     * @param txt
     * @return boolean
     */
    @Override
    public boolean search(String txt) {
        int M = pat.length();
        int N = txt.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            try {
                for (int j = M-1; j >= 0; j--) {
                    if (Character.toLowerCase(pat.charAt(j)) 
                        != Character.toLowerCase(txt.charAt(i+j))) {
                        skip = Math.max(1, j - right[Character.toLowerCase(txt.charAt(i+j))]);
                        break;
                    }
                }
            } catch (Exception e) { break; }
            if (skip == 0) {
                return true;    // found
            }
        }
        return false;           // not found
    }

    /**
     * Procedure setPattern
     * @param pat 
     */
    @Override
    public void setPattern(String pat) {
        this.pat = pat;
        right = new int[R];

        // position of rightmost occurrence of c in the pattern
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < pat.length(); j++) {
            right[Character.toLowerCase(pat.charAt(j))] = j;
        }
    }
}
