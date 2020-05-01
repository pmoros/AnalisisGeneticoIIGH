/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author pmoro
 */
public abstract class EntitySpec implements java.io.Serializable{
    
    
    public boolean matches(EntitySpec searched){
        return false;
    }
}
