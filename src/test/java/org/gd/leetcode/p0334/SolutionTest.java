package org.gd.leetcode.p0334;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@DisplayName("LeetCode #334: increasing triplet subsequence")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, true),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void increasingTriplet(int[] nums, boolean expected) {
        assertEquals(expected, new Solution().increasingTriplet(nums));
    }
}