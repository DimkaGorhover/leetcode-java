package org.gd.leetcode.p0086;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-23
 */
@DisplayName("LeetCode #86: Partition List")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(ListNode.of("1->4-> 3|2;5,2"), 3, ListNode.of("1->2->2->4->3->5"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void test_Partition(ListNode head, int x, ListNode expected) {
        assertEquals(expected, new Solution().partition(head, x));
    }
}
