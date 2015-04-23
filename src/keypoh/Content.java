/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypoh;

/**
 *
 * @author ical
 */
public class Content {
    private String message;
    private String URL;
    
    /**
     * Constructor
     * @param msg
     * @param URL 
     */
    public Content(String msg, String URL) {
        this.message = msg;
        this.URL = URL;
    }
    
    /**
     * String getMessage
     * @return String
     */
    public String getMessage() { return message; }
    
    /**
     * String getURL
     * @return String
     */
    public String getURL() { return URL; }
}
