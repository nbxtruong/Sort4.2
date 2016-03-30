package sort;

import java.util.Comparator;

// This class has been rewrited using lambda expressions instead internal anonymous classes.
public class Comparators {
	public static <T> Comparator<T> lexicographic(final Comparator<T> comp1, final Comparator<T> comp2) {
		return (T t1, T t2) -> {
			int resultComp1 = comp1.compare(t1, t2);
			return resultComp1 == 0 ? comp2.compare(t1, t2) : resultComp1;
		};
	}

	public static <T> Comparator<T> reverse(final Comparator<T> comp) {
		return (T t1, T t2) -> -comp.compare(t1, t2);
	}

	public static <T extends Comparable<? super T>> Comparator<T> trivialComparator() {
		return (T t1, T t2) -> t1.compareTo(t2);
	}
}
