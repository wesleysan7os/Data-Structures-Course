package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	protected int size;
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> busca = head;
		
		while(!busca.isNIL()) { 
			if (busca.getData().equals(element)) 
				return busca.data;
			else
				busca = busca.next;
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			
			SingleLinkedListNode<T> nil = new SingleLinkedListNode<T>();
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, nil);
		
			if (isEmpty()) {
				this.head = newNode;
			} else {

				SingleLinkedListNode<T> aux = head;
				while(!aux.next.isNIL()) {
					aux = aux.next;
				}
				aux.next = newNode;
			} 
			size++;
		}
	}

	@Override
	public void remove(T element) {
		
		if(element == null)
			return;
		
		if(!isEmpty()) {
			
			if(head.data.equals(element)) {
				head = head.next;
				size--;
			} else {
			
				SingleLinkedListNode<T> aux = head;
				SingleLinkedListNode<T> previous = new SingleLinkedListNode<>();
				
				while(!aux.isNIL() && !aux.getData().equals(element)) {
					previous = aux;
					aux = aux.next;
				} 
 				
				if(!aux.isNIL()) {
					previous.next = aux.next;
					size--;
				}
			} // end else 
			
		} 
	}

	@Override
	public T[] toArray(){
		// if list is empty, an empty array is returned instead null
		T[] array = (T[]) new Object[] {};
		
		if(!isEmpty()) {
			
			array = (T[]) new Object[size];
			SingleLinkedListNode<T> aux = head;
			
			for (int i = 0; i < size; i++) {
				if(aux.getData() != null)
					array[i] = aux.getData();
				aux = aux.next;
			}
			
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
	
	
		
}
