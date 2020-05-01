/*
 * @author fatorresra
 * 
 * In need of a review, in particular of the interface-implemented methods
 * and the inclusion of getters and setters.
 * 
 */

package DataStructures;

public class SinglyLinkedList<T> implements List<T> {

	SinglyLinkedListNode<T> head;
	SinglyLinkedListNode<T> tail;
	private int size;
	
	public class SinglyLinkedListNode<T> {
		T key;
		SinglyLinkedListNode<T> next;
		
		public SinglyLinkedListNode() {
			this.key = null;
		}
		
		public SinglyLinkedListNode(T key) {
			this.key = key;
		}
		
		public SinglyLinkedListNode(T key, SinglyLinkedListNode<T> next) {
			this.key = key;
			this.next = next;
		}

	}
	
	public SinglyLinkedList() {
		this.tail = this.head = null;
		this.size = 0;
	}
	
	public SinglyLinkedList(T key) {
		this.tail = this.head = new SinglyLinkedListNode<T>(key);
		this.size = 1;
	}
	
	public SinglyLinkedList(SinglyLinkedListNode<T> node) {
		this.tail = this.head = node;
		this.size = 1;
	}
	
	public int getSize() {
		return this.size;
	}
	
	@Override
	public void show_content() {
		SinglyLinkedListNode<T> p = this.head;
		
		while(p != null) {
			System.out.print(p.key + " ");
			p = p.next;
		}
		
		System.out.print("\n");
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}

	@Override
	public void append(T element) {
		SinglyLinkedListNode<T> node = new SinglyLinkedListNode<T>(element);
		
		if(this.head == null) {
			this.head = this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		
		this.size++;
	}

	@Override
	public void push_front(T element) {
		SinglyLinkedListNode<T> node = new SinglyLinkedListNode<T>(element);
		
		if(this.head == null) {
			this.head = this.tail = node;
		} else {
			node.next = this.head;
			this.head = node;
		}
		
		this.size++;
	}

	@Override
	public void insert(int index, T element) {
		SinglyLinkedListNode<T> node = new SinglyLinkedListNode<T>(element);
		SinglyLinkedListNode<T> p = this.head;
		
		if(index == 0) {
			push_front(element);
			return;
		}
		
		if(index == size) {
			append(element);
			return;
		}
		
		for(int i = 1; i < index - 1; i++) {
			if(p.next != null) p = p.next;
		}
		
		node.next = p.next;
		p.next = node;
		this.size++;
	}

	@Override
	public T get(int index) {
		SinglyLinkedListNode<T> p = this.head;
		
		for(int i = 0; i < index; i++) {
			if(p.next != null) p = p.next;
		}
		
		return p.key;
	}

	@Override
	public int find(T element) {
		SinglyLinkedListNode<T> p = this.head;

		for(int i = 0; i < size; i++) {
			if(p.key == element) return i;
			p = p.next;
		}
		
		return -1;
	}
	
	public void pop_front() {
		if(this.head != null) {
			this.head = this.head.next;
			this.size--;
		}
	}
	
	public void pop_back() {
		if(this.head != null) {
			SinglyLinkedListNode<T> p = this.head;
			for(int i = 0; i < size - 1; i++) {
				p = p.next;
			}
			this.tail = p;
		}
	}
	
	@Override
	public void delete(T element) {
		SinglyLinkedListNode<T> p = this.head;
		SinglyLinkedListNode<T> q = this.head;
		
		if(this.head.key == element) {
			pop_front();
			return;
		}
		
		p = p.next;
		for(int i = 1; i < size; i++) {
			if(p.key == element) {
				q.next = p.next;
				this.size--;
				return;
			}
			p = p.next;
			q = q.next;
		}
	}

	@Override
	public void delete_at(int index) {
		SinglyLinkedListNode<T> p = this.head;
		
		if(index == 0) { 
			pop_front();
			return;
		}
		
		if(index == size) {
			pop_back();
			return;
		}
		
		for(int i = 1; i < index; i++) {
			p = p.next;
		}
		
		p.next = p.next.next;
		this.size--;
	}

	@Override
	public int get_size() {
		return this.getSize();
	}
}