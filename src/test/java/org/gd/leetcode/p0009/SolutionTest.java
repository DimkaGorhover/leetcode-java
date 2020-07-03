package org.gd.leetcode.p0009;

import org.gd.leetcode.common.BooleanAssertion;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-03
 */
@DisplayName("LeetCode #9: Palindrome Number")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsPalindrome")
    void test_IsPalindrome(int number, boolean expected) {
        BooleanAssertion.of(expected).doAssert(new Solution().isPalindrome(number));
    }
}