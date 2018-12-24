package org.gd.common;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author Horkhover Dmytro
 * @see ReusableStringBuilder#reset()
 * @see AbstractStringBuilder
 * @see StringBuffer
 * @see StringBuilder
 * @see java.util.ConcurrentModificationException
 * @since 2018-12-24
 */
@SuppressWarnings({"UnusedReturnValue", "JavadocReference"})
public class ReusableStringBuilder implements Appendable {

    private static final AtomicIntegerFieldUpdater<ReusableStringBuilder> MOD = AtomicIntegerFieldUpdater
            .newUpdater(ReusableStringBuilder.class, "modOffset");

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private volatile int modOffset = 0;

    private char[] value;

    private int count = 0;

    public ReusableStringBuilder(int capacity) {
        if (capacity < 0 || capacity > MAX_ARRAY_SIZE)
            throw new IllegalArgumentException("capacity");
        value = new char[capacity];
    }

    public static ThreadLocal<ReusableStringBuilder> threadLocal(int capacity) {
        if (capacity < 0 || capacity > MAX_ARRAY_SIZE)
            throw new IllegalArgumentException("capacity");

        return new ThreadLocal<>() {

            @Override
            protected ReusableStringBuilder initialValue() {
                return new ReusableStringBuilder(capacity);
            }

            @Override
            public ReusableStringBuilder get() {
                ReusableStringBuilder appendable = super.get();
                appendable.reset();
                return appendable;
            }
        };
    }

    private void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity > 0)
            ensureCapacityInternal(minimumCapacity);
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        if (minimumCapacity - value.length > 0) {
            value = Arrays.copyOf(value, newCapacity(minimumCapacity));
        }
    }

    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int newCapacity = (value.length << 1) + 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
                ? hugeCapacity(minCapacity)
                : newCapacity;
    }

    private int hugeCapacity(int minCapacity) {
        if (Integer.MAX_VALUE - minCapacity < 0) { // overflow
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? minCapacity : MAX_ARRAY_SIZE;
    }

    @Override
    public ReusableStringBuilder append(CharSequence csq) {
        if (csq == null)
            return this;
        return append(csq, 0, csq.length());
    }

    @Override
    public ReusableStringBuilder append(CharSequence csq, int start, int end) {
        final int length;
        if (csq == null || (length = end - start) <= 0)
            return this;
        if (length == 1)
            return append(csq.charAt(start));
        final int mod = MOD.get(this);
        ensureCapacity(count + length);
        for (int i = start; i < end; i++)
            value[count++] = csq.charAt(i);
        if (!MOD.weakCompareAndSet(this, mod, mod + 1))
            throw new ConcurrentModificationException();
        return this;
    }

    @Override
    public ReusableStringBuilder append(char c) {
        final int mod = MOD.get(this);
        ensureCapacity(count + 1);
        value[count++] = c;
        if (!MOD.weakCompareAndSet(this, mod, mod + 1))
            throw new ConcurrentModificationException();
        return this;
    }

    public ReusableStringBuilder reset() {
        count = 0;
        return this;
    }

    @Override
    public String toString() { return new String(value, 0, count); }
}
