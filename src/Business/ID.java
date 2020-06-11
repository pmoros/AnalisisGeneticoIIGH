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
public class ID implements java.io.Serializable{
    
    private final int value;
    private final EntityType type;    
    
    public ID(EntityType t, int val){
        this.type = t;
        this.value = val;
    }
    
    public int get_value(){
        return this.value;
    }
    
    public EntityType get_type(){
        return this.type;
    }
    
    public boolean equals(ID other){
        if(other.get_type().equals(other.get_type())){
            return (this.value == other.value);
        }
        return false;
    }
     
    public int compare_to(ID other){
        if (this.value == other.value){
            return 0;
        }
        else if(this.value > other.value){
            return 1;
        }
        else{
            return -1;
        }
        
    } 
    
    public String get(){
        String aux = Integer.toString(this.value);
        return (this.type.name() + aux);
    
    }
    
}
