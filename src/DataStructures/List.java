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
public interface List<T> extends java.io.Serializable{
    
    //Metodo de prueba 
    public void show_content();
    
    //Adds an element at last position
    public void append(T element);
    
    //Adds an element at the start
    public void push_front(T element);
       
    
    //Insert an element at a required position 
    public void insert(int index, T element);
    
    //Returns an element at a required position
    public T get(int index);    
    
    //Returns if the list contains an element
    public boolean contains(T element);
    
    //Returns an element by key
    public T find(T element);
        
    //Returns an array with elements
    public T[] matches(T element);
    
    //Deletes an element from the list
    public void delete(T element);
    
    //Deletes an element at last position
    public void pop();    
    
    //Returns how may elements are there
    public int get_size();
    
    //Returns the capacity of the list
    public int get_length();
}
