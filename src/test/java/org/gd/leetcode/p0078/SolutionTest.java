package org.gd.leetcode.p0078;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #78: Subsets")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, java.util.Arrays.asList(
                        java.util.Arrays.asList(3),
                        java.util.Arrays.asList(1),
                        java.util.Arrays.asList(2),
                        java.util.Arrays.asList(1, 2, 3),
                        java.util.Arrays.asList(1, 3),
                        java.util.Arrays.asList(2, 3),
                        java.util.Arrays.asList(1, 2),
                        java.util.Arrays.asList()
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