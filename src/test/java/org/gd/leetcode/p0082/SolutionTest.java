package org.gd.leetcode.p0082;

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
 * @since 2018-10-21
 */
@DisplayName("LeetCode #82: Remove Duplicates from Sorted List II")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(ListNode.of(1, 2, 3, 3, 4, 4, 5), ListNode.of(1, 2, 5)),
                arguments(ListNode.of(1, 1, 2), ListNode.of(2)),
                arguments(ListNode.of(1, 1, 2, 3, 3), ListNode.of(2)),
                arguments(ListNode.of(1, 1, 1, 2, 3), ListNode.of(2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DeleteDuplicates")
    void test_DeleteDuplicates(ListNode input, ListNode expected) {
        assertEquals(expected, new Solution().deleteDuplicates(input));
    }
}
