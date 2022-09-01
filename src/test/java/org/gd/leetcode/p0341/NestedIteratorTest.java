package org.gd.leetcode.p0341;

import lombok.var;
import org.gd.leetcode.common.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link NestedIterator}
 */
@DisplayName("LeetCode #341: Flatten Nested List Iterator")
class NestedIteratorTest {

    static int count(List<NestedInteger> nestedList) {
        int count = 0;
        LinkedList<List<NestedInteger>> q = new LinkedList<>();
        q.addFirst(nestedList);
        while ((nestedList = q.poll()) != null) {
            for (NestedInteger i : nestedList) {
                if (i.isInteger()) {
                    count++;
                } else {
                    q.addFirst(i.getList());
                }
            }
        }
        return count;
    }

    @Test
    void test_count() {

        assertEquals(
                21,
                count(
                        java.util.Arrays.asList(
                                NestedInteger.of(1),
                                NestedInteger.of(2),
                                ListNestedInteger.of(
                                        NestedInteger.of(1),
                                        NestedInteger.of(2),
                                        ListNestedInteger.of(
                                                NestedInteger.of(1),
                                                NestedInteger.of(2),
                                                ListNestedInteger.of(
                                                        NestedInteger.of(1),
                                                        NestedInteger.of(2),
                                                        ListNestedInteger.of(1, 2, 3, 4, 5),
                                                        NestedInteger.of(3),
                                                        NestedInteger.of(4)),
                                                NestedInteger.of(3),
                                                NestedInteger.of(4)
                                        ),
                                        NestedInteger.of(3),
                                        NestedInteger.of(4)),
                                NestedInteger.of(3),
                                NestedInteger.of(4)
                        )
                )
        );
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        java.util.Arrays.asList(
                                NestedInteger.of(1, 1),
                                NestedInteger.of(2),
                                NestedInteger.of(1, 1)),
                        java.util.Arrays.asList(1, 1, 2, 1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #341: Flatten Nested List Iterator")
    void test(List<NestedInteger> nestedList, List<Integer> expected) {
        var iterator = new NestedIterator(nestedList);
        var actual = CollectionUtils.listOf(iterator);
        assertEquals(expected, actual);
    }
}
