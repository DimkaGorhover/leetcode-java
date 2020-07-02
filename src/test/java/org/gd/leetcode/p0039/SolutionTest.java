package org.gd.leetcode.p0039;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeetCode #39: Combination Sum")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 3, 6, 7}, 7,
                        List.of(
                                List.of(2, 2, 3),
                                List.of(7))
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
