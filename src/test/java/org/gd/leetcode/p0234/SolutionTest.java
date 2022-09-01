package org.gd.leetcode.p0234;

import org.gd.leetcode.common.ListNode;
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
 *
 * @since 2019-09-11
 */
@DisplayName("LeetCode #234: Palindrome Linked List")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(ListNode.of("1->2->3->2->1"), true),
                Arguments.of(ListNode.of("1->2"), false),
                Arguments.of(ListNode.of("1->2->2->1"), true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Extra Memory")
    void test_ExtraMemorySolution(ListNode node, boolean expected) {
        assertEquals(expected, new ExtraMemorySolution().isPalindrome(node));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Two Pointers")
    void test_TwoPointers(ListNode node, boolean expected) {
        assertEquals(expected, new TwoPointersSolution().isPalindrome(node));
    }
}
