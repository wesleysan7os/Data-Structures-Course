package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;
	
	public RecursiveSingleLinkedListImpl() {
		this.data = null;
		this.next = null;
	}
	
	@Override
	public boolean isEmpty() {
		if (this.data == null)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		int count = 0;
		if (this.data != null) {
			count = 1 + next.size();
		}
		return count;
	}

	@Override
	public T search(T element) {
		if (element == null)
			return null;
		
		if (this.data == null) {
			return null;
		} else {
			if (data.equals(element))
				return element;
			else if ( next != null)
				return next.search(element);
			else
				return null;
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {		
			
			if (this.data == null) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<T>();
			} else {
				next.insert(element);
			}
			
		}
	}

	@Override
	public void remove(T element) {
		if (element == null || this.data == null)
			return;
		if (this.data.equals(element)) { 
			this.data = next.getData();
			this.next = next.getNext();
		} else {
			this.next.remove(element);
		}
	}
	
	@Override
	public T[] toArray(){
		T[] array = (T[]) new Object[size()];
		int firstIndex = 0;
		return toArray(array, firstIndex);
	}
	
	private T[] toArray(T[] array, int current) {
		if (this.data != null) {
			array[current] = this.data;
			this.next.toArray(array, current + 1);
		}
		return array;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}