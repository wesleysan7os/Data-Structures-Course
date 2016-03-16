package sorting.linearSorting;

import java.sql.Array;
import java.util.Arrays;

import sorting.AbstractSorting;

public class RadixSort extends AbstractSorting<Integer> {

	public static final int MAX_LEN = 10;
	Integer[] sorting;
	Integer[] counting;
	
	public RadixSort() {
		this.sorting = new Integer[MAX_LEN];
	}

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (array.length > 0) {
			
			Integer lenMax = getMaxValue(array, leftIndex, rightIndex).toString().toCharArray().length;
			int exp = 1;
			
			for (int v = 0; v < lenMax; v++) {
				countingSort(array, leftIndex, rightIndex, exp);
				exp = exp*10;
			}
	
		} // end if array.len >= 0
		
	}

	private void countingSort(Integer[] array, int leftIndex, int rightIndex, int exp) {

		this.counting = new Integer[MAX_LEN];
		resetArray(counting);
		
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
		
		for (int i = rightIndex; i >= leftIndex; i--) {
			int key = (array[i] / exp) % 10;
			this.sorting[--counting[key]] = array[i];
		}
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = this.sorting[i];
		}
		
	}
	
	private Integer getMaxValue(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];
		for (int i = leftIndex+1; i <= rightIndex; i++) {
			if (array[i] > max){
				max = array[i];
			}
		}
		return max;
	}
	
	public void resetArray(Integer[] array) {
		for (int i = 0; i < MAX_LEN; i++) {
			array[i] = 0;
		}
	}
	

}
