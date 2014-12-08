package my.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by devesh on 12/7/14.
 */
public interface MyCollection<T> extends Iterable<T> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Iterator<T> iterator();
    Object[] toArray();
    <T> T[] toArray(T[] a);
    boolean add(T e);
    boolean remove(Object o);
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<? extends T> c);
    boolean removeAll(Collection<?> c);
    boolean retainAll(Collection<?> c);
    void clear();
    boolean equals(Object o);
    int hashCode();
}
