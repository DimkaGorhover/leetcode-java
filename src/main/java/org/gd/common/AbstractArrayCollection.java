package org.gd.common;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Horkhover Dmytro
 * @see ArrayList
 * @see ArrayList#rangeCheckForAdd(int)
 * @since 2019-01-22
 */
@SuppressWarnings("JavadocReference")
abstract class AbstractArrayCollection<E> extends AbstractCollection<E> implements ICollection<E> {

    static final Object[] EMPTY_ELEMENT_DATA = {};

    static final int DEFAULT_CAPACITY = 10;

    static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    Object[] elementData = EMPTY_ELEMENT_DATA;

    int size;

    /**
     * @see ArrayList#hugeCapacity(int)
     */
    static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    /**
     * @see ArrayList#newCapacity(int)
     */
    static int newCapacity(Object[] elementData, int minCapacity) {
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

    abstract int hashCode(int start, int multiplier);

    @Override
    public int size() { return size; }

    /**
     * @see ArrayList#hashCode()
     * @see ArrayList#hashCodeRange(int, int)
     */
    @Override
    public int hashCode() { return hashCode(0, 31); }

    /**
     * @see ArrayList#grow(int)
     */
    void grow(int minCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity(elementData, minCapacity));
    }

    void ensureCapacityFor(int size) {
        final int newSize = size() + size;
        if (newSize >= elementData.length)
            grow(newSize);
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        final int size = size();
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        final Object prev = elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        this.size = size - 1;
        return (E) prev;
    }
}
