/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;



public class DoublyLinkedList<T> implements List<T>{

    @Override
    public T[] get_content() {
        T[] aux_arr = (T[]) new Object[this.size];
        int k = 0;
        Node auxH = this.head;        
        while(auxH != null){
            aux_arr[k] = (T) auxH.data;
            auxH = auxH.next;
            k++;
        }        
        return aux_arr;
    }

    
    public class Node<T> implements java.io.Serializable{
        public T data;
        public Node<T> prev;
        public Node<T> next;

        Node(T data){
            this.data = data;
            prev = null;
            next = null;
        }
    }

    public int size = 0;
    public Node<T> head;
    Node<T> tail;
    
    public void DoubleLinkedList(){
        head = null;
        tail = null;
    }
        
    @Override
    public void push_front(T key) {
        Node<T> node = new Node<>(key);
        if (this.head == null){
            this.head = node;
            this.tail = node;
            this.size++;
        }
        else{
            node.next = head;                 
            this.head.prev = node;
            this.head = node; 
            this.size++;
        }
    }    

@Override
    public void append(T key) {
       Node<T> node = new Node<>(key);
       if (this.head == null) {
           this.head = node;
           this.tail = node;
           this.size++;
           return;
       }
       Node aux = this.tail;       
       this.tail = node;
       aux.next = this.tail;
       this.tail.prev = aux;       
       this.size++;
    }   
    
    @Override
    public void insert(int index, T element){
      Node<T> node = new Node<>(element);   
      Node auxH = this.head;
      for (int i = 0; i < index; i++){
          auxH = auxH.next;
      }
      auxH.prev.next = node;
      node.prev = auxH.prev;
      auxH.prev = node;
      node.next = auxH;   
      this.size++;
    }
    
    
    @Override
    public T find(T key) {	
        Node auxH = this.head;        
        while(auxH != null){
            if(auxH.data.equals(key)) return (T)auxH.data;
            
        }
        return null;
    }   

    @Override
    public T[] matches(T element) {
        Node auxH = this.head;
        T[] my_arr = (T[]) new Object[10];
        int k = 0;
        while(auxH != null){
            if(auxH.data.equals(element)){                            
                if(k > (my_arr.length)){      
                    T[] aux = (T[]) new Object[10];
                    System.arraycopy(my_arr, 0, aux, 0, my_arr.length);
                    my_arr = aux;
                }
                my_arr[k] = (T)auxH.data;
                k++;                      
            }            
        }
        return my_arr;
    }    
    
    @Override
    public T get(int index){
      Node<T> auxH = this.head;   
      for (int i = 0; i < index; i++){
          auxH = auxH.next;
      }        
      return auxH.data;
    }
    
    public T top_front() {
        return this.head.data;
    }    
    
    public void pop_front() {        
        Node aux = this.head;
        this.head = aux.next;                
        this.size--;        
    }
    
    @Override
    public void delete(T key) {
        /*
        Gotta check this method, 'cause it's necessary to
        repeat the code that we wrote at find method.
        */        
        Node auxH = this.head;                      
        
        while((auxH != null)){
            if ((auxH.data.equals(key))){                                    
                    if(auxH == this.head) {
                        this.pop_front();
                        this.size--;
                        return;
                    }
                    auxH.prev.next = auxH.next;
                    auxH.next.prev = auxH.prev;
                    this.size--;                               
            }
            auxH = auxH.next;            
        }                       
    }
    
    @Override
    public void pop() {
        Node aux = this.tail;
        this.tail = aux.prev;
        this.tail.next = null;
        aux.prev = null;
        this.size--;
    }    
    
    @Override
    public boolean contains(T element) {
        Node auxH = this.head;
        while(auxH != null){
            if (auxH.equals(element)) return true;
        }
        return false;
    }

    @Override
    public int get_length() {
        return this.size + 1;
    }   
    
    
    @Override
    public void show_content() {
        Node<T> auxH = this.head;
        
        while(auxH.next != null){            
            System.out.print(auxH.data);
            auxH = auxH.next;            
        }
        System.out.println();
    }
    
   

    
    public T top_back() {
        return this.tail.data;
    }
       

    @Override
    public int get_size() {
        //Fix later 
        if (this.head == null) return 0;
        return this.size+ 1;
    }    
    

     
    
}


