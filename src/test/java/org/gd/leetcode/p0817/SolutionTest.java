package org.gd.leetcode.p0817;

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
@DisplayName("LeetCode #817: Linked List Components")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(ListNode.of(0, 1, 2, 3, 4), new int[]{0, 3, 1, 4}, 2),
                Arguments.of(ListNode.of(0, 1, 2, 3), new int[]{0, 1, 3}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("NumComponents")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_NumComponents(ListNode head, int[] G, int expected) {
        assertEquals(expected, new Solution().numComponents(head, G));
    }
}
