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
public class Entity implements java.io.Serializable{
    public ID id;
    public EntityType type;
    private EntitySpec specs;  
        
    public Entity(EntityType tipo, EntitySpec properties){
        this.type = tipo;
        this.specs = properties;
    }
    
    public Entity(EntitySpec properties){
        this.type = EntityType.ENTITY;
        this.specs = properties;
    }    
    
    public EntitySpec get_specs(){
        return this.specs;
    }
    
    
}
                                                                                                                                                                                                                                                                                                                                                                                                         