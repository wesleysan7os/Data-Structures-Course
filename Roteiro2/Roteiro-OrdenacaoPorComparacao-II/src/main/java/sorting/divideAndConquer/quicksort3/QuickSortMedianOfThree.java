package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import sorting.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que funciona 
 * de forma ligeiramente diferente. Relembre que quando o pivô escolhido divide o 
 * array aproximadamente na metade, o QuickSort tem um desempenho perto do ótimo. 
 * Para aproximar a entrada do caso ótimo, diversas abordagens podem ser utilizadas. 
 * Uma delas é usar a mediana de 3 para achar o pivô. Essa técnica consiste no seguinte:
 * 1.	Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2.	Ordenar os elemento, tal que: A[left] < A[center] < A[right].
 * 3.	Adotar o A[center] como pivô.
 * 4.	Colocar o pivô na penúltima posição A[right-1].
 * 5.	Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6.	Aplicar o algoritmo na metade a esquerda e na metade a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T>{
    
	public void sort(T[] array, int leftIndex, int rightIndex){

		if (leftIndex < rightIndex) {
			
			medianaDeTres(array, leftIndex, rightIndex);
			changePivot(array, leftIndex, rightIndex);
			
			int pivotIndex = partition(array, leftIndex + 1, rightIndex - 1);
			
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);

		}
	}
	
	public void medianaDeTres(T[] array, int leftIndex, int rightIndex){
		
		int middle = leftIndex + (rightIndex - leftIndex) / 2;
		int minIndex = leftIndex;
		
		if (array[middle].compareTo(array[minIndex]) == -1) {
			minIndex = middle;
		}
		if (array[rightIndex].compareTo(array[minIndex]) == -1) {
			minIndex = rightIndex;	
		}
		
		Util.swap(array, leftIndex, minIndex);
		
		if (array[rightIndex].compareTo(array[middle]) == -1) {
			Util.swap(array, rightIndex, middle);
		}
				
	}
	
	public void changePivot(T[] array, int leftIndex, int rightIndex) {
		int pivotIndex = leftIndex + (rightIndex - leftIndex) / 2;
		Util.swap(array, pivotIndex, rightIndex - 1);
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
