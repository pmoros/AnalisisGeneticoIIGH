/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;
import Business.EntityType;
import Business.EntitySpec;
import Business.Entity;
import DataStructures.*;
import Business.*;

/**
 *
 * @author pmoro
 * @param <T>
 */
public class BDStructure<T> implements java.io.Serializable{
    
    /*
    OJO, AQUI HAY QUE REVISAR MUCHOS METODOS QUE NO SON GENERICOS
    COMO EL DE BORRAR CON ID.
    
    */
    int index = 0;
    public EntityType type;
    private DynamicArray<T> elements;
    public String path;
    public DynamicArray<ID> identifier;
    public BDStructure(String path, String identifier){
        //Implementar luego con otras estructuras
        this.elements = new DynamicArray<>();
        this.identifier = identifier;
        this.path = path + this.identifier;           
    }
    
    public String add_user(User obj){                
        index++;
        obj.id = EntityType.USER.name();
        obj.id = obj.id + Integer.toString(index);
        this.elements.append((T)obj);
        return obj.id;
    }
    
    public String add_horse(Entity obj){ 
        //This method adds 
        index++;
        obj.id = EntityType.ENTITY.name();
        obj.id = obj.id + Integer.toString(index);
        this.elements.append((T)obj);
        return obj.id;
    }    
    
    public void remove_user(String id){                
        for (int i = 0; i < this.elements.len; i++){
            User aux = (User) this.elements.get(i);
            if (aux.id.equals(id)){
                this.elements.delete_at(i);
                return;
            }
        }
    }
    
    public void remove_entity(String id){                
        for (int i = 0; i < this.elements.len; i++){
            Entity aux = (Entity) this.elements.get(i);
            if (aux.id.equals(id)) this.elements.delete_at(i);
        }
    } 
    
    public void remove_based_on(EntitySpec specs){        
        //Only works with Entities
        for(int i = 0; i < this.elements.len; i++){
            Entity aux = (Entity) this.elements.get(i);
            EntitySpec others = aux.specs;
            if (others.equals(specs)) this.elements.delete_at(i);
        }
    }
    
    public User find_user(String id){
       for (int i = 0; i < this.elements.len; i++){
           User aux = (User) this.elements.get(i);
           if(aux.id.equals(id)) return aux;
       }
       return null;
    }
    
    public Entity find_entity(String id){
       for (int i = 0; i < this.elements.len; i++){
           Entity aux = (Entity) this.elements.get(i);
           if(aux.id.equals(id)) return aux;
       }
       return null;    
    }    
    
    public DynamicArray<Entity> match_properties(EntitySpec searched){
        
       DynamicArray<Entity> results = new DynamicArray<>();
       for (int i = 0; i < this.elements.len; i++){
           Entity aux = (Entity) this.elements.get(i);
           if(aux.specs.matches(searched)){
               results.append(aux);
           }
       }
       return results;
    }
    
    public void order_entities(){
        int n = this.elements.len; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (( (((Entity)this.elements.get(j)).id).compareTo(((Entity)this.elements.get(j)).id)) > 0)
                { 
                    // swap arr[j+1] and arr[i] 
                    T temp = this.elements.get(j); 
                    this.elements.insert(j,this.elements.get(j+1)); 
                    this.elements.insert((j+1),temp); 
                }         
    }
    
    public DynamicArray<T> get_horses(){
        return this.elements;
    }
    
    public DynamicArray<T> get_users(){
        return this.elements;
    }
    
    public void show_users(){
        for(int i = 0; i < this.elements.pointer; i++){
            User aux = (User) this.elements.get(i);
            System.out.println(aux.id);
            System.out.println(aux.user_name);
        }
        
    }
    
    
}
