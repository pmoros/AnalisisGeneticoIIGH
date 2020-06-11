package analisisgeneticoiigh;
import Business.AutorizationLevel;
import Business.EntityType;
import DataManagement.DBStructureType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
  
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {        
        //Aplication.reset();
        Aplication my_app =  new Aplication();                                                            
        Test test = new Test(my_app);
        test.full_user_management(10);               
        //my_app.save_changes();                    
        
    }
    
}
