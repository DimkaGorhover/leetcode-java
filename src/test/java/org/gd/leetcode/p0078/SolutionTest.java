package org.gd.leetcode.p0078;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, List.of(
                        List.of(3),
                        List.of(1),
                        List.of(2),
                        List.of(1, 2, 3),
                        List.of(1, 3),
                        List.of(2, 3),
                        List.of(1, 2),
                        List.of()
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void subsets(int[] nums, List<List<Integer>> expected) {

        var actual = new Solution().subsets(nums);

        assertEquals(
                new HashSet<>(expected),
                new HashSet<>(actual));
    }
}