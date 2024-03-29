package org.gd.leetcode.p0206;

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
 * @see org.gd.leetcode.p0096.SolutionTest
 * @see org.gd.leetcode.p0143.SolutionTest
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #206: Reverse Linked List")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        ListNode.of(1, 2, 3, 4, 5),
                        ListNode.of(5, 4, 3, 2, 1)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void reverseList(ListNode head, ListNode expected) {

        //noinspection deprecation
        assertEquals(expected, head.reverse());

        assertEquals(expected, new Solution().reverseList(head));
    }
}