package org.gd.leetcode.p1373;

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
 * @since 2020-08-12
 */
@DisplayName("LeetCode #1373: Maximum Sum BST in Binary Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(4, 3, null, 1, 2), 2),
                Arguments.of(TreeNode.of(8, 9, 8, null, 9, null, 1, null, null, -3, 5, null, -2, null, 6), 11),
                Arguments.of(TreeNode.of(9, 2, 3, null, 2, null, null, 3, null, -5, 4, null, 1, null, 10), 14),
                Arguments.of(TreeNode.of(4, 8, null, 6, 1, 9, null, -5, 4, null, null, null, -3, null, 10), 14),
                Arguments.of(TreeNode.of(-4, -2, -5), 0),
                Arguments.of(TreeNode.of(1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6), 20)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MaxSumBST")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_MaxSumBST(TreeNode root, int expected) {

        assertEquals(expected, new MyUglySolution().maxSumBST(root));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Reference Solution")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Reference(TreeNode root, int expected) {

        assertEquals(expected, new ReferenceSolution().maxSumBST(root));
    }
}