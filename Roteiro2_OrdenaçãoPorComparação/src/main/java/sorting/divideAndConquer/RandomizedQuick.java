package sorting.divideAndConquer;

import java.util.Random;

import sorting.AbstractSorting;
import sorting.Util;

public class RandomizedQuick<T extends Comparable<T>> extends AbstractSorting<T>{
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex > leftIndex) {
			int pivotIndex = randomizedPartition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex-1);
			sort(array, pivotIndex+1, rightIndex);
		}
	}
	
	private int randomizedPartition(T[] array, int leftIndex, int rightIndex) {
		Random gerador = new Random();
		int randomIndex = leftIndex + gerador.nextInt(rightIndex - leftIndex + 1);
		Util.swap(array, leftIndex, randomIndex);
		return partition(array, leftIndex, rightIndex);
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
				
		int i = leftIndex;
		int j = leftIndex + 1;
		int p = leftIndex;
		
		while (j <= rightIndex) {
			
			if (array[j].compareTo(array[p]) == -1) {
				i = i + 1;
				Util.swap(array, i, j);
			}
			 j = j + 1;
		}
		
		Util.swap(array, i, p);
		return i;
	}
			
}