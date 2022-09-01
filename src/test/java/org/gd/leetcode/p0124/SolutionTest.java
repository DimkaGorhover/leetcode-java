package org.gd.leetcode.p0124;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 48),
                Arguments.of(TreeNode.of(2, -1, -2), 2),
                Arguments.of(TreeNode.of(2, -1), 2),
                Arguments.of(TreeNode.of(-10, 9, 20, null, null, 15, 7), 42),
                Arguments.of(TreeNode.of(1, 2, 3), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #124: Binary Tree Maximum Path Sum")
    void maxPathSum(TreeNode root, int expected) {

        assertEquals(expected, new Solution().maxPathSum(root));
    }
}
