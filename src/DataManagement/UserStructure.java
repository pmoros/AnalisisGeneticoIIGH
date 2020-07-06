/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import Business.EntityType;
import Business.ID;
import Business.User;
import DataStructures.AVLTree;
import DataStructures.CloseHashTable;
import DataStructures.DoubleHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pmoro
 */
public class UserStructure extends DBStructure{    
    public CloseHashTable<User> users;
    public String self_path;        
    
    public UserStructure(String path, String identifier){        
        this.self_path = path + "\\" + identifier;
        this.users = new CloseHashTable();       
    }        
    
    @Override
    public void add(Object obj) throws ClassNotFoundException {
        User my_user = (User) obj;  
            if(this.users.get(my_user) != null ) throw new ClassNotFoundException();
            this.users.add(my_user);
    }

    @Override
    public void remove(Object obj) throws ClassNotFoundException{
        User my_user = (User) obj;  
        if(this.users.get(my_user) == null ) throw new ClassNotFoundException();
        this.users.remove((User) obj);
    }

    @Override
    public void remove_based_on(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(Object obj) throws ClassNotFoundException {
        User my_user = (User) obj;
        return (User) this.users.get(my_user);        
    }

    @Override
    public Object[] matches(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void order() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void order(boolean reverse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String get_path() {
        return this.self_path;
    }

    @Override
    public String get_identifier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public void show_content(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int get_size() {
        return this.users.size();
    }
    
    @Override
    public User get_last(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] get_content() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return this.users.get_content();
    }
}
