package org.gd.leetcode.p0025;

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
@DisplayName("LeetCode #25: Reverse Nodes in k-Group")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), 3, ListNode.of(3, 2, 1, 4, 5)),
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), 2, ListNode.of(2, 1, 4, 3, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ReverseKGroup")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_ReverseKGroup(ListNode head, int k, ListNode expected) {
        assertEquals(expected, new Solution().reverseKGroup(head, k));
    }
}
