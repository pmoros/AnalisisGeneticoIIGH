package analisisgeneticoiigh;
import Business.AutorizationLevel;
import Business.Entity;
import Business.EntityType;
import Business.HorseSpec;
import Business.ID;
import Business.IDGenerator;
import Business.Request;
import Business.RequestPriority;
import Business.User;
import DataStructures.BinTree;
import DataStructures.DoubleHashSet;
import DataStructures.DoublyLinkedList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
  
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {                
        Aplication.reset();
        
        Aplication my_app =  new Aplication();                                

        Test test = new Test(my_app);                                                      
        //test.full_user_management(10);
        test.full_horse_management(1);
        //test.full_analysis_manager();
        //test.full_request_management(1000);                 
        //my_app.save_changes();               
    }
    
}
