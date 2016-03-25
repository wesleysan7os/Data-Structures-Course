package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		last = new DoubleLinkedListNode<T>();
	}
	
	@Override
	public void insertFirst(T element) {
		if (element != null) {
			
			DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<>();
			
			if(isEmpty()) {
				last = new DoubleLinkedListNode<T>(element, nil, nil);
				head = last;
			} else {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, nil, nil);
				newNode.setNext(head);
				( (DoubleLinkedListNode<T>) head).previous = newNode;
				head = newNode;
			}
			size++;
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()) {
			
			if(size() == 1) {
				last = new DoubleLinkedListNode<T>();
				head = new DoubleLinkedListNode<T>();
			} else {
				( (DoubleLinkedListNode<T>) head.next).previous  = new DoubleLinkedListNode<T>();				
				head = head.next;
			}
			size--;
		}
	}
	 
	@Override
	public void removeLast() {
		if (!isEmpty()) {
			
			if(size() == 1) {
				last = new DoubleLinkedListNode<T>();
				head = new DoubleLinkedListNode<T>();
			} else {
				last = last.previous;
				last.next = new DoubleLinkedListNode<T>();
			}
			size--;
		}
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			
			if (isEmpty()) {
				insertFirst(element);				
			} else {
				DoubleLinkedListNode<T> next = new DoubleLinkedListNode<T>();
				DoubleLinkedListNode<T> previous = last; 
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, next, previous);
				
				last.setNext(newNode);
				last = newNode;
				size++;
			}
		}
	}
	
	public void remove(T element) {

		if(head.getData().equals(element)) {
			removeFirst();
		} else if (last.getData().equals(element)) {
			removeLast();
		} else {
			SingleLinkedListNode<T> aux = head;
			
			while( !aux.isNIL() && !aux.data.equals(element)){
				aux = aux.next;
			}
			
			if (!aux.isNIL()){
				( (DoubleLinkedListNode<T>) aux).previous.next = aux.next;
				( (DoubleLinkedListNode<T>) aux.next).previous = ( (DoubleLinkedListNode<T>) aux).previous;
				size--;
			}
		}
	}
	
}
