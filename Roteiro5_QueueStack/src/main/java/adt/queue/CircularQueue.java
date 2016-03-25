package adt.queue;

public class CircularQueue<T> implements Queue<T> {
	
	private T[] array;
	private int tail;
	private int head;
	private int elements;
	
	private int size;
	
	public CircularQueue(int size) {
		if (size <= 0)
			throw new IllegalArgumentException("Size must be bigger than 0.");
			
		array = (T[])new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
		this.size = size;
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();

		if (element != null) {			
			
			if (isEmpty())
				head++;
			
			tail = (tail + 1) % size;
			array[tail] = element;
			elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();
		
		T removedElement = array[head];
		elements--;
		if (isNotEmpty())
			head = (head + 1) % size;
		return removedElement;
	}

	@Override
	public T head() {
		if (isEmpty())
			return null;
		else
			return array[head];
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}
	
	public boolean isNotEmpty() {
		return !isEmpty();
	}

	@Override
	public boolean isFull() {
		return elements == size;
	}
	
	public boolean isNotFull() {
		return !isFull();
	}

}
