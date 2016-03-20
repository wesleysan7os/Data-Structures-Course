package sorting.variationsOfBubbleSort;

import javax.swing.AbstractAction;

import org.w3c.dom.views.AbstractView;

import sorting.AbstractSorting;
import sorting.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it pushes big
 * elements to the right, like the normal bubble sort does. Then in the second, iterates the
 * array backwards, that is, from right to left, while pushing small elements to the left.
 * This process is repeated until the array is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		for (int i = leftIndex; i <= rightIndex; i++) {
			
			for (int j = leftIndex; j < rightIndex; j++) {
				if (array[j].compareTo(array[j+1]) == 1) {
					Util.swap(array, j, j+1);
				}
			}
			
			for (int j = rightIndex; j > leftIndex; j--) {
				if (array[j].compareTo(array[j-1]) == -1) {
					Util.swap(array, j, j-1);
				}
			}	
			
		} // end mean for

	}

}
