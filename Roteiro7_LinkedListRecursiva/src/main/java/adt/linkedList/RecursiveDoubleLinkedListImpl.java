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
		
		if (isEmpty()) {
			data = element;
			next = new RecursiveDoubleLinkedListImpl<T>();
			
			((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
			
			previous = new RecursiveDoubleLinkedListImpl<T>();
			previous.setNext(this);
			
		} else {
			T copyData = data;
			RecursiveDoubleLinkedListImpl<T> copyNext = (RecursiveDoubleLinkedListImpl<T>) next;
			
			data = element;
			next = new RecursiveDoubleLinkedListImpl<T>();
			
			previous = new RecursiveDoubleLinkedListImpl<T>();
			previous.setNext(this);
			
			next.setNext(copyNext);
			next.setData(copyData);
			
			((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
			((RecursiveDoubleLinkedListImpl<T>) next.next).setPrevious(getNext());
		}

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
		if(data != null) {
			
			if(next.getData() == null) {
				if (previous.getData() == null) {
					setPrevious(null);
					setNext(null);
					setData(null);
				} else {
					next = new RecursiveDoubleLinkedListImpl<T>();
					((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(previous);
					previous.setNext(next);
				}
			} else {
				((DoubleLinkedList<T>) next).removeLast();
			}
			
		}
	}

	public void insert(T element) {
		if (element != null) {
			
			if (data == null) {
				setData(element);
				setNext( new RecursiveDoubleLinkedListImpl<T>());
				((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
				
				if(previous == null) {
					setPrevious(new RecursiveDoubleLinkedListImpl<T>());
					previous.setNext(this);
				}
				
			} else {
				next.insert(element);
			}
			
		}
	}
	
	
	public void remove(T element) {
		if (isEmpty() || element == null) 
			return;
		
		if (data.equals(element)) {
			
			if (next.getData() == null) {
				setPrevious(null);
				setNext(null);
				setData(null);
			} else {
				setData(next.getData());
				setNext(next.getNext());
				((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
			}
			
		} else if (next.getData() != null){
			this.next.remove(element);
		}
		// testar para lista vazia, lista size() == 1, == 2, == 3
	}
	
	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return this.previous;
	}
	
	
	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
	

	public RecursiveDoubleLinkedListImpl<T> getNext() {
		return (RecursiveDoubleLinkedListImpl<T>) next;
	}
	

}