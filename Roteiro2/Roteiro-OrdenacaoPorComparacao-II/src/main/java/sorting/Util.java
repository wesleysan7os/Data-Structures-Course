package sorting;

/**
 * Class containing useful methods for arrays manipulation.
 */
public class Util {
	
	/**
	 * Swaps the contents of two positions in an array.
	 *
	 * @param array  The array to be modified, not null
	 * @param i  One of the target positions
	 * @param j  The other target position
	 */
	public static void swap(Object[] array, int i, int j) {
		if(array == null)
			throw new IllegalArgumentException();

		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * Creates a generic array of the specified size. <p>
	 * Ex.: {@code Util.<Integer>makeArray(10);}
	 *
	 * @param size  The desired size
	 * @return An array of the type and size chosen
	 */
	public static <T> T[] makeArray(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}