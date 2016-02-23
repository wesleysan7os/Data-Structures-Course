package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < 0){
			throw new RuntimeException("LeftIndex menor que 0.");
		}else if(rightIndex > array.length){
			throw new RuntimeException("RightIndex maior que o tamanho do array: " + array.length);
		}
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			for (int j = leftIndex; j < rightIndex; j++) {
				if (array[j].compareTo(array[j+1]) == 1) {
					sorting.Util.swap(array, j, j+1);
				}
			} // fecha segundo for
		}
	}
	
}

