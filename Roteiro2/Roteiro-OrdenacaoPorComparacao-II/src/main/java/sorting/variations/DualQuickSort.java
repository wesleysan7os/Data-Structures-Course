package sorting.variations;

import javax.swing.text.AbstractDocument.LeafElement;

import sorting.AbstractSorting;
import sorting.Util;

public class DualQuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (array == null || array.length == 0 || leftIndex > rightIndex) {
			return;
		}
		
		
		if(array[leftIndex].compareTo(array[rightIndex]) > 0)
			Util.swap(array, leftIndex, rightIndex);
		
		int pivotOne = leftIndex;
		int pivotTwo = rightIndex;
		
		int l = leftIndex;
		int r = rightIndex;
		int k = leftIndex+1;
		
		while (k < r) {
			
			if (array[k].compareTo(array[pivotOne]) < 0) {				
				l++;
				Util.swap(array, k, l);
				k++;
			} else if (array[k].compareTo(array[pivotTwo]) > 0) {
				r--;
				Util.swap(array, k, r);
			} else {
				k++;
			}
		} // end while

		Util.swap(array, l, pivotOne);
		Util.swap(array, r, pivotTwo);
		
		sort(array, leftIndex, l - 1);
		sort(array, l + 1, r - 1);
		sort(array, r + 1, rightIndex);
		
	}

	
	
}