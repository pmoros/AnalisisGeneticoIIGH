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

    }
    
}
