package org.gd.common;

import java.nio.ByteOrder;

/**
 * @since 2019-10-02
 */
public interface ByteUtils {

    static ByteUtils get() { return forOrder(ByteOrder.nativeOrder()); }

    static ByteUtils forOrder(ByteOrder order) { return ByteUtilsImpl.forOrder(order); }

    short readShort(byte[] bytes, int position);

    void writeShort(byte[] bytes, int position, short value);

    int readInt(byte[] bytes, int position);

    void writeInt(byte[] bytes, int position, int value);

    long readLong(byte[] bytes, int position);

    void writeLong(byte[] bytes, int position, long value);

    float readFloat(byte[] bytes, int position);

    void writeFloat(byte[] bytes, int position, float value);

    double readDouble(byte[] bytes, int position);

    void writeDouble(byte[] bytes, int position, double value);
}
