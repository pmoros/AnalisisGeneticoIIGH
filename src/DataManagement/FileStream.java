/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
/**
 *
 * @author pmoro
 * @param <T>
 */
public class FileStream<T> implements java.io.Serializable{
    
    public FileStream(){
    
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
            System.out.println(ex);
        }
    
    }

    public T read_file(String path){
        T obj;
        try{
            try (FileInputStream file = new FileInputStream(path); ObjectInputStream in = new ObjectInputStream(file)) {
                
                //deserialization
                obj = (T) in.readObject();
            }
            return obj;
        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex + "There was an error loading the object.");
            throw new IllegalArgumentException("Error");
        }          
    }    
    
    public void delete_file(String path){
        try{
            File file = new File(path);
            file.delete();
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();  
        }
    }
}
