/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;



public class DoublyLinkedList<T> implements List<T>{
    
    int size = 0;
    

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

    Node<T> head;
    Node<T> tail;
    
    
    @Override
    public void show_content() {
        Node<T> auxH = this.head;
        
        while(auxH.next != null){            
            System.out.print(auxH.data);
            auxH = auxH.next;            
        }
        System.out.println();
    }
    
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

    
    public T top_front() {
        return this.head.data;
    }


    
    public T pop_front() {
        T data_aux = this.head.data;
        Node aux = this.head;
        this.head = aux.next;        
        this.head.prev = null;
        this.size--;
        return data_aux;
    }

    
@Override
    public void append(T key) {
       Node<T> node = new Node<>(key);
       if (this.head == null) {
           this.head = node;
           this.tail = node;
           this.size++;
       }
       Node aux = this.tail;       
       this.tail = node;
       aux.next = this.tail;
       this.tail.prev = aux;       
       this.size++;
    }

    
    public T top_back() {
        return this.tail.data;
    }
    
    
    public void pop_back() {
        Node aux = this.tail;
        this.tail = aux.prev;
        this.tail.next = null;
        aux.prev = null;
        this.size--;
    }

    @Override
    public int find(T key) {
	int k = 0;
        Node auxH = this.head;
        Node auxT = this.tail;
        while((auxH != null) && (auxT != null)){
            if ((auxH.data == key) || (auxT.data == key)) return k;
            auxH = auxH.next;
            auxT = auxT.prev;
	    k++;
        }
        return -1;
    }

    @Override
    public void delete(T key) {
        /*
        Gotta check this method, 'cause it's necessary to
        repeat the code that we wrote at find method.
        */        
        Node auxH = this.head;
        Node auxT = this.tail;                
        
        while((auxH != null) && (auxT != null)){
            if ((auxH.data == key) || (auxT.data == key)){
                if(auxH.data == key){                    
                    if(auxH == this.head) {
                        this.pop_front();
                        this.size--;
                        return;
                    }
                    auxH.prev.next = auxH.next;
                    auxH.next.prev = auxH.prev;
                    this.size--;
                }
                else{
                    if(auxT == this.tail) {
                        this.pop_back();
                        this.size--;
                        return;
                    }
                    auxT.prev.next = auxT.next;
                    auxT.next.prev = auxT.prev;
                    this.size--;
                }                
            }
            auxH = auxH.next;
            auxT = auxT.prev;
        }                       
    }

    @Override
    public int get_size() {
        //Fix later 
        if (this.head == null) return 0;
        return this.size++;
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
    public T get(int index){
      Node<T> auxH = this.head;   
      for (int i = 0; i < index; i++){
          auxH = auxH.next;
      }        
      return auxH.data;
    }
    
    @Override
    public void delete_at(int index) {
      Node<T> auxH = this.head;   
      for (int i = 0; i < index; i++){
          auxH = auxH.next;
      }
      auxH.prev.next = auxH.next;      
      auxH.next.prev = auxH.prev;
      this.size--;
    }    
    
}


