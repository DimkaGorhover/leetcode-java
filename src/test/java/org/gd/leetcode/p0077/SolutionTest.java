package org.gd.leetcode.p0077;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.gd.leetcode.common.CollectionUtils.setOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-20
 */
@DisplayName("LeetCode #77: combinations")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(4, 2, setOf(
                        Arrays.asList(2, 4),
                        Arrays.asList(3, 4),
                        Arrays.asList(2, 3),
                        Arrays.asList(1, 2),
                        Arrays.asList(1, 3),
                        Arrays.asList(1, 4)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Combine")
    void test_Combine(int n, int k, Set<List<Integer>> expected) {
        val solution = new Solution();
        assertEquals(expected, new LinkedHashSet<>(solution.combine(n, k)));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Combine 1")
    void test_Combine1(int n, int k, Set<List<Integer>> expected) {
        val solution = new Solution1();
        assertEquals(expected, new LinkedHashSet<>(solution.combine(n, k)));
    }
}
