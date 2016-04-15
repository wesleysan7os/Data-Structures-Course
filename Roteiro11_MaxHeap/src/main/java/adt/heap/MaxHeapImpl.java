package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeapImpl<T extends Comparable<T>> implements MaxHeap<T> {
	
	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;
	private static final int ROOT_INDEX = 0;
		
	protected int lastIndex;
	private T[] heap;

	public MaxHeapImpl() {
		this.lastIndex = -1;
		this.heap = (T[]) new Comparable[INITIAL_SIZE];
	}
	
	private int parent(int i) {
		return (i-1)/2;
	}

	private int left(int i) {
		return (2*i) +1;
	}

	private int right(int i) {
		return (2*i) + 2;
	}
	
	@Override
	public void buildHeap(T[] array) {
		
		if (array == null)
			return;
		
		heap = (T[]) new Comparable[array.length];
		lastIndex = -1;
		
		for (int i = 0, j = 0; i < array.length; i++) { 
			if (array[i] != null) {
				heap[j++] = (array[i]);
				lastIndex++;
			}
		}
				
		for (int i = parent(lastIndex+1); i >= ROOT_INDEX; i--)
			heapify(i);
	}

	private void heapify(int position){

		int maxIndex = indexOfMax(position, left(position), right(position));
		if (position != maxIndex) {
			Util.swap(heap, position, maxIndex);
			heapify(maxIndex);
		}
	}
	
	@Override
	public boolean isEmpty() {
		return lastIndex == -1;
	}
	
	@Override
	public void insert(T element) {
		if (element == null)
			return;
		
		if (isFull())
			increaseHeap();
		
		
		if (isEmpty()) {
			heap[ROOT_INDEX] = element;
			lastIndex++; // makes lastIndex (equals to -1) turns 0
		} else {
		
			lastIndex++;
			int i = lastIndex; 
		
			while (i > ROOT_INDEX && heap[parent(i)].compareTo(element) < 0) {
				Util.swap(heap, i, parent(i));
				i = parent(i);
			}
			heap[i] = element;
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

	@Override
	public T[] heapsort(T[] array) {
		
		if(array == null)
			return null;
		
		buildHeap(array);
		
		T[] copyHeap = Arrays.copyOf(heap, getSize());
		int copyLastIndex = lastIndex;
		
		T[] sorted = (T[]) new Comparable[array.length];
		int i = getSize();
		
		while(!isEmpty())
			sorted[--i] = extractRootElement();

		this.heap = copyHeap;
		this.lastIndex = copyLastIndex;
		
		return sorted;
	}
	
	@Override
	public T[] toArray() {
		T[] copy =  Arrays.copyOf(heap, getSize());
		return copy;
	}
	
	private boolean isFull() {
		return lastIndex+1 == heap.length;
	}
	
	private void increaseHeap() {
		T[] aux = heap;
		
		heap = (T[]) new Comparable[aux.length + INCREASING_FACTOR]; 
		
		for (int i = ROOT_INDEX; i < aux.length; i++) 
			heap[i] = aux[i];
	}
	
	private int indexOfMax(int position, int left, int right) {
		
		int maxIndex = position;
		
		if (left <= lastIndex && heap[maxIndex].compareTo(heap[left]) < 0)
			maxIndex = left;
		
		if (right <= lastIndex && heap[maxIndex].compareTo(heap[right]) < 0)
			maxIndex = right; 
		
		return maxIndex;
	}
	
	public int getSize() {
		return lastIndex + 1;
	}	

}