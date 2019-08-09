package org.gd.leetcode.p0334;

import org.gd.leetcode.common.BooleanAssertion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, true),
                arguments(new int[]{5, 4, 3, 2, 1}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void increasingTriplet(int[] nums, boolean expected) {
        BooleanAssertion.of(expected).doAssert(new Solution().increasingTriplet(nums));
    }
}