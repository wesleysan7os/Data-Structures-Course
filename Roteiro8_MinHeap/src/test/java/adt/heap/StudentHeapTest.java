package adt.heap;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentHeapTest {

	private GenericHeap<Integer> heap;
	private PriorityQueue<Integer> queue;
	
	@Before
	public void setUp() {
		getImplementations();
		
		heap.insert(2);
		
		Comparator<Integer> integerComparatorInvertido = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -(o1.compareTo(o2));
			}
		};
	/*		
	 * O aluno pode utilizar uma estrutura auxiliar no seus testes para verificar
	 * o funcionamento de sua heap. 
	 * Ver: https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
	 */
		queue = new PriorityQueue<Integer>(8, integerComparatorInvertido);
		queue = new PriorityQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
	}
	
	private void getImplementations(){
		heap = new MinHeapImpl<Integer>();
	}
	
	// Arrays que podem ser utilizados para o teste do HeapSort.
	// Nem todos os cenarios de testes são abordados com esses arrays.
	Integer[] vetorRepetido = {4, 4, 3, 4, 3, 1, 4};
	Integer[] vetorCrescente = {2, 3, 4, 5, 6, 7};
	Integer[] vetorDescrescente = {7, 6, 5, 4, 3, 2};

	@Test
	public void testHeapsort() {
		Assert.fail("Not implemented!");
	}
	
	@Test
	public void testIsEmpty() {
		assertFalse(heap.isEmpty());
		
		heap.extractRootElement();
		assertTrue(heap.isEmpty());
	}

	@Test
	public void testInsert() {
		assertEquals((Integer) 2, heap.rootElement());
		
		heap.insert(1);
		assertEquals((Integer) 1, heap.rootElement());
		
		heap.insert(null);
		assertEquals((Integer) 1, heap.rootElement());
	}

	@Test
	public void testExtractRootElement() {
		heap.insert(3);
		heap.insert(4);
		
		assertEquals((Integer) 2, heap.extractRootElement());
		assertEquals((Integer) 3, heap.rootElement());	
		
		heap.insert(5);
		heap.insert(6);
		assertEquals((Integer) 3, heap.extractRootElement());
		assertEquals((Integer) 4, heap.extractRootElement());
		assertEquals((Integer) 5, heap.extractRootElement());
		assertEquals((Integer) 6, heap.extractRootElement());
		
		assertNull(heap.extractRootElement());
		
		heap.insert(1);
		assertEquals((Integer) 1, heap.rootElement());
		
	}

	@Test
	public void testRootElement() {
		assertEquals((Integer) 2, heap.rootElement());
		
		MinHeap<Integer> heap_2 = new MinHeapImpl<Integer>();
		assertNull(heap_2.rootElement());
	}

	@Test
	public void testBuildHeap() {
		Integer[] heapVazia = {};
		Integer[] heapCrescente = {1, 2, 3, 4};
		
		heap.buildHeap(heapVazia);
		assertTrue(heap.isEmpty());
		
		heap.buildHeap(heapCrescente);
		assertFalse(heap.isEmpty());
		
		assertEquals((Integer) 1, heap.extractRootElement());
		assertEquals((Integer) 2, heap.extractRootElement());
		assertEquals((Integer) 3, heap.extractRootElement());
		assertEquals((Integer) 4, heap.extractRootElement());
		assertNull(heap.extractRootElement());
		
	}
}