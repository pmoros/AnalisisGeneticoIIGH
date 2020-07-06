package DataStructures;


/**
 *
 * @author Fabian Torres
 */
public class DoubleHashSet<T extends Comparable<T>> {

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
	private float loadFactor;
	
	// Falta establecer un primo menor para hash2()
	public DoubleHashSet(int ts) {
		this.tableSize = ts;
		this.size = 0;
		
		this.arr = (DoubleHashSet<T>.HashObject[]) new Object[this.tableSize];
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
		this.loadFactor = this.size/this.tableSize;
		return this.loadFactor > 0.9;
	}
	
	private int hash(T key) {
		return key.hashCode() % this.tableSize;
	}
	
	private int hash2(T key) {
		return pSize - (key.hashCode() % pSize);
	}
	
	//
	private int hash(T key, int size) {
		return key.hashCode() % size;
	}
	
	private void rehash() {
		int newSize = 2*tableSize + 1;
		HashObject[] aux = (DoubleHashSet<T>.HashObject[]) new Object[newSize];
		
		for(int i = 0; i < this.tableSize; i++) {
			if(arr[i] != null) {
				int index = hash(arr[i].key, newSize);
				aux[index] = arr[i];
			}
		}
		
		this.arr = aux;
		this.tableSize = newSize;
		this.pSize = 2*pSize + 1;	// Se puede crear un arreglo de primos para escoger
	}
	
	public void insert(T key) {
		HashObject entry = new HashObject(key, key.hashCode());
		
		if(isLoaded()) rehash();
		
		int index = hash(entry.key);
		int index2 = hash2(entry.key);
		int i = 0;
		
		while(this.arr[index] != null && this.arr[index].value != -1) { // Est� ocupada la posici�n
			i++;
			index = (index + i * index2) % this.tableSize;
		}
		
		this.arr[index] = entry;
		this.size++;
	}

	public void delete(T key) {
		int index = hash(key);
		int index2 = hash2(key);
		int i = 0;
		
		// Posible bucle indefinido?
		while(this.arr[index] != null && this.arr[index].key.compareTo(key) != 0) {
			i++;
			index = (index + i * index2) % this.tableSize;
		}
		
		this.arr[index].key = null;
		this.arr[index].value = -1;
		this.size--;
	}
	
	public int find(T key) {
		int index = hash(key);
		int index2 = hash2(key);
		int i = 0;
		
		while(this.arr[index] != null && this.arr[index].key.compareTo(key) != 0) {
			i++;
			index = (index + i * index2) % this.tableSize;
		}
		
		return this.arr[index].value;
	}
	
	// Para testear
	public void printTable() {
		System.out.println("\n Tabla Hash:");
		for(int i = 0; i < this.tableSize; i++) {
			if(arr[i] != null)
				System.out.println(arr[i].key + " " + arr[i].value);
		}
	}
}
