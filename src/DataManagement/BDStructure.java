/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;
import Business.*;
import DataStructures.*;
/**
 *
 * @author pmoro
 */
public abstract class BDStructure<T> implements java.io.Serializable{
    int index = 0;
    public EntityType type;
    protected DynamicArray<T> elements;
    public String path ;
    public String identifier;
        
    public abstract ID add(Entity obj);
    public abstract boolean verify_type(Entity obj);
    public abstract void remove(ID id);
    public abstract void remove_based_on(HorseSpec specs);
    public abstract Entity find(ID id);
    public abstract DynamicArray<Entity> match(HorseSpec searched);
    public abstract void order_entities();
    public abstract DynamicArray<T> get_elements();
    public abstract String get_path();
    public abstract int get_index();
    public abstract EntityType get_type();    
    public abstract String get_identifier();
    
    
}
