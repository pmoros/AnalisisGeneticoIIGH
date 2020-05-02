/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;
import DataStructures.*;
import Business.*;

/**
 * Esta estructura es el equivalente a una tabla de una base de
 * datos, esta almacena los elementos que tenemos en el sistema
 * como usuarios o caballos, su generic recibe el tipo de dato
 * que va a almacenar. Esta es la encargada de hacer las opera -
 * ciones CRUD y demás sobre la información.
 * 
 * Nota: IMPLEMENTAR OTRAS QUE TENGAN LOS MISMOS METODOS PERO QUE
 * ESTEN BASADAS EN OTRAS ESTRUCTURAS DE DATOS, COMO:
 * 
 *  - BDLinkedStructure
 *  - BDTreeStructure
 * 
 * @author pmoro
 * @param <T>
 */
public class BDArrayStructure<T> implements java.io.Serializable{
    
    /*
    OJO, AQUI HAY QUE REVISAR LOS SIGUIENTES METODOS QUE NO SON
    GENERICOS:
       - void remove_based_on(HorseSpec specs) : Solo funciona
         tomando HorseSpec, osea caracteristicas de caballos,
         esta función debería recibir cualquier EntitySpec y
         poder hacer las comparaciones.
    
       - DynamicArray<Entity> match(HorseSpec searched): Solo
         funciona con caracteristicas de caballos, deberia ser
         posible que funcione con caracteristicas de cualquier
         entidad.
    
    Nota: show_users() y show_horses() son funciones de testeo.
    
    */
    int index = 0;
    public EntityType type;
    private DynamicArray<T> elements;
    public String path;
    public String identifier;
    
/**
 * Construye una "tabla" de la base de datos.
 * @param tipo El tipo de dato que se va almacenar, ejemplo: EntityType.USER
 * @param path Es la ruta del proyecto, se usa para saber donde guardar.
 * @param identifier El codigo que recibe la "tabla"
 */    
    public BDArrayStructure(EntityType tipo, String path, String identifier){               
        //Implementar luego con otras estructuras        
        this.type = tipo;
        this.elements = new DynamicArray<>();
        this.identifier = identifier;
        this.path = path + this.identifier;           
    }
    
/**
 * Agrega un nuevo objeto a la "tabla" de la base de datos
 * @param obj Objeto que agrega
 * @return Retorna el identificador que tiene en la "tabla" el objeto
 */    
    public ID add(Entity obj){ 
        if(!this.verify_type(obj)) return null;
        index++;
        obj.id = new ID(obj.type, index);
        this.elements.append((T)obj);
        return obj.id;
    }
   
/**
 * Checks if the object we passed it's allowed on the table
 * @param obj
 * @return 
 */    
    public boolean verify_type(Entity obj){
        //Metodo voluntario...
        if(!obj.type.equals(this.type)) {
            System.out.println("There was a problem adding the element.");
            return false;
        }    
        return true;
    }
    
/**
 * Removes an element based on it's ID
 * @param id instance of class ID
 */    
    public void remove(ID id){                
        for (int i = 0; i < this.elements.pointer; i++){
            Entity aux = (Entity) this.elements.get(i);
            if (aux.id.equals(id)){
                this.elements.delete_at(i);
                return;
            }
        }
    }
     
    
/**
 * This removes all the objects in the table that match the specs
 * @param specs contains the pattern of info we are looking for.
 */    
    public void remove_based_on(HorseSpec specs){        
        //Only works with Horses, GOTTA FIX IT
        for(int i = 0; i < this.elements.pointer; i++){
            Entity aux = (Entity) this.elements.get(i);
            HorseSpec others = (HorseSpec) aux.get_specs();
            if (specs.matches(others)){ 
                this.elements.delete_at(i);
                i--;
            }
        }
    }
    
/**
 * Finds and object based on an ID
 * @param id
 * @return 
 */    
    
    public Entity find(ID id){
       for (int i = 0; i < this.elements.pointer; i++){
           Entity aux = (Entity) this.elements.get(i);
           if(id.equals(aux.id)) return aux;
       }
       System.out.println("Couldn't find it.");
       return null;
    }        
    
/**
 * Returns the list of all the elements that match the patter
 * @param searched it's the specifications pattern that we give
 * @return 
 */    
    public DynamicArray<Entity> match(HorseSpec searched){
        //Only works with horses, GOTTA FIX IT
       DynamicArray<Entity> results = new DynamicArray<>();
       for (int i = 0; i < this.elements.pointer; i++){
           Entity aux = (Entity) this.elements.get(i);
           if(searched.matches((HorseSpec)aux.get_specs())){
               results.append(aux);
           }
       }
       return results;
    }
    
    
/**
 * Not implemented yet al all
 */    
    public void order_entities(){
        //CHECK THIS METHOD
        
        int n = this.elements.pointer; 
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n-i; j++) 
                if (( (((Entity)this.elements.get(j)).id).compare_to(((Entity)this.elements.get(j)).id)) > 0)
                { 
                    // swap arr[j+1] and arr[i] 
                    T temp = this.elements.get(j); 
                    this.elements.insert(j,this.elements.get(j+1)); 
                    this.elements.insert((j+1),temp); 
                }         
    }
    
    
/**
 * Returns all that is stored in the "table"
 * @return 
 */    
    public DynamicArray<T> get_elements(){
        return this.elements;
    }
    

//TESTER METHODS    
    public void show_users(){
        for(int i = 0; i < this.elements.pointer; i++){
            User aux = (User) this.elements.get(i);
            System.out.println("User " + Integer.toString(i) + ":");
            System.out.println(aux.id.get());
            System.out.println(aux.get_specs().user_name);
        }
        
    }
    
    public void show_horses(){
        for(int i = 0; i < this.elements.pointer; i++){
            Entity aux = (Entity) this.elements.get(i);
            HorseSpec aux2 = (HorseSpec) aux.get_specs();
            System.out.println("Horse " + Integer.toString(i) + ":");
            System.out.println(aux.id.get());
            System.out.println(aux2.name);
        }    
        
    }
    
}
