package analisisgeneticoiigh;
import Business.AutorizationLevel;
import Business.Entity;
import Business.EntityType;
import Business.HorseSpec;
import Business.ID;
import Business.IDGenerator;
import Business.User;
import DataStructures.DoublyLinkedList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
  
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {        
        //Aplication.reset();
        
        Aplication my_app =  new Aplication();                
        
        
        //my_app.sign_up(AutorizationLevel.WORKER, "sito", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        my_app.login(AutorizationLevel.WORKER, "sito", "696wq");
        //String[] workers = {"sito"};
        
        //ID id = my_app.business_manager.create_analysis("sito", workers, "Analisis de prueba 2");
        //System.out.println(id.get_value());
        
        my_app.analisis_manager.load_analysis(14607935L);         
        my_app.analisis_manager.add_entity(EntityType.HORSE, 62517L);            
        
        Object[] temp_horses = my_app.analisis_manager.current.data.get_content();
        for(int i = 0; i < temp_horses.length; i++){            
            Entity aux = (Entity) temp_horses[i];
            aux.get_specs().show_attributes();
        }        
                       
        
        //Test test = new Test(my_app);                                      
        //test.horse_loading();
        //test.full_user_management(1);                       
        //my_app.save_changes();        

    }
    
}
