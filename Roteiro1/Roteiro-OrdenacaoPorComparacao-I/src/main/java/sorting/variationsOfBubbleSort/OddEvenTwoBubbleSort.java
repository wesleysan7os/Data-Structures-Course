package sorting.variationsOfBubbleSort;

import sorting.AbstractSorting;
import sorting.Util;

public class OddEvenTwoBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		boolean sorted = false;
		
		while(!sorted) {

			sorted = true;
			
			for (int i = leftIndex+1; i <= rightIndex; i+=2) {
				if(array[i].compareTo(array[i-1]) < 0) {
					Util.swap(array, i, i-1);
					sorted = false;
				}
			}
			
			for (int i = leftIndex+2; i <= rightIndex; i+=2) {
				if (array[i].compareTo(array[i-1]) < 0) {
					Util.swap(array, i, i-1);
					sorted = false;
				}
			}
			
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		System.out.println("\n===\n");
		
	}

}
