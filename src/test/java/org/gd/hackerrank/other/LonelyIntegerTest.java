package org.gd.hackerrank.other;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Test for {@link LonelyInteger}
 */
class LonelyIntegerTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[] { 1 }, 1),
                Arguments.of(new int[] { 1, 1, 2 }, 2),
                Arguments.of(new int[] { 0, 0, 1, 2, 1 }, 2)
            );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LonelyInteger")
    void test_LonelyInteger(int[] arr, int expected) {
        int actual = LonelyInteger.lonelyinteger(arr);
        assertEquals(expected, actual);
    }
}
