package org.gd.leetcode.p0002;

import lombok.NonNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-16
 */
class SolutionTest {

    @NonNull
    private static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.arguments(
                        ListNode.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
                        ListNode.of(5, 6, 4),
                        ListNode.of(6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
                ),
                Arguments.arguments(
                        ListNode.of(9),
                        ListNode.of(1, 9, 9, 9, 9, 9, 9, 9, 9, 9),
                        ListNode.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
                ),
                Arguments.arguments(
                        ListNode.of(0),
                        ListNode.of(0),
                        ListNode.of(0)
                ),
                Arguments.arguments(
                        ListNode.of(2, 4, 3),
                        ListNode.of(5, 6, 4),
                        ListNode.of(7, 0, 8)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsStream")
    @DisplayName("AddTwoNumbers")
    void test_AddTwoNumbers(@NonNull ListNode l1,
                            @NonNull ListNode l2,
                            @NonNull ListNode expected) {
        assertEquals(expected, new Solution().addTwoNumbers(l1, l2));
    }
}