package adt.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeapImpl<T extends Comparable<T>> implements MinHeap<T> {

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;
	private static final int ROOT_INDEX = 0;
	
	private int lastIndex;
	private T[] heap;
	
	public MinHeapImpl() {
		this.lastIndex = -1;
		this.heap = (T[]) new Comparable[INITIAL_SIZE];
	}
	
	@Override
	public boolean isEmpty() {
		return lastIndex == -1;
	}

	// change
	@Override
	public void insert(T element) {
		if (element == null)
			return;
		
		if (isFull())
			increaseHeap();
		
		
		if (isEmpty()) {
			heap[ROOT_INDEX] = element;
			lastIndex++; // makes lastIndex = -1 turns 0
		} else {
		
			lastIndex++;
			int i = lastIndex; 
			heap[i] = element;
		
			while (i > ROOT_INDEX && heap[parent(i)].compareTo(element) > 0) {
				Util.swap(heap, i, parent(i));
				i = parent(i);
			}
		}
	}

	@Override
	public T extractRootElement() {
		
		if (isEmpty())
			return null;
		
		T removed = heap[ROOT_INDEX];
		
		Util.swap(heap, ROOT_INDEX, lastIndex);
		lastIndex--;
		
		heapify(ROOT_INDEX);
		
		return removed;
	}

	@Override
	public T rootElement() {
		if (isEmpty())
			return null;
		else
			return heap[ROOT_INDEX];
	}

	// change
	@Override
	public T[] heapsort(T[] array) {
		List<T> result = new ArrayList<T>();
		
		buildHeap(array);
		
		while(!isEmpty())
			result.add(extractRootElement());
		
		return (T[]) result.toArray(new Comparable[0]);
	}

	@Override
	public void buildHeap(T[] array) {
		
		if (array == null)
			return;
		
		heap = (T[]) new Comparable[array.length];
		lastIndex = -1;
		
		for (int i = 0; i < array.length; i++) { 
			if (array[i] != null) {
				heap[i] = (array[i]);
				lastIndex++;
			}
		}
		
		for (int i = parent(lastIndex); i > ROOT_INDEX; i--)
			heapify(i);
	}

	// change
	private void heapify(int position){

		int minIndex = indexOfMin(position, left(position), right(position));
		if (position != minIndex) {
			Util.swap(heap, position, minIndex);
			heapify(minIndex);
		}
	}
	
	@Override
	public T[] toArray() {
		T[] result = (T[]) new Comparable[heap.length];
		
		for (int i = 0; i < heap.length; i++) 
			result[i] = heap[i];
		
		
		return result;
	}

	protected int parent(int i) {
		return (i-1)/2;
	}

	protected int left(int i) {
		return (2*i) +1;
	}

	protected int right(int i) {
		return (2*i) + 2;
	}

	private boolean isFull() {
		return lastIndex == heap.length;
	}

	private void increaseHeap() {
		T[] aux = heap;
		
		heap = (T[]) new Comparable[aux.length + INCREASING_FACTOR]; 
		
		for (int i = ROOT_INDEX; i < aux.length; i++) 
			heap[i] = aux[i];
	}
	
	private int indexOfMin(int position, int left, int right) {
		
		int minIndex = position;
		
		if (left <= lastIndex && heap[minIndex].compareTo(heap[left]) > 0)
			minIndex = left;
		
		if (right <= lastIndex && heap[minIndex].compareTo(heap[right]) > 0)
			minIndex = right; 
		
		return minIndex;
	}

}