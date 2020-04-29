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
public class DynamicArray<T> implements List<T>{
    T []array;
    int len = 10;
    int pointer = 0;
    public DynamicArray(){
        this.array = (T[]) new Object[len];                        
        this.len = 10;
    }
    
    //TEST METHOD
    @Override
    public void show_content(){
        for (int i = 0; i < this.pointer; i++){
            System.out.print(Integer.toString((Integer)this.array[i]) + " ");
        }        
        System.out.println();
    }    
    //FINISHED TEST METHOD
    
    public void resize(){
        int aux = this.len;
        this.len*=2;
        T[] array2 = (T[]) new Object[this.len];
        System.arraycopy(this.array, 0, array2, 0, aux);        
        this.array = array2;        
    }
    
    @Override
    public T get(int index){
        if (index < this.len){
            return this.array[index];
        }
        else{
            System.out.println("Index out of range");
            return null;
        }
    }
    
    @Override
    public void append(T data){
        if (this.pointer > (this.len - 1)) this.resize();
        this.array[this.pointer] = data;        
        this.pointer++;
    }
    
    @Override
    public void insert(int index, T data){
        if (index > this.len){
            this.append(data);
            System.out.println("Added at last position.");
        }
        this.array[index] = data;
    }
    
    @Override
    public int find(T element){
        for(int i =0; i < this.pointer; i++){
            T aux = this.array[i];
            if (aux.equals(element)){
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public void delete(T data){
    //This delete an element that is equal
        int result = this.find(data);
        if (result < 0){
            System.out.println("Could not find it.");            
        }
        else{
            this.delete_at(result);
        }
    }
    
    @Override
    public void delete_at(int index){
        if(index > this.pointer){
            for(int i = index; i < (this.pointer - 1); i++){
                this.array[i] = this.array[this.pointer + 1];
            }
            this.array[this.pointer - 1] = null;
            this.pointer--;
        }
        else{
            System.out.println("Index out of range");
        }
    }    

    @Override
    public void push_front(T element) {
        if (this.pointer < (this.len - 1)){
            for(int i = 0; i < (this.pointer - 1); i++){
                this.array[i + 1] = this.array[this.pointer];
            }
            this.array[0] = element;
            this.pointer++;
        }
        else{
            System.out.println("Index out of range");
        }        
    }

    @Override
    public int get_size() {
        return this.len;
    }

}
