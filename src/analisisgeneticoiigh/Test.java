/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisgeneticoiigh;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Business.*;
import DataManagement.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rock
 */
public class Test {
    
    public long start_time, end_time;
    ReadData read;
    public BDPointer database_pointer = new BDPointer();    
    public BDManager<BDArrayStructure> database;            
    Test(EntityType tipo){
        this.database = database_pointer.database;    
        read = new ReadData();
        this.database.load(tipo);
    }
    
    public void save_changes(){
        this.database.save_changes();
    }
    
    public void add_client(String user_name, String password, String name, String last_name, String  email){        
        UserSpec spec1 = new UserSpec(user_name, password, name, last_name, email);
        User user1 = new User(AutorizationLevel.CLIENT,spec1);
        this.database.current.add(user1);        
    }

    public void add_horse(String name, int age, String race, String farm){        
        HorseSpec spec1 = new HorseSpec(name, age, race, farm);
        Entity user1 = new Entity(EntityType.HORSE,spec1);
        this.database.current.add(user1);        
    }    
    
    public long test_add_clients(int size) throws FileNotFoundException{
        //Size is specified in thousands like this:
        // 5 -> 5000; 1000 -> 1000000
        String pathToCsv = this.database.path + "\\data\\" + "Clients" + Integer.toString(size) +"k.csv";
        String row;
        this.start_time = System.nanoTime(); 
        File csvFile = new File(pathToCsv);
        if (csvFile.isFile()) {
            try ( // create BufferedReader and read data from csv
                    BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv))) {
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");
                    // ESTE CODIGO TOMA LO QUE ESTÁ EN CADA LINEA DEL ARCHIVO Y AGREGA UN CLLIENTE
                    String user_name = data[0];
                    String password = data[1];
                    String name = data[2];
                    String last_name = data[3];
                    String email = data[4];
                    this.add_client(user_name, password, name, last_name, email);        
                }
            } catch (IOException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
  
    this.end_time = System.nanoTime() - this.start_time;
    return this.end_time/1000000;          
        
    }
    
    public long test_add_horses(int size) throws FileNotFoundException{
        //Size is specified in thousands like this:
        // 5 -> 5000; 1000 -> 1000000
        String pathToCsv = this.database.path + "\\data\\" + "Horses" + Integer.toString(size) +"k.csv";
        String row;
        this.start_time = System.nanoTime(); 
        File csvFile = new File(pathToCsv);
        if (csvFile.isFile()) {
            try ( // create BufferedReader and read data from csv
                    BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv))) {
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");
                    // ESTE CODIGO TOMA LO QUE ESTÁ EN CADA LINEA DEL ARCHIVO Y AGREGA UN CLLIENTE
                    String name = data[0];
                    int age = 0;
                     try{
                        age = Integer.parseInt(data[1]);
                    } catch(NumberFormatException ex){ // handle your exception
                        System.out.println(ex);
                    }
                    String race = data[2];
                    String farm = data[3];                    
                    this.add_horse(name, age, race, farm);        
                }
            } catch (IOException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
  
    this.end_time = System.nanoTime() - this.start_time;
    return this.end_time/1000000;          
        
    }    
    
}
