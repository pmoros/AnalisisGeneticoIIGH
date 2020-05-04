package analisisgeneticoiigh;
import Business.*;
import DataStructures.*;
import DataManagement.*;
import Business.*;
import java.io.FileNotFoundException;

public class Main {
  
    public static void main(String[] args) throws FileNotFoundException {
        
    //REINICIADOR DE LA BASE DE DATOS
    //Test.reset();

    //Cargamos 1k registros  USUARIOS  (ESTO ES VARIABLE)
    
    /*
    Test test = new Test(EntityType.USER);  
    System.out.println(test.add_clients(10));
    test.save_changes();    //Guardado permanente
    */
    
    //Cargamos 1k registros  CABALLOS   (ESTO ES VARIABLE)
    
    /*
    Test test = new Test(EntityType.HORSE);  
    System.out.println(test.add_horses(10));
    test.save_changes();    //Guardado permanente
    */
    
    //Buscamos un caballo especifico por ID
    
    /*
    Test test = new Test(EntityType.HORSE);
    test.find_horse(EntityType.HORSE, 40);
    */ 
    
       
    //Buscamos un usuario especifico por ID
    
    /*            
    Test test = new Test(EntityType.USER);
    test.find_user(EntityType.USER, 998);
    */
        
    //Buscamos todos los caballos de una raza y granja
    
    
    Test test = new Test(EntityType.HORSE);
    HorseSpec specs = new HorseSpec();
    specs.race = "Cuban";
    specs.farm = "Sundance";
    test.find_horse_by_specs(specs); 
    
             
    }
    
}
