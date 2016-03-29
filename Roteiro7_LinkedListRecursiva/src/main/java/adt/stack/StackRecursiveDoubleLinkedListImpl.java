package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> list;
	protected int size;
	
	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		list = new RecursiveDoubleLinkedListImpl<T>();
	}
	
		
	@Override
	public void push(T element) throws StackOverflowException {
		if(list.size() < size) {
			list.insert(element);
		} else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(list.size() > 0) {
			T result = top();
			list.removeLast();
			return result;
		} else {
			throw new StackUnderflowException();
		}
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
		return size == list.size();
	}

}