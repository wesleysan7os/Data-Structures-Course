package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import sorting.Util;
public class RecursiveSelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas esse método sem 
	 * usar nenhum outro método auxiliar (exceto Util.swap(array,int,int)). Para isso, tente 
	 * definir o caso base do algoritmo e depois o caso indutivo, que reduz o problema para 
	 * uma entrada menor em uma chamada recursiva. Seu algoritmo deve ter complexidade quadrática
	 * O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		// stop condition
		if(array != null && array.length != 0 && rightIndex - leftIndex > 0) {

			/* take the first index as the index 
			 * of the shortest item just to initialize variable */
			int min = leftIndex;
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				/* if there is an item at the current abstract array that is shortter than  
				 * the current shortest, put its index as the index of the shortest number */
				if (array[i].compareTo(array[min]) < 0)
					min = i;
				
			} // end for
			
			// put the shortest item at the most leftIndex for the current abstract array
			Util.swap(array, min, leftIndex);
			
			/* recursive call to array from leftIndex+1 to rightIndex;
			 * it is know that before (inclusive) leftIndex all elements are already sorted. */
			sort(array, leftIndex + 1, rightIndex);
		}
	}
}