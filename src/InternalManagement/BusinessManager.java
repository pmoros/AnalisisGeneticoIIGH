/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InternalManagement;

import Business.AutorizationLevel;
import Business.ID;
import Business.User;
import DataManagement.DBPointer;
import DataManagement.DBStructureType;

/**
 *
 * @author pmoro
 */
public class BusinessManager {
    
    AnalysisManager analysis_manager;
    DBPointer database;
    
    public BusinessManager(AnalysisManager analysis_manager, DBPointer database){
        this.analysis_manager = analysis_manager;
        this.database = database;    
    }
    
    public ID create_analysis(String username_client, String[] usernames_employees, String description) throws ClassNotFoundException{
        User my_client = new User(AutorizationLevel.CLIENT, username_client);
        User[] employees = new User[usernames_employees.length];
        for(int i = 0; i < usernames_employees.length; i++){
            employees[i] = new User(AutorizationLevel.WORKER, usernames_employees[i]);
        }
        return this.analysis_manager.create_analysis(my_client, employees, description);
    }
    
    public void delete_analysis(Long id){        
        this.analysis_manager.delete_analysis(id);
    }
    
    public void add_employee(Long id_analysis, String user_employee) throws ClassNotFoundException{
        this.database.connect(DBStructureType.USER);
        User aux = new User(AutorizationLevel.WORKER, user_employee);
        User employee = (User) this.database.current.find(aux);
        this.analysis_manager.load_analysis(id_analysis);
        this.analysis_manager.add_worker(employee);        
    }
    
    public void delete_employee(Long id_analysis, String user_employee) throws ClassNotFoundException{
        this.database.connect(DBStructureType.USER);
        User aux = new User(AutorizationLevel.WORKER, user_employee);
        User employee = (User) this.database.current.find(aux);
        this.analysis_manager.load_analysis(id_analysis);
        this.analysis_manager.delete_worker(employee);        
    }    
    
    public void save_changes(){    
        this.analysis_manager.save_changes();
    }
    
}
