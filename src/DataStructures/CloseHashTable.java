/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;



public class CloseHashTable <T extends Comparable <T>> implements java.io.Serializable{
	
	public static class HashNode <T>{
		T value;
		Integer key;
		HashNode<T> next;
		
		public T getValue() {
			return value;
		}
		public HashNode<T> getNext() {
			return next;
		}
		// Constructor 
		public HashNode(T value) {
			this.value = value;
			this.key = value.hashCode();
			next = null;
		}
		
		@Override
		public String toString() {
			return key.toString() + " " + value.toString();
		}
	}
	
	private DynamicArray<HashNode<T>> slotArray; //Represent the HashTable
	private int numSlots; 
	private int size; //Number of elements
	

	public DynamicArray<HashNode<T>> getSlotArray() {
		return slotArray;
	}

	public CloseHashTable() {
		slotArray = new DynamicArray<>(7);
		numSlots = 7;
		size = 0;
		
		//Reserve space in Array
        for (int i = 0; i < numSlots; i++) 
            slotArray.append(null);
			
	}
		
	public int size() {
		return size;
	}
		
	public boolean isEmpty() {
		return size == 0;
	}
	
	//Call result of Hash function
	private int getSlotOfIndex(Integer key) {
		return Math.abs(key % numSlots);  //Prevent negative values
	}
	
	//Remove by KEY - VALUE
	public T remove(Integer key) {	
		int slotIndex = getSlotOfIndex(key); //Apply Hash
		HashNode<T> head =  slotArray.get(slotIndex); //Get the head of the chain
		//Searching it
		HashNode<T> prev = null; 
		while (head != null) { 
            if (head.key.equals(key)) //Founded
                break; 
	 
            prev = head; 
            head = head.next; 
        } 
		
		if(head == null)
			return null; //Not Founded
			
		size--;
		
		//Removing it
		if(prev != null)
			prev.next = head.next;
		else
			slotArray.insert(slotIndex, head.next);;
			
		return head.value;
	}	
	public T remove(T value) {
		return remove(value.hashCode());
	}
	
	//Get an stored object by KEY - VALUE
	public T get(Integer key) {
		int slotIndex = getSlotOfIndex(key); //Apply Hash
		HashNode<T> head =  slotArray.get(slotIndex); //Get the head of the chain
		
		while (head != null) { 
			if (head.key.equals(key)) 
	            return head.value; //Founded
	            
	        head = head.next; //Not founded
	    }
		return null;
	}
	public T get(T value) {
		return get(value.hashCode());
	}
	public boolean contains(T value) {
		return null != get(value.hashCode());
	}
	
	//Rehash : when the LOAD FACTOR >= 0.75, need to increment the slots of the Table
	private void rehash() {
		
		if ((1.0*size)/numSlots >= 0.75) { //Load Factor
            DynamicArray<HashNode<T>> temp = slotArray; 
            slotArray = new DynamicArray<>(2 * numSlots); //Double Table size 
            numSlots = 2 * numSlots; 
            size = 0; 
            for (int i = 0; i < numSlots; i++) 
                slotArray.append(null); 
            
            //Storing again
            for (int i = 0; i < temp.get_size(); i++) { 
            	HashNode<T> headNode = temp.get(i);
                while (headNode != null) { 
                    add(headNode.value); 
                    headNode = headNode.next; 
                }
            } 
        } 
		return;
	}
	
	//Add an element
	public void add(T value) {
		Integer key = value.hashCode();
		int slotIndex = getSlotOfIndex(key); 
		HashNode<T> head =  slotArray.get(slotIndex);
		
		while (head != null) { 
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}    
	            
	        head = head.next; 
		}
		
		size++;
        head = slotArray.get(slotIndex); 
        HashNode<T> newNode = new HashNode<T>(value); 
        newNode.next = head; 
        slotArray.insert(slotIndex, newNode);
        
        rehash();
	}
	
	//Display the HashTable
	public void print() {
		
		DynamicArray<HashNode<T>> temp = slotArray; 

        for (int i = 0; i < temp.get_size(); i++) { 
        	HashNode<T> headNode = temp.get(i);
        	System.out.print("["+ i +"] : ");
            while (headNode != null) { 
                System.out.print(headNode.toString());
                
                if(headNode.next != null)
                	System.out.print("  ->  ");
                
                headNode = headNode.next; 
            }
           System.out.println();
        } 
	}
        
        public Object[] get_content(){        
            Object[] aux_arr = new Object[this.slotArray.get_length()];
            int j = 0;
            for(int i = 0; i < this.slotArray.get_length(); i++){
                if(this.slotArray.get(i) != null){
                    aux_arr[j++] = this.slotArray.get(i).value;
                    HashNode<T> aux = this.slotArray.get(i);
                    while(aux.next != null){
                        aux = this.slotArray.get(i).next;
                        aux_arr[j++] = aux.value;
                    }
                } 
            }
            return aux_arr;
        }
        
        public Object[] matches(Object o){   
            
    
            
            Object[] aux_arr = new Object[this.slotArray.get_length()];
            int j = 0;
            for(int i = 0; i < this.slotArray.get_length(); i++){
                if(this.slotArray.get(i) != null){
                    if(o.equals(this.slotArray.get(i).value)) aux_arr[j++] = this.slotArray.get(i).value;                    
                    HashNode<T> aux = this.slotArray.get(i).next;
                    while(aux != null){                        
                        if(o.equals(aux.value)) aux_arr[j++] = aux.value;                                            
                        aux = aux.next;
                    }
                } 
            }
            return aux_arr;
            
        }
           
}
/*
 * Basada en : https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
 * */