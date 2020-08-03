package org.gd.leetcode.p0543;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-03
 */
@DisplayName("LeetCode #543: Diameter of Binary Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(1, 2, 3), 2),
                Arguments.of(TreeNode.of(1, 2, 3, 4), 3),
                Arguments.of(TreeNode.of(1, 2, 3, 4, 5), 3),
                Arguments.of(TreeNode.of(4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2), 8)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DiameterOfBinaryTree")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_DiameterOfBinaryTree(TreeNode root, int expected) {
        assertEquals(expected, new Solution().diameterOfBinaryTree(root));
    }
}