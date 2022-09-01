package org.gd.leetcode.p0513;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode #513: Find Bottom Left Tree Value")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(2, 1, 3), 1),
                Arguments.of(TreeNode.of(1, 2, 3, 4, null, 5, 6, null, null, 7), 7)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void findBottomLeftValue(TreeNode root, int expected) {
        int actual = new Solution().findBottomLeftValue(root);
        assertEquals(expected, actual);
    }
}