/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import Business.EntityType;
import analisisgeneticoiigh.AnalisisGeneticoIIGH;

/**
 *
 * @author pmoro
 */
public class BDPointer {
    
    public BDManager<BDArrayStructure> database;        
    public BDArrayStructure current;
            
    public BDPointer(){
        this.load_database();
    }
    
    public void create_database(){ 
        //Creates the database from cero
        BDManager<BDManager> iniciador = new BDManager<>();
        iniciador.add(EntityType.USER);
        iniciador.add(EntityType.HORSE);
        iniciador.write_file(iniciador.self_path, iniciador);
    }
    public void load_database(){
        //Revisar para que retorne la base con su tipo BDManager<BDStructure>
        //Asi puede cargar varias bases de datos
        //loads the database to the sistem
        BDManager<BDManager> iniciador = new BDManager<>();
        BDManager<BDArrayStructure> aux = iniciador.read_file(iniciador.self_path);
        this.database = aux;
    }    
    
    public void save_changes(){
        //It saves the changes in the data base
        BDManager<BDManager> iniciador = new BDManager<>();
        BDManager<BDArrayStructure> aux = iniciador.read_file(iniciador.self_path);        
    }    

    //METODOS DIRECTOS A LA TABLA
    public void connect(EntityType t){
        this.database.load(t);
        this.current = this.database.current;
    }

    public void save(){
        this.database.save_changes();
    }
    

    
}
