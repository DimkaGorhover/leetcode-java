package org.gd.leetcode.p0203;

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
 * Test for {@link Solution}
 *
 * @since 2019-08-23
 */
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        ListNode.of("1->2->6->3->4->5->6"),
                        6,
                        ListNode.of("1->2->3->4->5")),
                Arguments.of(
                        ListNode.of("7->7->7->7"),
                        7,
                        null),
                Arguments.of(
                        ListNode.of("1->2->2->1"),
                        2,
                        ListNode.of("1->1"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Recursive Solution")
    void recursive(ListNode input, int val, ListNode expected) {
        Solution solution = new RecursiveSolution();
        assertThat(solution.removeElements(input, val)).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Loop Solution")
    void loop(ListNode input, int val, ListNode expected) {
        Solution solution = new LoopSolution();
        assertThat(solution.removeElements(input, val)).isEqualTo(expected);
    }
}