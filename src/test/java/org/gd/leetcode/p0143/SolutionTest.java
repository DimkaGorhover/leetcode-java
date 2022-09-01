package org.gd.leetcode.p0143;

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
 * @see org.gd.leetcode.p0206.SolutionTest
 * @since 2020-08-17
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #143: Reorder List")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(ListNode.of(1), ListNode.of(1)),
                Arguments.of(ListNode.of(1, 2), ListNode.of(1, 2)),
                Arguments.of(ListNode.of(1, 2, 3), ListNode.of(1, 3, 2)),
                Arguments.of(ListNode.rangeClosed(1, 9), ListNode.of(1, 9, 2, 8, 3, 7, 4, 6, 5)),
                Arguments.of(ListNode.rangeClosed(0, 9), ListNode.of(0, 9, 1, 8, 2, 7, 3, 6, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ReorderList")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_ReorderList(ListNode head, ListNode expected) {
        new Solution().reorderList(head);
        assertEquals(expected, head);
    }
}
