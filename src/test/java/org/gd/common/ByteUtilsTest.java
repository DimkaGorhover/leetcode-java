package org.gd.common;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.nio.ByteOrder;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link ByteUtils}
 *
 * @since 2019-10-03
 */
@Execution(ExecutionMode.CONCURRENT)
class ByteUtilsTest {

    @ParameterizedTest(name = "byte order: {0}")
    @ArgumentsSource(ByteUtilsArgumentsProvider.class)
    @DisplayName("Read & Write Short")
    void test_short(ByteUtils byteUtils) throws Exception {
        for (int i = 0; i < 1 << 10; i++) {

            short value = (short) ThreadLocalRandom.current().nextInt();
            byte[] bytes = new byte[6];

            byteUtils.writeShort(bytes, 2, value);

            assertEquals(value, byteUtils.readShort(bytes, 2));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.writeShort(bytes, 5, value));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.writeShort(bytes, -1, value));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.readShort(bytes, 5));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.readShort(bytes, -1));
        }
    }

    @ParameterizedTest(name = "byte order: {0}")
    @ArgumentsSource(ByteUtilsArgumentsProvider.class)
    @DisplayName("Read & Write Int")
    void test_Int(ByteUtils byteUtils) throws Exception {
        for (int i = 0; i < 1 << 10; i++) {

            int value = ThreadLocalRandom.current().nextInt();
            byte[] bytes = new byte[8];

            byteUtils.writeInt(bytes, 3, value);

            assertEquals(value, byteUtils.readInt(bytes, 3));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.writeInt(bytes, 5, value));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.writeInt(bytes, -1, value));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.readInt(bytes, 5));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.readInt(bytes, -1));
        }
    }

    @ParameterizedTest(name = "byte order: {0}")
    @ArgumentsSource(ByteUtilsArgumentsProvider.class)
    @DisplayName("Read & Write Long")
    void test_Long(ByteUtils byteUtils) throws Exception {
        for (int i = 0; i < 1 << 10; i++) {

            long value = ThreadLocalRandom.current().nextLong();
            byte[] bytes = new byte[18];

            byteUtils.writeLong(bytes, 3, value);

            assertEquals(value, byteUtils.readLong(bytes, 3));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.writeLong(bytes, 11, value));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.writeLong(bytes, -1, value));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.readLong(bytes, 11));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.readLong(bytes, -1));
        }
    }

    @ParameterizedTest(name = "byte order: {0}")
    @ArgumentsSource(ByteUtilsArgumentsProvider.class)
    @DisplayName("Read & Write Float")
    void test_Float(ByteUtils byteUtils) throws Exception {
        for (int i = 0; i < 1 << 10; i++) {

            float value = (float) ThreadLocalRandom.current().nextDouble();
            byte[] bytes = new byte[18];

            byteUtils.writeFloat(bytes, 3, value);

            assertEquals(value, byteUtils.readFloat(bytes, 3));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.writeFloat(bytes, 15, value));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.writeFloat(bytes, -1, value));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.readFloat(bytes, 15));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.readFloat(bytes, -1));
        }
    }

    @ParameterizedTest(name = "byte order: {0}")
    @ArgumentsSource(ByteUtilsArgumentsProvider.class)
    @DisplayName("Read & Write Double")
    void test_Double(ByteUtils byteUtils) throws Exception {
        for (int i = 0; i < 1 << 10; i++) {

            double value = ThreadLocalRandom.current().nextDouble();
            byte[] bytes = new byte[18];

            byteUtils.writeDouble(bytes, 3, value);

            assertEquals(value, byteUtils.readDouble(bytes, 3));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.writeDouble(bytes, 11, value));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.writeDouble(bytes, -1, value));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.readDouble(bytes, 11));
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> byteUtils.readDouble(bytes, -1));
        }
    }
}