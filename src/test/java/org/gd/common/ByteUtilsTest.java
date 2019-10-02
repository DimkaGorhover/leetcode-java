package org.gd.common;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link ByteUtilsImpl}
 *
 * @see ByteUtils
 * @see ByteUtilsImpl
 * @since 2019-10-02
 */
@Execution(ExecutionMode.CONCURRENT)
class ByteUtilsTest {

    private static Stream<Arguments> byteOrderArgs() {
        return Stream.of(
                arguments(ByteOrder.BIG_ENDIAN),
                arguments(ByteOrder.LITTLE_ENDIAN)
        );
    }

    @ParameterizedTest(name = "byte order: {0}")
    @MethodSource("byteOrderArgs")
    @DisplayName("NioTLImpl")
    void test_NioTLImpl(ByteOrder order) throws Exception {

        ByteUtils byteUtils = ByteUtils.forOrder(order);
        byte[] bytes = new byte[4];

        for (short value = Short.MIN_VALUE; value < Short.MAX_VALUE; value++) {
            byteUtils.writeShort(bytes, 2, value);
            assertEquals(value, ByteBuffer.wrap(bytes).order(order).getShort(2));
            assertEquals(value, byteUtils.readShort(bytes, 2));
        }
    }
}