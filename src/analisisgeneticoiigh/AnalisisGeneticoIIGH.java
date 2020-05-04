package analisisgeneticoiigh;
import Business.*;
import DataStructures.*;
import DataManagement.*;
import Business.*;
import java.io.FileNotFoundException;
/**
 *
 * @author pmoro
 */

public class AnalisisGeneticoIIGH {

    /**
     * @param args
     */    
	
	public static void main(String[] args) throws FileNotFoundException {
		//Creamos el puntero que sirve para manipular el manejador de la base
//		BDPointer BD_POINTER = new BDPointer();         
//		BD_POINTER.connect(EntityType.HORSE);
		
		//BUSCAMOS UN CABALLO
//		ID aux = new ID(EntityType.HORSE, 987);
//		Entity horse = BD_POINTER.current.find(aux);
//		HorseSpec info = (HorseSpec) horse.get_specs();
//		System.out.println(info.name);
		
		Test test = new Test(EntityType.HORSE);
		test.database.current.show_horses();
	}
	
}
