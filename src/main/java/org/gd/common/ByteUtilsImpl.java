package org.gd.common;

import java.nio.ByteOrder;
import java.util.Objects;

import static java.lang.invoke.MethodHandles.byteArrayViewVarHandle;
import static java.util.Objects.requireNonNull;

/**
 * @since 2019-10-02
 */
class ByteUtilsImpl implements ByteUtils {

    private static final ByteUtilsImpl LITTLE_ENDIAN = new ByteUtilsImpl(ByteOrder.LITTLE_ENDIAN);
    private static final ByteUtilsImpl BIG_ENDIAN = new ByteUtilsImpl(ByteOrder.BIG_ENDIAN);

    private final ByteOrder order;

    private ByteUtilsImpl(ByteOrder order) {
        requireNonNull(order, "\"order\" cannot be null");
        this.order = order;
    }

    static ByteUtilsImpl forOrder(ByteOrder order) {
        requireNonNull(order, "\"order\" cannot be null");
        return order == ByteOrder.BIG_ENDIAN
                ? ByteUtilsImpl.BIG_ENDIAN
                : ByteUtilsImpl.LITTLE_ENDIAN;
    }

    private static void check(byte[] bytes, int position, int length) {
        requireNonNull(bytes, "\"bytes\" cannot be null");
        if (position < 0 || length < 0 || bytes.length - position > length)
            throw new ArrayIndexOutOfBoundsException();
    }

    private static void checkShort(byte[] bytes, int position) {
        check(bytes, position, Short.BYTES);
    }

    private static void checkInt(byte[] bytes, int position) {
        check(bytes, position, Integer.BYTES);
    }

    private static void checkLong(byte[] bytes, int position) {
        check(bytes, position, Long.BYTES);
    }

    @Override
    public short readShort(byte[] bytes, int position) {
        checkShort(bytes, position);
        return (short) byteArrayViewVarHandle(short[].class, order).get(bytes, position);
    }

    @Override
    public void writeShort(byte[] bytes, int position, short value) {
        checkShort(bytes, position);
        byteArrayViewVarHandle(short[].class, order).set(bytes, position, value);
    }

    @Override
    public int readInt(byte[] bytes, int position) {
        checkInt(bytes, position);
        return (int) byteArrayViewVarHandle(int[].class, order).get(bytes, position);
    }

    @Override
    public void writeInt(byte[] bytes, int position, int value) {
        checkInt(bytes, position);
        byteArrayViewVarHandle(int[].class, order).set(bytes, position, value);
    }

    @Override
    public long readLong(byte[] bytes, int position) {
        checkLong(bytes, position);
        return (long) byteArrayViewVarHandle(long[].class, order).get(bytes, position);
    }

    @Override
    public void writeLong(byte[] bytes, int position, long value) {
        checkLong(bytes, position);
        byteArrayViewVarHandle(long[].class, order).set(bytes, position, value);
    }

    @Override
    public float readFloat(byte[] bytes, int position) {
        return Float.intBitsToFloat(readInt(bytes, position));
    }

    @Override
    public void writeFloat(byte[] bytes, int position, float value) {
        writeInt(bytes, position, Float.floatToIntBits(value));
    }

    @Override
    public double readDouble(byte[] bytes, int position) {
        return Double.longBitsToDouble(readLong(bytes, position));
    }

    @Override
    public void writeDouble(byte[] bytes, int position, double value) {
        writeLong(bytes, position, Double.doubleToLongBits(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ByteUtilsImpl)) return false;
        ByteUtilsImpl byteUtils = (ByteUtilsImpl) o;
        return Objects.equals(order, byteUtils.order);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(order);
    }

    @Override
    public String toString() {
        return "ByteUtilsImpl{" +
                "order=" + order +
                '}';
    }
}
