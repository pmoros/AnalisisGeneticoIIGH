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
public interface Queue<T> extends java.io.Serializable {
    
    //Adds an element to the queue
    public void enqueue(T item);
    
    //Takes out the last element of the queue
    public T dequeue();
    
    //Shows the last element of the queue (keeps it in the queue)
    public T front();
    
    
    //Verifies if it is empty or not
    public boolean is_empty();
    
    //returns the size of queue (how many elements are there)
    public int get_size();
    
    
}
