package sorting.test;


import java.util.Arrays;
import java.util.Random;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.linearSorting.BucketSort;

public class BucketSortTest {

	Integer[] list;
	Integer[] list2;
	Integer[] list3;
	BucketSort bucket;

	@Before
	public void before() {
		list = new Integer[] { 8, 4, 7, 1 };
		list2 = new Integer[] { 21, 23, 2, 34, 245, 33, 66 };
		list3 = new Integer[] { 6, 5 , 1, 3, 8, 4, 7, 9, 2};
		bucket = new BucketSort();
	}
	
	@Test
	public void test() {

		bucket.sort(list);
		Integer[] x = { 1, 4, 7, 8 };
		Assert.assertArrayEquals(x, list);

		bucket.sort(list2);
		Integer[] x2 = { 2, 21, 23, 33, 34, 66, 245 };
		Assert.assertEquals(x2, list2);
	
		
		bucket.sort(list3);
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
				v[j] = random.nextInt(1001);
			System.out.println(Arrays.toString(v));
			bucket.sort(v);
			System.out.println(Arrays.toString(v));
			Assert.assertTrue(isSorted(v));
		}

	}



}