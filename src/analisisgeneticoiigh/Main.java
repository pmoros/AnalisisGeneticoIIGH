package analisisgeneticoiigh;
import Business.AutorizationLevel;
import Business.Entity;
import Business.EntityType;
import Business.HorseSpec;
import Business.ID;
import Business.IDGenerator;
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
        
        my_app.login(AutorizationLevel.CLIENT, "sito", "696wq");
        //System.out.println(my_app.current_user.getUser_name());
        for(int i = 0; i < 30; i++) my_app.listener.send_request(my_app.current_user, RequestPriority.COMMON, "I need my animals in my analysis.");                         
        my_app.login(AutorizationLevel.ADMIN, "acid", "696wq");        
        my_app.login(AutorizationLevel.CLIENT, "sito", "696wq");
        my_app.listener.send_request(my_app.current_user, RequestPriority.COMMON, "I need my animals in my analysis.");                         
             
        
        //Test test = new Test(my_app);                                      
        //test.horse_loading();
        //test.full_user_management(1);                       
        //my_app.save_changes();        

    }
    
}
