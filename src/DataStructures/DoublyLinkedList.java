/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author judgonzalezmu
 */
public class DoublyLinkedList<T>
{
	class Node
	{ 
        T key; 
        Node prev; 
        Node next; 
  
        // Constructor 
        // next y prev son null 
        Node(T k)
        { 
        	key = k;
        } 
    } 
	
	Node head;
	int size;
  
	//Adds an element at front 
    public void push_front(T element) 
    { 
        Node newNode = new Node(element); 
        
        newNode.next=head;
        newNode.prev=null;
        
        if (head != null)
        	head.prev=newNode;
        
        head=newNode; 
        size+=1;
    } 
  
    // Given a node, insert a new node after the given node 
    public void insert(Node prevNode, T element) 
    { 
        if (prevNode==null)
        { 
            System.out.println("Given node can't be null"); 
            return; 
        } 
        
        Node newNode=new Node(element);
        
        newNode.next=prevNode.next;
        prevNode.next=newNode;
        newNode.prev=prevNode;
  
        if(newNode.next!=null)
        {
        	newNode.next.prev=newNode;
        	size+=1;
        }
    } 
  
    //Adds an element at last position 
    public void append(T element) 
    { 
        Node newNode=new Node(element);   
        Node last=head; 
  
        newNode.next=null; 
        
        if(head==null)
        {
        	newNode.prev=null;
        	head=newNode;
        	size+=1;
        	return;        	
        }
        
        while(last.next!=null)
        	last=last.next;
        
        last.next=newNode;
        newNode.prev=last; 
        size+=1;
    } 
    
    // Returns an element at a required position    
    public T get(Node pointer)
    {
    	if (pointer==null)
        { 
            System.out.println("Given node doesn't point anything"); 
            return null; 
        } 
    	else
    	{
    		return pointer.next.key;
    	}
    }
  
    // Print the list
    public void show_content() 
    { 
    	Node tmp=head;
    	 
        while (tmp!=null)
        {
        	System.out.print(tmp.key+" ");
        	tmp=tmp.next;
        	
        }        
    } 
    
    public int get_size() 
    {
    	return size;    	
    }
    
    // Delete the first element
    public void deleteFirst()
    {
        if (size==0) 
        	System.out.print("There are no items in the list");
        
        head = head.next;
        head.prev = null;
        size--;
    }
     
    // Delete the last element
    public void deleteLast()
    {
    	Node last=head; 
    	
    	if (size==0) 
        	System.out.print("There are no items in the list");
    	
    	while(last.next!=null)
        	last=last.next;
    	
    	last.prev.next=null;
        size--;
    }  
}