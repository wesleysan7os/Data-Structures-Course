package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;

/**
 * This selection sort variation has two internal iterations. In the first, it takes the
 * smallest elements from the array, and puts it in the first position. In the second,
 * the iteration is done backwards, that is, from right to left, and this time the biggest
 * element is selected and stored in the last position. Then it repeats the process,
 * excluding the positions already filled in, until the whole array is ordered.
 */
public class BidirectionalSelectionSort<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex < 0) {
			throw new RuntimeException("LeftIndex menor que 0.");
		} else if (rightIndex > array.length) {
			throw new RuntimeException("RightIndex maior que o tamanho do array: " + array.length);
		}
		
		while(rightIndex >= leftIndex) {
			int min = leftIndex;
			int max = rightIndex;
			for (int i = leftIndex; i <= rightIndex; i++) {
				if ( array[i].compareTo(array[min]) == - 1 ) {
					min = i;
				}				
			}
			
			sorting.Util.swap(array, leftIndex, min);
			
			for (int i = rightIndex; i > leftIndex; i--) {
				if ( array[i].compareTo(array[max]) == 1 ) {
					max = i;
				}
			}
			
			{sorting.Util.swap(array, rightIndex, max);
			
			}
			leftIndex+=1;
			rightIndex-=1;
			
			} // fecha while		
	}
	
}