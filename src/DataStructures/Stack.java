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
public interface Stack<T> {

    /**
     *
     * @param item
     */
    
    //Pushes an element into the stack
    public void push(T item);
    
    //Pops the first element in the stack  (deletes it)
    public T pop();
    
    //Returns the first element (Doesnt delete it)
    public T top();
    
    //Returns if it is empthy
    public boolean is_empty();
    
    //Returns the size (How many elements are in the Stack)
    public int get_size();
    
    
    
    
    
}
