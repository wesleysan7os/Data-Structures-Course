package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;
import sorting.Util;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure evitar desperdicio de 
 * memoria alocando o array de contadores com o tamanho sendo o máximo inteiro presente no array 
 * a ser ordenado.  
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	public CountingSort() {
		
	}
	
	@Override
	public void sort(Integer[] array,int leftIndex, int rightIndex) {
	
		if(array.length != 0) {
		
		Integer[] sortedArray = array.clone();
		
		int maxValueIndex = findmaxValueIndex(array, leftIndex, rightIndex);
		Integer[] countArray = new Integer[ array[maxValueIndex] + 1];
		
		for (int i = 0; i < countArray.length; i++) {
			countArray[i] = 0;
		}
		
		for (int i = leftIndex; i <= rightIndex; i++){		
			countArray[ array[i] ] = countArray[ array[i] ] + 1;
		}
		
		for (int i = 1; i <= array[maxValueIndex]; i++) {
			countArray[i] = countArray[i] + countArray[i-1];
		}
		
		for (int i = rightIndex; i >= leftIndex; i--) {
			sortedArray[ countArray[ array[i] ] -1 ] = array[i];
			countArray[ array[i] ] = countArray[ array[i] ]  - 1;
		}
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = sortedArray[i];
		}
		
		}
	}

	public int findmaxValueIndex(Integer[] array,int leftIndex, int rightIndex) {
		int maxValueIndex = leftIndex;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > array[maxValueIndex]) {
				maxValueIndex = i;
			}
		}
		return maxValueIndex;
	}

}
