/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalManagement;

import Business.AutorizationLevel;
import Business.User;
import DataManagement.DBPointer;
import DataManagement.DBStructureType;

/**
 *
 * @author pmoro
 */
public class UserManager {
    DBPointer database;
    
    public UserManager(DBPointer d){
        this.database = d;
        this.database.connect(DBStructureType.USER);        
    }
     
    
    /**
     * Adds and stores an user
     * @param autolevel autorization level
     * @param user_name
     * @param password
     * @param first_name
     * @param last_name
     * @param email
     * @throws java.lang.ClassNotFoundException
     */    
    public void sign_up(AutorizationLevel autolevel, String user_name,
                        String password, String first_name,String last_name, String email) throws ClassNotFoundException{                       
       
       this.database.connect(DBStructureType.USER);         
        
       User user = new User(autolevel, user_name, password, first_name, last_name, email);
       this.database.current.add(user);        
    }
    
    /**
     * Allows users to login into the system, loads a profile
     * @param auto_level The autorization level of the user
     * @param user_name
     * @param password
     * @throws ClassNotFoundException 
     */
    public User login(AutorizationLevel auto_level, String user_name, String password) throws ClassNotFoundException{           
        
        this.database.connect(DBStructureType.USER);        
        
        User usuario = new User(auto_level, user_name, password);
                    User aux = (User) this.database.current.find(usuario);
                    if ( aux != null){
                        if(usuario.getPassword().equals(aux.getPassword())) return aux;   
                        else{
                        throw  new Class­Not­Found­Exception("Invalid password");
                        } 
                    }
                    else{
                        throw  new Class­Not­Found­Exception("Not founded");
                    }                               
    }    
    
    
    
    /**
     * This method is used to delete the user's account once he has logged in
     * @param user 
     */    
    public void delete_account(User user){    
        this.database.connect(DBStructureType.USER);                
        
        this.database.current.remove(user);        
    }   
    
    /**
     * This method is the one that the admins will be using to delete accounts
     * @param auto_level
     * @param user_name 
     */
    public void delete_account(AutorizationLevel auto_level, String user_name){
        User my_user = new User(auto_level, user_name);
        this.database.connect(DBStructureType.USER);
        this.database.current.remove(my_user);    
    }
        
    
    /*
        THE NEXT METHODS ASSOCIATED TO CHANGING USER INFO WILL BE USED BY THE ADMINS
    */
    public void change_account_pass_mail(AutorizationLevel auto_level, String user_name, String password, String email){
        this.database.connect(DBStructureType.USER);
        User my_user = new User(auto_level, user_name);
        User aux_user = (User) this.database.current.find(my_user);
        aux_user.setPassword(password);
        aux_user.setEmail(email);                        
    }  
    
    public void change_account_pass(AutorizationLevel auto_level, String user_name, String value){
        this.database.connect(DBStructureType.USER);
        User my_user = new User(auto_level, user_name);
        User aux_user = (User) this.database.current.find(my_user);
        aux_user.setPassword(value);                             
    }     
    
    public void change_account_mail(AutorizationLevel auto_level, String user_name, String value){
        this.database.connect(DBStructureType.USER);
        User my_user = new User(auto_level, user_name);
        User aux_user = (User) this.database.current.find(my_user);
        aux_user.setEmail(value);
    }       
         
    
     
    
}
