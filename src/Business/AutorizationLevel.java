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
public enum AutorizationLevel {
    CLIENT(0),
    ADMIN(1);

    private int numVal;

    AutorizationLevel(int numVal) {
        this.numVal = numVal;
    }

    public int get_val() {
        return numVal;
    }    
}
