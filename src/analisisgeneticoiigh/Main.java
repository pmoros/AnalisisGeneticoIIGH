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
import Interfaz.Bienvenida;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
  
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {                
        
        /*
        PARA EJECUTAR EL CODIGO QUITAR LOS COMENTARIOS Y HACER EJECUCIONES EN EL ORDEN
        ESTABLECIDO, ES DECIR QUITAR EL COMENTARIO DEL BLOQUE DE CODIGO 0, LUEGO
        COMENTARLO DE NUEVO Y EJECUTAR EL SIGUIENTE BLOQUE DE CODIGO HASTA HABER EJECUTADO
        TODOS, CUANDO ESTO SE COMPLETE, SE PUEDE EJECUTAR LA INTERFAZ CON NORMALIDAD
        CUANTAS VECES SE DESEE SIN EJECUTAR ESTOS PASOS.
        */
        
        //REINICIAR APP 0
        //Aplication.reset();    
        
        
        //CARGAR DATA DE USUARIOS 1
        /*
        Aplication my_app =  new Aplication();                                       
        Test test = new Test(my_app);                                                               
        test.full_user_management(1);
        test.sign_up(AutorizationLevel.ADMIN, "sitovive", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");
        test.sign_up(AutorizationLevel.WORKER, "horseman", "696wq", "Jupiter", "Olivela", "kkk@gmail.com");                      
        my_app.save_changes();               
        */
        
        //Cargar los caballos 2
        
        /*
        Aplication my_app =  new Aplication();   
        Test test = new Test(my_app);                                                               
        test.full_horse_management(1);
        my_app.save_changes();  
        */
        
        //CODIGO INTERFAZ 3
        
        Bienvenida frame = new Bienvenida();
        frame.setVisible(true);
                
    }
    
}
