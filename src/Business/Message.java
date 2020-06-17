/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author pmoro
 */
public class Message implements java.io.Serializable{
    public ID id_analysis;
    public ID id_administrator;
    public ID id_worker;
    public String content;
    public String topic;
    
    
    public Message(String topic, String content){
        this.content = content;
        this.topic = topic;
    }
    
    public String get(){        
        if((id_analysis != null)&&(id_worker != null)&&(id_administrator != null)){
            String admin_info = "Administrator id: %s\n".format(this.id_administrator.get());
            String worker_info = "Worker id: %s\n".format(this.id_worker.get());
            String analysis_info = "Analysis related id: %s\n\n".format(this.id_analysis.get());
            return (admin_info + worker_info + analysis_info + this.content);
        }
        else if((id_analysis != null)&&(id_administrator != null)){
            String admin_info = "Administrator id: %s\n".format(this.id_administrator.get());            
            String analysis_info = "Analysis related id: %s\n\n".format(this.id_analysis.get());
            return (admin_info +  analysis_info + this.content);
        }      
        else if((id_administrator != null)){
            String admin_info = "Administrator id: %s\n\n".format(this.id_administrator.get());            
            return (admin_info+ this.content);
        }        
        else{
            return this.content;
        }
    }
    
}
