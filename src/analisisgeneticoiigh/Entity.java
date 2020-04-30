/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisgeneticoiigh;
import DataManagement.*;
/**
 *
 * @author pmoro
 */
public class Entity implements java.io.Serializable{
    public String id;
    public EntityType type;
    public EntitySpec specs;    
    Entity(EntitySpec properties){
        this.specs = properties;
    }
}
