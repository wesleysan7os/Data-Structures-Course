package sorting.test;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.RadixSort;

public class RadixSortTests {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	
	Integer[] list;
	Integer[] list2;
	Integer[] list3;
	RadixSort radix;
	
	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] {0, 329, 457, 657, 839, 436, 720, 355});
		populaVetorTamanhoImpar(new Integer[] {329, 457, 657, 839, 436, 720, 355});
		populaVetorRepetido(new Integer[] {4, 9, 3, 4, 0, 5, 1, 4});
		populaVetorIgual(new Integer[] {6, 6, 6, 6, 6, 6});
		
		list = new Integer[] { 8, 4, 7, 1 };
		list2 = new Integer[] { 21, 23, 2, 34, 245, 33, 66 };
		list3 = new Integer[] { 6, 5, 1, 3, 8, 4, 7, 9, 2 };
		radix = new RadixSort();
		
		getImplementation();
	}
	
	//// MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação do aluno
	 */
	private void getImplementation() {
		this.implementation = new RadixSort();
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
	public void test() {

		radix.sort(list);
		Integer[] x = { 1, 4, 7, 8 };
		Assert.assertArrayEquals(x, list);

		radix.sort(list2);
		Integer[] x2 = { 2, 21, 23, 33, 34, 66, 245 };
		Assert.assertArrayEquals(x2, list2);

		radix.sort(list3);
		Integer[] x3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertArrayEquals(x3, list3);

	}
	
	private static boolean isSorted(Integer[] v) {
		for (int i = 0; i < v.length - 1; i++)
			if (v[i] > v[i + 1])
				return false;
		return true;
	}

	@Test
	public void testRandom() {

		Random random = new Random();
		
		for (int i = 0; i <= 10; i++) {
			Integer[] v = new Integer[i];
			for (int j = 0; j < i; j++)
				v[j] = random.nextInt(1010);
			//System.out.println(Arrays.toString(v));
			radix.sort(v);
			//System.out.println(Arrays.toString(v));
			Assert.assertTrue(isSorted(v));
		}

	}

}

