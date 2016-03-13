package sorting.variationsOfInsertionSort;

import sorting.AbstractSorting;

public class ShellSort<T extends Comparable<T>> extends AbstractSorting<T>{

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		int divider = (rightIndex-leftIndex)/2+1;
		while(divider > 0) {
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				
				T key = array[i];
				int j = i;
				
				while (j >= divider && key.compareTo(array[j-divider]) == -1) {
					array[j] = array[j - divider];
					j = j - divider;
				}
				array[j] = key;
				
			} // end for
			
			divider = divider / 2;
		}
		
	}

}
