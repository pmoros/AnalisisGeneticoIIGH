/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;
/**
 *
 * @author pmoro
 */
public class Database implements java.io.Serializable {    
    //CAMBIAR POR OTRA ESTRUCTURA EL STRUCTURES y HACERLO DINAMICO
    public String path; //Program folder path
    public String self_path;    //Database path 
    public String identifier;   //Unique identifier of database
    public FileStream<DBStructure> file_stream; //Output and input flux    
    public String[] structures; //The structures that store the information
    public DBStructure current;
    public DBStructureType current_type;
    
    public Database(String path, String identifier){
        this.path = path;
        this.identifier = identifier;        
        this.self_path = this.path + "\\" + this.identifier;
        this.file_stream = new FileStream<>();        
        this.structures = new String[10];
        this.current_type = null;
        this.create();
    }        
    
    public void connect(DBStructureType type){
        this.current_type = type;
        int index = type.get_value();
        String aux_path = this.structures[index];
        this.current = this.file_stream.read_file(aux_path);
        this.current_type = this.current.current_type;
    }    
    
    public void save_changes(){
        this.file_stream.write_file(this.current.get_path(), current);
    }
        
    public void create(){
        
                String aux_identifier;
                aux_identifier = "USER";
                UserStructure structure1 = new UserStructure(this.path, aux_identifier);
                this.structures[DBStructureType.USER.get_value()] = this.path + "\\" + aux_identifier;
                
                aux_identifier = "ENTITY";
                EntityStructure structure2 = new EntityStructure(this.path, aux_identifier);             
                this.structures[DBStructureType.ENTITY.get_value()] = this.path + "\\" + aux_identifier;
                
                                
                this.file_stream.write_file(structure1.get_path(), structure1);
                this.file_stream.write_file(structure2.get_path(), structure2);                
                
                //Special flux for database file type
                FileStream<Database> aux_stream;
                aux_stream = new FileStream<>();                
                aux_stream.write_file(this.self_path, this);
                
        } 
    
}
