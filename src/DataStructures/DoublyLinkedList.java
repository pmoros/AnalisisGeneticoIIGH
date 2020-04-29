/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *

    
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