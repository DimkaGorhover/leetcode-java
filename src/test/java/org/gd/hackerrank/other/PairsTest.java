package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Pairs}
 *
 * @since 2019-09-25
 */
class PairsTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                //arguments(new int[]{1, 2, 3, 4}, 1, 3),
                arguments(new int[]{1, 5, 3, 4, 2}, 2, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Pairs")
    void test_Pairs(int[] arr, int k, int expected) throws Exception {
        
        int actual = Pairs.pairs(k, arr);
        assertEquals(expected, actual);

        actual = Pairs.twoPointersSolution(k, arr);
        assertEquals(expected, actual);

        actual = Pairs.linearSolution(k, arr);
        assertEquals(expected, actual);
    }
}
