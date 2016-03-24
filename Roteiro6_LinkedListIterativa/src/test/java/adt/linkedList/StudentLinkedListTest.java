package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedListTest {
	
	private LinkedList<Integer> lista1;
	private LinkedList<Integer> lista2;
	
	@Before
	public void setUp() throws Exception {
		
		getImplementations();
		
		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);
		
	}
	
	private void getImplementations(){
		lista1 = new SingleLinkedListImpl();
		lista2 = new SingleLinkedListImpl();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		
		lista1.remove(1);
		lista1.remove(2);
		lista1.remove(3);
		Assert.assertTrue(lista1.isEmpty());
		
		Assert.assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertTrue(lista1.size() == 3);
		
		lista1.remove(1);
		lista1.remove(2);
		lista1.remove(3);
		Assert.assertTrue(lista1.size() == 0);
		
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insert(1);
		Assert.assertTrue(lista2.size() == 1);
		
		lista2.remove(1);
		Assert.assertTrue(lista2.size() == 0);
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(lista1.search(1) == 1);
		Assert.assertTrue(lista1.search(2) == 2);
		Assert.assertTrue(lista1.search(3) == 3);
		Assert.assertTrue(lista1.search(4) == null);
		
		Assert.assertTrue(lista2.search(1) == null);
	}

	@Test
	public void testInsert() {
		lista2.insert(10);
		Assert.assertTrue(lista2.size() == 1);

		lista1.insert(10);
		Assert.assertTrue(lista1.size() == 4);

		lista1.insert(null);
		Assert.assertTrue(lista1.size() == 4);
	}
	
	@Test
	public void testInsertComparative() {
		Integer[] array = new Integer[50];
		int j;
		for(j = 0; j < 50; j++){
			lista2.insert(j);
			array[j] = j;
			Assert.assertTrue(lista2.search(j).equals(j));
		}
		for(int i = 0; i < array.length; i++){
			Assert.assertEquals(lista2.search(i), array[i]);
		}
		
	}

	@Test
	public void testRemove() {
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

		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		lista2.remove(2);
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
	}
	
	@Test
	public void testRemoveComparative() {
		Integer[] array = new Integer[10];
		int j;
		for(j = 0; j < 10; j++) {
			lista2.insert(j);
			Assert.assertTrue(lista2.search(j).equals(j));
		}
		
		for(int i = 0; i < 5; i++) {
			lista2.remove(i);
			Assert.assertFalse(new Integer(i).equals(lista2.search(i)));
		}
		
		for(int i = 9; i > 5; i--) {
			lista2.remove(i);
			Assert.assertFalse(new Integer(i).equals(lista2.search(i)));
		}
		
		lista2.remove(5);
		Assert.assertTrue(lista2.isEmpty());
		
	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[]{3,2,1}, lista1.toArray());
		
		Assert.assertArrayEquals(new Integer[]{}, lista2.toArray());
		
		lista2.insert(1);
		Assert.assertArrayEquals(new Integer[]{1}, lista2.toArray());
		
		lista2.remove(1);
		Assert.assertArrayEquals(new Integer[]{}, lista2.toArray());
	}

	
	// ## TESTS ON STREAMS ## -------------------
	
	@Test
	public void streamTest1() {
		LinkedList<Integer> array = new SingleLinkedListImpl<Integer>();
		Assert.assertTrue(array.isEmpty());
		Assert.assertEquals(array.size(), 0);
		array.insert(5);
		Assert.assertFalse(array.isEmpty());
		Assert.assertEquals(array.size(), 1);
	}
	
	@Test
	public void streamTest2() {
		LinkedList<Integer> vector = new SingleLinkedListImpl<Integer>();
		Integer[] array = new Integer[]{5, 3, 9};
		vector.insert(5);
		vector.insert(3);
		vector.insert(9);
		Assert.assertArrayEquals(array, vector.toArray());
	}
	
	@Test
	public void streamTest3() {
		LinkedList<Integer> array = new SingleLinkedListImpl<Integer>();
		array.insert(5);
		array.insert(3);
		array.insert(9);
		array.insert(12);
		array.remove(3);
		Assert.assertArrayEquals(new Integer[]{5, 9, 12}, array.toArray());
		Assert.assertFalse(array.isEmpty());
		Assert.assertEquals(array.size(), 3);
		array.remove(3);
		Assert.assertArrayEquals(new Integer[]{5, 9, 12}, array.toArray());
		Assert.assertEquals(array.size(), 3);
		array.remove(5);
		Assert.assertArrayEquals(new Integer[]{9, 12}, array.toArray());
		Assert.assertEquals(array.size(), 2);
		array.remove(9);
		Assert.assertArrayEquals(new Integer[]{12}, array.toArray());
		Assert.assertEquals(array.size(), 1);
		array.remove(12);
		Assert.assertEquals(array.size(), 0);
		Assert.assertTrue(array.isEmpty());
		Assert.assertArrayEquals(new Integer[]{}, array.toArray());
		array.remove(17);
		Assert.assertArrayEquals(new Integer[]{}, array.toArray());
	}
	
	@Test
	public void streamTest4() {
		LinkedList<String> array = new SingleLinkedListImpl<String>();
		array.insert("rafael");
		array.insert("lapis");
		array.insert("borracha");
		array.insert("papel");
		array.insert("regua");
		Assert.assertEquals(array.search("rafael"), "rafael");
		Assert.assertEquals(array.search("regua"), "regua");
		Assert.assertEquals(array.search("caneta"), null);	
	}
	
	@Test
	public void streamTest5() {
		SingleLinkedListImpl<Integer> testando = new SingleLinkedListImpl<Integer>();
		
		Assert.assertTrue(testando.size() == 0);
		Assert.assertTrue(testando.isEmpty());
		testando.insert(1);
		testando.insert(2);
		testando.insert(3);
		testando.insert(null);
		Assert.assertTrue(testando.size() == 3);
		Assert.assertFalse(testando.isEmpty());
		Assert.assertTrue(2 == testando.getHead().getNext().getData());
		Assert.assertTrue(testando.search(4) ==  null);
		Assert.assertTrue(testando.search(null) == null);
		Assert.assertTrue(testando.search(2) == 2);
		testando.remove(null);
		testando.remove(5);
		testando.remove(2);
		testando.insert(5);
		Assert.assertTrue(testando.size() == 3);
		Integer[] array = {1,3,5};
		Assert.assertArrayEquals( array , testando.toArray());
	}
	
	@Test
	public void streamTest6() {
		
		lista2 = new SingleLinkedListImpl();
		Integer[] array = {6,7,1,3,4,2,10};
		
		Assert.assertTrue(lista2.isEmpty());
		Assert.assertTrue(lista2.size()==0);
		lista2.insert(5);
		Assert.assertFalse(lista2.isEmpty());
		Assert.assertTrue(lista2.size()==1);
		Assert.assertTrue(lista2.search(6)==null);
		Assert.assertTrue(lista2.search(5)==5);
		lista2.insert(6);
		Assert.assertTrue(lista2.search(6)==6);
		Assert.assertTrue(lista2.search(7)==null);
		lista2.insert(7);
		Assert.assertTrue(lista2.search(7)==7);
		lista2.remove(5);
		Assert.assertTrue(lista2.search(5)==null);
		lista2.insert(1);
		lista2.insert(3);
		lista2.insert(4);
		lista2.insert(2);
		lista2.insert(10);
		
		Assert.assertArrayEquals(array, lista2.toArray());
	}
	
	@Test
	public void streamTest7() {
		lista2.insert(2);
		lista2.remove(1);
		Assert.assertFalse(lista2.isEmpty());
		lista2.remove(2);
		Assert.assertTrue(lista2.isEmpty());
		lista2.insert(2);
		lista2.insert(3);
		lista2.insert(5);
		lista2.remove(3);
		Integer[] array = {2,5};
		Assert.assertArrayEquals(array, lista2.toArray());
	}

	@Test
	public void streamTest8() {
		lista2.insert(2);
		lista2.insert(3);
		lista2.insert(5);
		Assert.assertTrue(lista2.search(2) == 2);
		Assert.assertTrue(lista2.search(3) == 3);
		lista2.remove(3);
		Assert.assertTrue(lista2.search(5) == 5);
		Assert.assertTrue(lista2.search(3) == null);
	}
	
	@Test
	public void streamTest9() {
		
		SingleLinkedListImpl<Integer> array = new SingleLinkedListImpl<Integer>();
		
		array.insert(1);
		array.insert(2);
		array.insert(3);
		Assert.assertTrue(array.size() == 3);
		
		array.remove(3);
		Assert.assertTrue(array.getHead().getData() == 1);
		Assert.assertTrue(array.getHead().getNext().getNext().getData() == null);
		
		array.remove(1);
		Assert.assertTrue(array.getHead().getData() == 2);
		
		
	}	
}