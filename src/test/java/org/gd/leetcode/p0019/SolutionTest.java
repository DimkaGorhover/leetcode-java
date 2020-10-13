package org.gd.leetcode.p0019;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #19: Remove Nth Node From End of List")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), 2, ListNode.of(1, 2, 3, 5)),
                Arguments.of(ListNode.of(1), 1, null),
                Arguments.of(ListNode.of(1, 2), 2, ListNode.of(2)),
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), 1, ListNode.of(1, 2, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void removeNthFromEnd(ListNode input, int n, ListNode expected) {
        Solution solution = new Solution();
        ListNode actual = solution.removeNthFromEnd(input, n);
        assertEquals(expected, actual);
    }
}