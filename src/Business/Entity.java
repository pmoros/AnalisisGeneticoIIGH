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
    
    /**
     * Compara los atributos
     * @param x
     * @return 
     */
    public boolean equals(Entity x){
        return (this.specs.equals(x.specs));
    }

    /**
     * Compara la etiqueta
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Entity o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
                                                                                                                                                                                                                                                                                                                                                                                                         