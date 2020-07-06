/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisgeneticoiigh;
import Business.*;
import DataManagement.*;
import InternalManagement.AnalysisManager;
import InternalManagement.BusinessManager;
import InternalManagement.GeneticManager;
import InternalManagement.Listener;
import InternalManagement.RequestManager;
import InternalManagement.UserManager;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author pmoro
 */
public class Aplication {  
    //Modify later to make all attributes static
    public String path;
    private DBPointer database;   
    private UserManager user_manager;
    private GeneticManager genetic_manager;
    public AnalysisManager analisis_manager;
    public  BusinessManager business_manager;    
    public Listener listener; //Revisar si puede ser static
    private DBStructureType last;
    public Request current_request;
    
    public User current_user;       
    
    public Aplication(){        
        this.database = new DBPointer("DATABASE");
        //ACA IRIAN LOS OBJETOS DE LAS CLASES DE CADA VISTA COMO AdminPanel
        //CADA UNO SE CONSTRUYE CON EL DBPointer
        this.user_manager = new UserManager(this.database);
        this.genetic_manager = new GeneticManager(this.database);
        this.analisis_manager = new AnalysisManager(this.database);         
        this.listener = new Listener(this.database);
        
        this.business_manager = new BusinessManager(this.analisis_manager, this.database);                
        this.path = this.database.path;
    }
    
    
//######- FUNCIONES DE CONTROL DE CUENTAS-#############    
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
        try{       
        this.user_manager.sign_up(autolevel, user_name, password, first_name, last_name, email);
        }
        catch(ClassNotFoundException e){
            System.out.println("The user has already been added.");
        }            
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
        this.last = DBStructureType.USER;       
    }  
    
    public User find_user(AutorizationLevel auto_level, String user_name) throws ClassNotFoundException{   
        return this.user_manager.find_user(auto_level, user_name);        
    }        
    
    
    /**
     * This allows the users to delete their accounts
     * when we call this method, we logout, so we got
     * to handle it in the interface.
     */
    public void delete_account() throws ClassNotFoundException{        
        this.user_manager.delete_account(this.current_user);
        this.current_user = null;        
        this.last = DBStructureType.USER;       
    }           
    
    /**
     * This allows the admin to delete an account without login
     * @param auto_level
     * @param user_name 
     */
    public void delete_account(AutorizationLevel auto_level, String user_name) throws ClassNotFoundException{
        if(this.current_user.getPrivileges().compareTo(AutorizationLevel.ADMIN) < 0) return;
        this.user_manager.delete_account(auto_level, user_name);                
    }
    
    /**
     * This allows the admin to change user's info without login
     * @param auto_level
     * @param user_name
     * @param password
     * @param email 
     */
    public void change_account_info(AutorizationLevel auto_level, String user_name, String password, String email) throws ClassNotFoundException{
        if(this.current_user.getPrivileges().compareTo(AutorizationLevel.ADMIN) < 0) return;        
        if(!"".equals(password)&& !"".equals(email)){
            this.user_manager.change_account_pass_mail(auto_level, user_name, password, email);
        }
        else if(!"".equals(password)){
            this.user_manager.change_account_pass(auto_level, user_name, password);
        }
        else if(!"".equals(email)){
            this.user_manager.change_account_mail(auto_level, user_name, email);
        }          
    }     
    
    
//#######-FUNCIONES DE GENETICA-#########
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
    public void add_horse(Long register, String name, String birth_date, String color, String sex,
            String chip, String genotype, String step, Long father, Long mother) throws ClassNotFoundException{    
                if(this.current_user.getPrivileges().compareTo(AutorizationLevel.WORKER) < 0){
            System.out.println();
            throw new ClassNotFoundException("Not allowed here!");
        } 
            this.genetic_manager.add_horse(register, name, birth_date, color, sex, chip, genotype, step, father, mother);            
    }
    
    /**
     * Loads many horses from a csv file.
     * @param path
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void add_horses(String path) throws FileNotFoundException, IOException, ClassNotFoundException{  
        if(this.current_user.getPrivileges().compareTo(AutorizationLevel.WORKER) < 0){
            System.out.println();
            throw new ClassNotFoundException("Not allowed here!");
        } 
        this.genetic_manager.add_horses(path);        
    }
    
    
    /**
     * Finds an animal based in the register
     * @param type
     * @param register
     * @return 
     * @throws java.lang.ClassNotFoundException 
     */
    public Entity find_animal(EntityType type, Long register) throws ClassNotFoundException{
        if(this.current_user.getPrivileges().compareTo(AutorizationLevel.WORKER) < 0){
            System.out.println();
            throw new ClassNotFoundException("Not allowed here!");
        } 
        return this.genetic_manager.find_animal(type, register);                
    }
      
    public Entity[] matches(EntityType type, EntitySpec specs) throws ClassNotFoundException{
                if(this.current_user.getPrivileges().compareTo(AutorizationLevel.WORKER) < 0){
            System.out.println();
            throw new ClassNotFoundException("Not allowed here!");
        } 
        return this.genetic_manager.matches(type, specs);
    }    
    
    public void delete_animal(EntityType type, Long register) throws ClassNotFoundException{
        if(this.current_user.getPrivileges().compareTo(AutorizationLevel.WORKER) < 0){
            System.out.println();
            throw new ClassNotFoundException("Not allowed here!");
        } 
        this.genetic_manager.delete_animal(type, register);        
    }    
    
    public void delete_by_specs(EntityType type, EntitySpec specs) throws ClassNotFoundException{
                if(this.current_user.getPrivileges().compareTo(AutorizationLevel.WORKER) < 0){
            System.out.println();
            throw new ClassNotFoundException("Not allowed here!");
        } 
                
        this.genetic_manager.delete_by_specs(type, specs);        
    }    
    
    public Entity[] get_all_animals() throws ClassNotFoundException{
                if(this.current_user.getPrivileges().compareTo(AutorizationLevel.WORKER) < 0){
            System.out.println();
            throw new ClassNotFoundException("Not allowed here!");
        }                 
        return this.genetic_manager.get_all_animals();
    }    

        public void generate_family_tree(Long register) throws ClassNotFoundException{
            System.out.println("The generations before horse " + Long.toString(register) + " are:");
            this.genetic_manager.generate_family_tree(register);
        }  
//##################-FUNCIONES DE MANEJO DE ANALISIS-###################
    public Long create_analysis(String username_client, String[] usernames_employees, String description) throws ClassNotFoundException{
        ID aux = this.business_manager.create_analysis(username_client, usernames_employees, description);        
        Long val = aux.get_value();
        this.current_user.analyses.append(aux);
        System.out.println("Added analysis: " + val);        
        return val;
    }
    
    public void delete_analysis(Long id){        
        this.business_manager.delete_analysis(id);        
        this.current_user.analyses.delete(new ID(id));
    }    
    
    public void add_employee(Long id_analysis, String user_employee) throws ClassNotFoundException{
        this.business_manager.add_employee(id_analysis, user_employee);
    }    
    
    public void delete_employee(Long id_analysis, String user_employee) throws ClassNotFoundException{
        this.business_manager.delete_employee(id_analysis, user_employee);
    } 
    
//###################-FUNCIONES ASOCIADAS CON LAS PETICIONES-###########
    
    public void send_request(RequestPriority priority, String description) throws ClassNotFoundException{
        this.listener.send_request(this.current_user, priority, description);
    }
    
    public void load_request(){
        this.current_user.requests.top_front();
        this.current_request = this.current_user.requests.top_front();
    }
    
    public void close_request() throws ClassNotFoundException{
        this.listener.close_request(this.current_request);
    }
    
//###################-FUNCIONES INTERNAS DE LOS ANALISIS-###############  
    
    public void load_analysis(Long id){        
        this.analisis_manager.load_analysis(id);
    }    
    
    public void add_entity(EntityType type, Long register) throws ClassNotFoundException{
        this.analisis_manager.add_entity(type, register);
    }  
    
    public void remove_entity(EntityType type, Long register) throws ClassNotFoundException{
        this.analisis_manager.remove_entity(type, register);
    }
    
    public void add_many_entity(EntityType type, HorseSpec specs) throws ClassNotFoundException{
        this.analisis_manager.add_many_entity(type, specs);
    }    
    
    public void remove_many_entity(EntityType type, HorseSpec specs) throws ClassNotFoundException{
        this.analisis_manager.remove_many_entity(type, specs);
    }    
    
    
    
//###################-FUNCIONES PROPIAS DE LA APLICACIÓN-################
    
    //METODO DE PRUEBA
    public User[] get_content() {
        return this.user_manager.get_content();
    }
    
    public void show_content(EntityType type){
        this.database.show_content(type);
    } 
    
    public User get_test_user(){
        this.database.connect(DBStructureType.USER);        
        return (User) this.database.current.get_last();
    }    

    //APLICATION CONTROLLERS
    
    public void save_changes(){
        this.database.save_changes();
        this.listener.save_changes();
        this.analisis_manager.save_changes();
    }
    
    public static void reset(){
        DBPointer my_del = new DBPointer("DATABASE");
        AnalysisManager anl = new AnalysisManager(my_del);
        anl.reset();
        my_del.reset();        
        Listener my_lis = new Listener(my_del);
        my_lis.reset();        
    }
    
    
}
