package org.gd.leetcode.p0077;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-20
 */
@DisplayName("LeetCode #77: combinations")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(4, 2, Set.of(
                        List.of(2, 4),
                        List.of(3, 4),
                        List.of(2, 3),
                        List.of(1, 2),
                        List.of(1, 3),
                        List.of(1, 4)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Combine")
    void test_Combine(int n, int k, Set<List<Integer>> expected) throws Exception {
        assertEquals(expected, Set.copyOf(new Solution().combine(n, k)));
        assertEquals(expected, Set.copyOf(new Solution1().combine(n, k)));
    }
}