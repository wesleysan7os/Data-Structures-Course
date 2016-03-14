package sorting.variations;

import java.util.Arrays;

import sorting.AbstractSorting;
import sorting.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do MergeSort 
 * que pode fazer uso do InsertionSort (um algoritmo híbrido) da seguinte forma: 
 * o MergeSort é aplicado a entradas maiores a um determinado limite. Caso a entrada 
 * tenha tamanho menor ou igual ao limite o algoritmo usa o InsertionSort. 
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de 
 *   forma que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada
 *   chamada interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e 
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 *  - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
    
	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;
	public boolean firstCall = true;
	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		resetValues();
				
		if (rightIndex - leftIndex > SIZE_LIMIT) {
			int mid = leftIndex + (rightIndex - leftIndex) / 2;
			sort(array, leftIndex, mid);
			sort(array, mid+1, rightIndex);
			merge(array, leftIndex, mid, rightIndex);
		} else {
			insertionSort(array, leftIndex, rightIndex);			
		}
	}
	
	public void insertionSort(T[] array, int leftIndex, int rightIndex) {
	
		INSERTIONSORT_APPLICATIONS++;
		
		for (int i = leftIndex+1; i <= rightIndex; i++) {
			
			T key = array[i];
			int j = i;
			
			while (j > leftIndex && key.compareTo(array[j-1]) == -1) {
				array[j] = array[j-1];
				j = j - 1;
			}
			
			array[j] = key;
		}
		
	}
	
	public void merge(T[] array, int leftIndex, int mid, int rightIndex) {
	
		T[] aux = Arrays.copyOf(array, array.length);
		
		int i = leftIndex;
		int j = mid + 1;
		int k = leftIndex;
				
		while (i <= mid && j <= rightIndex) {
			if (aux[i].compareTo(aux[j]) == -1) {
				array[k] = aux[i];
				i++;
				k++;
			} else {
				array[k] = aux[j];
				j++;
				k++;
			}
		}
		
		while (i <= mid) {
			array[k] = aux[i];
			i++;
			k++;
		}
		
		while (j <= rightIndex) {
			array[k] = aux[j];
			j++;
			k++;
		}
	}
	
	private void resetValues() {
		if (firstCall == true) {
			MERGESORT_APPLICATIONS = 0;
			INSERTIONSORT_APPLICATIONS = 0;
			this.firstCall = false;
		}
	}
	

}