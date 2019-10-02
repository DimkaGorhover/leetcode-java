package org.gd.common;

import java.nio.ByteOrder;
import java.util.Arrays;

import static java.util.Objects.requireNonNull;

/**
 * @see java.nio.ByteBuffer
 * @see java.nio.ByteOrder
 * @see java.io.ByteArrayInputStream
 * @see java.io.ByteArrayOutputStream
 * @see java.io.DataOutputStream
 * @since 2019-10-02
 */
public class ByteBufferImpl implements ByteBuffer {

    private static final byte[] EMPTY = new byte[0];
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private byte[] buf;
    private int count;
    private ByteOrder order = ByteOrder.nativeOrder();

    public ByteBufferImpl() { this(32); }

    public ByteBufferImpl(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Negative initial size: " + capacity);

        buf = new byte[capacity];
    }

    private void ensureCapacity(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - buf.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = buf.length;
        int newCapacity = oldCapacity << 1;
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        buf = Arrays.copyOf(buf, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    @Override
    public ByteOrder order() { return order; }

    @Override
    public ByteBuffer order(ByteOrder order) {
        requireNonNull(order, "\"order\" cannot be null");
        this.order = order;
        return this;
    }

    @Override
    public ByteBuffer write(byte value) {
        ensureCapacity(count + 1);
        buf[count++] = value;
        return this;
    }

    @Override
    public ByteBuffer write(short value) {
        ensureCapacity(count + Short.BYTES);
        ByteUtils.forOrder(order()).writeShort(buf, count, value);
        count += Short.BYTES;
        return this;
    }

    @Override
    public ByteBuffer write(int value) {
        ensureCapacity(count + Integer.BYTES);
        ByteUtils.forOrder(order()).writeInt(buf, count, value);
        count += Integer.BYTES;
        return this;
    }

    @Override
    public ByteBuffer write(float value) {
        return write(Float.floatToIntBits(value));
    }

    @Override
    public ByteBuffer write(long value) {
        ensureCapacity(count + Long.BYTES);
        ByteUtils.forOrder(order()).writeLong(buf, count, value);
        count += Long.BYTES;
        return this;
    }

    @Override
    public ByteBuffer write(double value) {
        return write(Double.doubleToLongBits(value));
    }

    @Override
    public ByteBuffer write(byte[] bytes) {
        requireNonNull(bytes, "\"bytes\" cannot be null");
        return write(bytes, 0, bytes.length);
    }

    @Override
    public ByteBuffer write(byte[] bytes, int offset, int length) {

        requireNonNull(bytes, "\"bytes\" cannot be null");
        if (offset < 0 || length < 0 || bytes.length - offset > length)
            throw new ArrayIndexOutOfBoundsException();

        if (length == 0)
            return this;

        if (length == 1)
            return write(bytes[offset]);

        ensureCapacity(count + length);
        System.arraycopy(bytes, offset, buf, count, length);
        count += length;
        return this;
    }

    @Override
    public byte[] array() {
        return count == 0 ? EMPTY : Arrays.copyOfRange(buf, 0, count);
    }
}
