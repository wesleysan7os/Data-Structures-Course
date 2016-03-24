package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {
	
	protected DoubleLinkedList<T> list;
	protected int size;
	
	public StackDoubleLinkedListImpl(int size) {
		list = new DoubleLinkedListImpl<T>();
		this.size = size;
	}
	
	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException();

		if (element != null) {
			list.insertFirst(element);
		}
		
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();

		T[] array = list.toArray();
		list.removeFirst();
		return array[0];
	}

	@Override
	public T top() {
		if (isEmpty()) return null;

		T[] array = list.toArray();
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return (list.size() == size);
	}

}
