package org.gd.leetcode.p0125;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #125: Is Palindrome")
@Timeout(value = 30, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("0P", false),
                Arguments.of("race a car", false),
                Arguments.of("A man, a plan, a canal: Panama", true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void isPalindrome(String s, boolean expected) {
        assertEquals(expected, new Solution().isPalindrome(s));
    }
}