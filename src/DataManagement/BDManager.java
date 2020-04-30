/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;
import java.io.*;
import DataStructures.*;
/**
 *
 * @author pmoro
 * @param <T>
 */

//THIS HAS TO BE AN ABSTRACT CLASS
public class BDManager<T> implements Serializable {
    public String path = System.getProperty("user.dir");   
    public String identifier = "\\BDManager";
    
    
            
    public void write_file(String path, T obj){
        //Gotta remember to introduce an obj that implements Serializable
        try{
            //Saving the object in a file
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);            
            //Serializing the object
            out.writeObject(obj);
            out.close();
            file.close();
            
        }
        catch(IOException ex){
            System.out.println("Something went wrong saving.");
        }
    
    }

    public T read_file(String path){
        T obj = null;
        try{
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            
            //deserialization
            obj = (T) in.readObject();
            in.close();
            file.close();
            return obj;
        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println("There was an error loading the object.");
        }  
        return null;
    }
    
}
