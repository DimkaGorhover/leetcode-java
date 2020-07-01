package org.gd.leetcode.p1339;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, 2, 3, 4, 5, 6), 110),
                Arguments.of(TreeNode.of(1, 1), 1),
                Arguments.of(TreeNode.of(1, null, 2, 3, 4, null, null, 5, 6), 90)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #1339: Maximum Product of Splitted Binary Tree")
    void maxProduct(TreeNode node, int expected) {
        int actual = new Solution().maxProduct(node);
        assertEquals(expected, actual);
    }
}