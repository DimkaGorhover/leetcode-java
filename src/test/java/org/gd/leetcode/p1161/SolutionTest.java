package org.gd.leetcode.p1161;

import org.gd.leetcode.common.TreeNode;
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
 * @since 2019-09-23
 */
@DisplayName("LeetCode #1161: Maximum Level Sum of a Binary Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(989, null, 10250, 98693, -89388, null, null, null, -32127), 2),
                Arguments.of(TreeNode.of(1), 1),
                Arguments.of(null, 0),
                Arguments.of(TreeNode.of(1, 7, 0, 7, -8, null, null), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MaxLevelSum")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void test_MaxLevelSum(TreeNode root, int expected) {
        assertEquals(expected, new Solution().maxLevelSum(root));
    }
}
