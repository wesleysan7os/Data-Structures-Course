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

	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (rightIndex > leftIndex) {
			int pivotIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex-1);
			sort(array, pivotIndex+1, rightIndex);
		}

	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		
		int i = leftIndex;
		int j = leftIndex + 1;
		int p = leftIndex;
		
		while (j <= rightIndex) {
			
			if (array[j].compareTo(array[p]) == -1) {
				i = i + 1;
				Util.swap(array, i, j);
			}
			 j = j + 1;
		}
		
		Util.swap(array, i, p);
		return i;
		
	}
	
}