package org.gd.leetcode.p0234;

import org.gd.leetcode.common.BooleanAssertion;
import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-11
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(ListNode.of("1->2"), false),
                Arguments.arguments(ListNode.of("1->2->2->1"), true),
                Arguments.arguments(ListNode.of("1->2->3->2->1"), true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsPalindrome")
    void test_IsPalindrome(ListNode node, boolean expected) throws Exception {
        BooleanAssertion.of(expected).doAssert(new Solution().isPalindrome(node));
    }
}