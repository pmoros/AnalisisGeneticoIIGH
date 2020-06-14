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
    private Integer register = null;
    //DynamicArray<Entity> sons = new DynamicArray<>();
    private Integer register_father = null;
    //DynamicArray<Entity> sons = new DynamicArray<>();
    private Integer register_mother = null;
    //DynamicArray<Entity> sons = new DynamicArray<>();
    private String name = null;
    //DynamicArray<Entity> sons = new DynamicArray<>();
    private String birth_date = null;
    public String  color, sex, chip, genotype, step;        
    
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
    
    
    @Override
    public boolean equals(EntitySpec s){
            HorseSpec searched = (HorseSpec) s;
            if(((this.getRegister() != null) && !(this.register.equals(searched.register)))){
                return false;
            }
            if(((this.getName() != null) && !(this.name.equals(searched.name)))){
                return false;
            }
            if(((this.getBirth_date() != null) && !(this.birth_date.equals(searched.birth_date)))){
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
        System.out.println(Integer.toString(this.getRegister()) + "  " + this.getName());
    }
    
    @Override
        public Integer GetRegister(){
        return this.getRegister();
    }

    /**
     * @return the register
     */
    public Integer getRegister() {
        return register;
    }

    /**
     * @param register the register to set
     */
    public void setRegister(Integer register) {
        this.register = register;
    }

    /**
     * @return the register_father
     */
    public Integer getRegister_father() {
        return register_father;
    }

    /**
     * @param register_father the register_father to set
     */
    public void setRegister_father(Integer register_father) {
        this.register_father = register_father;
    }

    /**
     * @return the register_mother
     */
    public Integer getRegister_mother() {
        return register_mother;
    }

    /**
     * @param register_mother the register_mother to set
     */
    public void setRegister_mother(Integer register_mother) {
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
}
