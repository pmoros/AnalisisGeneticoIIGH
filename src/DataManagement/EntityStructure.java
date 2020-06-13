/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import Business.ID;
import Business.Entity;
import DataStructures.DynamicArray;
import DataStructures.List;
/**
 *
 * @author pmoro
 */
public class EntityStructure extends DBStructure{
    public DynamicArray<Entity> elements;
    public String self_path;
    
    public EntityStructure(String path, String identifier){
        this.self_path = path + "\\" + identifier;
        this.elements = new DynamicArray();
    }    
    
    @Override
    public void add(Object obj) {
        this.elements.append( (Entity) obj);
    }

    @Override
    public void remove(Object obj) {
        this.elements.delete((Entity) obj);
    }

    @Override
    public void remove_based_on(Object obj) {
        Entity[] matched = this.elements.matches((Entity)obj);
        for (Entity matched1 : matched) {
            this.remove(matched1);
        }
    }

    @Override
    public Object find(Object obj) {
        return this.elements.find((Entity) obj);
    }

    @Override
    public Object[] matches(Object obj) {
        return (Entity[]) this.elements.matches((Entity) obj);
    }

    @Override
    public void order() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void order(boolean reverse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String get_path() {
        return this.self_path;
    }

    @Override
    public String get_identifier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //METODO DE PRUEBA
    @Override
    public void show_content() {
        for(int i = 0; i <= this.elements.get_size(); i++){
            System.out.println(this.elements.get(i).type);
            this.elements.get(i).get_specs().show_attributes();
        }
    }

    @Override
    public Entity[] get_content() {
        return (Entity[]) this.elements.get_content();
    }

    @Override
    public int get_size() {
        return this.elements.get_size();
    }

    @Override
    public Object get_last() {
        return this.elements.get(this.elements.get_size());
    }

}
