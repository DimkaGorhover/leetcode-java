package org.gd.common;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static java.util.Objects.requireNonNull;

/**
 * TODO: add {@link ConcurrentModificationException}
 *
 * @author Horkhover Dmytro
 * @see ArrayList
 * @see ArrayList#rangeCheckForAdd(int)
 * @since 2018-12-22
 */
@SuppressWarnings("unchecked")
public class ArrayStack<E> implements Stack<E> {

    private static final Object[] EMPTY_ELEMENT_DATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private Object[] elementData = EMPTY_ELEMENT_DATA;

    private int size;

    public ArrayStack() {
    }

    @SuppressWarnings("ForLoopReplaceableByForEach")
    public static <E> ArrayStack<E> of(E... values) {
        requireNonNull(values, "values");
        ArrayStack<E> stack = new ArrayStack<>();
        for (int i = 0; i < values.length; i++)
            stack.push(values[i]);
        return stack;
    }

    /**
     * @see ArrayList#hugeCapacity(int)
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    /**
     * @see ArrayList#newCapacity(int)
     */
    private static int newCapacity(Object[] elementData, int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == EMPTY_ELEMENT_DATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    /**
     * @see ArrayList#grow(int)
     */
    private void grow(int minCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity(elementData, minCapacity));
    }

    private void ensureCapacityFor(int size) {
        final int newSize = size() + size;
        if (newSize >= elementData.length)
            grow(newSize);
    }

    @Override
    public boolean push(E element) { return add(element); }

    @Override
    public E pop() { return isEmpty() ? null : (E) elementData[--size]; }

    @Override
    public List<E> toList() {
        final Object[] a = this.elementData;
        switch (size()) {
            case 0: return emptyList();
            case 1: return singletonList((E) a[0]);
            case 2: return asList((E) a[1], (E) a[0]);
            case 3: return asList((E) a[2], (E) a[1], (E) a[0]);
            case 4: return asList((E) a[3], (E) a[2], (E) a[1], (E) a[0]);
            case 5: return asList((E) a[4], (E) a[3], (E) a[2], (E) a[1], (E) a[0]);
            case 6: return asList((E) a[5], (E) a[4], (E) a[3], (E) a[2], (E) a[1], (E) a[0]);
            case 7: return asList((E) a[6], (E) a[5], (E) a[4], (E) a[3], (E) a[2], (E) a[1], (E) a[0]);
            case 8: return asList((E) a[7], (E) a[6], (E) a[5], (E) a[4], (E) a[3], (E) a[2], (E) a[1], (E) a[0]);
            case 9: return asList((E) a[8], (E) a[7], (E) a[6], (E) a[5], (E) a[4], (E) a[3], (E) a[2], (E) a[1], (E) a[0]);
        }
        return new ArrayList<>(this);
    }

    @Override
    public Set<E> toSet() {
        final Object[] a = this.elementData;
        switch (size()) {
            case 0: return emptySet();
            case 1: return singleton((E) a[0]);
            case 2: return (Objects.equals(a[0], a[1])) ? singleton((E) a[0]) : Set.of((E) a[1], (E) a[0]);
        }
        return new HashSet<>(this);
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size() == 0; }

    @Override
    public boolean contains(Object o) {
        if (o == null || isEmpty())
            return false;
        for (int i = 0; i < size; i++)
            if (Objects.equals(o, elementData[i]))
                return true;
        return false;
    }

    @Override
    public Spliterator<E> spliterator() {
        return isEmpty()
                ? Spliterators.emptySpliterator()
                : Spliterators.spliterator(iterator(), size(), 0);
    }

    @Override
    public Stream<E> stream() {
        final int size = size();
        return IntStream.rangeClosed(1, size)
                .map(index -> size - index)
                .mapToObj(value -> (E) elementData[value]);
    }

    @Override
    public Stream<E> parallelStream() { return stream().parallel(); }

    /**
     * @see ArrayList#iterator()
     */
    @Override
    public Iterator<E> iterator() {
        return isEmpty() ? Collections.emptyIterator() : new Itr<>(this);
    }

    /**
     * @see ArrayList#toArray()
     */
    @Override
    public Object[] toArray() {
        if (isEmpty())
            return EMPTY_ELEMENT_DATA;
        final Object[] copy = new Object[size];
        for (int i = 0; i < size; i++)
            copy[i] = elementData[size - 1 - i];
        return copy;
    }

    /**
     * @see ArrayList#toArray(Object[])
     */
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
            a[i] = (T) elementData[size - 1 - i];
        return a;
    }

    @Override
    public boolean add(E e) {
        if (e == null)
            return false;
        ensureCapacityFor(size + 1);
        elementData[size++] = e;
        return true;
    }

    /**
     * @see ArrayList#remove(Object)
     */
    @Override
    public boolean remove(Object o) {
        if (isEmpty())
            return false;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elementData[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    private void remove(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException();
        System.arraycopy(elementData, i + 1, elementData, i, size - i);
        size--;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null || c.isEmpty())
            return true;
        if (isEmpty())
            return false;
        for (Object o : c)
            if (!contains(o))
                return false;
        return true;
    }

    /**
     * @see ArrayList#addAll(Collection)
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {

        if (c == null || c.isEmpty())
            return false;

        if (c instanceof ArrayStack) {
            int size = size(), sizeC = c.size();
            ensureCapacityFor(sizeC + size + 1);
            final Object[] elementData = ((ArrayStack<? extends E>) c).elementData;
            for (int i = sizeC - 1; i >= 0; i--)
                this.elementData[size++] = elementData[i];
            this.size = size;
            return true;
        }

        if (c instanceof RandomAccess) {
            final Object[] array = c.toArray();
            ensureCapacityFor(array.length + size);
            System.arraycopy(array, 0, elementData, size, array.length);
            this.size += array.length;
            return true;
        }

        boolean res = true;
        for (E e : c)
            res &= add(e);
        return res;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null || c.isEmpty() || isEmpty())
            return true;
        boolean res = true;
        for (Object e : c)
            res &= remove(e);
        return res;
    }

    /**
     * @see ArrayList#retainAll(Collection)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean res = false;
        for (int i = 0; i < size(); ) {
            if (!c.contains(elementData[i])) {
                remove(i);
                res = true;
            } else {
                i++;
            }
        }
        return res;
    }

    @Override
    public void clear() { size = 0; }

    @Override
    public String toString() {
        if (isEmpty())
            return "->[]";
        final int size = size();
        final StringBuilder sb = new StringBuilder()
                .append("->[")
                .append(elementData[size - 1]);
        for (int i = size - 2; i >= 0; i--)
            sb.append(", ").append(elementData[i]);
        return sb.append("]").toString();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        requireNonNull(action, "action");
        for (int i = size - 1; i >= 0; i--)
            action.accept((E) elementData[i]);
    }

    /**
     * @see #remove(Object)
     */
    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        boolean res = false;
        for (int i = 0; i < size(); ) {
            if (filter.test((E) elementData[i])) {
                remove(i);
                res = true;
            } else {
                i++;
            }
        }
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Stack)) return false;
        final int size = size();
        if (((Stack) obj).size() != size) return false;

        if (obj instanceof ArrayStack)
            return Arrays.equals(
                    elementData, 0, size,
                    ((ArrayStack) obj).elementData, 0, size);

        final Iterator itr1 = iterator(), itr2 = ((Stack) obj).iterator();
        while (itr1.hasNext() && itr2.hasNext())
            if (!Objects.equals(itr1.next(), itr2.next()))
                return false;

        return itr1.hasNext() ^ itr2.hasNext();
    }

    /**
     * @see ArrayList#hashCode()
     * @see ArrayList#hashCodeRange(int, int)
     */
    @Override
    public int hashCode() { return hashCode(0, 31); }

    public int hashCode(int start, int multiplier) {
        int hash = start;
        for (int i = size - 1; i >= 0; i--)
            hash = multiplier * hash + elementData[i].hashCode();
        return hash;
    }

    /**
     * @see ArrayList#iterator()
     */
    static class Itr<E> implements Iterator<E> {

        private final ArrayStack<E> stack;

        private int index;

        Itr(ArrayStack<E> stack) {
            this.stack = requireNonNull(stack, "stack");
            this.index = stack.size() - 1;
        }

        private int nextIndex() {
            if (!hasNext())
                throw new NoSuchElementException();
            final int i = index;
            index--;
            return i;
        }

        @Override
        public boolean hasNext() { return index >= 0; }

        @Override
        public E next() { return (E) stack.elementData[nextIndex()]; }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            requireNonNull(action, "action");
            while (index >= 0)
                action.accept((E) stack.elementData[index--]);
        }

        @Override
        public void remove() { stack.remove(nextIndex()); }

        @Override
        public String toString() {
            return "ArrayStackIterator{index=" + index + '}';
        }
    }
}
