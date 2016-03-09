package sorting.divideAndConquer;

import java.util.Random;

import sorting.AbstractSorting;
import sorting.Util;

public class RandomizedQuick<T extends Comparable<T>> extends AbstractSorting<T>{
	
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			int pivotIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex+1, rightIndex);
		}	
	}
	
	private void randomizedPartition(T[] array, int leftIndex, int rightIndex) {
		Random gerador = new Random();
		int randomIndex = rightIndex - leftIndex - 1;
		randomIndex = randomIndex  + gerador.nextInt(rightIndex);	
		Util.swap(array, 0, randomIndex);
		
		partition(array, leftIndex, rightIndex);
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
				
		int i = leftIndex;
		int storeIndex = rightIndex - 1;
		T pivot = array[rightIndex];
		
		while(i <= storeIndex) {
			
			if(array[i].compareTo(pivot) <= 0) {
				i = i + 1;
			} else if (array[storeIndex].compareTo(pivot) >= 0) {
				storeIndex  = storeIndex - 1;
			} else {
				Util.swap(array, i, storeIndex);
			}
		}
			Util.swap(array, i, rightIndex);
						
			return i;
			
	}
			
}