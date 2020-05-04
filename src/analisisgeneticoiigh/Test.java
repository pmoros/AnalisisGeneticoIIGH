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
import Business.*;
import DataManagement.*;
import DataStructures.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rock
 */
public class Test {
    
    public long start_time, end_time;    
    public BDPointer BD_POINTER = new BDPointer();  
    
    
    Test(EntityType tipo){
        this.BD_POINTER.load_database(); //Carga la base de datos
        
        start_time = System.nanoTime();        
        
        this.BD_POINTER.connect(tipo); //Conecta una tabla
        
        end_time = (System.nanoTime() - start_time)/1000000;
        System.out.printf("Time loading files: %d \n",end_time);           
    }    
    
    public static void reset(){
        BDPointer BD_POINTER = new BDPointer();  //Puntero de la base de datos
        BD_POINTER.create_database();        //Crea la base de datos de cero    
    }    
    
    public void save_changes(){
        this.BD_POINTER.save();
    }
    
    public void add_client(String user_name, String password, String name, String last_name, String  email){        
        UserSpec spec1 = new UserSpec(user_name, password, name, last_name, email);
        User user1 = new User(AutorizationLevel.CLIENT,spec1);
        this.BD_POINTER.add(user1);        
    }

    public void add_horse(String name, int age, String race, String farm){        
        HorseSpec spec1 = new HorseSpec(name, age, race, farm);
        Entity user1 = new Entity(EntityType.HORSE,spec1);
        this.BD_POINTER.add(user1);        
    }    
    
    public long add_clients(int size) throws FileNotFoundException{
        //Size is specified in thousands like this:
        // 5 -> 5000; 1000 -> 1000000+    
        this.start_time = System.nanoTime(); 
        //for(int i = 0; i < size; i++){ 
            String pathToCsv = this.BD_POINTER.database.get_path() + "\\data\\" + "Clients" + "1" +"k.csv";
            String row;            
            File csvFile = new File(pathToCsv);            
            if (csvFile.isFile()) {
                for(int i = 0; i < size; i++){
                try ( // create BufferedReader and read data from csv
                        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv))) {
                    while ((row = csvReader.readLine()) != null) {
                        String[] data = row.split(",");
                        // ESTE CODIGO TOMA LO QUE ESTÃ� EN CADA LINEA DEL ARCHIVO Y AGREGA UN CLIENTE
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
    }
    this.end_time = (System.nanoTime() - this.start_time)/1000000;
    System.out.printf("Time adding clients: %d \n", end_time);  
    return this.end_time/1000000;          
        
    }
    
    public long add_horses(int size) throws FileNotFoundException{
        //Size is specified in thousands like this:
        // 5 -> 5000; 1000 -> 1000000
        this.start_time = System.nanoTime();
        for(int i = 0; i < size; i++){
            String pathToCsv = this.BD_POINTER.database.get_path() + "\\data\\" + "Horses" + "1" +"k.csv";
            String row;             
            File csvFile = new File(pathToCsv);
            if (csvFile.isFile()) {
                try ( // create BufferedReader and read data from csv
                        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv))) {
                    while ((row = csvReader.readLine()) != null) {
                        String[] data = row.split(",");
                        // ESTE CODIGO TOMA LO QUE ESTÃ� EN CADA LINEA DEL ARCHIVO Y AGREGA UN CLLIENTE
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
    }
    this.end_time = (System.nanoTime() - this.start_time)/1000000;
    System.out.printf("Time adding horses: %d \n", end_time);  
    return this.end_time/1000000;          
        
    }    
    
    public Entity find_user(EntityType type, int num){
        start_time = System.nanoTime();  
        
        ID aux = new ID(type, num);    
        Entity user = BD_POINTER.find(aux); 
        UserSpec info = (UserSpec) user.get_specs();
        System.out.printf("%s: %15s%15s%s\n", user.id.get(), info.user_name, info.first_name, info.last_name);        
                
        end_time = (System.nanoTime() - start_time)/1000000;
        System.out.printf("Time finding user by ID: %d \n",end_time);  
        
        return user;
    } 
    
    public Entity find_horse(EntityType type, int num){
        start_time = System.nanoTime();  
        
        ID aux = new ID(type, num);    
        Entity horse = BD_POINTER.find(aux); 
        HorseSpec info = (HorseSpec) horse.get_specs();
        System.out.printf("%s: %15s%15s%s\n", horse.id.get(), info.name, info.race, info.farm);        
                
        end_time = (System.nanoTime() - start_time)/1000000;
        System.out.printf("Time finding horse by ID: %d \n",end_time);  
        
        return horse;
    }
        
    
    public DynamicArray<Entity> find_horse_by_specs(HorseSpec searched){
        start_time = System.nanoTime();
        
        DynamicArray<Entity> horses = new DynamicArray<>();                
        horses = BD_POINTER.match(searched);  
        
        end_time = (System.nanoTime() - start_time)/1000000;
        System.out.printf("Time finding horse by Specs: %d \n",end_time);  
                
        //Este bucle quita mucho tiempo, por ahora lo comentamos
        //No cuenta al tiempo de ejecuciÃ³n.
            for(int i = 0; i < horses.pointer; i++){
                Entity auxiliar = (Entity) horses.get(i);
                HorseSpec caracteristicas = (HorseSpec) auxiliar.get_specs();
                System.out.printf("%s: %15s%15s%15s\n", auxiliar.id.get(), caracteristicas.name, caracteristicas.race, caracteristicas.farm);
            }
            
        return horses;
    }
    
}
