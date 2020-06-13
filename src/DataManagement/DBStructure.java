/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import DataStructures.List;

/**
 *
 * @author pmoro
 * @param <T>
 */
public abstract class DBStructure<T> implements java.io.Serializable{
    public DBStructureType current_type;    
    
    public abstract void add(T obj);    
    public abstract void remove(T obj);
    public abstract void remove_based_on(T obj);
    public abstract T find(T obj);
    public abstract T[] matches(T obj);
    public abstract void order();
    public abstract void order(boolean reverse);    
    public abstract String get_path();        
    public abstract String get_identifier();
    public abstract int get_size();
    //METODO DE PRUEBA
    public abstract Object[] get_content();
    public abstract void show_content();
    public abstract Object get_last();
    
}
