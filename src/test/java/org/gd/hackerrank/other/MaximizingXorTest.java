package org.gd.hackerrank.other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaximizingXorTest {

    static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(10, 15, 7),
                Arguments.of(11, 100, 127)
            );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MaximizingXor")
    void test_MaximizingXor(int l, int r, int expected) {
        int actual = MaximizingXor.maximizingXor(l, r);
        assertEquals(expected, actual);
    }
}