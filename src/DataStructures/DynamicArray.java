/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Business.Entity;

/**
 *
 * @author pmoro
 * @param <T>
 */
public class DynamicArray<T> implements List<T>{
    T []array;
    private int length = 10;
    private int size = 0;
    
    public DynamicArray(){
        this.array = (T[]) new Object[this.length];                                
    }
    
    public DynamicArray(int length){
        this.array = (T[]) new Object[length];                        
        this.length = length;
    }    
    //TEST METHOD
    @Override
    public void show_content(){
        //Gotta implement it
        for(int i = 0; i < this.size; i++){
            System.out.println(this.array[i].getClass());
        }
    }    
    //FINISHED TEST METHOD
    
    /**
     * Doubles the size of the array
     */
    public void resize(){
        int aux = this.length;
        this.length*=2;
        T[] array2 = (T[]) new Object[this.length];
        System.arraycopy(this.array, 0, array2, 0, aux);        
        this.array = array2;        
    }
    
    /**
     * Returns an element that is stored at a position
     * in case that the index is out of range, returns
     * null
     * @param index position in the array 
     * @return element T that is at the required position
     */
    @Override
    public T get(int index){
        if (index <= this.get_length()){
            return this.array[index];
        }
        else{
            System.out.println("Index out of range");
            return null;
        }
    }
    
    /**
     * Adds an element to the last position in the array
     * @param data whatever we want to store 
     */
    @Override
    public void append(T data){
        if (this.size > (this.length - 1)) this.resize();
        this.array[this.size] = data;        
        this.size++;
    }
    
    /**
     * Stores data at required position, it deletes 
     * what was there before.
     * @param index Position where we will store
     * @param data Data we wanna store
     */
    @Override
    public void insert(int index, T data){
        if (index >= this.size){
            if(index >= this.length){
                System.out.println("Index out of range");
                return;
            }
            this.append(data);            
        }
        this.array[index] = data;
    }
    
    /**
     * We pass an element to check if it is contained in the array
     * this will search in the array by using the compare_to
     * @param element element we are looking for
     * @return true if it is in the array false the other way
     */
    @Override
    public boolean contains(T element) {
        for(int i = 0; i < this.size; i++){
            T aux = this.array[i];
            if(element.equals(aux)){
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * this will go through the whole list checking
     * if it is in this, by using the compareTo, this
     * compare to method uses an unique identifier,
     * if the element is not in the list, then it
     * returns a null.
     * @param element the one we are looking for
     * @return returns the element
     */
    @Override
    public T find(T element){        
        for(int i = 0; i < this.size; i++){
            T aux = this.array[i];
            if(element.equals(aux)){
                return aux;
            }
        }
        return null;
    }
    
    /**
     * This search for an element and when it
     * finds an element, it returns the index.
     * @param element
     * @return 
     */    
    public int find_index(T element) {
        for(int i = 0; i < this.size; i++){
            T aux = this.array[i];
            if(element.equals(aux)){
                return i;
            }
        }
        return -1;
    }
            
    /**
     * Deletes an element and moves all the elements that are
     * next to the element 1 step backward to fill the list.
     * This delete works by using the unique identifier.
     * @param data The element we want to delete.
     */   
    @Override
    public void delete(T data){
        for(int i = 0; i < this.size; i++){
            T element = this.array[i];
            if(data.equals(element)){
                for(int j = i; j < (this.size - 1); j++){
                    this.array[j] = this.array[j + 1];
                }
                this.size--;
                break;
            }
        }
    }
    
    /**
     * Takes an index and deletes the element in that
     * position.
     * @param index 
     */
    public void delete_at(int index){
        if(index < this.length){
            for(int i = index; i < (this.size - 1); i++){
                this.array[i] = this.array[i + 1];
            }            
            this.size--;
        }
        else{
            System.out.println("Index out of range");
        }
    }    

    
    /**
     * Adds an element at the beginning of the array
     * and pushes all the other one position
     * @param element 
     */
    @Override
    public void push_front(T element) {
        if (this.size < (this.length - 1)){
            for(int i = 0; i < (this.size - 1); i++){
                this.array[i + 1] = this.array[i];
            }
            this.array[0] = element;
            this.size++;
        }
        else{
            System.out.println("Index out of range");
        }        
    }

    /**
     * Deletes the element at the last position
     */
    @Override
    public void pop() {        
        this.size--;
    }    
    
    /**
     * The size if how many elements are in the list
     * @return size
     */
    @Override
    public int get_size() {
        return this.size - 1;
    }
    
    /**
     *  the length is the accommodation in the list. (Capacidad)
     * @return length
     */
    @Override
    public int get_length() {
        return this.length;
    }    

    @Override
    public T[] matches(T element) {
        T[] my_arr = (T[]) new Object[10];
        int k= 0;
        for(int i = 0; i < this.array.length; i++){
            if(element.equals(this.array[i])){                
                if(k > (my_arr.length)){      
                    T[] aux = (T[]) new Object[10];
                    System.arraycopy(my_arr, 0, aux, 0, my_arr.length);
                    my_arr = aux;
                }
                my_arr[k] = this.array[i];
                k++;
            }
        }
        return my_arr;
    }

    @Override
    public Object[] get_content() {
        return (Entity[]) this.array;
    }

}
