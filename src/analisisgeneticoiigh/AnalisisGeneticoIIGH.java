/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisgeneticoiigh;
import DataStructures.*;
import DataManagement.*;
import Business.*;
/**
 *
 * @author pmoro
 */
public class AnalisisGeneticoIIGH {

    /**
     * @param args
     */
    public static BDManager<BDStructure> database;
    
    public static void create_database(){ 
        BDManager<BDManager> iniciador = new BDManager<>();
        iniciador.add(EntityType.USER);
        iniciador.add(EntityType.ENTITY);
        iniciador.write_file(iniciador.path, iniciador);
    }
    
    public static void load_database(){
        BDManager<BDManager> iniciador = new BDManager<>();
        BDManager<BDStructure> aux = iniciador.read_file(iniciador.path2);
        AnalisisGeneticoIIGH.database = aux;
    }    
    
    public static void save_alter_database(){
        BDManager<BDManager> iniciador = new BDManager<>();
        BDManager<BDStructure> aux = iniciador.read_file(iniciador.path2);        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here         
        //PRUEBAS     
        
        
        //create_database();
        //load_database();
        //database.load(EntityType.USER);
        
        
        /* HAY UN FALLO CON LA CARGA DE LOS DATOS DESDE AFUERA       
        */
        
        
        //PRUEBAS
        
        BDStructure BD = new BDStructure("", "");
        
        Client user1 = new Client("sito","Paul","Moros");
        BD.add_user(user1);
        Client user2 = new Client("acid","Santi","Diaz");
        BD.add_user(user2);
        BD.show_users();        
        DynamicArray<User> usuarios  = BD.get_users();
        
        for(int i = 0; i < usuarios.pointer; i++){
        User aux = usuarios.get(i);
        System.out.print(aux.name + " " + aux.last_name);
        System.out.println();
        }
                
    }
    
}
