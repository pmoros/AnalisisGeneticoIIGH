/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisgeneticoiigh;
import DataStructures.*;
/**
 *
 * @author pmoro
 */
public class HorseSpec extends EntitySpec implements java.io.Serializable{
    String name;
    int age;    
    String race;   
    String farm;
    DynamicArray<Entity> sons = new DynamicArray<>();
    
    public boolean matches(HorseSpec searched){
        if(!((this.name != null) &&(this.name.equals(searched.name)))){
            return false;
        }
        if(!((this.age == searched.age))){
            return false;
        }
        if(!((this.race != null) &&(this.race.equals(searched.race)))){
            return false;
        }
        if(!((this.race != null) &&(this.race.equals(searched.race)))){
            return false;
        }  
        return true;
    }    
}
