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
public class Entity implements java.io.Serializable, Comparable<Entity>{
    public ID id;
    public EntityType type;
    private final EntitySpec specs;  
        
    public Entity(EntityType tipo, EntitySpec properties){
        Integer aux = 0;
        this.type = tipo;
        this.specs = properties;
        aux = properties.GetRegister();
        this.id = new ID(tipo, aux);
    }
    
    public Entity(EntitySpec properties){
        this.type = EntityType.ENTITY;
        this.specs = properties;        
    }    
    
    public Entity(EntityType tipo, int register){
        this.type = EntityType.ENTITY;
        this.id = new ID(tipo, register);
        this.specs = null;
    }     
    
    
    public EntitySpec get_specs(){
        return this.specs;
    }
    
    /**
     * Compara los atributos
     * @param x
     * @return 
     */
    public boolean equals(Entity x){
        return (this.specs.equals(x.specs));
    }
    
    @Override
    public boolean equals(Object x){
        Entity aux = (Entity) x;
        return (this.specs.equals(aux.specs));
    }    

    /**
     * Compara la etiqueta
     * @param o
     * @return 
     */

    @Override
    public int compareTo(Entity o) {
        if(this.id.compareTo(o.id) < 0) return -1;
        else if(this.id.compareTo(o.id) > 0) return 1;
        else{
            return 0;
        }
    }



    
}
                                                                                                                                                                                                                                                                                                                                                                                                         