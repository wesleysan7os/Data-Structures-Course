package sorting.simpleSorting;

import sorting.AbstractSorting;
import sorting.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T>{

	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < 0){
			throw new RuntimeException("LeftIndex menor que 0.");
		}else if(rightIndex > array.length){
			throw new RuntimeException("RightIndex maior que o tamanho do array: " + array.length);
		}
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			
			int min = leftIndex;
			
			for (int j = min + 1; j <= rightIndex; j++) {
				if ( array[min].compareTo(array[j]) == -1) {
					min = j;
				}
				
			Util.swap(array, min, j);
				
			} // fecha 2 for
		}
	} // fecha método
}
