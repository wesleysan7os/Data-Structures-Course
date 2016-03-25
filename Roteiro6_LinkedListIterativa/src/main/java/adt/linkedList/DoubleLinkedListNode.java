package adt.linkedList;

public class DoubleLinkedListNode<T> extends SingleLinkedListNode<T> {
	
	protected DoubleLinkedListNode<T> previous;

	public DoubleLinkedListNode() {
		
	}

	public DoubleLinkedListNode(T data, DoubleLinkedListNode<T> next, DoubleLinkedListNode<T> previous) {
		super(data, next);
		this.previous = previous;
	}
	
	public void setPrevious(SingleLinkedListNode<T> element) {
		this.previous = (DoubleLinkedListNode<T>) element;
	}
	
	public DoubleLinkedListNode<T> getPrevious() {
		if (this.previous.isNIL()) 
			return new DoubleLinkedListNode<>();
		else
			return this.previous;
	}
	

}
