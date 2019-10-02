package org.gd.common;

import java.nio.ByteOrder;

/**
 * @since 2019-10-02
 */
public interface ByteBuffer {

    ByteOrder order();

    ByteBuffer order(ByteOrder order);

    ByteBuffer write(byte value);

    ByteBuffer write(short value);

    ByteBuffer write(int value);

    ByteBuffer write(float value);

    ByteBuffer write(long value);

    ByteBuffer write(double value);

    ByteBuffer write(byte[] bytes);

    ByteBuffer write(byte[] bytes, int offset, int length);

    byte[] array();
}
