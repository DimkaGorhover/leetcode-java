package org.gd.hackerrank.leverton;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link MaxDifferenceInAnArray}
 *
 * @author Horkhover Dmytro
 * @since 2020-09-24
 */
@DisplayName("HackerRank: Maximum Difference in an Array")
class MaxDifferenceInAnArrayTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 6, 4}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void maxDiff(int[] arr, int expected) {
        int actual = MaxDifferenceInAnArray.maxDiff(arr);
        assertEquals(expected, actual);
    }
}
