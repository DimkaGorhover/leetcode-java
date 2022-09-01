package org.gd.leetcode.p1424;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.leetcode.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-29
 */
@DisplayName("LeetCode #1424: Diagonal Traverse II")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(java.util.Arrays.asList(
                        java.util.Arrays.asList(1, 2, 3),
                        java.util.Arrays.asList(4, 5, 6),
                        java.util.Arrays.asList(7, 8, 9)
                ), java.util.Arrays.asList(1, 4, 2, 7, 5, 3, 8, 6, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindDiagonalOrder")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_FindDiagonalOrder(List<List<Integer>> nums, List<Integer> expected) {

        assertEquals(expected, listOf(new Solution().findDiagonalOrder(nums)));
    }
}
