package analisisgeneticoiigh;
import Business.Entity;
import Business.EntityType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
  
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {        
        //Aplication.reset();
        Aplication my_app =  new Aplication();                
        Test test = new Test(my_app);                         
        test.horse_loading();       
        Entity finded_animal = my_app.find_animal(EntityType.HORSE, 297478);
        System.out.println("My animal is:");
        finded_animal.get_specs().show_attributes();        
        //test.full_user_management(100);                       
        //my_app.save_changes();
        // TODO code application logic here        
    }
    
}
