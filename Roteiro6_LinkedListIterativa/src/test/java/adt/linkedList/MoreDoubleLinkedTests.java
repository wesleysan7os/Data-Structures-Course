package adt.linkedList;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoreDoubleLinkedTests {
	
	private DoubleLinkedList<Integer> lista1;
	private DoubleLinkedList<Integer> lista2;
	private DoubleLinkedList<Integer> lista3;
	
	@Before
	public void setUp() throws Exception {

		getImplementations();
		
		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		
		// Lista com 1 elemento.
		lista3.insert(1);
	}
	
	private void getImplementations(){
		//TODO O aluno deve ajustar aqui para instanciar sua implementaÃ§Ã£o
		lista1 = new DoubleLinkedListImpl<>();
		lista2 = new DoubleLinkedListImpl<>();
		lista3 = new DoubleLinkedListImpl<>();
	}

	@Test
	public void testIsEmpty() {
		assertFalse(lista1.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(3, lista1.size());
		assertEquals(0, lista2.size());
		assertEquals(1, lista3.size());
	}

	@Test
	public void testSearch() {
		assertEquals(2, lista1.search(2).intValue());
		assertEquals(1, lista1.search(1).intValue());
		assertEquals(3, lista1.search(3).intValue());
		assertEquals(1, lista3.search(1).intValue());
		assertEquals(null, lista2.search(2));
	}

	@Test
	public void testInsert() {
		lista2.insert(1);
		assertEquals(1, lista2.search(1).intValue());
		assertEquals(null, lista2.search(2));
	}

	@Test
	public void testRemove() {
		lista1.remove(2);
		assertEquals(null, lista1.search(2));
		lista1.remove(null);
		assertEquals(null, lista1.search(2));
	}

	@Test
	public void testToArray() {
		Integer[] array = new Integer[3];
		array[0] = 3;
		array[1] = 2;
		array[2] = 1;
		
		lista2.insert(3);
		lista2.insert(2);
		lista2.insert(1);

		assertArrayEquals(lista2.toArray(), array);
	}
	
	// Metodos de DoubleLinkedList
	
	@Test
	public void testInsertFirst(){
		lista2.insertFirst(1);
		lista2.insertFirst(2);
		lista2.insertFirst(3);
	}

	@Test
	public void testRemoveFirst(){
		lista2.insertFirst(1);
		lista2.insertFirst(2);
		lista2.insertFirst(3);
		assertEquals(3, lista2.search(3).intValue()); // o 3 ainda ta aqui.
		lista2.removeFirst(); //remover o 3
		assertEquals(null, lista2.search(3));
	}
	
	@Test
	public void testRemoveLast(){
		lista2.insertFirst(1);
		lista2.insertFirst(2);
		lista2.insertFirst(3);
		lista2.removeLast(); //remover o 1.
	}
	
	@Test
	public void testRemoveDouble(){
		lista2.insertFirst(1);
		lista2.insertFirst(2);
		lista2.insertFirst(3); //cabeca
		
		lista2.remove(2);
		assertEquals(null, lista2.search(2));
		
		
	}
	
	@Test
	public void testToArrayDouble(){

		Integer[] arrayDouble = new Integer[3];
		arrayDouble[0] = 3;
		arrayDouble[1] = 2;
		arrayDouble[2] = 1;
		
		lista2.insertFirst(1);
		lista2.insertFirst(2);
		lista2.insertFirst(3);
		
		assertArrayEquals(lista2.toArray(), arrayDouble);
	}
}