package org.gd.leetcode.p0202;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode #202: Happy Number")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(19, true),
                Arguments.of(18, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void isHappy(int n, boolean expected) {
        assertEquals(expected, new Solution().isHappy(n));
    }
}