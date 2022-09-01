package org.gd.leetcode.p0002;

import lombok.NonNull;
import lombok.var;
import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-16
 */
@DisplayName("LeetCode #2: Add Two Numbers")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        ListNode.of("1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1"),
                        ListNode.of("5,6,4"),
                        ListNode.of("6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1")
                ),
                Arguments.of(
                        ListNode.of(9),
                        ListNode.of("1,9,9,9,9,9,9,9,9,9"),
                        ListNode.of("0,0,0,0,0,0,0,0,0,0,1")
                ),
                Arguments.of(
                        ListNode.of(0),
                        ListNode.of(0),
                        ListNode.of(0)
                ),
                Arguments.of(
                        ListNode.of(2, 4, 3),
                        ListNode.of(5, 6, 4),
                        ListNode.of(7, 0, 8)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("AddTwoNumbers")
    void test_AddTwoNumbers(@NonNull ListNode l1,
                            @NonNull ListNode l2,
                            @NonNull ListNode expected) {
        var solution = new Solution();
        assertThat(solution.addTwoNumbers(l1, l2)).isEqualTo(expected);
    }
}
