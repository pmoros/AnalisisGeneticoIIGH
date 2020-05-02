/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Business.EntitySpec;
import Business.Entity;
import DataStructures.*;
/**
 *
 * @author pmoro
 */
public class HorseSpec extends EntitySpec implements java.io.Serializable{
    public String name;
    public int age;    
    public String race;   
    public String farm;
    DynamicArray<Entity> sons = new DynamicArray<>();
    
    public HorseSpec(){
        
    }
    
    public HorseSpec(String name, int age, String race, String farm){
        this.name = name;
        this.age = age;
        this.race = race;
        this.farm = farm;
    }    
    
    
    public boolean matches(HorseSpec searched){
            if(((this.name != null) && !(this.name.equals(searched.name)))){
                return false;
            }
            if(!((this.age == searched.age))){
                return false;
            }
            if(((this.race != null) && !(this.race.equals(searched.race)))){
                return false;
            }
            if(((this.farm != null) && !(this.farm.equals(searched.farm)))){
                return false;
            }  
            return true;
    }    
}
