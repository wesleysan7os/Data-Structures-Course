package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest {
	
	private DoubleLinkedList<Integer> lista1;
	private DoubleLinkedList<Integer> lista2;
	private DoubleLinkedList<Integer> lista3;
	
	@Before
	public void setUp() throws Exception {

		getImplementations();
		
		// Lista com 3 elementos.
		lista1.insert(1);
		lista1.insert(2);
		lista1.insert(3);

		
		// Lista com 1 elemento.
		lista3.insert(1);
	}
	
	private void getImplementations(){
		lista1 = new DoubleLinkedListImpl();
		lista2 = new DoubleLinkedListImpl();
		lista3 = new DoubleLinkedListImpl();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertTrue(lista2.isEmpty());
		
		Assert.assertFalse(lista3.isEmpty());
		
		lista3.removeLast();
		Assert.assertTrue(lista3.isEmpty());
		
		lista3.insert(1);
		Assert.assertFalse(lista3.isEmpty());
		lista3.removeFirst();
		Assert.assertTrue(lista3.isEmpty());
		lista3.insert(1);
		Assert.assertFalse(lista3.isEmpty());
		lista3.remove(1);
		Assert.assertTrue(lista3.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertTrue(lista1.size() == 3);
		Assert.assertTrue(lista2.size() == 0);
		Assert.assertTrue(lista3.size() == 1);
		
		lista3.removeLast();
		Assert.assertTrue(lista3.size() == 0);
		
		lista3.insert(1);
		lista3.removeFirst();
		Assert.assertTrue(lista3.size() == 0);
		
		lista3.insert(1);
		lista3.remove(1);
		Assert.assertTrue(lista3.size() == 0);
		
		lista3.insertFirst(1);
		Assert.assertTrue(lista3.size() == 1);
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(lista1.search(1) == 1);
		Assert.assertTrue(lista1.search(2) == 2);
		Assert.assertTrue(lista1.search(3) == 3);
		Assert.assertTrue(lista1.search(4) == null);
		
		lista1.removeLast();
		Assert.assertTrue(lista1.search(3) == null);
		
		lista1.removeFirst();
		Assert.assertTrue(lista1.search(1) == null);
		
		Assert.assertTrue(lista2.search(1) == null);
		
		Assert.assertTrue(lista3.search(1) == 1);
	}

	@Test
	public void testInsert() {
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insert(1);
		Assert.assertTrue(lista2.size() == 1);
		
		lista2.remove(1);
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insert(null);
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insert(1);
		Assert.assertTrue(lista2.size() == 1);
		
		//#--------------------------------------------
		
		DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<Integer>();
		
		Assert.assertTrue(list.size == 0);
		
		list.insert(1);
		Assert.assertTrue(list.getHead().getData() == 1);
		Assert.assertTrue(list.last.getData() == 1);
		
		list.removeFirst();
		Assert.assertTrue(list.size == 0);
		
		list.insert(0);
		Assert.assertTrue(list.getHead().getData() == 0);
		Assert.assertTrue(list.last.getData() == 0);
		
		list.insert(1);
		Assert.assertTrue(list.last.getData() == 1);
		
		list.insert(2);
		Assert.assertTrue(list.last.getData() == 2);
		
		Assert.assertTrue(list.last.next.getData() == null);
		Assert.assertTrue(list.last.previous.getData() == 1);
		
		
	}

	@Test
	public void testRemove() {
		Assert.assertTrue(lista1.size() == 3);
		
		lista1.remove(1);
		Assert.assertTrue(lista1.size() == 2);
		
		lista1.remove(10);
		Assert.assertTrue(lista1.size() == 2);
		
		lista1.remove(null);
		Assert.assertTrue(lista1.size() == 2);
		
		lista1.remove(2);
		Assert.assertTrue(lista1.size() == 1);
		
		lista1.remove(3);
		Assert.assertTrue(lista1.size() == 0);
		
		//#---------------------------------------------------
		
		DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<Integer>();
		Assert.assertTrue(list.size == 0);
		
		list.insert(0);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		
		list.remove(2);
		Assert.assertTrue( list.head.next.next.getData() == 3 );
		Assert.assertTrue( list.last.previous.getData() == 1 );
		
		list.remove(0);
		Assert.assertTrue(list.head.getData() == 1);
		
		list.remove(3);
		Assert.assertTrue(list.last.getData() == 1);
		Assert.assertTrue(list.head.getData() == 1);
		Assert.assertTrue(list.last.previous.getData() == null);
		Assert.assertTrue(list.head.next.getData() == null);
		
		
		list.remove(1);
		Assert.assertTrue(list.last.getData() == null);
		Assert.assertTrue(list.head.getData() == null);
	
		//#---------------------------------------------------
		
		list = new DoubleLinkedListImpl<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		
		list.remove(1);
		Assert.assertTrue(list.getHead().getData() == 2);
		
		list.insertFirst(1);
		
		list.remove(3);
		Assert.assertTrue(list.head.getData() == 1);
		Assert.assertTrue(list.last.getData() == 2);
		
		list.insert(3);
		
		list.remove(2);
		Assert.assertTrue(list.head.getData() == 1);
		Assert.assertTrue(list.last.getData() == 3);
		
	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[]{1, 2, 3}, lista1.toArray());
		Assert.assertArrayEquals(new Integer[]{}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[]{1}, lista3.toArray());
		
		lista2.insert(1);
		Assert.assertArrayEquals(new Integer[]{1}, lista2.toArray());
		
		lista2.remove(1);
		Assert.assertArrayEquals(new Integer[]{}, lista2.toArray());
		
		lista3.removeFirst();
		Assert.assertArrayEquals(new Integer[]{}, lista3.toArray());
		
		lista3.insertFirst(1);
		Assert.assertArrayEquals(new Integer[]{1}, lista3.toArray());
		lista3.removeLast();
		Assert.assertArrayEquals(new Integer[]{}, lista3.toArray());
	}
	
	// Métodos de DoubleLinkedList
	
	@Test
	public void testInsertFirst(){

		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insertFirst(1);
		Assert.assertTrue(lista2.size() == 1);
		
		lista2.remove(1);
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insertFirst(null);
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insertFirst(1);
		Assert.assertTrue(lista2.size() == 1);
				
		lista2.insertFirst(0);
		Assert.assertTrue(lista2.size() == 2);
		
		//#---------------------------------------------------
		
		DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<Integer>();
		
		Assert.assertTrue(list.size == 0);
		
		list.insertFirst(0);
		Assert.assertTrue(list.getHead().getData() == 0);
		
		list.insertFirst(1);
		Assert.assertTrue(list.last.getData() == 0);
		Assert.assertTrue(list.getHead().getData() == 1);
		
		list.insertFirst(2);
		Assert.assertTrue(list.last.getData() == 0);
		Assert.assertTrue(list.getHead().getData() == 2);
		
	}

	@Test
	public void testRemoveFirst(){
		DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<Integer>();
		
		Assert.assertTrue(list.size == 0);
		
		list.insertFirst(0);
		Assert.assertTrue(list.getHead().getData() == 0);
		
		list.insertFirst(1);
		Assert.assertTrue(list.last.getData() == 0);
		Assert.assertTrue(list.getHead().getData() == 1);
		
		list.insertFirst(2);
		Assert.assertTrue(list.last.getData() == 0);
		Assert.assertTrue(list.getHead().getData() == 2);
		
		list.removeFirst();
		Assert.assertTrue(list.head.getData() == 1);
		Assert.assertTrue(list.head.next.getData() == 2);
		Assert.assertTrue(list.last.previous.previous.getData() == null);
		
		Assert.assertTrue(list.size == 2);
		
		list.removeFirst();
		Assert.assertTrue(list.head.getData() == 0);
		Assert.assertTrue(list.head.next.getData() == null);
		Assert.assertTrue(list.last.previous.getData() == null);
		
		list.removeLast();
		Assert.assertTrue(list.last.getData() == null);
		Assert.assertTrue(list.head.getData() == null);
		
	}
	
	@Test
	public void testRemoveLast(){

		DoubleLinkedListImpl<Integer> list = new DoubleLinkedListImpl<Integer>();
		
		Assert.assertTrue(list.size == 0);
		
		list.insertFirst(0);
		Assert.assertTrue(list.getHead().getData() == 0);
		
		list.insertFirst(1);
		Assert.assertTrue(list.last.getData() == 0);
		Assert.assertTrue(list.getHead().getData() == 1);
		
		list.insertFirst(2);
		Assert.assertTrue(list.last.getData() == 0);
		Assert.assertTrue(list.getHead().getData() == 2);
		
		list.removeLast();
		Assert.assertTrue(list.last.getData() == 1);
		Assert.assertTrue(list.last.next.getData() == null);
		Assert.assertTrue(list.last.previous.getData() == 2);
		
		Assert.assertTrue(list.size == 2);
		
		list.removeLast();
		Assert.assertTrue(list.last.getData() == 2);
		Assert.assertTrue(list.last.next.getData() == null);
		Assert.assertTrue(list.last.previous.getData() == null);
		
		list.removeLast();
		Assert.assertTrue(list.last.getData() == null);
		Assert.assertTrue(list.head.getData() == null);
		
	}
	
}