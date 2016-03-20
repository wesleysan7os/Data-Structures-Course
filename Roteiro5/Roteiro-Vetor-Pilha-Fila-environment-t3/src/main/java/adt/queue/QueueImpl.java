package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	public static final int HEAD = 0;
	
	private T[] array;
	private int tail;
		
	
	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
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

		tail--;		// as elements were shifted by one to left, tail must also shift;
	}

	// PRIMEIRO VERIFICO SE É FULL OU SE É NULL? A ORDEM MUDA O RESULTADO DE TESTES
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
