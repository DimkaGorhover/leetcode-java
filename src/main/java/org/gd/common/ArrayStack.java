package org.gd.common;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

/**
 * TODO: add {@link ConcurrentModificationException}
 *
 * @author Horkhover Dmytro
 * @see ArrayList
 * @see ArrayList#rangeCheckForAdd(int)
 * @since 2018-12-22
 */
@SuppressWarnings({"unchecked", "JavadocReference", "WeakerAccess"})
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
    private int newCapacity(int minCapacity) {
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
    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
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
        return isEmpty() ? Collections.emptyList() : new ArrayList<>(this);
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
                : Spliterators.spliterator(elementData, 0, size, 0);
    }

    /**
     * @see ArrayList#iterator()
     */
    @Override
    public Iterator<E> iterator() {
        return isEmpty() ? Collections.emptyIterator() : new Itr<>(elementData, size);
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
    @SuppressWarnings("SuspiciousSystemArraycopy")
    @Override
    public <T> T[] toArray(T[] a) {
        if (isEmpty())
            return a;
        if (a.length < size)
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
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
                System.arraycopy(elementData, i + 1, elementData, i, size - i);
                size--;
                return true;
            }
        }
        return false;
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

        if (c instanceof RandomAccess) {
            final Object[] array = c.toArray();
            ensureCapacityFor(array.length + size());
            System.arraycopy(array, 0, elementData, size, array.length);
            size += array.length;
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

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() { size = 0; }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";
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

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see ArrayList#iterator()
     */
    static class Itr<E> implements Iterator<E> {

        private final Object[] elementData;

        private int index;

        Itr(Object[] elementData, int size) {
            this.elementData = elementData;
            this.index = size - 1;
        }

        @Override
        public boolean hasNext() { return index >= 0; }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return (E) elementData[index--];
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            requireNonNull(action, "action");
            for (int i = index; i >= 0; i--)
                action.accept((E) elementData[i]);
        }

        @Override
        public String toString() {
            return "ArrayStackIterator{" +
                    "index=" + index +
                    '}';
        }
    }
}
