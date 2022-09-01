package org.gd.leetcode.p0515;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-15
 */
@DisplayName("LeetCode #515: Find Largest Value in Each Tree Row")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, 3, 2, 5, 3, null, 9), Arrays.asList(1, 3, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("BFS")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void test_BFS(TreeNode root, List<Integer> expected) {
        assertEquals(expected, new BFSSolution().largestValues(root));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DFS")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void test_DFS(TreeNode root, List<Integer> expected) {
        assertEquals(expected, new RecursiveSolution().largestValues(root));
    }
}
