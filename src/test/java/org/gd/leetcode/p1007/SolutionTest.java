package org.gd.leetcode.p1007;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-10-19
 */
@DisplayName("Test for org.gd.leetcode.p1007.Solution")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        new int[]{3, 5, 1, 2, 3},
                        new int[]{3, 6, 3, 3, 4},
                        -1),

                Arguments.of(
                        new int[]{2, 1, 2, 4, 2, 2},
                        new int[]{5, 2, 6, 2, 3, 2},
                        2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MinDominoRotations")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_MinDominoRotations(int[] A, int[] B, int expected) {
        assertEquals(expected, new Solution().minDominoRotations(A, B));
    }
}
