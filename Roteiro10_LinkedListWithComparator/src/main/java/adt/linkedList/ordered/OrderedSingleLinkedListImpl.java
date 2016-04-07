package adt.linkedList.ordered;

import java.util.Comparator;

import adt.linkedList.SingleLinkedListNode;

/**
 * Para testar essa classe voce deve implementar seu comparador. 
 * Primeiro implemente todos os métodos requeridos. Depois implemente dois comparadores (com idéias opostas)
 * e teste sua classe com eles. Dependendo do comparador que você utilizar a lista funcionar como ascendente
 * ou descendente, mas a implemntação dos métodos é a mesma.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class OrderedSingleLinkedListImpl<T> implements
		OrderedSingleLinkedList<T> {

	private SingleLinkedListNode<T> head;
	private Comparator<T> comparator;
	
	public OrderedSingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
		this.comparator = new ComparatorDefault(); // default crescent ordered comparator  
	}
	
	public OrderedSingleLinkedListImpl(Comparator<T> comparator) {
		this.head = new SingleLinkedListNode<T>();
		this.comparator = comparator;
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxNode = head;
		while (!auxNode.isNIL()) {
			size++;
			auxNode = auxNode.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> busca = head;
		
		while(!busca.isNIL()) { 
			if (busca.getData().equals(element)) 
				return busca.getData();
			else
				busca = busca.getNext();
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (element == null) {
			return;
		}
		
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
		
		if (isEmpty()) {
			this.head = newNode;
		} else {
			if (comparator.compare(element, head.getData()) < 0) {
				newNode.setNext(this.head);
				this.head = newNode;
			} else {
				SingleLinkedListNode<T> aux = head.getNext();
				SingleLinkedListNode<T> previous = head;
				while (!aux.isNIL() && comparator.compare(element, aux.getData()) >= 0) {
					aux = aux.getNext();
					previous = previous.getNext();
				}
				newNode.setNext(previous.getNext());
				previous.setNext(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element == null)
			return;
		
		if(!isEmpty()) {
			
			if(head.getData().equals(element)) {
				head = head.getNext();
			} else {
			
				SingleLinkedListNode<T> aux = head;
				SingleLinkedListNode<T> previous = new SingleLinkedListNode<>();
				
				while(!aux.isNIL() && !aux.getData().equals(element)) {
					previous = aux;
					aux = aux.getNext();
				} 
 				
				if(!aux.isNIL()) {
					previous.setNext(aux.getNext());
				}
			} // end else 
			
		} 
	}

	@Override
	public T[] toArray() {
		// if list is empty, an empty array is returned instead null
		T[] array = (T[]) new Object[] {};
		
		if(!isEmpty()) {
			
			array = (T[]) new Object[size()];
			SingleLinkedListNode<T> aux = head;
			
			for (int i = 0; i < size(); i++) {
				if(aux.getData() != null)
					array[i] = aux.getData();
				aux = aux.getNext();
			}
			
		}
		return array;
	}

	@Override
	public T minimum() {
		if (this.comparator == null || this.isEmpty())
			return null;
		
		T min = this.head.getData();
		T[] array = toArray();
		
		for (T item : array) {
			if (this.comparator.compare(min, item) > 0) {
				min = item;
			}
		}
		return min;
	}

	@Override
	public T maximum() {
		if (this.comparator == null || this.isEmpty())
			return null;
		
		T max = this.head.getData();
		T[] array = toArray();
		
		for (T item : array) {
			if (this.comparator.compare(max, item) < 0) {
				max = item;
			}
		}
		return max;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
	
}
