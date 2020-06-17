/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import Business.EntityType;
import Business.User;
import java.io.FileNotFoundException;

/**
 *
 * @author pmoro
 */
public class DBPointer implements java.io.Serializable {
    public final String path;       
    private final String database_path;
    private final String database_identifier;     
    private final FileStream<Database> file_stream;
    public Database database;
    public DBStructure current;
            
    public DBPointer(String identifier){        
        this.database_identifier = identifier;
        this.path = System.getProperty("user.dir");                
        this.database_path = this.path + "\\" + this.database_identifier;    
        this.file_stream = new FileStream();
        this.load_database(this.database_identifier);      
    }
    
    /**
     * Loads a table in the database, but it takes care that we don't need to
     * load the table again if we will perfom another operation that uses the
     * same table.
     * @param my_type
     */
    public void connect(DBStructureType my_type){
        if(this.database.current_type == null){
            this.database.connect(my_type);
            this.current = this.database.current;
            this.database.current_type = my_type;
        }
        else if(!this.database.current_type.equals(my_type)){
            this.database.connect(my_type);
            this.current = this.database.current;
            this.database.current_type = my_type;
        }
    }
    
    /**
     * Saves the changes that we had made in a table.
     */
    public void save_changes(){
        this.database.save_changes();
        this.database.current = null;
        this.database.current_type = null;
        this.file_stream.write_file(this.database.self_path, this.database);
    }    

    
    /**
     * Deletes all the information in all the tables of
     * our database.
     */
    public void reset(){        
        FileStream<String> aux_flux = new FileStream();
        aux_flux.delete_file(this.database_path);                
        this.load_database(this.database_identifier);        
        this.file_stream.write_file(this.database_path, this.database);        
    }    
    
    /**
     * Loads the database, it allows to access al the tables that we have got.
     * @param database_identifier 
     */    
    private void load_database(String database_identifier){  
        try{
           this.database = (Database) this.file_stream.read_file(this.database_path);
           if(this.database == null){
               throw new FileNotFoundException();
           }
           else if(!this.database.path.equals(this.path)){
               throw new FileNotFoundException();
           }                      
        }        
        catch(FileNotFoundException | NullPointerException | IllegalArgumentException e1){
            System.out.println(e1);
            System.out.println("Creating the new database...");            
            this.database = new Database(this.path, database_identifier);            
            //this.file_stream.write_file(this.database_path, this.database);
        }          
    }    
    
    //METODO DE PRUEBA
    public void show_content(EntityType type){
        if(type.equals(EntityType.USER)){
        this.connect(DBStructureType.USER);        
        }
        else if (type.equals(EntityType.ENTITY)){
            this.connect(DBStructureType.ENTITY);
        }
        this.database.current.show_content();
    }  
        
    public User get_test_user(){
        this.connect(DBStructureType.USER);        
        return (User) this.database.current.get_last();
    }
    
}
