package org.gd.common;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-22
 */
public class SortedArrayList<E> extends AbstractArrayCollection<E> implements List<E> {

    private final Comparator<E> comparator;

    private SortedArrayList(Comparator<E> comparator) {
        this.comparator = requireNonNull(comparator, "\"comparator\" cannot be null");
    }

    public static <E extends Comparable<E>> SortedArrayList<E> ofComparable() {
        return new SortedArrayList<E>(Comparator.naturalOrder());
    }

    @SafeVarargs
    public static <E extends Comparable<E>> SortedArrayList<E> ofComparable(E ... comparableList) {
        SortedArrayList<E> list = ofComparable();
        list.addAll(asList(comparableList));
        return list;
    }

    public static <E> SortedArrayList<E> ofComparator(Comparator<E> comparator) {
        return new SortedArrayList<>(comparator);
    }

    @Override
    public Iterator<E> iterator() { return new Itr(); }

    @Override
    public Object[] toArray() {
        final int size = size();
        if (size == 0)
            return ArrayUtils.EMPTY_OBJECTS;
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public boolean add(E e) {
        if (e == null)
            return false;
        final int size = size();
        ensureCapacityFor(size + 1);
        if (size == 0) {
            elementData[0] = e;
            this.size = 1;
            return true;
        }
        final int i = ArrayUtils.binarySearchPos(elementData, 0, size, e, comparator);
        System.arraycopy(elementData, i, elementData, i + 1, size + 1);
        elementData[i] = e;
        this.size = size + 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection c) {
        if (c == null || c.isEmpty())
            return false;
        boolean result = false;
        for (Object o : c) {
            result |= add((E) o);
        }
        return result;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        final int size = size();
        Arrays.fill(elementData, 0, size, null);
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        final int size = size();
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) { throw new UnsupportedOperationException(); }

    @Override
    public void add(int index, E element) { throw new UnsupportedOperationException(); }

    @Override
    public int indexOf(Object o) {
        if (o == null)
            return -1;
        return ArrayUtils.binarySearch(elementData, 0, size(), (E) o, comparator);
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        final int size = size();
        if (size == 0)
            return a;
        if (a.length < size)
            a = (a.getClass() == Object[].class)
                    ? (T[]) new Object[size]
                    : (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        for (int i = 0; i < size; i++)
            a[i] = (T) elementData[i];
        return a;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        requireNonNull(generator, "\"generator\" cannot be null");
        return toArray(generator.apply(size()));
    }

    @Override
    int hashCode(int start, int multiplier) {
        int size = size(), hash = start;
        for (int i = 1; i < size; i++)
            hash = multiplier * hash + Objects.hashCode(elementData[i]);
        return hash;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> toList() {
        final Object[] a = this.elementData;
        switch (size()) {
            case 0: return emptyList();
            case 1: return singletonList((E) a[0]);
            case 2: return asList((E) a[0], (E) a[1]);
            case 3: return asList((E) a[0], (E) a[1], (E) a[2]);
            case 4: return asList((E) a[0], (E) a[1], (E) a[2], (E) a[3]);
            case 5: return asList((E) a[0], (E) a[1], (E) a[2], (E) a[3], (E) a[4]);
            case 6: return asList((E) a[0], (E) a[1], (E) a[2], (E) a[3], (E) a[4], (E) a[5]);
            case 7: return asList((E) a[0], (E) a[1], (E) a[2], (E) a[3], (E) a[4], (E) a[5], (E) a[6]);
            case 8: return asList((E) a[0], (E) a[1], (E) a[2], (E) a[3], (E) a[4], (E) a[5], (E) a[6], (E) a[7]);
            case 9: return asList((E) a[0], (E) a[1], (E) a[2], (E) a[3], (E) a[4], (E) a[5], (E) a[6], (E) a[7], (E) a[8]);
            case 10: return asList((E) a[0], (E) a[1], (E) a[2], (E) a[3], (E) a[4], (E) a[5], (E) a[6], (E) a[7], (E) a[8], (E) a[9]);
        }
        return new ArrayList<>(this);
    }

    @Override
    public String toString() {
        final int size = size();
        if (size == 0)
            return "[]";
        StringBuilder sb = new StringBuilder().append('[').append(elementData[0]);
        for (int i = 0; i < size; i++)
            sb.append(',').append(elementData[i]);
        return sb.append(']').toString();
    }

    /**
     * @see ArrayList#iterator()
     */
    class Itr implements Iterator<E> {

        final int size;

        private int i = 0;

        Itr() { this.size = size(); }

        @Override
        public boolean hasNext() { return i < size; }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return (E) elementData[i++];
        }

        @Override
        public void remove() {
            SortedArrayList.this.remove(i);
        }

        @SuppressWarnings("unchecked")
        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            requireNonNull(action, "\"action\" cannot be null");
            for (int j = i; j < size; j++)
                action.accept((E) elementData[i]);
        }
    }
}
