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
public class ID {
    
    private final String value;
    private final EntityType type;    
    
    public ID(EntityType t, String val){
        this.type = t;
        this.value = val;
    }
    
    public String get_value(){
        return this.value;
    }
    
    public EntityType get_type(){
        return this.type;
    }
    
    public boolean equals(ID other){
        if(other.get_type().equals(other.get_type())){
            return this.get_value().equals(other.get_value());
        }
        return false;
    }
        
}
