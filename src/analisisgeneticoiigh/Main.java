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
import DataStructures.DoublyLinkedList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
  
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {        
        //Aplication.reset();
        
        Aplication my_app =  new Aplication();                        
        
        
        
        //my_app.sign_up(AutorizationLevel.ADMIN, "sitovive", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        //my_app.sign_up(AutorizationLevel.CLIENT, "joker", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");        

        //Test test = new Test(my_app);                                      
        //test.horse_loading();
        //test.full_user_management(1);                       
        //my_app.save_changes();        

    }
    
}
