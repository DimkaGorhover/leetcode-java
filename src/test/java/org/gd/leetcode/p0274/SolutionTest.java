package org.gd.leetcode.p0274;

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
 * @since 2020-08-11
 */
@DisplayName("LeetCode #274: H-Index")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{100}, 1),
                Arguments.of(new int[]{3, 0, 6, 1, 5}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("O(N)")
    void test_HIndex(int[] citations, int expected) {
        assertEquals(expected, new Solution().hIndex(citations));
    }
}
