/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisgeneticoiigh;
import Business.*;
import DataManagement.*;
import InternalManagement.GeneticManager;
import InternalManagement.UserManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pmoro
 */
public class Aplication {  
    //Modify later to make all attributes static
    public String path;
    private DBPointer database;
    //public static final Listener listener;
    private UserManager user_manager;
    private GeneticManager genetic_manager;
    
    
    public User current_user;       
    
    public Aplication(){        
        this.database = new DBPointer("DATABASE");
        //ACA IRIAN LOS OBJETOS DE LAS CLASES DE CADA VISTA COMO AdminPanel
        //CADA UNO SE CONSTRUYE CON EL DBPointer
        this.user_manager = new UserManager(this.database);
        this.genetic_manager = new GeneticManager(this.database);
        this.path = this.database.path;
    }
    
    
    
    /**
     * Adds and stores an user
     * @param autolevel autorization level
     * @param user_name
     * @param password
     * @param first_name
     * @param last_name
     * @param email
     */
    public void sign_up(AutorizationLevel autolevel, String user_name,
                        String password, String first_name,String last_name, String email){
                
        this.user_manager.sign_up(autolevel, user_name, password, first_name, last_name, email);
    }  
    
    /**
     * Allows users to login into the system, loads a profile
     * @param auto_level The autorization level of the user
     * @param user_name
     * @param password
     * @throws ClassNotFoundException 
     */
    public void login(AutorizationLevel auto_level, String user_name, String password) throws ClassNotFoundException{   
        this.current_user = this.user_manager.login(auto_level, user_name, password);
    }
    
    
    /**
     * This allows the users to delete their accounts
     * when we call this method, we logout, so we got
     * to handle it in the interface.
     */
    public void delete_account(){        
        this.user_manager.delete_account(this.current_user);
        this.current_user = null;
    }           
    
    /**
     * Adds a single horse to the system.
     * @param register
     * @param name
     * @param birth_date
     * @param color
     * @param sex
     * @param chip
     * @param genotype
     * @param step
     * @param father
     * @param mother 
     */
    public void add_horse(int register, String name, String birth_date, String color, String sex,
            String chip, String genotype, String step, int father, int mother){
            
            this.genetic_manager.add_horse(register, name, birth_date, color, sex, chip, genotype, step, father, mother);
    }
    
    /**
     * Loads many horses from a csv file.
     * @param path
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void add_horses(String path) throws FileNotFoundException, IOException{
        this.genetic_manager.add_horses(path);
    }
    
    
    public void save_changes(){
        this.database.save_changes();
    }
    
    public static void reset(){
        DBPointer my_del = new DBPointer("DATABASE");
        my_del.reset();
    }
    
    
    //#########################################################################
    //METODO DE PRUEBA
    public void show_content(EntityType type){
        this.database.show_content(type);
    } 
    
    public User get_test_user(){
        this.database.connect(DBStructureType.USER);        
        return (User) this.database.current.get_last();
    }    
}
