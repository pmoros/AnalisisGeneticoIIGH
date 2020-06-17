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
    public Long register = null;
    //DynamicArray<Entity> sons = new DynamicArray<>();
    public Long register_father = null;
    //DynamicArray<Entity> sons = new DynamicArray<>();
    public Long register_mother = null;
    //DynamicArray<Entity> sons = new DynamicArray<>();
    public String name = null;
    //DynamicArray<Entity> sons = new DynamicArray<>();
    public String birth_date = null;
    public String color;        
    public String sex;        
    public String chip;        
    public String genotype;        
    public String step;        
    
    public HorseSpec(){
        
    }
    
    public HorseSpec(Long register, String name, String birth_date, String color, String sex,
            String chip, String genotype, String step, Long father, Long mother){
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
    
    
    @Override
    public boolean equals(EntitySpec s){
            HorseSpec searched = (HorseSpec) s;
            if(((this.GetRegister() != null) && !(this.register.equals(searched.register)))){
                return false;
            }
            if(((this.getName() != null) && !(this.name.equals(searched.name)))){
                return false;
            }
            if(((this.getBirth_date() != null) && !(this.birth_date.equals(searched.birth_date)))){
                return false;
            } 
            if(((this.getColor() != null) && !(this.color.equals(searched.color)))){
                return false;
            } 
            if(((this.getSex() != null) && !(this.sex.equals(searched.sex)))){
                return false;
            }             
            if(((this.getChip() != null) && !(this.chip.equals(searched.chip)))){
                return false;
            }             
            if(((this.getGenotype() != null) && !(this.genotype.equals(searched.genotype)))){
                return false;
            } 
            if(((this.step != null) && !(this.step.equals(searched.step)))){
                return false;
            } 
            if(((this.getRegister_father() != null) && !(this.register_father.equals(searched.register_father)))){
                return false;
            }             
            if(((this.getRegister_mother() != null) && !(this.register_mother.equals(searched.register_mother)))){
                return false;
            }                         
            return true;
    }    
    
    @Override
    public void show_attributes(){
        System.out.println(Long.toString(this.GetRegister()) + "  " + this.getName());
    }
    
    @Override
        public Long GetRegister(){
        return this.getRegister();
    }

    /**
     * @return the register
     */

    /**
     * @param register the register to set
     */
    public void setRegister(Long register) {
        this.register = register;
    }

    /**
     * @return the register_father
     */
    public Long getRegister_father() {
        return register_father;
    }

    /**
     * @param register_father the register_father to set
     */
    public void setRegister_father(Long register_father) {
        this.register_father = register_father;
    }

    /**
     * @return the register_mother
     */
    public Long getRegister_mother() {
        return register_mother;
    }

    /**
     * @param register_mother the register_mother to set
     */
    public void setRegister_mother(Long register_mother) {
        this.register_mother = register_mother;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the birth_date
     */
    public String getBirth_date() {
        return birth_date;
    }

    /**
     * @return the register
     */
    public Long getRegister() {
        return register;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @return the chip
     */
    public String getChip() {
        return chip;
    }

    /**
     * @return the genotype
     */
    public String getGenotype() {
        return genotype;
    }
}
