package sorting.linearSorting;

import java.sql.Array;
import java.util.Arrays;

import sorting.AbstractSorting;

public class RadixSort extends AbstractSorting<Integer> {

	public static final int MAX_LEN = 10;
	Integer[] sorting;
	
	public RadixSort() {
		this.sorting = new Integer[MAX_LEN];
	}

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (array.length > 0) {
			
			Integer maxValue = getMaxValue(array, leftIndex, rightIndex);
			int lenMaxValue = maxValue.toString().toCharArray().length;
			int exp = 1;
			
			for (int v = 0; v < lenMaxValue; v++) {
				countingSort(array, leftIndex, rightIndex, exp);
				exp = exp*10;
			}
	
		} // enf if array.len >= 0
		
	}

	private void countingSort(Integer[] array, int leftIndex, int rightIndex, int exp) {

		Integer[] counting = new Integer[MAX_LEN];
		
		for (int i = 0; i < counting.length; i++) {
			counting[i] = 0;
		}
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			int key = (array[i] / exp) % 10;
			counting[key] = counting[key]+1;
		}
		
		for (int i = leftIndex+1; i < MAX_LEN; i++) {
			counting[i] = counting[i] + counting[i-1];
		}
		
		for (int i = rightIndex; i >= 0; i--) {
			int key = (array[i] / exp) % 10;
			this.sorting[--counting[key]] = array[i];
		}
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = this.sorting[i];
		}
		
	}
	
	private int getMaxValue(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];
		for (int i = leftIndex+1; i <= rightIndex; i++) {
			if (array[i] > max){
				max = array[i];
			}
		}
		return max;
	}

}
