package Lab7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
        while ( iter.hasNext()){
            T next = iter.next();
            if ( p.test(next)){
                iter.remove();
            }
        }
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
        while ( iter.hasNext()){
            T next = iter.next();
            if ( ! p.test(next)){
                iter.remove();
            }
        }
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> result = new HashSet<>();
        Iterator<T> iter = coll.iterator();
        while ( iter.hasNext()){
            T next = iter.next();
            if ( p.test(next)){
                result.add(next);
            }
        }
        return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
        int count = -1;
        while ( iter.hasNext()){
            count++;
            T next = iter.next();
            if (p.test(next)) {
                return count;
            }
        }
        return -1;
	}
	public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(4);
        list.add(8);
        Even p = new Even();
        System.out.println();
        System.out.println(MyPredicates.find(list, p));
        System.out.println(list);
    }
}
