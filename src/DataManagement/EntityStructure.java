/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import Business.ID;
import Business.Entity;
import DataStructures.AVLTree;
import DataStructures.DynamicArray;
import DataStructures.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pmoro
 */
public class EntityStructure extends DBStructure{
    public AVLTree<Entity> elements;
    public String self_path;
    
    public EntityStructure(String path, String identifier){
        this.self_path = path + "\\" + identifier;
        this.elements = new AVLTree();
    }    
    
    @Override
    public void add(Object obj) {
        try {
            this.elements.insert((Entity) obj);
        } catch (ClassNotFoundException ex) {
            Entity aux = (Entity) obj;
            System.out.println("This horse has already been added: ");
            aux.get_specs().show_attributes();
        }
    }

    @Override
    public void remove(Object obj) {
        this.elements.remove((Entity) obj);
    }

    @Override
    public void remove_based_on(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*
        Entity[] matched = this.elements.matches((Entity)obj);
        for (Entity matched1 : matched) {
            this.remove(matched1);
        }
                */
    }

    @Override
    public Object find(Object obj) {
        return this.elements.find((Entity) obj);
    }

    @Override
    public Object[] matches(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*
        return (Entity[]) this.elements.matches((Entity) obj);
               */
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity[] get_content() {
        return (Entity[]) this.elements.traverse_inOrder();
    }

    @Override
    public int get_size() {
        return this.elements.size;
    }

    @Override
    public Object get_last() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
