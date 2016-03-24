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
			
			DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<T>();
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, nilNode, nilNode);
		
			if(isEmpty()) {
				last = newNode; 
				setHead(last);
			} else {
				
				((DoubleLinkedListNode<T>) head.next).previous = newNode;
				newNode.next = this.head;
				setHead(newNode);

			}
			size++;
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {

			DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<T>();
			
			// verifies if head and last are the same reference at memory;
			// if true, so list is unitary
			if (this.head == this.last) {
				this.last = new DoubleLinkedListNode<T>();
				this.head = new DoubleLinkedListNode<T>();
			} else {
				((DoubleLinkedListNode<T>) head.next).previous = nilNode;
				this.head = this.head.next;				
			}			
			size--;
		}
	}
	 
	@Override
	public void removeLast() {
		if (!isEmpty()) {
			
			DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<T>();
			
			if (this.head == this.last) {
				this.last = nilNode;
				this.head = nilNode;
			} else {
				this.last = this.last.previous;
				this.last.next = nilNode; 
			}
			
			size--;
			
		}
	}

	/***
	 * Iterates over List from end to begin, to take head element avoiding to cast references. 
	 * @return the head element, as DoubleLinkedNode, if List is not Empty.
	 */
	public DoubleLinkedListNode<T> getHeadTypeDouble() {
		if(!isEmpty()) {
			
			DoubleLinkedListNode<T> aux = last;
			
			while(!aux.previous.isNIL()) {
				aux = aux.previous;
			}
		return aux;
			
		}
		return null;
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {

			DoubleLinkedListNode<T> newNode;
			DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<T>();
			
			if(isEmpty()) {
				newNode = new DoubleLinkedListNode<T>(element, nilNode, nilNode);
				last = newNode;
				setHead(last);
			} else {
				newNode = new DoubleLinkedListNode<T>(element, nilNode, last);
				last.next = newNode;
				last = newNode;
			}
			size++;
		}
	}
	
	public void remove(T element) {
		if (element == null)
			return;
		
		DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<T>();
		
		if (!isEmpty()) {
			
			if (head.getData().equals(element)) {
				removeFirst();
			} else if (last.getData().equals(element)) {
				removeLast();
			} else {
				
				DoubleLinkedListNode<T> auxNodeNext = last;
				DoubleLinkedListNode<T> auxNode = last.previous;
				
				while(!auxNode.isNIL() && !auxNode.getData().equals(element)) {
					auxNodeNext = auxNodeNext.previous;
					auxNode = auxNode.previous;
				}
				
				if (!auxNode.isNIL()) {
					auxNode.previous.next = auxNode.next;
					auxNodeNext.previous = auxNode.previous;
					size--;
				}
			}
		}
		
		
	}
	
}
