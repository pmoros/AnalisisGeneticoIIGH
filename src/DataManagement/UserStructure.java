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
import DataStructures.DynamicArray;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pmoro
 */
public class UserStructure extends DBStructure{    
    public AVLTree<User> users;
    public String self_path;        
    
    public UserStructure(String path, String identifier){        
        this.self_path = path + "\\" + identifier;
        this.users = new AVLTree();       
    }        
    
    @Override
    public void add(Object obj) {
        User my_user = (User) obj;             
        try {        
            this.users.insert(my_user);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserStructure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(Object obj) {
        this.users.remove((User) obj);
    }

    @Override
    public void remove_based_on(Object obj) {
        //this.users.           //ADD THIS TO THE AVL
    }

    @Override
    public Object find(Object obj) {
        User my_user = (User) obj;
        return (User) this.users.find(my_user);        
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
        return this.users.size;
    }
    
    @Override
    public User get_last(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] get_content() {
        return this.users.traverse_inOrder();
    }
}
