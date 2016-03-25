package sorting.divideAndConquer;

import sorting.AbstractSorting;
import sorting.Util;

/**
 * Merge sort is based on the divide-and-conquer paradigm.  
 * The algorithm consists of recursively dividing the unsorted list in the middle,
 * sorting each sublist, and then merging them into one single sorted list.
 * Notice that if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array,int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, mid);
			sort(array, mid+1, rightIndex);
			merge(array, leftIndex, mid, rightIndex);
		}
	}
	
	public void merge(T[] array, int leftIndex, int med, int rightIndex) {
		T helper[] = Util.<T>makeArray(array.length);
		for (int i = 0; i < helper.length; i++) {
			helper[i] = array[i];
		}
		
		int i = leftIndex;
		int k = leftIndex;
		int j = med + 1;
		
		while (i <= med && j <= rightIndex) {
			if (helper[i].compareTo(helper[j]) == - 1) {
				array[k] = helper[i];
				i = i + 1;
				k = k + 1;
			} else {
				array[k] = helper[j];
				j = j + 1;
				k = k + 1;
			}
			
		} // fecha while
			
			while(i <= med) {
				array[k] = helper[i];
				k = k + 1;
				i = i + 1;
			}
			
			while(j <= rightIndex) {
				array[k] = helper[j];
				k = k + 1;
				j = j +1;
			}
	}
}

