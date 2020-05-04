/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import Business.Entity;
import Business.EntityType;
import Business.HorseSpec;
import Business.ID;
import DataStructures.DynamicArray;


/**
 *
 * @author pmoro
 */
public class BDPointer  extends BDStructure{
    
    public BDManager<BDStructure> database;        
    public BDStructure current;
            
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
        BDManager<BDStructure> aux = iniciador.read_file(iniciador.self_path);
        this.database = aux;
    }    
    
    public void save_changes(){
        //It saves the changes in the data base
        BDManager<BDManager> iniciador = new BDManager<>();
        BDManager<BDStructure> aux = iniciador.read_file(iniciador.self_path);        
    }    

    //METODOS DIRECTOS A LA TABLA
    public void connect(EntityType t){
        this.database.load(t);
        this.current = this.database.current;
    }

    public void save(){
        this.database.save_changes();
    }

    @Override
    public ID add(Entity obj) {
        return this.current.add(obj);
    }

    @Override
    public boolean verify_type(Entity obj) {
        return this.current.verify_type(obj);
    }

    @Override
    public void remove(ID id) {
        this.current.remove(id);
    }

    @Override
    public void remove_based_on(HorseSpec specs) {
        this.current.remove_based_on(specs);
    }

    @Override
    public Entity find(ID id) {
        return this.current.find(id);
    }

    @Override
    public DynamicArray match(HorseSpec searched) {
        return this.current.match(searched);
    }

    @Override
    public void order_entities() {
        this.current.order_entities();
    }

    @Override
    public DynamicArray get_elements() {
        return this.current.get_elements();
    }

    @Override
    public String get_path() {
        return this.current.get_path();
    }

    @Override
    public int get_index() {
        return this.current.get_index();
    }

    @Override
    public EntityType get_type() {
        return this.current.get_type();
    }

    @Override
    public String get_identifier() {
        return this.current.get_identifier();
    }
    

    
}
