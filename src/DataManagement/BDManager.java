/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;
import Business.EntityType;
import java.io.*;
import DataStructures.*;
/**
 *
 * @author pmoro
 * @param <T>
 */

//THIS HAS TO BE AN ABSTRACT CLASS
public class BDManager<T> implements Serializable {
    //PRUEBA
    public int index = 0;
    public String path = System.getProperty("user.dir");   
    public String self_path;
    public String identifier = "\\BDManager";    
    public DynamicArray<String> indices;
    public DynamicArray<String> structures;
    public BDArrayStructure current;
    
    public BDManager(){
        this.indices = new DynamicArray<>();
        this.structures = new DynamicArray<>();
        this.self_path = this.path + this.identifier;
    }
    
    public void add(EntityType type){        
        String id_structure = type.name();        
        //esto lo guardamos en indices
        String ruta_tabla = this.path + "\\" + id_structure;
        this.indices.append(id_structure);
        this.structures.append(ruta_tabla);
        BDArrayStructure aux = new BDArrayStructure<>(type, ruta_tabla, id_structure);
        //this.write_file(ruta_tabla, (T) aux);
    }
    
    public void load(EntityType type){
        int indice_aux = this.indices.find(type.name());        
        String ruta =  this.structures.get(index);
        this.current = (BDArrayStructure) this.read_file(ruta);
        
    }    
    
    public void save_changes(){
        //It saves the changes in the current data base
        this.write_file(this.current.path, (T)this.current);
    }
    
    public void write_file(String path, T obj){
        //Gotta remember to introduce an obj that implements Serializable
        try{
            try ( //Saving the object in a file
                    FileOutputStream file = new FileOutputStream(path); ObjectOutputStream out = new ObjectOutputStream(file)) {
                //Serializing the object
                out.writeObject(obj);
            }
            
        }
        catch(IOException ex){
            System.out.println("Something went wrong saving.");
        }
    
    }

    public T read_file(String path){
        T obj = null;
        try{
            try (FileInputStream file = new FileInputStream(path); ObjectInputStream in = new ObjectInputStream(file)) {
                
                //deserialization
                obj = (T) in.readObject();
            }
            return obj;
        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println("There was an error loading the object.");
        }  
        return null;
    }
    
}
