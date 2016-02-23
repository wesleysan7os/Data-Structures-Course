package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < 0) {
			throw new RuntimeException("LeftIndex menor que 0.");
		} else if (rightIndex > array.length){
			throw new RuntimeException("RightIndex maior que o tamanho do array: " + array.length);
		}
		
		for (int i = leftIndex+1; i <= rightIndex; i++) {
			T key = array[i];
			int j = i;
			
			while( j > 0 && (key.compareTo(array[j-1]) == -1)) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = key;
		}
	}
}
