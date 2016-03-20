package sorting.variationsOfBubbleSort;

import sorting.AbstractSorting;
import sorting.Util;

public class OddEvenOneBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		boolean sorted = false;
		
		while(!sorted) {
			
			sorted = true;
			
			for (int i = leftIndex+1; i <= rightIndex; i++) {
				
				// compare with odd index
				if (i%2==0) {
					if(array[i].compareTo(array[i-1]) == -1) {
						Util.swap(array, i, i-1);
						sorted = false;
					}
				}
				
				// compare with even index
				else {
					if (array[i].compareTo(array[i-1]) == -1) {
						Util.swap(array, i, i-1);
						sorted = false;
					}
				}
				
			} // end for
			
		} 
		
	} // end sort

}