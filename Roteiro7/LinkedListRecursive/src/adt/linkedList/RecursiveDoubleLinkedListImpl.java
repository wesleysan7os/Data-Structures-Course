package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		super();
		this.previous = null;
	}
	
	@Override
	public void insertFirst(T element) {
		if (element == null) 
			return;
		
		if (data == null) {
			setData(element);
			setNext( new RecursiveDoubleLinkedListImpl<T>());
			((RecursiveDoubleLinkedListImpl<T>)next).previous = this;
		} else {
			T arg = data;
			setData(element);
			((RecursiveDoubleLinkedListImpl<T>)next).insertFirst(arg);
		}
		// testar para add quando estiver vazia
		// este algo eh o(n), mas segue estritamente a ideia de recursividade. os outros n seguiriam. qual implementar?
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()) {
			if(next.getData() == null) {
				setPrevious(null);
				setNext(null);
				setData(null);
			} else {
				setData(next.getData());
				setNext(next.getNext());
				((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
			}
		}
		// testar para size == 0, == 1, == 2, == 3
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			
			if (getData() == null) {
				this.previous.setData(null);
				this.previous.setNext( new RecursiveDoubleLinkedListImpl<T>());
			} else {
				((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
			}
			
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return this.previous;
	}
	
	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

	// FALTA SOBRESCREVER INSERT E REMOVE
	
}
