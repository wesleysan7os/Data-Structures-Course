package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	public static final int HEAD = 0;
	
	private T[] array;
	private int tail;
		
	
	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		if (size <= 0)
			throw new IllegalArgumentException("Size must be bigger than 0.");
		
		array = (T[])new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if(isEmpty())
			return null;
		else
			return array[HEAD];
	}

	@Override
	public boolean isEmpty() {
		return (tail == -1);
	}

	@Override
	public boolean isFull() {
		return (tail == array.length - 1);
	}
	
	private void shiftLeft(){
		for (int i = HEAD; i < tail; i++) {
			array[i] = array[i + 1];
		}

		tail--;		// as elements were shifted by one to left, tail must also shifts;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();
		
		if (element != null) {
			tail++;
			array[tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();
		
		T element = array[HEAD];
		shiftLeft();
		return element;
	}

}