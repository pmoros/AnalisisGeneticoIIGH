package DataStructures;

/**
 *This heap will be able to change it's priority
 * @author Rock
 * @param <T>
 */
public class Heap<T extends Comparable<T>> implements java.io.Serializable {
    private boolean min;
    private T[] heap;
    private int size;
    private int max_size;
    
    
    /**
     * Finds the parent of a element in a slot
     * @return the position of the parent in the array
     */    
    private int parent(int pos){
        return pos/2;
    }
    
    private int left_child(int pos){
        return 2*pos + 1;
    }
    
    private int right_child(int pos){
        return 2*pos + 2;
    }
    
    private boolean is_leaf(int pos){
        return ( pos >= (this.size/2) && pos <= this.size);
    }
    
    private boolean has_parent(int index){
        return (index > 0);
    }
    
    private boolean has_left_child(int index){
        return (this.left_child(index) < this.size);
    }
    
    private boolean has_right_child(int index){
        return (this.right_child(index) < this.size);
    }
    /**
     * Swaps the content of two slots
     * @param fpos The current slot
     * @param spos The other slot
     */
    private void swap(int fpos, int spos){
        T tmp;
        tmp = this.heap[fpos];
        this.heap[fpos] = this.heap[spos];
        this.heap[spos] = tmp;        
    }
    
    /**
     * Takes the root and starts swaping down till it's in the right place
     */
    private void heapify_down(int index){
        if(!this.min){
            if(this.has_left_child(index)){
                int greater_index = this.right_child(index);
                if(this.has_left_child(index) && (this.heap[this.left_child(index)].compareTo(this.heap[this.right_child(index)]) >= 0 )){
                    greater_index = this.left_child(index);
                }
                if(this.heap[index].compareTo(this.heap[greater_index]) <= 0){
                    this.swap(index, greater_index);
                    this.heapify_down(greater_index);
                }
            }            
        }
        else{
            if(this.has_right_child(index)){
                int lesser_index = this.left_child(index);
                if(this.has_right_child(index) && (this.heap[this.right_child(index)].compareTo(this.heap[this.left_child(index)]) <= 0 )){
                    lesser_index = this.right_child(index);
                }
                if(this.heap[index].compareTo(this.heap[lesser_index]) >= 0){
                    this.swap(index, lesser_index);
                    this.heapify_down(lesser_index);
                }
            }         
            
        }
    }
    
    /**
     * Takes the last element we added and places it in the right slot
     */
    private void heapify_up(int index){
        
        if(!this.min){
            if((this.has_parent(index) && (this.heap[this.parent(index)].compareTo(this.heap[index])) <= 0)){
                this.swap(this.parent(index), index);
                this.heapify_up(this.parent(index));
            }
        }
        else{
            if((this.has_parent(index) && !((this.heap[this.parent(index)].compareTo(this.heap[index])) <= 0))){
                this.swap(this.parent(index), index);
                this.heapify_up(this.parent(index));
            }        
        }
    }    
    
    
    public Heap(int max_size){    
        this.max_size = max_size;
        this.heap = (T[]) new Comparable[this.max_size];
        this.min = false;
        this.size = 0;
    }   
    
    public Heap(){    
        this.max_size = 10;
        this.heap = (T[]) new Comparable[this.max_size];
        this.min = false;
        this.size = 0;
    }     
    
    /**
     * Saca todos los elementos de la cola de prioridad
     * Los guarda en un arreglo temporal
     * cambia el valor de min a true
     * comienza a meter cada uno de los elementos del temporal en la PQ
     */
    public void priority_to_min(){
        T[] aux_arr = (T[]) new Comparable[this.size];
        System.arraycopy(heap, 0, aux_arr, 0, this.size);
        this.size = 0;
        this.min = true;        
        for(int i = 0; i < aux_arr.length; i++){
            this.add(aux_arr[i]);
        }
    }
    
    /**
     * Saca todos los elementos de la cola de prioridad
     * Los guarda en un arreglo temporal
     * cambia el valor de min a false
     * comienza a meter cada uno de los elementos del temporal en la PQ
     */    
    public void priority_to_max(){
        T[] aux_arr = (T[]) new Comparable[this.size];
        System.arraycopy(heap, 0, aux_arr, 0, this.size);
        this.size = 0;
        this.min = false;                
        for(int i = 0; i < aux_arr.length; i++){
            this.add(aux_arr[i]);
        }    
    }    
    
    public T peek(){
        if(this.size == 0) throw new IndexOutOfBoundsException();
        T tmp = this.heap[0];
        return tmp;
    }    
    
    public T poll(){
        if(this.size == 0) throw new IndexOutOfBoundsException();
        T tmp = this.heap[0];
        this.heap[0] = this.heap[this.size - 1]; //-1 because we added 1 for the next
        this.size-=1;
        this.heapify_down(0); 
        return tmp;
    }
    
    private void resize(){
        int aux = this.max_size;
        this.max_size*=2;
        T[] array2 = (T[]) new Comparable[this.max_size];
        //System.arraycopy(this.heap, 0, array2, 0, aux);        
        for(int i = 0; i < this.heap.length; i++){
            array2[i] = (T) this.heap[i];
        }
        this.heap = array2;        
    }
    
    public void add(T element){    
        if(this.size == this.max_size) this.resize();
        this.heap[this.size] = element;               
        this.size+=1;        
        this.heapify_up(this.size -1); 
    }
    
}

/*
//PRUEBAS

public static void main(String[] args) {
        // TODO code application logic here
        Integer[] my_values = {15, 36, 17, 18, 84, 79, 65, 92, 19};
        Heap my_heap = new Heap(15);
        
        System.out.println("Going forward:");
        
        //Enqueueing values        
        for(int i = 0; i < my_values.length; i++){
            my_heap.add(my_values[i]);
        }
        
        //Polling values
        for(int i = 0; i < my_values.length; i++){
            System.out.print(my_heap.poll() + " ");
        }                
        
        System.out.println();
        //Going backwards
        
        System.out.println("Going Backward:");
        
        //Enqueueing values
        for(int i = 0; i < my_values.length; i++){
            my_heap.add(my_values[i]);
        }
        
        //Changing priority
        my_heap.priority_to_min();
        
        //Polling values
        for(int i = 0; i < my_values.length; i++){
            System.out.print(my_heap.poll() + " ");
        }   
    }
*/