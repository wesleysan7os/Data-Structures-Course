package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import sorting.Util;

/**
 * This algorithm simulates a logical partitioning of the input array by considering 
 * different indexing, that is, the first sub-array is indexed by even elements and
 * the second sub-array is indexed by odd elements. Then, it applies a complete bubblesort
 * in the first sub-array considering neighbours (even). After that, 
 * it applies a complete bubblesort in the second sub-array considering
 * neighbours (odd).  After that, the algorithm performs a merge between elements indexed
 * by even and odd numbers.
 */
public class OddEvenBubbleSort<T extends Comparable<T>> extends AbstractSorting<T>{
	
	
	@Override
	public void sort(T[] array,int leftIndex, int rightIndex) {

		bubble(array, leftIndex, rightIndex);
		merge(array, leftIndex, rightIndex);
				
	}
	
	private void bubble(T[] array,int leftIndex, int rightIndex) {

		boolean sorted = false;
				
		while(!sorted) {
			
			sorted = true;
			
			for (int j = leftIndex + 2; j <= rightIndex; j = j + 1) {	
		
				// Compara Pares
				if(j % 2 == 0) {
					
					if(array[j-2].compareTo(array[j]) == 1) {
						Util.swap(array, j, j-2);
						sorted = false;
					}
					
				} else {
					
					if(array[j-2].compareTo(array[j]) == 1) {
						Util.swap(array, j, j-2);
						sorted = false;
					}
					
				} // fecha bloco if
			} 
		} //fecha while sorted
	}
	
	private void merge(T[] array,int leftIndex, int rightIndex) {
	
		T[] aux = Util.makeArray(rightIndex - leftIndex + 1);
		
		int oddIndex = leftIndex;
		int evenIndex = leftIndex + 1;
		int auxIndex = leftIndex;
		
		while (oddIndex <= rightIndex && evenIndex <= rightIndex) {	
			// se ímpar for menor
			if(array[evenIndex].compareTo(array[oddIndex]) == -1) {
				aux[auxIndex] = array[evenIndex];
				evenIndex = evenIndex + 2;
				auxIndex = auxIndex + 1;
			} else { // se par for menor ou igual
				aux[auxIndex] = array[oddIndex];
				oddIndex = oddIndex + 2;
				auxIndex = auxIndex + 1;
			}
		} // fecha while
		
		while(oddIndex <= rightIndex) {
			aux[auxIndex] = array[oddIndex];
			oddIndex = oddIndex + 2;
			auxIndex = auxIndex + 1;
		}
		
		while(evenIndex <= rightIndex) {
			aux[auxIndex] = array[evenIndex];
			evenIndex = evenIndex + 2;
			auxIndex = auxIndex + 1;
		}
		
		copy(array, aux, leftIndex, rightIndex);
		
	}

	private void copy(T[] array, T[] aux, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = aux[i];
		}
	}
	
}