package org.gd.leetcode.p0257;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        TreeNode.of(1, 2, 3, null, 5),
                        List.of(
                                "1->2->5",
                                "1->3"
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #257: Binary Tree Paths")
    void binaryTreePaths(TreeNode root, List<String> expected) {
        assertEquals(
                new HashSet<>(expected),
                new HashSet<>(new Solution().binaryTreePaths(root))
        );
    }
}