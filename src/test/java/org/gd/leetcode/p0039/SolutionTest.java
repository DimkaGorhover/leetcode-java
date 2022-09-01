package org.gd.leetcode.p0039;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode #39: Combination Sum")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 3, 6, 7}, 7,
                        java.util.Arrays.asList(
                                java.util.Arrays.asList(2, 2, 3),
                                java.util.Arrays.asList(7))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void combinationSum(int[] candidates, int target, List<List<Integer>> expected) {
        var actual = new Solution().combinationSum(candidates, target);
        assertEquals(
                (expected),
                (actual));
    }
}
