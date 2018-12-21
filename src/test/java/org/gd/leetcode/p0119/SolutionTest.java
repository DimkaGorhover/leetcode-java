package org.gd.leetcode.p0119;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0118.SolutionTest
 * @since 2018-12-21
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(3, List.of(1, 3, 3, 1)),
                arguments(5, List.of(1, 5, 10, 10, 5, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("GetRow")
    void test_GetRow(int level, List<Integer> expected) {
        assertEquals(expected, new Solution().getRow(level));
    }
}