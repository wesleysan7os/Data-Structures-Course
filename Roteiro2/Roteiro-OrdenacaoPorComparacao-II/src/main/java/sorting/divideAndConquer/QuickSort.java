package sorting.divideAndConquer;

import java.util.Random;

import sorting.AbstractSorting;
import sorting.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm.
 * The algorithm chooses a pivot element and rearranges the elements of the
 * interval in such a way that all elements lesser than the pivot go to the
 * left part of the array and all elements greater than the pivot, go to the
 * right part of the array. Then it recursively sorts the left and the right parts.
 * Notice that if the list has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	public boolean statusRandom= false;
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			
			if (this.statusRandom == false) {
				trocaRandom(array, leftIndex, rightIndex);
				this.statusRandom = true;
			}
			
			int pivotIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex+1, rightIndex);
		}	
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		
		int i = leftIndex;
		int storeIndex = rightIndex - 1;
		T pivot = array[rightIndex];
		
		while(i <= storeIndex) {
			
			if(array[i].compareTo(pivot) <= 0) {
				i = i + 1;
			} else if (array[storeIndex].compareTo(pivot) >= 0) {
				storeIndex  = storeIndex - 1;
			} else {
				Util.swap(array, i, storeIndex);
			}
		}
			Util.swap(array, i, rightIndex);
			return i; 	
	}
	
	private void trocaRandom(T[] array, int leftIndex, int rightIndex) {
		Random gerador = new Random();
		int randomIndex = leftIndex - 1;
		do {			
			randomIndex = gerador.nextInt(rightIndex) + 1;
		} while (randomIndex < leftIndex);
		
		Util.swap(array, 0, randomIndex);
	}
		
}
