package org.gd.leetcode.p0207;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
@DisplayName("Test for org.gd.leetcode.p0207.Solution")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}}, true),
                Arguments.of(2, new int[][]{{1, 0}, {0, 1}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("CanFinish")
    void test_CanFinish(int numCourses, int[][] prerequisites, boolean expected) {
        assertEquals(expected, new Solution().canFinish(numCourses, prerequisites));
    }
}