package org.gd.leetcode.p0148;

import org.gd.common.ArrayUtils;
import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Dmytro Horkhover
 * @see OnPlaceSolution
 * @see HeapSolution
 * @since 2020-10-13
 */
@DisplayName("LeetCode #148: Sort List")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Supplier<Arguments> randomArguments(int length) {

        if (length <= 0)
            throw new IllegalArgumentException("length");

        return () -> {

            int[] values = new int[length];
            Arrays.setAll(values, i -> i);
            ListNode expected = ListNode.of(values);

            ArrayUtils.shuffle(values);
            ListNode actual = ListNode.of(values);

            return Arguments.of(actual, expected);
        };
    }

    private static Stream<Arguments> args() {

        return Stream.of(

                () -> Arguments.of(ListNode.of(3, 1, 4, 2), ListNode.rangeClosed(1, 4)),
                () -> Arguments.of(ListNode.of(3, 1, 5, 4, 2), ListNode.rangeClosed(1, 5)),
                () -> Arguments.of(ListNode.of(3), ListNode.of(3)),
                () -> Arguments.of(ListNode.of(4, 3), ListNode.of(3, 4)),
                () -> Arguments.of(null, null),

                randomArguments(137),
                randomArguments(641),
                randomArguments(29),
                randomArguments(357),
                randomArguments(17)

        ).map(Supplier::get);
    }

    @ParameterizedTest(name = "{displayName} #{index}")
    @MethodSource("args")
    @DisplayName("On Place Solution")
    void test_SortList1(ListNode head, ListNode expected) {
        assertEquals(expected, new OnPlaceSolution().sortList(head));
    }

    @ParameterizedTest(name = "{displayName} #{index}")
    @MethodSource("args")
    @DisplayName("Heap Solution")
    void test_SortList2(ListNode head, ListNode expected) {
        assertEquals(expected, new OnPlaceSolution().sortList(head));
    }
}
