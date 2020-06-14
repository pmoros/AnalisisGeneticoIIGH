package analisisgeneticoiigh;
import Business.AutorizationLevel;
import Business.Entity;
import Business.EntityType;
import Business.HorseSpec;
import Business.IDGenerator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
  
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {        
        //Aplication.reset();
        /*
        Aplication my_app =  new Aplication();                
        
        my_app.sign_up(AutorizationLevel.WORKER, "sito", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        my_app.login(AutorizationLevel.WORKER, "sito", "696wq");
        HorseSpec specs = new HorseSpec();
        specs.sex = "MACHO";
        
        Entity[] result = my_app.matches(EntityType.HORSE, specs);
        my_app.delete_by_specs(EntityType.HORSE, specs);
        result = my_app.matches(EntityType.HORSE, specs);  
                */
        
        //Test test = new Test(my_app);                              
        //test.horse_loading();
        //test.full_user_management(1);                       
        //my_app.save_changes();        
        System.out.println(IDGenerator.full());
    }
    
}
