package DataStructures;

import java.lang.reflect.Array;


/**
 *
 * @author Fabian Torres
 */
public class DoubleHashSet<T extends Comparable<T>> implements java.io.Serializable{

	public class HashObject {
		public T key;
		public int value;
		
		public HashObject(T key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private HashObject[] arr;
	private int tableSize;
	private int size;
	private int pSize;
	private double loadFactor;
	
	// Falta establecer un primo menor para hash2()
	public DoubleHashSet(int ts) {
		this.tableSize = ts;
		this.size = 0;
		this.pSize = 7;
		this.arr = (DoubleHashSet<T>.HashObject[]) Array.newInstance(HashObject.class, this.tableSize);
		for(int i = 0; i < this.tableSize; i++) {
			arr[i] = null;
		}	
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	private boolean isLoaded() {
		this.loadFactor = (1.0*this.size/this.tableSize) + 0.1;                
		return this.loadFactor > 0.5;
	}
	
	private int hash(T key) {
		return Math.abs(key.hashCode() % this.tableSize);
	}
	
	private int hash2(T key) {
		return Math.abs(pSize - (key.hashCode() % pSize));
	}
	
	//
	private int hash(T key, int size) {
		return Math.abs(key.hashCode() % size);
	}
        
	
	private void rehash() {
		int newSize = 2*tableSize + 1;
		HashObject[] aux = (DoubleHashSet<T>.HashObject[]) Array.newInstance(HashObject.class, newSize);
		
		for(int i = 0; i < tableSize; i++) {
			if(arr[i] != null) {
				int index = Math.abs(hash(arr[i].key, newSize));
				aux[index] = arr[i];
			}

		}
		
		this.arr = aux;
		this.tableSize = newSize;
		this.pSize = 2*pSize + 1;	// Se puede crear un arreglo de primos para escoger
                this.arr = aux;
	}
        
	
	public void insert(T key) throws ClassNotFoundException {
                if(this.find(key) != null) throw new ClassNotFoundException("It already exist");
		HashObject entry = new HashObject(key, key.hashCode());
		
		if(isLoaded()) rehash();
		
		int index = Math.abs(hash(entry.key));
		int index2 = Math.abs(hash2(entry.key));
		int i = 0;
		//Tester                
		while(this.arr[index] != null && this.arr[index].value != -1) { // Est� ocupada la posici�n
                    /*
                        if(i == 4) {
                            System.out.println("Gotta be serious with your inputs.");
                            return;
                        }         
                            */
			i++;                        
			index = (index + i * index2) % this.tableSize;                        
		}
		
		this.arr[index] = entry;
		this.size++;
	}

	public void delete(T key) throws ClassNotFoundException {
                if(this.find(key) == null) throw new ClassNotFoundException("It does not exist");
		int index = Math.abs(hash(key));
		int index2 = Math.abs(hash2(key));
		int i = 0;
		
		// Posible bucle indefinido?
		while(this.arr[index] != null && this.arr[index].key.compareTo(key) != 0) {
			i++;
			index = (index + (i * index2)) % this.tableSize;
		}
		
		this.arr[index].key = null;
		this.arr[index].value = -1;
		this.size--;
	}
	
	public T find(T key) throws ClassNotFoundException {
		int index = Math.abs(hash(key));
		int index2 = Math.abs(hash2(key));
		int i = 0;

		while(this.arr[index] != null && this.arr[index].key.compareTo(key) != 0) {                    
                    if(i == 4)return null;
			i++;
			index = (index + i * index2) % this.tableSize;
		}		
                if(this.arr[index] == null)return null;
		return this.arr[index].key;
	}
	
	// Para testear
	public void printTable() {
		System.out.println("\n Tabla Hash:");
		for(int i = 0; i < this.tableSize; i++) {
			if(arr[i] != null)
				System.out.println(arr[i].key + " " + arr[i].value);
		}
	}
        
        public Object[] get_content(){        
            Object[] aux_arr = new Object[this.getSize()];
            for(int i = 0; i < this.arr.length; i++){
                if(this.arr[i] != null) aux_arr[i] = this.arr[i].key;                    
            }
            return aux_arr;
        }
        
        public Object[] matches(Object o){        
            Object[] aux_arr = new Object[this.size];
            int j = 0;
            for(int i = 0; i < this.arr.length; i++){
                if(this.arr[i] != null) {  
                    if(o.equals(this.arr[i])){
                        aux_arr[j] = this.arr[i].key;                 
                        j++;                        
                    }
                }                   
            }
            return aux_arr;
        }        
        
}
