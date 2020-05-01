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
public abstract class Entity implements java.io.Serializable{
    public ID id;
    public EntityType type;
    public EntitySpec specs;  
        
    Entity(EntitySpec properties){
        this.specs = properties;
    }
    
    
}
                                                                                                                                                                                                                                                                                                                                                                                                         