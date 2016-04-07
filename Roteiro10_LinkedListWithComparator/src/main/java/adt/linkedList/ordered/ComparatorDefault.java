package adt.linkedList.ordered;

import java.util.Comparator;

public class ComparatorDefault<T extends Comparable> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if (o1.compareTo(o2) > 0) {
			return 1;
		} else if (o1.compareTo(o2) == 0) {
			return 0;
		} else {
			return -1;
		}
	}
	
}
