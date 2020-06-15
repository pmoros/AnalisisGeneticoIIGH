/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalManagement;

import Business.Request;
import Business.RequestPriority;
import Business.User;
import DataManagement.DBPointer;
import DataManagement.FileStream;
import java.io.FileNotFoundException;

/**
 *
 * @author pmoro
 */
public class Listener {
    //private MessageManager message_manager;    
    private RequestManager request_manager;    
    //private AnalysisManager analysis_manager; //TEMPORAL, TOCA REVISAR ESTO
    private final String request_path;
    private final FileStream file_stream;
    private final DBPointer database;
    
    public Listener(DBPointer database){  
        this.database = database;        
        this.request_path = database.path + "\\" + "REQUEST_MANAGER";  
        this.file_stream = new FileStream();
        this.load_manager();
    }
    
    public void send_request(User sender, RequestPriority prior, String description) throws ClassNotFoundException{
        String user_name = sender.getUser_name();        
        Request my_request = new Request(user_name, prior, description);
        this.request_manager.send(sender, my_request);
        System.out.println("Sended request: " + Long.toString(my_request.id.get_value()));        
    }
    
    public void close_request(Long id){
        this.request_manager.close(id);
    }
    
    public void save_changes(){            
        this.file_stream.write_file(this.request_path, this.request_manager);
    }
    
    
    private void load_manager(){  
        try{
           this.request_manager = (RequestManager) this.file_stream.read_file(this.request_path);           
           if(this.request_manager == null){
               throw new FileNotFoundException();
           }                    
           this.request_manager.load_admins();
        }        
        catch(FileNotFoundException | NullPointerException | IllegalArgumentException e1){
            System.out.println(e1);
            System.out.println("Creating the new request manager...");            
            this.request_manager = new RequestManager(this.database);       
            this.request_manager.load_admins();
            //this.file_stream.write_file(this.database_path, this.database);
        }          
    }  
    
    public void reset(){        
        FileStream<String> aux_flux = new FileStream();
        aux_flux.delete_file(this.request_path);                
        this.load_manager();     
        this.file_stream.write_file(this.request_path, this.request_manager);        
        
    }            
    
}
