package adt.stack;


public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;
	
	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		if (size <= 0)
			throw new IllegalArgumentException("Size must be bigger than 0.");
		array = (T[])new Object[size];
		top = -1;
	}
	
	@Override
	public T top() {
		if (isEmpty())
			return null;
		
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == array.length-1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException();
		
		if (element != null) {
			top++;
			array[top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		
		T removedElement = array[top];
		top--;
		return removedElement;
	}


}