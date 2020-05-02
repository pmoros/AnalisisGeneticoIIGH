package analisisgeneticoiigh;
import Business.*;
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
    public static BDManager<BDArrayStructure> database;
    
    public static void create_database(){ 
        //Creates the database from cero
        BDManager<BDManager> iniciador = new BDManager<>();
        iniciador.add(EntityType.USER);
        iniciador.add(EntityType.ENTITY);
        iniciador.write_file(iniciador.path, iniciador);
    }
    
    public static void load_database(){
        //loads the database to the sistem
        BDManager<BDManager> iniciador = new BDManager<>();
        BDManager<BDArrayStructure> aux = iniciador.read_file(iniciador.self_path);
        AnalisisGeneticoIIGH.database = aux;
    }    
    
    public static void save_changes(){
        //It saves the changes in the data base
        BDManager<BDManager> iniciador = new BDManager<>();
        BDManager<BDArrayStructure> aux = iniciador.read_file(iniciador.self_path);        
    }
    
    public static void main(String[] args) {
/*PRUEBAS SIN GUARDADO EN LA BASE DE DATOS
    
    - Se crean dos estructuras de almacenamiento
      una almacena instancias de User y la otra
      almacena instancias de Entity (caballos,
      vacas...).
    
*/
    //Creacion de las tablas   
    BDArrayStructure<User> TABLA_USUARIOS = new BDArrayStructure<>(EntityType.USER, "AnalisisGeneticoIIGH", EntityType.ADMINISTRATOR.name());
    BDArrayStructure<Entity> TABLA_CABALLOS = new BDArrayStructure<>(EntityType.ENTITY, "AnalisisGeneticoIIGH", EntityType.ENTITY.name());

    //Creacion de usuarios de prueba
    UserSpec s1 = new UserSpec("B612", "matematico", "Paul", "Moros", "pmoros@unal.edu.co");    
    UserSpec s2 = new UserSpec("Sito", "matematico", "Leteliel", "Anacona", "sitovivemoros@gmail.com");
    User u1 = new User( AutorizationLevel.ADMIN, s1);    
    User u2 = new User(AutorizationLevel.ADMIN, s2);    
    //Creacion de caballos de prueba
    HorseSpec sc1 = new HorseSpec();
    sc1.name = "Ricardo";
    sc1.farm = "Napoles";    
    HorseSpec sc2 = new HorseSpec();
    sc2.name = "EatMyShorts";
    sc2.farm = "The Simpsons";
    HorseSpec sc3 = new HorseSpec();
    sc3.name = "Ay Caramba";
    sc3.farm = "The Simpsons";    
    Entity c1 = new Entity(sc1);
    Entity c2 = new Entity(sc2);    
    Entity c3 = new Entity(sc3);
    
    //PRUEBAS SOBRE USUARIOS
    
    TABLA_CABALLOS.add(c1);
    TABLA_CABALLOS.add(c2);
    TABLA_CABALLOS.add(c3);
    DynamicArray<Entity> usuarios = TABLA_CABALLOS.get_elements();
     
    //BUSCAMOS LOS CABALLOS DE THE SIMPSONS
    DynamicArray<Entity> BartHorses;
    HorseSpec pat = new HorseSpec();
    pat.farm = "The Simpsons"; 
    //pat.name = "Ay Caramba";
    
   
  
    TABLA_CABALLOS.remove_based_on(pat);
    TABLA_CABALLOS.show_horses();

    
    
    }
    
    
}
