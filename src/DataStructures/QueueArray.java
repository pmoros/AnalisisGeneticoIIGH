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
public class QueueArray<T> implements Queue<T> {
    /*
        Check this class, there is a little problem
        related with the creation of the DynamicArray,
        that is because the array is build with generics
        and THE SIZE CANNOT BE DETERMINED IN THE CONSTRUCTOR
        OF THIS CLASS.
    
    */
    
    private final DynamicArray<T> arr = new DynamicArray<>();
    private int tail = -1;
    private int head = -1;       


    public QueueArray(){                 
        
    }
    
    //FUNCION DE TESTEO
    public void show_elements(){
        for(int i = 0; i < this.arr.get_length(); i++){
            System.out.print(Integer.toString( (Integer)this.arr.get(i)));
        }
        System.out.println();
    }
    //FIN FUNCION DE TESTEO
    
    @Override
    public void enqueue(T item) {          
        if((this.tail + 1)%this.arr.get_length() == this.head) return;
        if(this.is_empty()){
            this.head = 0;
            this.tail = 0;                                   
        }                  
        this.arr.insert(this.tail, item);        
        this.tail = ((this.tail + 1)%this.arr.get_length());                                            
    }

    @Override
    public T dequeue() {        
        if (this.is_empty() ){            
            System.out.println("Empty queue.");
            return null;
        }                                   
        T aux = this.arr.get(this.head);        
        this.head = ((this.head + 1)%this.arr.get_length());   
        if (this.head == this.tail){
                    this.head = -1;
                    this.tail = -1; 
        }
        return aux;
    }

    @Override
    public T front() {
        return (this.arr.get(this.head));
    }

    /**
     * Finds how many elements are there in the queue
     * @return size of the queue
     */
    @Override
    public int get_size() {
        return this.arr.get_size();
    }
    
    /**
     * Finds how many spaces are there in the queue
     * @return length of the queue
     */
    @Override
    public int get_length() {
        return this.arr.get_length();
    }    
        
    @Override
    public boolean is_empty() {
        return (head == -1) && (tail == -1);
    }
           
    
}
