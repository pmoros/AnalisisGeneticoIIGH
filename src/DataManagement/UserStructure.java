/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import Business.EntityType;
import Business.ID;
import Business.User;
import DataStructures.DynamicArray;
/**
 *
 * @author pmoro
 */
public class UserStructure extends DBStructure{    
    public DynamicArray<User> users;
    public String self_path;        
    
    public UserStructure(String path, String identifier){        
        this.self_path = path + "\\" + identifier;
        this.users = new DynamicArray();        
    }        
    
    @Override
    public void add(Object obj) {
        User my_user = (User) obj;        
        if(this.users.contains(my_user)){
            System.out.println("The user" + my_user.getUser_name() +" has already been created.");
            return;
        }        
        this.users.append(my_user);        
    }

    @Override
    public void remove(Object obj) {
        this.users.delete((User)obj);
    }

    @Override
    public void remove_based_on(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(Object obj) {
        User my_user = (User) obj;
        return (User) this.users.find(my_user);        
    }

    @Override
    public Object matches(Object obj) {
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
    
    
    //METODOS DE PRUEBA   
    @Override
    public DynamicArray get_content(){
        return this.users;
    }
    
    @Override
    public void show_content(){
        for(int i = 0; i < this.users.get_size(); i++){
            System.out.println(this.users.get(i).getUser_name()+ "        "  + this.users.get(i).getPassword());
        }
    }

    @Override
    public int get_size() {
        return this.users.get_size();
    }
    
    @Override
    public User get_last(){
        return (User) this.users.get(this.users.get_size());
    }
}
