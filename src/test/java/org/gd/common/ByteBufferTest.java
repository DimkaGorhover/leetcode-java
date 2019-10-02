package org.gd.common;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.ByteOrder;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link ByteBuffer}
 *
 * @since 2019-10-02
 */
class ByteBufferTest {

    private static Stream<Arguments> byteOrderArgs() {
        return Stream.of(
                arguments(ByteOrder.BIG_ENDIAN),
                arguments(ByteOrder.LITTLE_ENDIAN)
        );
    }

    @ParameterizedTest(name = "byte order: {0}")
    @MethodSource("byteOrderArgs")
    @DisplayName("Write")
    void test_Write(ByteOrder order) throws Exception {

        ByteBuffer byteBuffer = new ByteBufferImpl().order(order);

    }
}