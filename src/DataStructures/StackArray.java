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
public class StackArray<T> implements Stack<T> {
    
    private T[] arr;
    private int size;
    private int end;
    
    StackArray(int size){
        this.arr = (T[]) new Object[size];
        this.size = size;
        this.end = -1;
    }
    
    StackArray(){
        this.size = 10;
        this.arr = (T[]) new Object[this.size];
        this.end = -1;
    }    
    
    @Override
    public void push(T item) {
        if(!(this.end < this.size - 1)){
            T[] aux = (T[]) new Object[2*this.size];
            System.arraycopy(this.arr, 0, aux, 0, this.size);
            this.arr = aux;
            this.size = 2*this.size;
        }        
        this.end++;
        this.arr[this.end] = item;          
    }

    @Override
    public T pop() {
        if(this.end >= 0){
            T x = this.arr[this.end];
            this.end--;
            return x;
        }
        else{
            System.out.println("Empty Stack!");
            return null;
        }        
    }

    @Override
    public T top() {
        if(this.is_empty()) {
        } else {
            return this.arr[this.end];
        }
        System.out.println("Empty Stack!");
        return null;        
    }

    @Override
    public boolean is_empty() {
        return (!(this.end >= 0)); 
    }

    @Override
    public int get_size() {
        return this.size;
    }
    
    
}
