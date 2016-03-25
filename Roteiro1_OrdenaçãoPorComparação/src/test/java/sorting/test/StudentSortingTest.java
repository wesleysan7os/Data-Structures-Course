package sorting.test;

import java.text.Bidi;
import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubbleSort.BidirectionalBubbleSort;
import sorting.variationsOfBubbleSort.OddEvenOneBubbleSort;
import sorting.variationsOfBubbleSort.OddEvenTwoBubbleSort;
import sorting.variationsOfInsertionSort.ShellSort;
import sorting.variationsOfSelectionsort.BidirectionalSelectionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	
	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] {30, 28, 7, 29, 11, 26, 4, 22, 23, 31});
		populaVetorTamanhoImpar(new Integer[] {6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36});
		populaVetorRepetido(new Integer[] {4, 9, 3, 4, 0, 5, 1, 4});
		populaVetorIgual(new Integer[] {6, 6, 6, 6, 6, 6});
		
		getImplementation();
	}
	
	//// MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação do aluno
	 */
	private void getImplementation() {
		this.implementation = new ShellSort<Integer>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao){
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao){
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao){
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao){
		this.vetorValoresIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO
	
	//MÉTODOS DE TESTE
	
	public void genericTest(Integer[] array) {
		Integer[] copy1 = Arrays.copyOf(array, array.length);
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}
	
	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}
	
	//MÉTODOS QUE OS ALUNOS PODEM CRIAR 
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES ARGUMENTOS
	 * PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM SEGUIR A ESTRUTURA DOS
	 * MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS UMA PARTE DO ARRAY.
	 */

	@Test
	public void studentTest() {
		
		// GENERATE UNSORTED ARRAY WITH RANDOM NUMBERS
		Random generate = new Random();
		Integer[] array = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			int random = generate.nextInt(1000);
			array[i] = random;
		}
		
		// TEST FOR RANDOM BOUNDS 
		for (int i = 0; i < 1000; i++) {
			int left = generate.nextInt(1000);
			int right = generate.nextInt(1000);
			
			if (left < right)
				testBetweenBounds(array, left, right);
		}

	}
	
	public void testBetweenBounds(Integer[] array, int left, int right) {
		Integer[] copy1 = Arrays.copyOfRange(array, left, right);
		Integer[] copy2 = Arrays.copyOfRange(array, left, right);
		
		implementation.sort(copy1);
		Arrays.sort(copy2);
		Assert.assertArrayEquals(copy1, copy2);
	}
	
	@Test
	public void testUnitaryArray() {
		Integer[] array = new Integer[] {1};
		Integer[] copy = Arrays.copyOf(array, 1);
		
		implementation.sort(array);
		Arrays.sort(copy);
		Assert.assertArrayEquals(array, copy);
	}
	
}