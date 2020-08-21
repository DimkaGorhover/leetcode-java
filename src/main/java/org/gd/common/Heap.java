package org.gd.common;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @see java.util.PriorityQueue
 */
public class Heap<E> {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    private final Comparator<? super E> comparator;

    private Object[] queue;
    private int size = 0;

    public Heap(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public Heap(int initialCapacity, Comparator<? super E> comparator) {

        if (initialCapacity < 1)
            throw new IllegalArgumentException();

        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    public boolean add(E e) {
        if (e == null)
            throw new NullPointerException();

        int i = size;
        if (i >= queue.length)
            grow(i + 1);

        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);

        return true;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }

    public int size() { return size; }

    public void clear() {
        Arrays.fill(queue, 0, size, null);
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if (size == 0)
            return null;

        int s = --size;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;

        if (s != 0)
            siftDown(0, x);

        return result;
    }

    @SuppressWarnings("unchecked")
    private void siftUp(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }

    @SuppressWarnings("unchecked")
    private void siftDown(int k, E x) {
        int half = size >>> 1;
        while (k < half) {

            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;

            if (right < size && comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];

            if (comparator.compare(x, (E) c) <= 0)
                break;

            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }
}
