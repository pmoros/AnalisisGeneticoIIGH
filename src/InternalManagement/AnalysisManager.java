/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalManagement;

import Business.Analysis;
import Business.Entity;
import Business.EntityType;
import Business.HorseSpec;
import Business.ID;
import Business.User;
import DataManagement.DBPointer;
import DataManagement.Database;
import DataManagement.FileStream;
import DataStructures.AVLTree;
import java.io.FileNotFoundException;

/**
 *
 * @author pmoro
 */
public class AnalysisManager {
    private FileStream<AVLTree> file_stream;
    public GeneticManager genetic_manager;
    public AVLTree<Analysis> content;
    public Analysis current;
    public String path;
    
    public AnalysisManager( DBPointer database){
        this.path = database.path + "\\" + "ANALYSIS_MANAGER";  
        this.file_stream = new FileStream();
        this.genetic_manager = new GeneticManager(database);
        //LOADING CONTENT
        this.load_manager();
    }
    
    public ID create_analysis(User client, User[] workers, String description) throws ClassNotFoundException{
        ID result_id;
        Analysis my_analysis = new Analysis(client, workers, description);
        result_id = my_analysis.id;
        this.content.insert(my_analysis);
        return result_id;
    }
    
    public void delete_analysis(Long id){
        ID aux = new ID(id);
        Analysis my_aux = new Analysis(aux);
        this.content.remove(my_aux);
    }
    
    public void load_analysis(Long id){        
        ID aux = new ID(id);
        Analysis my_aux = new Analysis(aux);
        this.current = this.content.find(my_aux);
    }
    
    public void add_entity(EntityType type, Long register){
        Entity aux = this.genetic_manager.find_animal(type, register);
        this.current.add_entity(aux);
    }    
    
    public void remove_entity(EntityType type, Long register){
        Entity aux = this.genetic_manager.find_animal(type, register);
        this.current.delete_entity(aux);
    }    
    
    public void add_many_entity(EntityType type, HorseSpec specs){
        Entity[] aux = this.genetic_manager.matches(type, specs);
        this.current.add_many_entity(aux);
    }
    
    public void remove_many_entity(EntityType type, HorseSpec specs){
        Entity[] aux = this.genetic_manager.matches(type, specs);
        this.current.delete_by_specs(aux);
    }
    
    public void add_worker(User wor){
        this.current.add_worker(wor);
    }    
    
    public void delete_worker(User wor){
        this.current.delete_worker(wor);
    }    
    
    
    private void load_manager(){  
        try{
           this.content = (AVLTree) this.file_stream.read_file(this.path);
           if(this.content == null){
               throw new FileNotFoundException();
           }                    
        }        
        catch(FileNotFoundException | NullPointerException | IllegalArgumentException e1){
            System.out.println(e1);
            System.out.println("Creating the new Analysis manager...");            
            this.content = new AVLTree<>();          
            //this.file_stream.write_file(this.database_path, this.database);
        }          
    }        
    
    public void save_changes(){
        this.current.save();
        this.file_stream.write_file(this.path, this.content);
    }
    
    public void reset(){        
        FileStream<String> aux_flux = new FileStream();
        aux_flux.delete_file(this.path);                
        this.load_manager();     
        this.file_stream.write_file(this.path, this.content);        
    }        
    
}
