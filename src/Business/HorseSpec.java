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
    //DynamicArray<Entity> sons = new DynamicArray<>();
    public Integer register, register_father, register_mother;
    public String name, birth_date, color, sex, chip, genotype, step;    
    public HorseSpec(){
        
    }
    
    public HorseSpec(int register, String name, String birth_date, String color, String sex,
            String chip, String genotype, String step, int father, int mother){
        this.register = register;
        this.name = name;
        this.birth_date = birth_date;
        this.color = color;
        this.sex = sex;
        this.chip = chip;
        this.genotype = genotype;
        this.step = step;
        this.register_father = father;
        this.register_mother = mother;
    }    
    
    
    public boolean equals(HorseSpec searched){
            if(((this.register != null) && !(this.register.equals(searched.register)))){
                return false;
            }
            if(((this.name != null) && !(this.name.equals(searched.name)))){
                return false;
            }
            if(((this.birth_date != null) && !(this.birth_date.equals(searched.birth_date)))){
                return false;
            } 
            if(((this.color != null) && !(this.color.equals(searched.color)))){
                return false;
            } 
            if(((this.sex != null) && !(this.sex.equals(searched.sex)))){
                return false;
            }             
            if(((this.chip != null) && !(this.chip.equals(searched.chip)))){
                return false;
            }             
            if(((this.genotype != null) && !(this.genotype.equals(searched.genotype)))){
                return false;
            } 
            if(((this.step != null) && !(this.step.equals(searched.step)))){
                return false;
            } 
            if(((this.register_father != null) && !(this.register_father.equals(searched.register_father)))){
                return false;
            }             
            if(((this.register_mother != null) && !(this.register_mother.equals(searched.register_mother)))){
                return false;
            }                         
            return true;
    }    
    
    @Override
    public void show_attributes(){
        System.out.println(Integer.toString(this.register) + "  " + this.name);
    }
    
    @Override
        public Integer GetRegister(){
        return this.register;
    }
}
