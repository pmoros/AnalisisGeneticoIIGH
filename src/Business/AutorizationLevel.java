/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Rock
 */
public enum AutorizationLevel implements java.io.Serializable{
    USER(0),
    CLIENT(1),
    WORKER(2),
    ADMIN(3);    

    private final int numVal;

    AutorizationLevel(int numVal) {
        this.numVal = numVal;
    }

    public int get_value() {
        return numVal;
    }
    
}
