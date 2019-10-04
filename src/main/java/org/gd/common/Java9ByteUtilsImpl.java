package org.gd.common;

import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;

import static java.lang.invoke.MethodHandles.byteArrayViewVarHandle;
import static java.util.Objects.requireNonNull;

/**
 * @since 2019-10-02
 */
class Java9ByteUtilsImpl implements ByteUtils {

    private static final Java9ByteUtilsImpl LITTLE_ENDIAN = new Java9ByteUtilsImpl(ByteOrder.LITTLE_ENDIAN);
    private static final Java9ByteUtilsImpl BIG_ENDIAN = new Java9ByteUtilsImpl(ByteOrder.BIG_ENDIAN);

    private final ByteOrder order;

    private final VarHandle shortView;
    private final VarHandle intView;
    private final VarHandle longView;

    private Java9ByteUtilsImpl(ByteOrder order) {
        requireNonNull(order, "\"order\" cannot be null");
        this.order = order;
        shortView = byteArrayViewVarHandle(short[].class, order);
        intView = byteArrayViewVarHandle(int[].class, order);
        longView = byteArrayViewVarHandle(long[].class, order);
    }

    static Java9ByteUtilsImpl forOrder(ByteOrder order) {
        requireNonNull(order, "\"order\" cannot be null");
        return order == ByteOrder.BIG_ENDIAN
                ? Java9ByteUtilsImpl.BIG_ENDIAN
                : Java9ByteUtilsImpl.LITTLE_ENDIAN;
    }

    private static void check(byte[] bytes, int position, int length) {
        requireNonNull(bytes, "\"bytes\" cannot be null");
        if (position < 0 || length < 0 || bytes.length - position < length)
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
        return (short) shortView.get(bytes, position);
    }

    @Override
    public void writeShort(byte[] bytes, int position, short value) {
        checkShort(bytes, position);
        shortView.set(bytes, position, value);
    }

    @Override
    public int readInt(byte[] bytes, int position) {
        checkInt(bytes, position);
        return (int) intView.get(bytes, position);
    }

    @Override
    public void writeInt(byte[] bytes, int position, int value) {
        checkInt(bytes, position);
        intView.set(bytes, position, value);
    }

    @Override
    public long readLong(byte[] bytes, int position) {
        checkLong(bytes, position);
        return (long) longView.get(bytes, position);
    }

    @Override
    public void writeLong(byte[] bytes, int position, long value) {
        checkLong(bytes, position);
        longView.set(bytes, position, value);
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
    public String toString() {
        return "Java9ByteUtilsImpl{" +
                "order=" + order +
                '}';
    }
}
