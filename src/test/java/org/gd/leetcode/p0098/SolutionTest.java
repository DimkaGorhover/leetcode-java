package org.gd.leetcode.p0098;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
@DisplayName("LeetCode #98: Validate Binary Search Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(2, 1, 3), true),
                Arguments.of(TreeNode.of(5, 1, 4, null, null, 3, 6), false),
                Arguments.of(TreeNode.of(10, 5, 15, null, null, 6, 20), false),
                Arguments.of(TreeNode.of(2147483647), true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsValidBST")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_IsValidBST(TreeNode node, boolean expected) {

        assertEquals(expected, new DFSSolution().isValidBST(node));
    }
}