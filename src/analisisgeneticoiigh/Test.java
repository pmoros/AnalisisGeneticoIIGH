/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisgeneticoiigh;
import Business.AutorizationLevel;
import Business.EntityType;
import Business.User;
import DataManagement.CSVLoader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
/**
 *
 * @author pmoro
 */
public class Test {
    long start_time, end_time;
    Aplication app;
    Random my_random;    
    
    public static int hashCode(String string) {
        final int PRIME = 31;
        return string != null ? string.hashCode() * PRIME : 0;  // PRIME = 31 or another prime number.
    }

    public Test(Aplication app){
        this.app = app;
        this.my_random = new Random();
    }
     
    public long sign_up(AutorizationLevel autolevel, String user_name,
                        String password, String first_name,String last_name, String email){
        
                //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime(); 
        
        this.app.sign_up(autolevel, user_name, password, first_name, last_name, email);
        
        //TIMER PAUSED
        this.end_time = (System.nanoTime() - this.start_time)/1000;
        System.out.printf("Time adding a single client: %d \n", end_time);  
        return this.end_time/1000;          
    }
    
    /**
     * Size is specified in thousands like this:
     *  5 -> 5000; 1000 -> 1000000+  
     * @param size
     * @param auto_level
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void sign_up_many(int size, AutorizationLevel auto_level) throws FileNotFoundException, IOException{   
            String pathToCsv = this.app.path + "\\data\\" + "Clients" + Integer.toString(size) + "k.csv";            
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime();                
            
            CSVLoader reader;            
                reader = new CSVLoader(pathToCsv, 5);
                String[] data;
                while((data = reader.read_line_unrestricted()) != null){                                        
                    
                        String user_name = data[0];
                        String password = data[1];
                        String name = data[2];
                        String last_name = data[3];
                        String email = data[4];
                            
                    this.app.sign_up(auto_level, user_name, password, last_name, last_name, email);
                }            
            
                
    //TIMER PAUSED
    this.end_time = (System.nanoTime() - this.start_time)/1000;
    System.out.printf("Time adding   " + Integer.toString(size*1000) + "   clients: %d \n", end_time);      
        
    }
    
    
    public void login_user(AutorizationLevel auto_level, String user_name, String password) throws ClassNotFoundException{  
        User test_user = new User(auto_level, user_name, password);
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime(); 
        
        this.app.login(test_user.getPrivileges(), user_name, password);
        
        //TIMER PAUSED
        this.end_time = (System.nanoTime() - this.start_time)/1000;
        System.out.printf("Time login single client: %d \n", end_time);          
    }
    
    public void delete_user(AutorizationLevel auto_level, String user_name, String password) throws ClassNotFoundException{        
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime(); 
        this.app.login(auto_level, user_name, password);        
        this.app.delete_account();
        
        //TIMER PAUSED
        this.end_time = (System.nanoTime() - this.start_time)/1000;
        System.out.printf("Time deleting single client: %d \n", end_time);         
    }
    
    private void load_horses() throws IOException, FileNotFoundException, ClassNotFoundException{
        String pathToCsv = this.app.path + "\\data\\" + "Horses" + "1" +"k.csv";                 
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime();     
        
        for(int i = 0; i < 1; i++){
            this.app.add_horses(pathToCsv);
        }
        
        //TIMER PAUSED
        this.end_time = (System.nanoTime() - this.start_time)/1000;
        System.out.printf("Time adding  " + Integer.toString(1*1000) + "  horses: %d \n", end_time);      
    }
    
    public void generate_mockup_users(int size) throws FileNotFoundException, IOException{
        String pathToCsv = this.app.path + "\\data\\" + "Clients" + ".csv";
        CSVLoader csv_loader = new CSVLoader(pathToCsv, 5);
        csv_loader.create_mockup(size);
    }
    
    public void full_user_management(int i) throws IOException, ClassNotFoundException{
        this.sign_up_many(i, AutorizationLevel.CLIENT);
        this.sign_up(AutorizationLevel.ADMIN, "sitovive", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        this.login_user(AutorizationLevel.ADMIN, "sitovive", "696wq");
        System.out.print("Retrieving user info...");
        System.out.println( " User: " + this.app.current_user.getFirst_name() + "    " + this.app.current_user.getLast_name() + "  " + this.app.current_user.getEmail());
        this.delete_user(AutorizationLevel.ADMIN, "sitovive", "696wq");
    }
    
    public void horse_loading() throws ClassNotFoundException, IOException{
        this.sign_up(AutorizationLevel.WORKER, "sito", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        this.login_user(AutorizationLevel.WORKER, "sito", "696wq");
        this.load_horses();
    }
    public void show_users(int i) throws IOException{
        this.sign_up_many(i, AutorizationLevel.CLIENT);
        this.app.show_content(EntityType.USER);        
    }
            
}
