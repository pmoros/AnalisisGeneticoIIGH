/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;
import java.io.Serializable;
/**
 *
 * @author pmoro
 * @param <T>
 */
public abstract class BDManager<T> implements Serializable {
    public static String path = System.getProperty("user.dir");   
    
    public void read_file(){
        
    }
        
    public void write_file(String path, T obj){
        
    
    }
}
