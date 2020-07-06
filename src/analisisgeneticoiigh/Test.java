/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisgeneticoiigh;
import Business.AutorizationLevel;
import Business.Entity;
import Business.EntityType;
import Business.HorseSpec;
import Business.RequestPriority;
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
                //AUXILIAR
                //int auxiliar = 1;
                while((data = reader.read_line_unrestricted()) != null){                                        
                    
                        String user_name = data[0];
                        String password = data[1];
                        String name = data[2];
                        String last_name = data[3];
                        String email = data[4];                    
                        //Prueba
                        //if(auxiliar > 45){
//                            System.out.println();
  //                      }
                        //auxiliar++;
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
    
    private Long load_horses(int size) throws IOException, FileNotFoundException, ClassNotFoundException{                
        this.login_user(AutorizationLevel.WORKER, "sito", "696wq");
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime();     
        
        //REALISTIC DATA BLOCK
        /*
        String pathToCsv = this.app.path + "\\data\\" + "Horses" + "1" +"k.csv";                 
            this.app.add_horses(pathToCsv);        
        pathToCsv = this.app.path + "\\data\\" + "Horses" + "2" +"k.csv";                 
           this.app.add_horses(pathToCsv);                    
        pathToCsv = this.app.path + "\\data\\" + "Horses" + "3" +"k.csv";                 
           this.app.add_horses(pathToCsv);                               
        pathToCsv = this.app.path + "\\data\\" + "Horses" + "4" +"k.csv";                 
           this.app.add_horses(pathToCsv);                                          
        */
        //TEST DATA BLOCKS
        
        String pathToCsv = this.app.path + "\\data\\" + "Horses" + Integer.toString(size) +"k.csv";                 
            this.app.add_horses(pathToCsv);         
        
        //TIMER PAUSED
        this.end_time = (System.nanoTime() - this.start_time)/1000;
        System.out.printf("Time adding  " + Integer.toString(size*1000) + "  horses: %d \n", end_time);      
        return this.end_time;
    }
    
    public void generate_mockup_users(int size) throws FileNotFoundException, IOException{
        String pathToCsv = this.app.path + "\\data\\" + "Clients" + ".csv";
        CSVLoader csv_loader = new CSVLoader(pathToCsv, 5);
        csv_loader.create_mockup(size);
    }
    
    public void generate_mockup_horses(int size) throws FileNotFoundException, IOException{
        String pathToCsv = this.app.path + "\\data\\" + "Horses" + ".csv";
        CSVLoader csv_loader = new CSVLoader(pathToCsv, 9);
        csv_loader.mockup_horses(size);
    }    
    
    public void full_user_management(int i) throws IOException, ClassNotFoundException{
        this.sign_up_many(i, AutorizationLevel.CLIENT);
        this.sign_up(AutorizationLevel.ADMIN, "sitovive", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        this.login_user(AutorizationLevel.ADMIN, "sitovive", "696wq");
        System.out.print("Retrieving user info...");
        System.out.println( " User: " + this.app.current_user.getFirst_name() + "    " + this.app.current_user.getLast_name() + "  " + this.app.current_user.getEmail());
        this.delete_user(AutorizationLevel.ADMIN, "sitovive", "696wq");
    }
    
    public void horse_loading(int size) throws ClassNotFoundException, IOException{
        this.sign_up(AutorizationLevel.WORKER, "sito", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        this.login_user(AutorizationLevel.WORKER, "sito", "696wq");
        this.load_horses(size);
    }
    
    
    public Long find_horse_by_id() throws ClassNotFoundException{
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime();     
        
        Entity find_animal = this.app.find_animal(EntityType.USER, 3750440L);
        find_animal.get_specs().show_attributes();
        
        //TIMER PAUSED
        this.end_time = (System.nanoTime() - this.start_time)/1000;
        System.out.printf("Time finding a horse by id: %d \n", end_time);            
        return this.end_time;
    }
    //ZAINO
    
    public Long find_horse_by_specs() throws ClassNotFoundException{
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime(); 
        
        HorseSpec spec = new HorseSpec();
        spec.color = "ZAINO";
        Entity[] matches = this.app.matches(EntityType.HORSE, spec);
        for(int i = 0; i < matches.length - 1; i++){
            matches[i].get_specs().show_attributes();
        }
        //TIMER PAUSED
        this.end_time = (System.nanoTime() - this.start_time)/1000;                
        return this.end_time;
    }
    
    public Long delete_horse_by_specs() throws ClassNotFoundException{
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime(); 
        
        HorseSpec spec = new HorseSpec();
        spec.color = "CASTAÑO";
        spec.sex = "HEMBRA";        
        this.app.delete_by_specs(EntityType.HORSE, spec);
        //TIMER PAUSED
        this.end_time = (System.nanoTime() - this.start_time)/1000;                
        return this.end_time;
    }    
    
    public Long generate_family_tree() throws ClassNotFoundException{
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime();     
        
        this.app.add_horse(55L, "H", "H", "H", "H", "H", "H", "H", null, null);
        this.app.add_horse(33L, "H", "H", "H", "H", "H", "H", "H", 55L, 14873L);        
        this.app.add_horse(22L, "H", "H", "H", "H", "H", "H", "H", 33L, 14873L);
        this.app.add_horse(11L, "H", "H", "H", "H", "H", "H", "H", 22L, 14873L);
        this.app.generate_family_tree(11L);
        
        //TIMER PAUSED
        this.end_time = (System.nanoTime() - this.start_time)/1000;
        System.out.printf("Time finding grand father: %d \n", end_time);            
        return this.end_time;
    }
    
    public void full_horse_management(int size) throws ClassNotFoundException, IOException{
        this.sign_up(AutorizationLevel.WORKER, "sito", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        this.login_user(AutorizationLevel.WORKER, "sito", "696wq");
        Long x1, x2 , x3, x4, x5;
        x1 = this.load_horses(size);
        System.out.printf("Time loading horses: %d \n", x1);                   
        x2 = this.find_horse_by_id();
        x3 = this.find_horse_by_specs();           
        x5 = this.delete_horse_by_specs();           
        x4 = this.generate_family_tree();
        System.out.print("\033[H\033[2J");
        System.out.flush();        
        System.out.printf("Time finding horse by id: %d \n", x2);           
        System.out.printf("Time finding horse with ZAINO hair (by specs): %d \n", x3);                   
        System.out.printf("Time deleting horses with CASTAÑO hair and HEMBRA(by specs): %d \n", x5);                   
    }
    
    
    
    public void full_analysis_manager() throws ClassNotFoundException{
        
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime();     
        
        for(int i = 0; i < 1000; i++){
            String a = "admin";
            String c = "client";
            String w = "Worker";
            a+= Integer.toString(i);
            c+= Integer.toString(i);
            w+= Integer.toString(i);
        this.app.sign_up(AutorizationLevel.ADMIN, a, "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        this.app.sign_up(AutorizationLevel.CLIENT, c, "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        this.app.sign_up(AutorizationLevel.WORKER, w, "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        }
        this.login_user(AutorizationLevel.ADMIN, "admin1", "696wq");        
        String[] names = {"worker1", "worker989"};
        Long val;
        for(int i = 0; i < 980; i++) val = this.app.create_analysis("client1", names, "Test analysis");
        val = this.app.create_analysis("client1", names, "Test analysis");
        this.app.load_analysis(val);
         System.out.println("ANALYSIS INFORMATION:");
         System.out.println("Added by:" + this.app.analisis_manager.current.client.getUser_name());
         System.out.println("Analysis #:" + Long.toString(this.app.analisis_manager.current.id.get_value()));
        System.out.println(this.app.analisis_manager.current.description);
        
        //TIMER PAUSED
        this.end_time = (System.nanoTime() - this.start_time)/1000;
        System.out.printf("Time adding 1000 analysis: %d \n", end_time);        
        
        this.app.add_horse(44L, "H", "H", "H", "H", "H", "H", "H", 43L, 14873L);
        
        
               
        //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime(); 
        
        
        this.app.add_entity(EntityType.HORSE, 44L);
        
        //TIMER PAUSED        
        this.end_time = (System.nanoTime() - this.start_time)/1000;        
        System.out.printf("Time adding a horse to an analysis: %d \n", end_time);                    
        
    }
    
    
    public void full_request_management(int size) throws ClassNotFoundException{
        
        for(int i = 0; i < 1000; i++){
            String a = "admin";
            String c = "client";
            String w = "Worker";
            a+= Integer.toString(i);
            c+= Integer.toString(i);
            w+= Integer.toString(i);
        this.app.sign_up(AutorizationLevel.ADMIN, a, "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        if(i < 100) this.app.sign_up(AutorizationLevel.CLIENT, c, "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        this.app.sign_up(AutorizationLevel.WORKER, w, "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        }
        
        this.app.login(AutorizationLevel.CLIENT, "admin0", "696wq");
                //TIMER STARTED
        this.start_time = 0;
        this.end_time = 0;       
        this.start_time = System.nanoTime(); 
        
        for(int i = 0; i < size*1000; i++){
            this.app.send_request(RequestPriority.COMMON, "My test request");
        }
        
        //TIMER PAUSED        
        this.end_time = (System.nanoTime() - this.start_time)/1000;        
        System.out.printf("Time sending " + Integer.toString(size*1000 )+ " request and  distributing them among 100  using a PQ: %d \n", end_time);         
    }
    
    
    public void show_users(int i) throws IOException{
        this.sign_up_many(i, AutorizationLevel.CLIENT);
        this.app.show_content(EntityType.USER);        
    }
            
}
