package org.gd.leetcode.p1290;

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
 * @since 2020-08-07
 */
@DisplayName("LeetCode #1290: Convert Binary Number in a Linked List to Integer")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0), 18_880)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("GetDecimalValue")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_GetDecimalValue(ListNode head, int expected) {
        assertEquals(expected, new Solution().getDecimalValue(head));
    }
}