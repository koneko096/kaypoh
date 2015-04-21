/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringMatching;

/**
 * Interface StringProcessor
 * @author ical
 */
public interface StringProcessor {

    /**
     * Function search
     * Perform search current pattern inside given text
     * 
     * @param text
     * @return
     */
    public boolean search(String text);
}
