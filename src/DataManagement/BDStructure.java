/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;
import DataStructures.*;
import Business.*;
import analisisgeneticoiigh.*;
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
    EntityType type;
    DynamicArray<T> structures;
    String path;
    String identifier;
    public BDStructure(String path, String identifier){
        //Implementar luego con otras estructuras
        this.structures = new DynamicArray<>();
        this.identifier = identifier;
        this.path = path + this.identifier;           
    }
    
    public void add_user(User obj){                
        index++;
        obj.id = EntityType.USER.name();
        obj.id = obj.id + Integer.toString(index);
        this.structures.append((T)obj);
    }
    
    public void add_entity(User obj){                
        index++;
        obj.id = EntityType.USER.name();
        obj.id = obj.id + Integer.toString(index);
        this.structures.append((T)obj);
    }    
    
    public void remove_user(String id){                
        for (int i = 0; i < this.structures.len; i++){
            User aux = (User) this.structures.get(i);
            if (aux.id.equals(id)) this.structures.delete_at(i);
        }
    }
    
    public void remove_entity(String id){                
        for (int i = 0; i < this.structures.len; i++){
            Entity aux = (Entity) this.structures.get(i);
            if (aux.id.equals(id)) this.structures.delete_at(i);
        }
    } 
    
    public void remove_based_on(EntitySpec specs){        
        //Only works with Entities
        for(int i = 0; i < this.structures.len; i++){
            Entity aux = (Entity) this.structures.get(i);
            EntitySpec others = aux.specs;
            if (others.equals(specs)) this.structures.delete_at(i);
        }
    }
    
    public boolean find_user(String id){
       for (int i = 0; i < this.structures.len; i++){
           User aux = (User) this.structures.get(i);
           if(aux.id.equals(id)) return true;
       }
       return false;
    }
    
    public Entity find_entity(String id){
       for (int i = 0; i < this.structures.len; i++){
           Entity aux = (Entity) this.structures.get(i);
           if(aux.id.equals(id)) return aux;
       }
       return null;    
    }    
    
    public DynamicArray<Entity> match_properties(EntitySpec searched){
        
       DynamicArray<Entity> results = new DynamicArray<>();
       for (int i = 0; i < this.structures.len; i++){
           Entity aux = (Entity) this.structures.get(i);
           if(aux.specs.matches(searched)){
               results.append(aux);
           }
       }
       return results;
    }
    
    public void order_entities(String id){
        int n = this.structures.len; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (( (((Entity)this.structures.get(j)).id).compareTo(((Entity)this.structures.get(j)).id)) > 0)
                { 
                    // swap arr[j+1] and arr[i] 
                    T temp = this.structures.get(j); 
                    this.structures.insert(j,this.structures.get(j+1)); 
                    this.structures.insert((j+1),temp); 
                }         
    }
}
