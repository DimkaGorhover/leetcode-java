package org.gd.leetcode.p0832;

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
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-11-10
 */
@DisplayName("LeetCode #832: Flipping an Image")
class SolutionTest {

    private static Stream<Arguments> args() {

        return Stream.of(

                Arguments.of(
                        new int[][]{
                                {1, 1, 0},
                                {1, 0, 1},
                                {0, 0, 0}
                        },
                        new int[][]{
                                {1, 0, 0},
                                {0, 1, 0},
                                {1, 1, 1}
                        }
                ),

                Arguments.of(
                        new int[][]{
                                {1, 1, 0, 0},
                                {1, 0, 0, 1},
                                {0, 1, 1, 1},
                                {1, 0, 1, 0}
                        },
                        new int[][]{
                                {1, 1, 0, 0},
                                {0, 1, 1, 0},
                                {0, 0, 0, 1},
                                {1, 0, 1, 0}
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FlipAndInvertImage")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_FlipAndInvertImage(int[][] A, int[][] expected) {
        List<List<Integer>> input = listOf(A);
        int[][] actual = new Solution().flipAndInvertImage(A);
        assertSame(A, actual);

        List<List<Integer>> expectedList = listOf(expected);
        List<List<Integer>> actualList = listOf(actual);
        assertEquals(expectedList, actualList, () -> {
            StringBuilder sb = new StringBuilder().append('\n');
            sb.append("   Input: ").append(input).append('\n');
            sb.append("Expected: ").append(expectedList).append('\n');
            sb.append("  Actual: ").append(actualList).append('\n');
            return sb.toString();
        });
    }
}
