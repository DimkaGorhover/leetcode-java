package org.gd.leetcode.p0328;

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
 * @author Horkhover Dmytro
 * @since 2020-08-24
 */
@DisplayName("LeetCode #328: Odd Even Linked List")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(ListNode.of("2->1->3->5->6->4->7"), ListNode.of("2->3->6->7->1->5->4")),
                Arguments.of(ListNode.rangeClosed(1, 5), ListNode.of(1, 3, 5, 2, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("OddEvenList")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_OddEvenList(ListNode head, ListNode expected) {
        assertEquals(expected, new Solution().oddEvenList(head));
    }
}
