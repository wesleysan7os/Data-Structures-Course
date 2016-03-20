package sorting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.Array;

import sorting.linearSorting.CountingSort;


public class CountingSortTest {

	Integer[] list;
	Integer[] list2;
	Integer[] list3;
	CountingSort counting;

	@Before
	public void before() {
		list = new Integer[] { 8, 4, 7, 1 };
		list2 = new Integer[] { 21, 23, 2, 34, 245, 33, 66 };
		list3 = new Integer[] { 6, 5 , 1, 3, 8, 4, 7, 9, 2};
		counting = new CountingSort();
	}
	
	@Test
	public void test() {

		counting.sort(list,0, 3);
		Integer[] x = { 1, 4, 7, 8 };
		Assert.assertArrayEquals(x, list);
		

		counting.sort(list2, 0, 6);
		Integer[] x2 = { 2, 21, 23, 33, 34, 66, 245 };
		Assert.assertArrayEquals(x2, list2);
		
		
		counting.sort(list3, 0, list3.length-1);
		Integer[] x3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertArrayEquals(x3, list3);
	
	}

}