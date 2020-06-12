package analisisgeneticoiigh;
import Business.AutorizationLevel;
import Business.EntityType;
import DataManagement.DBStructureType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DataStructures.AVLTree;
import java.util.Arrays;
public class Main {
  
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {        
        //Aplication.reset();
        Aplication my_app =  new Aplication();  
        //Test test = new Test(my_app);
        //test.full_user_management(10);       
        Integer[] my_integers = {1,2,3,4,5, 7};
        AVLTree my_avl = new AVLTree();
        for(Integer i: my_integers){
            my_avl.insert(i);
        }        
        System.out.println(Arrays.toString(my_avl.traverse_inOrder()));                        
    }
    
}
