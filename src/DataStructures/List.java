/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author pmoro
 * @param <T>
 */
public interface List<T> {
    
    //Metodo de prueba 
    public void show_content();
    
    //Adds an element at last position
    public void append(T element);
    
    //Adds an element at front
    public void push_front(T element);
    
    //Insert an element at a required position 
    public void insert(int index, T element);
    
    //Returns an element at a required position
    public T get(int index);
    
    //Returns the index of an element
    public int find(T element);
    
    //Elimina un elemento de una lista
    public void delete(T element);
    
    //Elimina un elemento en una poscion
    public void delete_at(int index);
    
}
